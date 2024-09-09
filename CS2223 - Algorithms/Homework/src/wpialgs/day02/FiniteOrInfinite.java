package wpialgs.day02;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * This is a test program to check if this terminates or not.
 *
 * @author George Heineman
 * @author Yu-Shan Sun
 *
 * @version 2.0
 */
public class FiniteOrInfinite {

    /**
     * The main entry point to the program.
     *
     * @param args
     *            Command line arguments
     */
    public static void main(String[] args) {
        long max = Integer.MIN_VALUE;

        for (int t = 0; t < 10000000; t++) {
            long v = StdRandom.uniformInt(Integer.MAX_VALUE);
            long numLoops = trial(v);
            if (numLoops > max) {
                max = numLoops;
                StdOut.println(v + " needs " + max + " loops.");
            }
        }
    }

    /**
     * A short piece of code that we are testing if it terminates.
     *
     * @param v
     *            A positive value to try
     *
     * @return Number of loop executions before terminating.
     */
    private static long trial(long v) {
        long numLoops = 0;
        while (v != 1) {
            numLoops++;
            if (v % 2 == 0) {
                v = v / 2;
            } else {
                v = 3 * v + 1;
            }
        }

        return numLoops;
    }
}