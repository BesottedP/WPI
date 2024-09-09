import java.util.Optional;
import java.util.Scanner;

public class VotingMachine {
    private static ElectionData eData = new ElectionData(new MostFirstVotesStrategy());
    private static Scanner scanner = new Scanner(System.in);

    public VotingMachine() {

    }

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("Current candidates are: " + eData.getCandidates());
            System.out.println(
                    "Do you want to [n]ominate someone, [v]ote for someone, change winner [s]trategy, see who [w]on, or [q]uit?");
            String input = scanner.nextLine();
            switch (input) {
                case "q":
                    run = false;
                    continue;
                case "n":
                    System.out.println("Who do you want to nominate?");
                    nomCandidate(scanner.nextLine());
                    continue;
                case "v":
                    System.out.println("Who is your first choice?");
                    String first = scanner.nextLine();
                    System.out.println("Who is your second choice?");
                    String second = scanner.nextLine();
                    System.out.println("Who is your third choice?");
                    String third = scanner.nextLine();
                    try {
                        eData.submitVote(first, second, third);
                    } catch (CandidateNotNominatedException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Would you like to nominate this candidate? [y]es/[n]o");
                        if (scanner.nextLine().equals("y")) {
                            nomCandidate(e.getCandidate());
                        }
                    } catch (MoreThanOnceException e) {
                        System.out.println(e.getMessage());
                    }
                    continue;
                case "s":
                    System.out.println("Which strategy would you like to use? most [f]irst votes or most [a]greeable?");
                    String choice = scanner.nextLine();
                    if (choice.equals("f")) {
                        eData.setStrategy(new MostFirstVotesStrategy());
                    } else if (choice.equals("a")) {
                        eData.setStrategy(new MostAgreeableStrategy());
                    } else {
                        System.out.println("Please enter either [f]irsst votes or most [a]greeable");
                    }
                    continue;
                case "w":
                    Optional<String> winner = eData.calculateWinner();
                    if (winner.isPresent()) {
                        System.out.println(eData.calculateWinner().get() + " is the winner!");
                    } else {
                        System.out.println("No clear winner under the current strategy.");
                    }
                    continue;
            }
        }
        System.out.println("Thanks for voting!");
    }

    public static void nomCandidate(String candidate) {
        try {
            eData.nominateCandidate(candidate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
