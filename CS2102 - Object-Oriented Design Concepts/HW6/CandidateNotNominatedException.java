/** 
 * An exception class that gets thrown when attempting to
 * nominate a candidate who hasn't been nominated 
*/

public class CandidateNotNominatedException extends Exception {
    /**
     * Name of the candidate
     */
    private String candidate;

    /**
     * Constucts an CandidateNotNominatedException with the specified candidate
     * 
     * @param name the name of the candidate that isn't nominated
     * 
     */
    public CandidateNotNominatedException(String name) {
        super(name + " has not been nominated");
        candidate = name;
    }

    /**
     * Gets the name of the candidate associated with the exception.
     *
     * @return the name of the candidate.
     */
    public String getCandidate() {
        return candidate;
    }
}
