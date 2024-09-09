package wpialgs.day02;

import edu.princeton.cs.algs4.*; // MUST ADD THIS AT START!
import java.util.Arrays;

/**
 * code from p. 47 of the 4ed Sedgewick.
 *
 * % java wpialgs.day02 tinyAllowedlist.txt < tinyText.txt
 */
public class BinarySearch {

    /**
     * An implementation of binary search by Sedgewick.
     *
     * @param key
     *            Item we are looking for
     * @param a
     *            Array of elements
     *
     * @return Index where the element is located if found, otherwise -1.
     */
    public static int indexOf(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }

        return -1;
    }

    /**
     * The main entry point to the program.
     *
     * @param args
     *            Command line arguments
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (indexOf(key, whitelist) == -1)
                StdOut.println(key);
        }
    }
}