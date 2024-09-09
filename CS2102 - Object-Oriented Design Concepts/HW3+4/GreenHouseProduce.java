
/**
 * An abstract superclass that provides template methods for subclasses.
 * It contains methods for calculating polling sensor data.
 * The class also utilizes helper methods for cleaning and sorting data.
 */

import java.util.GregorianCalendar;
import java.util.List;

public class GreenHouseProduce extends AbsGreenHouse {

    /**
     * Constructs a GreenHouseNursery object.
     */
    public GreenHouseProduce() {
        super();
    }

    /**
     * Constructs a GreenHouseNursery object with the specified initial Gregorian
     * calendar.
     * 
     * @param gc The initial Gregorian calendar for the greenhouse nursery.
     */
    public GreenHouseProduce(GregorianCalendar gc) {
        super(gc);
    }

    /**
     * Reads an ordered sequence of data from the weather sensors to store in the
     * greenhouse
     * When called multiple times, appends the new readings after the current sensor
     * readings
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
    @Override
    public void pollSensorData(List<Double> values) {
        super.pollSensorData(values);
        process();
    }

}
