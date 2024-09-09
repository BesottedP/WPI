package wpialgs.day03;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * This is a modified version of the Dijkstra's Two-Stack Algorithm for expression evaluation on pp. 129. It uses our
 * defined {@link IStack} and {@link FixedCapacityStack}.
 * <p>
 * To run in IntelliJ / Eclipse, you will need to enter your input into the Console window directly. After you press
 * return, nothing appears to happen. This is because you need to "close" the {@code StdIn}.
 * <p>
 * This is done on a PC by pressing Control-z.
 * <p>
 * On a Macintosh (I am not making this up), to terminate the input, click the mouse anywhere else in Eclipse (typically
 * just back in the source code or in the package explorer), then click BACK in the console window and press Control-d
 * (not Command-d). If you are using IntelliJ, you can just press Command-d in the console.
 *
 * @author George Heineman
 * @author Yu-Shan Sun
 *
 * @version 1.0
 */
public class DijkstraTwoStackAlgs {

    /**
     * The main entry point to the program.
     *
     * @param args
     *            Command line arguments
     */
    public static void main(String[] args) {
        // YS: Modified to used our fixed capacity stack.
        IStack<String> ops = new FixedCapacityStack<>(100);
        IStack<Double> vals = new FixedCapacityStack<>(100);
        while (!StdIn.isEmpty()) { // Read token, push if operator.
            String s = StdIn.readString();
            if (s.equals("("))
                ;
            else if (s.equals("+"))
                ops.push(s);
            else if (s.equals("-"))
                ops.push(s);
            else if (s.equals("*"))
                ops.push(s);
            else if (s.equals("/"))
                ops.push(s);
            else if (s.equals("sqrt"))
                ops.push(s);
            else if (s.equals(")")) { // Pop, evaluate, and push result if token is ")".
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+"))
                    v = vals.pop() + v;
                else if (op.equals("-"))
                    v = vals.pop() - v;
                else if (op.equals("*"))
                    v = vals.pop() * v;
                else if (op.equals("/"))
                    v = vals.pop() / v;
                else if (op.equals("sqrt"))
                    v = Math.sqrt(v);
                vals.push(v);
            } // Token not operator or paren: push double value.
            else
                vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());

        // set a breakpoint on this line and you can observe the state
        // of the ops stack and vals stack. You will need this for your
        // answer.
        StdOut.println();
    }
}