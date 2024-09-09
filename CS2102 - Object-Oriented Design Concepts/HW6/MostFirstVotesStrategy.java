import java.util.HashMap;
import java.util.Optional;
/**
 * An implementation of the I3VoteStrategy interface
 * that calculates the winner based on most first votes
 */

public class MostFirstVotesStrategy implements I3VoteStrategy {

    /**
     * Calculates the winner based on the most first votes.
     *
     * @param votes a HashMap containing candidate names as keys and their corresponding Vote objects as values.
     * 
     * @return Optional<String> containing the name of the winner if present, or empty if there is no winner.
     */
    @Override
    public Optional<String> calculateWinner(HashMap<String, Votes> votes) {
        String winner = null;
        int winnerVotes = 0;
        int totalVotes = 0;
        for (HashMap.Entry<String, Votes> entry : votes.entrySet()) {
            totalVotes += entry.getValue().getFirstVotes();
            if (entry.getValue().getFirstVotes() > winnerVotes) {
                winner = entry.getKey();
                winnerVotes = entry.getValue().getFirstVotes();
            } else if (entry.getValue().getFirstVotes() == winnerVotes) {
                winner = null;
            }
        }
        if ((double) winnerVotes / totalVotes <= 0.5) {
            winner = null;
        }

        if (winner == null) {
            return Optional.empty();
        }
        return Optional.of(winner);
    }

}
