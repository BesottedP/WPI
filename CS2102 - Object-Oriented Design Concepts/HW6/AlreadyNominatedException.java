/**
 * An exception class that gets thrown when attempting to
 * nominate a candidate who has already been nominated
 */

public class AlreadyNominatedException extends Exception {

    /**
     * Constucts an AlreadyNominatedException with the specified candidate
     * 
     * @param name the name of the candidate that is already nominated
     * 
     */
    public AlreadyNominatedException(String name) {
        super(name + " is already nominated");
    }
}
