/**
 * The SuperTempHumidReading class represents a temperature and humidity reading with extended functionality.
 * It extends the TempHumidReading class and provides additional constructors as well as overriden equals and toString methods.
 */

public class SuperTempHumidReading extends TempHumidReading {

    /**
     * Constructs a SuperTempHumidReading object with the given temperature and humidity.
     *
     * @param temperature The temperature value.
     * @param humidity The humidity value.
     */
    public SuperTempHumidReading(double temperature, double humidity) {
        super(temperature, humidity);
    }

    /**
     * Constructs a SuperTempHumidReading object with default error values for temperature and humidity.
     */
    public SuperTempHumidReading(){
        super(-999, -999);
    }

    /**
     * Constructs a SuperTempHumidReading object using the values from an existing TempHumidReading object.
     *
     * @param reading The TempHumidReading object to copy values from.
     */
    public SuperTempHumidReading(TempHumidReading reading) {
        super(reading.temperature, reading.humidity);
    }

    /**
     * Compares this SuperTempHumidReading object with another object, and checks if they are equal.
     * Returns true if the other object is a SuperTempHumidReading with approximately equal temperature and humidity.
     *
     * @param o The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o){
        if(! (o instanceof SuperTempHumidReading)){
            return false;
        }
        SuperTempHumidReading so = (SuperTempHumidReading) o;
        boolean sameTemperature = Math.abs(this.temperature - so.temperature) <= 0.001;
        boolean sameHumidity = Math.abs(this.humidity - so.humidity) <= 0.001;

        return sameTemperature && sameHumidity;
    }

    /**
     * Returns a string representation of this SuperTempHumidReading object.
     * The string includes formatted temperature and humidity values, or "Err" if the values are set to default error values.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString(){
        String Temperature;
        String Humidity;
        if (this.temperature == -999){
            Temperature = "Err";
        }
        else{
            Temperature = String.format("%.1f", this.temperature) + "F";
        }

        if (this.humidity == -999){
            Humidity = "Err";
        }
        else{
            Humidity = String.format("%.1f", this.humidity) + "%";
        }

        return String.format("{%s;%s}", Temperature, Humidity);
    }

}
