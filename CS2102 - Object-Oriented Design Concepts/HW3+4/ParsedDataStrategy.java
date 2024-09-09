import java.util.LinkedList;

/**
 * An interface representing a strategy for parsing sensor data.
 */
public interface ParsedDataStrategy {

    /**
     * Cleans a list by removing elements with a value of -999.
     *
     * @param list The list to be cleaned.
     */
    public void clean(LinkedList<Double> list);

    /**
     * Processes the sensor data to create a list of DTH objects, representing Date,
     * Temperature, and Humidity.
     * The method also cleans, sorts, and updates the allTemps and allHumids lists.
     */
    public void process();

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
    public TempHumidReading middleReading();

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
    public TempHumidReading middleReading(double onDate);

}
