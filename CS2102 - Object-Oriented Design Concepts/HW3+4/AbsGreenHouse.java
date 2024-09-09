import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

/**
 * An abstract superclass to provide template methods for performance specific
 * subclasses.
 */
public abstract class AbsGreenHouse implements Sensible, QualityControlable {

  /**
   * Raw sensor data.
   */
  protected LinkedList<Double> dataIn = new LinkedList<Double>();
  /**
   * All temperature values.
   */
  private LinkedList<Double> allTemps = new LinkedList<Double>();
  /**
   * All humidity values.
   */
  private LinkedList<Double> allHumids = new LinkedList<Double>();
  /**
   * Processed sensor data represented as a list of DTH objects.
   */
  private LinkedList<DTH> dths = new LinkedList<DTH>();
  /**
   * The time recorded at the last sensor measurement (in Gregorian time).
   */
  private GregorianCalendar clock = new GregorianCalendar();

  /**
   * The strategy used for parsed data handling, and middle readings
   */
  private ParsedDataStrategy strategy;

  /**
   * Default constructor initializing the clock and strategy.
   */
  public AbsGreenHouse() {
    this.clock = new GregorianCalendar();
    this.strategy = new MainStrategy();
  }

  /**
   * Constructor with a specified GregorianCalendar, initializing the clock and
   * strategy.
   *
   * @param gc The GregorianCalendar to set the clock to.
   */
  public AbsGreenHouse(GregorianCalendar gc) {
    this.clock = (GregorianCalendar) gc.clone();
    this.strategy = new MainStrategy();
  }

  // GIVEN CODE
  /**
   * Assume a sensor value is a date if it is greater jan 01, 1970
   * 
   * @param sensorDatum the datum which may be a date, datetime, temperature, or
   *                    humidity
   * @return true if it is a formatted date number
   */
  public boolean isDate(double sensorDatum) {
    return sensorDatum > 19700101.0;
  }

  /**
   * Assume a sensor value is a date if it is greater jan 01, 1970 00:00:00
   * represented as a double
   * 
   * @param sensorDatum the datum which may be a date, datetime, temperature, or
   *                    humidity
   * @return true if it is a formatted date number
   */
  public boolean isDateTime(double sensorDatum) {
    return sensorDatum > 19700101000000.0;
  }

  /**
   * Converts the double date time format to just the date part by dividing and
   * rounding
   * 
   * @param dateTime YYYYMMDDhhmmss.0
   * @return YYYYMMDD.0
   */
  public double toDate(double dateTime) {
    return Math.floor(dateTime / 1000000.0); // convert YYYYMMDDhhmmss -> YYYYMMDD
  }

  /**
   * compares two YYYYMMDD.0 for equality
   * 
   * @param date1 one YYYYMMDD.0
   * @param date2 another YYYYMMDD.0
   * @return true if they are within some error tolerance (0.001) of each other
   */
  public boolean sameDate(double date1, double date2) {
    return Math.abs(date1 - date2) < 0.001;
  }

  /**
   * Reads an ordered sequence of data from the weather sensors to store in the
   * greenhouse
   * When called multiple times, appends the new readings after the current sensor
   * readings.
   * Invalid values are ignored
   * 
   * @param values An ordered sequence of [datetime, temperature, humidity,
   *               temperature, humidity, ..., datetime, temperature,
   *               humidity,....]
   *               - a date and time in yyyymmddHHMMSS format. E.g. 20231106183930
   *               for Nov 11, 2023, 6:39:30pm
   *               - temperature is either degrees Fahrenheit or -999 for an error
   *               case
   *               - humidity is either % from 0.0 to 100.0 or -999 for an error
   *               case
   *               Assume the sensor data always starts with a valid date
   *               The multiple temperature humidity pairs for a single datetime
   *               come from different plant sensors
   *               The values may skip dates and times when the sensors are off
   *               (you cannot assume that the date/time intervals will be
   *               regular)
   *               You *may* assume that the datetimes will be in ascending order
   */
  public void pollSensorData(List<Double> values) {
    boolean validData = false;
    for (double value : values) {
      if ((isDateTime(value) && value < clockAsDatetime())) {
        validData = false;
      } else if (isDateTime(value)) {
        validData = true;
        setClockTo(value);
      }
      if (validData) {
        dataIn.add(value);
      }
    }
  }

  /**
   * Processes the sensor data to create a list of DTH objects, representing Date,
   * Temperature, and Humidity.
   * The method also cleans, sorts, and updates the allTemps and allHumids lists.
   */
  public void process() {
    int size = dataIn.size();
    LinkedList<Double> tempTemps = new LinkedList<>();
    LinkedList<Double> tempHumids = new LinkedList<>();
    double holdDate = dataIn.get(0);
    int count = 1;
    for (int i = 1; i < size; i++) {
      if (isDate(dataIn.get(i)) && toDate(dataIn.get(i)) != toDate(holdDate)) {
        clean(tempHumids);
        clean(tempTemps);
        tempHumids.sort(Double::compareTo);
        tempTemps.sort(Double::compareTo);
        dths.add(new DTH(holdDate, List.copyOf(tempHumids), List.copyOf(tempTemps)));
        tempHumids.clear();
        tempTemps.clear();
        holdDate = dataIn.get(i);
        count = 1;
        continue;
      }
      if (count % 2 == 1 && !isDateTime(dataIn.get(i))) {
        allTemps.add(dataIn.get(i));
        tempTemps.add(dataIn.get(i));
      } else if (!isDateTime(dataIn.get(i))) {
        allHumids.add(dataIn.get(i));
        tempHumids.add(dataIn.get(i));
      }
      count++;
    }
    clean(tempHumids);
    clean(tempTemps);
    tempHumids.sort(Double::compareTo);
    tempTemps.sort(Double::compareTo);
    dths.add(new DTH(holdDate, List.copyOf(tempHumids), List.copyOf(tempTemps)));
    tempHumids.clear();
    tempTemps.clear();

    clean(allTemps);
    clean(allHumids);
    allTemps.sort(Double::compareTo);
    allHumids.sort(Double::compareTo);
  }

