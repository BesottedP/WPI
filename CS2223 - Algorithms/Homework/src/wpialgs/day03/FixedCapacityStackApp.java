package wpialgs.day03;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * This is a quick demonstration of fixed capacity stack.
 *
 * @author George Heineman
 * @author Yu-Shan Sun
 *
 * @version 2.0
 */
public class FixedCapacityStackApp {

    /**
     * The main entry point to the program.
     *
     * @param args
     *            Command line arguments
     */
    public static void main(String[] args) {
        StdOut.println("Enter numbers, one per line. Enter '-' to pop a value. Control-z to stop.");
        IStack<Integer> stack = new FixedCapacityStack<>(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(Integer.valueOf(item));
            else if (stack.isEmpty())
                StdOut.println("BAD INPUT");
            else
                StdOut.println("REMOVED: " + stack.pop());
        }
        StdOut.println();

        // print what's left on the stack
        StdOut.println("(" + stack.size() + " left on the stack)");
        for (Integer i : stack) {
            StdOut.print("REMOVED: " + i);
            StdOut.println();
        }
    }

}