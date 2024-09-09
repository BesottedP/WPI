package wpialgs.day04;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * This is a quick demonstration of the doubling test from pp. 177 using {@link ThreeSumModified}.
 * <p>
 * % java wpialgs.day04.DoublingTest
 *
 * @author George Heineman
 * @author Yu-Shan Sun
 *
 * @version 2.0
 */
public class DoublingTest {

    private static final int MAXIMUM_INTEGER = 1000000;

    // This class should not be instantiated.
    private DoublingTest() {
    }

    /**
     * Returns the amount of time to call {@link ThreeSumModified#count(int[])} with <em>N</em> random 6-digit integers.
     *
     * @param N
     *            the number of integers
     *
     * @return amount of time (in seconds) to call {@link ThreeSumModified#count(int[])} with <em>N</em> random 6-digit
     *         integers
     */
    public static double timeTrial(int N) {
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniformInt(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        ThreeSumModified.count(a);
        return timer.elapsedTime();
    }

    /**
     * Prints table of running times to call {@link ThreeSumModified#count(int[])} for arrays of size 250, 500, 1000,
     * 2000, and so forth.
     *
     * @param args
     *            Command line arguments
     */
    public static void main(String[] args) {
        for (int N = 250; N <= 16000; N *= 2) {
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
        }
    }
}