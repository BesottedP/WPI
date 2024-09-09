package wpialgs.day04;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * This is a quick demonstration of ThreeSum from pp. 173.
 * <p>
 * % java wpialgs.day04.ThreeSum 1Kints.txt
 *
 * @author Yu-Shan Sun
 *
 * @version 1.0
 */
public class ThreeSum {

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
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        StdOut.println(count(a));
    }
}