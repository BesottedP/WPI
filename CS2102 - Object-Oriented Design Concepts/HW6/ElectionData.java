import java.util.*;

/**
 * Represents the data structure and operations for managing election votes.
 */
public class ElectionData {
    /**
     * A HashMap of candidates and their corresponding Vote objects
     */
    private HashMap<String, Votes> votes;
    /**
     * The strategy used for calculating the election winner.
     */
    private I3VoteStrategy strategy;

    /**
     * Constructs an ElectionData object with the specified voting strategy.
     *
     * @param strategy The voting strategy to be used for calculating the winner.
     */
    public ElectionData(I3VoteStrategy strategy) {
        votes = new HashMap<String, Votes>();
        this.strategy = strategy;
    }

    /**
     * Sets the voting strategy for the election.
     *
     * @param strategy The new voting strategy to be set.
     */
    public void setStrategy(I3VoteStrategy strategy) {
        this.strategy = strategy;
    }

     /**
     * Gets the set of candidates nominated in the election.
     *
     * @return A set containing the names of all nominated candidates.
     */
    public Set<String> getCandidates(){
        Set<String> candidates = new HashSet<>();
        for (HashMap.Entry<String, Votes> entry : votes.entrySet()){
            candidates.add(entry.getKey());
        }
        return candidates;
    }

    /**
     * Nominates a candidate for the election.
     *
     * @param person The name of the candidate to be nominated.
     * @throws AlreadyNominatedException If the candidate has already been nominated.
     */
    public void nominateCandidate(String person) throws AlreadyNominatedException{
        if(votes.containsKey(person)){
            throw new AlreadyNominatedException(person);
        }
        votes.put(person, new Votes(0, 0, 0));
    }

    /**
     * Submits a vote for the specified candidates, assigning first, second, and third votes.
     *
     * @param first  The candidate chosen as the first vote.
     * @param second The candidate chosen as the second vote.
     * @param third  The candidate chosen as the third vote.
     * @throws CandidateNotNominatedException If any of the candidates have not been nominated.
     * @throws MoreThanOnceException          If a candidate is chosen more than once in the votes.
     */
    public void submitVote(String first, String second, String third) throws CandidateNotNominatedException, MoreThanOnceException{
        if(first.equals(second) || first.equals(third)){
            throw new MoreThanOnceException(first);
        }
        if(second.equals(third))
        {
          throw new MoreThanOnceException(second);  
        }
        if(!(votes.containsKey(first))){
            throw new CandidateNotNominatedException(first);
        }
        if(!(votes.containsKey(second))){
            throw new CandidateNotNominatedException(second);
        }
        if(!(votes.containsKey(third))){
            throw new CandidateNotNominatedException(third);
        }

        votes.get(first).voteFirst();
        votes.get(second).voteSecond();
        votes.get(third).voteThird();

    }

    /**
     * Calculates the winner of the election using the specified voting strategy.
     *
     * @return An optional containing the name of the winning candidate, if any.
     */
    public Optional<String> calculateWinner(){
        HashMap<String, Votes> votesCopy = new HashMap<>();
        
        for (HashMap.Entry<String, Votes> entry : votes.entrySet()){
            votesCopy.put(entry.getKey(), new Votes(entry.getValue()));
        }

        return strategy.calculateWinner(votesCopy);
    }
}
