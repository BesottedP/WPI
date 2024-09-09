/** 
 * An exception class that gets thrown when attempting to
 * vote for a candidate more than once 
*/
public class MoreThanOnceException extends Exception {

    /**
     * Constucts an MoreThanOnceException with the specified candidate
     * 
     * @param name the name of the candidate that was voted for more than once
     * 
     */
    public MoreThanOnceException(String name) {
        super(name + " has been voted for more than once");
    }
}