  /**
   * Cleans a list by removing elements with a value of -999.
   *
   * @param list The list to be cleaned.
   */
  public void clean(LinkedList<Double> list) {
    list.removeIf((number) -> number == -999);
  }

  /**
   * produces a pair of the middle temperature and humidity (respectively) from
   * the stored readings ignoring error values (-999s)
   * 
   * @return a new SensorReading object that has the middle temperature of all the
   *         sensor values (value at index (size() / 2) of the sorted
   *         temperatures)
   *         and the middle humidity of the sorted humidities
   *         If there are no valid temperature or humidity values, respectively,
   *         then the resulting sensor reading should have -999 for that data
   */
  public TempHumidReading middleReading() {
    if (dataIn.isEmpty() || allTemps.isEmpty() || allHumids.isEmpty()) {
      return new SuperTempHumidReading(-999, -999);
    }
    double midTemp = allTemps.get(allTemps.size() / 2);
    double midHumid = allHumids.get(allHumids.size() / 2);
    return new SuperTempHumidReading(midTemp, midHumid);
  }

  /**
   * produces a pair of the middle temperature and humidity (respectively) from
   * the stored readings ignoring error values (-999s)
   * 
   * @param onDate the date which to consider medianReadings for (inclusive) with
   *               the format YYYYMMDD.0
   * @return a new SensorReading object that has the middle temperature of all the
   *         sensor values (value at index (size() / 2) of the sorted
   *         temperatures)
   *         and the middle humidity of the sorted humidities
   *         If there are no valid temperature or humidity values, respectively,
   *         then the resulting sensor reading should have -999 for that data
   */
  public TempHumidReading middleReading(double onDate) {
    if (dataIn.isEmpty() || allTemps.isEmpty() || allHumids.isEmpty()) {
      return new SuperTempHumidReading(-999, -999);
    }
    DTH targetdth = null;
    for (DTH dth : dths) {
      if (toDate(dth.date) == onDate) {
        targetdth = dth;
      }
    }
    double midTemp = targetdth.temperature.get(targetdth.temperature.size() / 2);
    double midHumid = targetdth.humidity.get(targetdth.humidity.size() / 2);
    return new SuperTempHumidReading(midTemp, midHumid);
  }

  /**
   * Calculates the percentage of error values in the stored sensor data.
   * The error percentage is computed based on the number of occurrences of the
   * error value -999
   * in the sensor data
   * 
   * @return The percentage of error values in the sensor data.
   */
  public double percentError() {
    int errorCount = 0;
    int dates = 0;
    for (double data : dataIn) {
      if (data == -999) {
        errorCount++;
      }
      if (isDateTime(data)) {
        dates++;
      }
    }
    return 100 * ((double) errorCount / (dataIn.size() - dates));
  }

  /**
   * A helper method to convert a gregroian calendar to a HW3 style datetime
   * double
   * 
   * @return a HW3 style datetime double
   */
  private double clockAsDatetime() {
    double year = clock.get(Calendar.YEAR);
    double month = clock.get(Calendar.MONTH) + 1;
    double day = clock.get(Calendar.DAY_OF_MONTH);
    double hour = clock.get(Calendar.HOUR_OF_DAY);
    double minute = clock.get(Calendar.MINUTE);
    double second = clock.get(Calendar.SECOND);
    return second +
        (minute * 100.0) + // shifted 2 decimal places
        (hour * 100.0 * 100.0) + // shifted 4 decimal places
        (day * 100.0 * 100.0 * 100.0) + // shifted 6 decimal places
        (month * 100.0 * 100.0 * 100.0 * 100.0) + // shifted 8 decimal places
        (year * 100.0 * 100.0 * 100.0 * 100.0 * 100.0); // shifted 10 decimal places
  }

  /**
   * Given a datetime as a double, make a java.util.GregorianCalendar object with
   * the
   * appropriate year, month, day of the month, hour of the day, minute, and
   * second.
   *
   * @param datetime a double in the format YYYYMMDDhhmmss.0
   *                 for example 20231112133045 for the date time Nov 12th 2023 at
   *                 1:30:45pm
   */
  public void setClockTo(double datetime) {
    String datetimeStr = String.format("%.0f", datetime);

    int year = Integer.parseInt(datetimeStr.substring(0, 4));
    // Subtract 1 from month because GregorianCalendar months are 0-based
    int month = Integer.parseInt(datetimeStr.substring(4, 6)) - 1;
    int day = Integer.parseInt(datetimeStr.substring(6, 8));
    int hour = Integer.parseInt(datetimeStr.substring(8, 10));
    int minute = Integer.parseInt(datetimeStr.substring(10, 12));
    int second = Integer.parseInt(datetimeStr.substring(12, 14));
    this.clock = new GregorianCalendar(year, month, day, hour, minute, second);
  }
}
