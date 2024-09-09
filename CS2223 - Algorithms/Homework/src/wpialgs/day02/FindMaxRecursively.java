package wpialgs.day02;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

/**
 * This is a quick demonstration of find max recursively using the fewest comparisons.
 *
 * @author George Heineman
 * @author Yu-Shan Sun
 *
 * @version 2.0
 */
public class FindMaxRecursively {

    /**
     * The main entry point to the program.
     *
     * @param args
     *            Command line arguments
     */
    public static void main(String[] args) {
        int[] sample = { 3, 5, 9, 1, 2 };
        StdOut.println("max of " + Arrays.toString(sample) + " is " + findMaximum(sample));

        sample = new int[] { 13, 5, 9, 1, 2 };
        StdOut.println("max of " + Arrays.toString(sample) + " is " + findMaximum(sample));

        sample = new int[] { 13, 5, 9, 1, 22 };
        StdOut.println("max of " + Arrays.toString(sample) + " is " + findMaximum(sample));
    }

    /**
     * This helper method sanity checks the input before calling {@link #findMaximum(int[], int, int)} to locate the
     * maximum element in the array.
     *
     * @param values
     *            List of values
     *
     * @return The maximum value in the array
     *
     * @throws IllegalArgumentException
     *             We have an empty array.
     */
    private static int findMaximum(int[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("Cannot find maximum of an empty array.");
        }

        if (values.length == 1) {
            return values[0];
        }

        return findMaximum(values, 0, values.length - 1);
    }

    /**
     * This uses the recursive approach to locate the maximum number in the array using the fewest comparisons.
     *
     * @param a
     *            List of values
     * @param lo
     *            Lowest index to start the search
     * @param hi
     *            Highest index to start the search
     *
     * @return The maximum value in the array
     */
    private static int findMaximum(int[] a, int lo, int hi) {
        /* Base Case: Two elements just requires one comparison. */
        if (hi - lo == 1) {
            if (a[lo] < a[hi]) {
                return a[hi];
            } else {
                return a[lo];
            }
        }

        /* Recursive case: compute largest of remaining objects. One additional comparison. */
        int max = findMaximum(a, lo + 1, hi);
        if (max < a[lo]) {
            return a[lo];
        } else {
            return max;
        }
    }
}