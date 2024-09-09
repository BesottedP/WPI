import java.util.HashMap;
import java.util.Optional;
/**
 * An implementation of the I3VoteStrategy interface
 * that calculates the winner based on most agreeable votes
 */

public class MostAgreeableStrategy implements I3VoteStrategy {

    /**
     * Calculates the winner based on the most agreeable votes.
     *
     * @param votes a HashMap containing candidate names as keys and their corresponding Vote objects as values.
     * 
     * @return Optional<String> containing the name of the winner if present, or empty if there is no winner.
     */
    @Override
    public Optional<String> calculateWinner(HashMap<String, Votes> votes) {
        String winner = null;
        int max = 0;
        for (HashMap.Entry<String, Votes> entry : votes.entrySet()) {
            int firstVotes = entry.getValue().getFirstVotes();
            int secondVotes = entry.getValue().getSecondVotes();
            int thirdVotes = entry.getValue().getThirdVotes();

            if (firstVotes >= secondVotes && firstVotes >= thirdVotes) {
                if (firstVotes > max) {
                    winner = entry.getKey();
                    max = firstVotes;
                }
            } else if (secondVotes >= firstVotes && secondVotes >= thirdVotes) {
                if (secondVotes > max) {
                    winner = entry.getKey();
                    max = secondVotes;
                }
            } else {
                if (thirdVotes > max) {
                    winner = entry.getKey();
                    max = thirdVotes;
                }
            }
        }
        if (winner == null) {
            return Optional.empty();
        }
        return Optional.of(winner);
    }
}
