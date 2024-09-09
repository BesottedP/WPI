import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;

public class Examples {
    ElectionData eData;

    public Examples() {
        eData = new ElectionData(new MostFirstVotesStrategy());
    }

    @Test
    public void testSetStrategy() {
        eData.setStrategy(new MostFirstVotesStrategy());
    }

    @Test
    public void testNominateCandidates() {
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetCandidates() {
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");
        } catch (Exception e) {
            fail(e.getMessage());
        }
        Set<String> candidates = new HashSet<String>();
        candidates.add("gompei");
        candidates.add("husky");
        candidates.add("bristaco");
        assertEquals(candidates, this.eData.getCandidates());
    }

    @Test
    public void testGetCandidatesWrong() {
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");
        } catch (Exception e) {
            fail(e.getMessage());
        }
        Set<String> candidates = new HashSet<String>();
        candidates.add("gompei");
        candidates.add("husky");
        candidates.add("bristaco");
        Set<String> candidates2 = this.eData.getCandidates();
        candidates2.add("Henry");
        assertEquals(candidates, candidates2);
    }

    @Test
    public void testOneVoteFV() {
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");
            this.eData.submitVote("gompei", "husky", "bristaco");
        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertEquals(Optional.of("gompei"), this.eData.calculateWinner());
    }

    @Test
    public void testZeroVoteFV() {
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");
        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertEquals(Optional.empty(), this.eData.calculateWinner());
    }

    @Test
    public void testManyVoteFV_Majority() {
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");
            this.eData.submitVote("gompei", "husky", "bristaco");
            this.eData.submitVote("husky", "gompei", "bristaco");
            this.eData.submitVote("bristaco", "husky", "gompei");
            this.eData.submitVote("gompei", "husky", "bristaco");
            this.eData.submitVote("gompei", "bristaco", "husky");
        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertEquals(Optional.of("gompei"), this.eData.calculateWinner());
    }

    @Test
    public void testManyVoteFV_NonMajority() {
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");
            this.eData.nominateCandidate("henry");
            this.eData.submitVote("gompei", "husky", "bristaco");
            this.eData.submitVote("husky", "gompei", "bristaco");
            this.eData.submitVote("bristaco", "husky", "gompei");
            this.eData.submitVote("gompei", "husky", "bristaco");
            this.eData.submitVote("gompei", "bristaco", "husky");
            this.eData.submitVote("husky", "bristaco", "gompei");
            this.eData.submitVote("henry", "gompei", "bristaco");
        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertEquals(Optional.empty(), this.eData.calculateWinner());
    }

    @Test
    public void testTieVoteFV() {
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");
            this.eData.submitVote("gompei", "husky", "bristaco");
            this.eData.submitVote("husky", "gompei", "bristaco");
            this.eData.submitVote("bristaco", "husky", "gompei");
            this.eData.submitVote("husky", "gompei", "bristaco");
            this.eData.submitVote("gompei", "bristaco", "husky");
        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertEquals(Optional.empty(), this.eData.calculateWinner());
    }

    @Test
    public void testManyVoteMA() {
        try {
            eData.setStrategy(new MostAgreeableStrategy());
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");
            this.eData.nominateCandidate("henry");
            this.eData.submitVote("gompei", "husky", "bristaco");
            this.eData.submitVote("bristaco", "gompei", "husky");
            this.eData.submitVote("bristaco", "gompei", "henry");
            this.eData.submitVote("husky", "bristaco", "gompei");
            this.eData.submitVote("henry", "gompei", "husky");
        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertEquals(Optional.of("gompei"), this.eData.calculateWinner());
    }

    @Test
    public void testManyVoteMA2() {
        try {
            eData.setStrategy(new MostAgreeableStrategy());
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");
            this.eData.nominateCandidate("henry");
            this.eData.submitVote("gompei", "husky", "bristaco");
            this.eData.submitVote("bristaco", "husky", "gompei");
            this.eData.submitVote("bristaco", "husky", "gompei");
        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertEquals(Optional.of("husky"), this.eData.calculateWinner());
    }

    @Test
    public void testnoVoteMA() {
        try {
            eData.setStrategy(new MostAgreeableStrategy());
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");
            this.eData.nominateCandidate("henry");

        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertEquals(Optional.empty(), this.eData.calculateWinner());
    }

    // Exception testing

    @Test(expected = AlreadyNominatedException.class)
    public void testCandidateAlreadyNominated() throws AlreadyNominatedException {
        this.eData.nominateCandidate("gompei");
        this.eData.nominateCandidate("gompei");

        fail("did not throw exception properly");
    }

    @Test(expected = CandidateNotNominatedException.class)
    public void testCandidateNotNominated()
            throws CandidateNotNominatedException, AlreadyNominatedException, MoreThanOnceException {
        this.eData.nominateCandidate("gompei");
        this.eData.nominateCandidate("husky");
        this.eData.nominateCandidate("bristaco");
        this.eData.submitVote("gompei", "Akaash", "Krish");
        this.eData.submitVote("gompei", "Akaash", "Krish");

        fail("did not throw exception properly");
    }

    @Test(expected = MoreThanOnceException.class)
    public void testCandidateMultipleVotes()
            throws CandidateNotNominatedException, AlreadyNominatedException, MoreThanOnceException {
        this.eData.nominateCandidate("gompei");
        this.eData.nominateCandidate("husky");
        this.eData.nominateCandidate("bristaco");
        this.eData.nominateCandidate("henry");
        this.eData.submitVote("gompei", "gompei", "gompei");

        fail("did not throw exception properly");
    }

}