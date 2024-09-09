import java.util.List;

/**
 * A DTO for valid temperatures and humidities, which are assigned to their
 * respective date of collection
 */
public class DTH {

    /**
     * A date in the format YYYYMMDDhhmmss.0
     */
    public double date;
    /**
     * A list of humidity values in percent
     */
    public List<Double> humidity;

    /**
     * A list of temperature values in Fahrenheit
     */
    public List<Double> temperature;

    /**
     * Constructs a DTH object with the specified date, humidity values, and
     * temperature values.
     * 
     * @param dateTime    a date in the format YYYYMMDDhhmmss.0
     * @param humidity    a list of humidities in percentage
     * @param temperature a list of temperatures in Fahrenheit
     */
    public DTH(double date, List<Double> humidity, List<Double> temperature) {
        this.date = date;
        this.humidity = humidity;
        this.temperature = temperature;
    }
}