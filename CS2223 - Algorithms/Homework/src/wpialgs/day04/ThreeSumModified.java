package wpialgs.day04;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * This is a quick demonstration of a modified ThreeSum from pp. 173. In this version, we ask the user for the random
 * number seed and total number of random integers to generate and count the number of triplets that add up to 0.
 * <p>
 * % java wpialgs.day04.ThreeSumModified 0 32
 *
 * @author George Heineman
 * @author Yu-Shan Sun
 *
 * @version 2.0
 */
public class ThreeSumModified {

    /**
     * This counts the number of triplets that add up to 0.
     *
     * @param a
     *            An array of distinct numbers
     *
     * @return The number of triplets that add up to 0.
     */
    public static int count(int[] a) {
        // Count triplets that sum to 0.
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    /**
     * The main entry point to the program.
     *
     * @param args
     *            Command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Error: Wrong number of arguments!");
            System.err.println("Usage: java wpialgs.day04.ThreeSumModified <rand_seed> <#_of_integers>");
        } else {
            StdRandom.setSeed(Long.parseLong(args[0]));
            int N = Integer.parseInt(args[1]);

            int[] ar = new int[N];
            for (int i = 0; i < N; i++) {
                ar[i] = StdRandom.uniformInt(-10000, 10000);
            }

            Stopwatch timer = new Stopwatch();
            int numTriples = ThreeSumModified.count(ar);
            double time = timer.elapsedTime();

            StdOut.println(numTriples + " triples + " + time + " seconds");
        }
    }
}