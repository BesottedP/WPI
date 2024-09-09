import java.util.LinkedList;
import java.util.List;

public class MainStrategy implements ParsedDataStrategy {

    /**
     * Cleans a list by removing elements with a value of -999.
     *
     * @param list The list to be cleaned.
     */
    @Override
    public void clean(LinkedList<Double> list) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'process'");
    }

    /**
     * Processes the sensor data to create a list of DTH objects, representing Date,
     * Temperature, and Humidity.
     * The method also cleans, sorts, and updates the allTemps and allHumids lists.
     */
    @Override
    public void process() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'process'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'middleReading'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'middleReading'");
    }

}
