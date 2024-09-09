package wpialgs.day06;

import wpialgs.day05.Node;
import java.util.Scanner;

/**
 * This is a linked-list test class to be completed in class.
 *
 * @author Roger Van Scoy
 * @author Yu-Shan Sun
 *
 * @version 2.0
 */
public class LinkedListTest {

    /**
     * The main entry point to the program.
     *
     * @param args
     *            Command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner inSS;

        // Temporary variables
        String commandLine;
        Node<Integer> tempNode = null;
        String tempString;
        char cmd;
        int newData;
        int oldData;

        // Our linked-list
        LinkedList<Integer> myList = new LinkedList<>();

        do {
            print_menu();

            // Use another Scanner to parse the input string
            commandLine = sc.nextLine();
            inSS = new Scanner(commandLine.substring(1));
            cmd = commandLine.charAt(0);

            switch (cmd) {
            case '+': // Insert x at the end
                newData = inSS.nextInt();
                myList.insertAtTail(newData);
                break;
            case '*': // Insert x at head
                newData = inSS.nextInt();
                myList.insertAtHead(newData);
                break;
            case 'P':
            case 'p': // Print current list contents
                System.out.println("------------------");
                myList.printList();
                System.out.println("------------------");
                break;
            case '^': // Replace item x with y
                oldData = inSS.nextInt();
                newData = inSS.nextInt();
                System.out.println("------------------");
                System.out.println("NOT IMPLEMENTED YET....");
                System.out.println("------------------");
                break;
            case '>': // Insert y after x
                oldData = inSS.nextInt();
                newData = inSS.nextInt();
                System.out.println("------------------");
                System.out.println("NOT IMPLEMENTED YET.....");
                System.out.println("------------------");
                break;
            case '<': // Insert y before x
                oldData = inSS.nextInt();
                newData = inSS.nextInt();
                System.out.println("------------------");
                System.out.println("NOT IMPLEMENTED YET......");
                System.out.println("------------------");
                break;
            case '-': // Remove the data item
                oldData = inSS.nextInt();
                System.out.println("------------------");
                System.out.println("NOT IMPLEMENTED YET.......");
                System.out.println("------------------");
                break;
            case 'C':
            case 'c': // Clear the list
                myList.clearList();
                break;
            case 'E':
            case 'e': // Empty list?
                if (myList.isEmpty()) {
                    System.out.println("------------------");
                    System.out.println("List is EMPTY.");
                    System.out.println("------------------");
                } else {
                    System.out.println("------------------");
                    System.out.println("List is NOT empty.");
                    System.out.println("------------------");
                }
                break;
            case 'F':
            case 'f': // Full list?
                System.out.println("------------------");
                System.out.println("Well...there is really no good way to know...");
                System.out.println("------------------");
                break;
            case 'L':
            case 'l': // Current List Size
                System.out.println("------------------");
                System.out.printf("There are %d items in the list.\n", myList.getListLength());
                System.out.println("------------------");
                break;
            case '?': // Search list for x
                oldData = inSS.nextInt();
                System.out.println("------------------");
                tempNode = myList.findNode(oldData);
                if (tempNode != null) {
                    System.out.printf("FOUND %d in list.\n", oldData);
                } else {
                    System.out.printf("%d NOT found in list.\n", oldData);
                }
                System.out.println("------------------");
                break;
            case 'M':
            case 'm': // Menu
                print_menu();
                break;
            case 'Q':
            case 'q': // Quit test program
                break;
            default: // Invalid command
                System.out.println("Invalid command");
                break;
            }
        } while (cmd != 'Q' && cmd != 'q');
    }

    /**
     * A helper method that prints our menu of options.
     */
    public static void print_menu() {
        System.out.println("Menu...");
        System.out.println("  M      : Menu (displays this message)");
        System.out.println("  +x     : Insert x at the end");
        System.out.println("  *x     : Insert x at the head");
        System.out.println("  >x y   : Insert y after item x");
        System.out.println("  <x y   : Insert y before item x");
        System.out.println("  ^x y   : Replace item x with y");
        System.out.println("  -x     : Find & Remove the item x");
        System.out.println("  ?x     : Search list for x");
        System.out.println("  C      : Clear the list");
        System.out.println("  E      : List Empty?");
        System.out.println("  F      : List Full?");
        System.out.println("  L      : Current List Size");
        System.out.println("  P      : Print current list contents");
        System.out.println("  Q      : Quit the test program");
        System.out.print("Enter Command: ");
    }
}