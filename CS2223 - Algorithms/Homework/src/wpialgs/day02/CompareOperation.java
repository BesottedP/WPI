package wpialgs.day02;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * This program tests the timing comparison of addition vs. multiplication vs. square root.
 *
 * @author George Heineman
 * @author Yu-Shan Sun
 *
 * @version 2.0
 */
public class CompareOperation {

    /**
     * The main entry point to the program.
     *
     * @param args
     *            Command line arguments
     */
    public static void main(String[] args) {
        // timing comparison of addition vs. multiplication vs. square root
        if (args.length == 0) {
            args = new String[] { "32768" };
        }
        int N = Integer.parseInt(args[0]);

        // only here so the code won't be detected as having no external effect.
        long sum;
        long[] numbers = new long[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = StdRandom.uniformInt(-1000000, 1000000);
        }

        Stopwatch addsw = new Stopwatch();
        sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += (numbers[i] + numbers[j]);
            }
        }
        StdOut.println("Add:" + addsw.elapsedTime() + " seconds");
        StdOut.println("For the record, sum was " + sum);

        Stopwatch multsw = new Stopwatch();
        sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += (numbers[i] * numbers[j]);
            }
        }
        StdOut.println("Mult:" + multsw.elapsedTime() + " seconds");
        StdOut.println("For the record, sum was " + sum);

        Stopwatch sqrtsw = new Stopwatch();
        sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += (Math.sqrt(numbers[i]) + Math.sqrt(numbers[j]));
            }
        }
        StdOut.println("Sqrt:" + sqrtsw.elapsedTime() + " seconds");
        StdOut.println("For the record, sum was " + sum);
    }
}