import java.util.GregorianCalendar;

/**
 * An abstract superclass that provides template methods for subclasses.
 * It contains methods for calculating middle readings.
 * The class also utilizes helper methods for cleaning and sorting data.
 */

public class GreenHouseNursery extends AbsGreenHouse {

    /**
     * Constructs a GreenHouseNursery object.
     */
    public GreenHouseNursery() {
        super();
    }

    /**
     * Constructs a GreenHouseNursery object with the specified initial Gregorian
     * calendar.
     * 
     * @param gc The initial Gregorian calendar for the greenhouse nursery.
     */
    public GreenHouseNursery(GregorianCalendar gc) {
        super(gc);
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
    @Override
    public TempHumidReading middleReading() {
        if (dataIn.isEmpty()) {
            return new SuperTempHumidReading(-999, -999);
        }
        this.process();
        return super.middleReading();
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
    @Override
    public TempHumidReading middleReading(double onDate) {
        if (dataIn.isEmpty()) {
            return new SuperTempHumidReading(-999, -999);
        }
        this.process();
        return super.middleReading(onDate);
    }

}
