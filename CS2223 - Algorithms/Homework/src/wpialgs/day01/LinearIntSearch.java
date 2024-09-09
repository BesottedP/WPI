package wpialgs.day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is a quick demonstration of linear search.
 *
 * @author Yu-Shan Sun
 *
 * @version 1.0
 */
public class LinearIntSearch {

    /**
     * The main entry point to the program.
     *
     * @param args
     *            Command line arguments
     */
    public static void main(String[] args) {
        try {
            // Open and read the contents of the file
            Scanner fileReader = new Scanner(new File(args[0]));

            String[] data = fileReader.nextLine().split(" ");
            int[] numbers = new int[data.length];
            for (int i = 0; i < data.length; i++) {
                numbers[i] = Integer.parseInt(data[i]);
            }
            fileReader.close();

            // Prompt for next number until done
            Scanner sc = new Scanner(System.in);
            int nextVal = 0;
            do {
                System.out.print("Enter a positive number to search for: ");
                nextVal = sc.nextInt();

                // Run linear search while keeping track of how long it takes to search
                if (nextVal > 0) {
                    long start = System.nanoTime();
                    int index = containsIndex(numbers, nextVal);
                    long finish = System.nanoTime();

                    // Display the results and the time elapsed
                    long timeElapsed = finish - start;
                    System.out.println("------------------------------------");
                    if (index != -1) {
                        System.out.println("The number: " + nextVal + " was found in index: " + index);
                    } else {
                        System.out.println("The number: " + nextVal + " was not found in the list");
                    }
                    System.out.println("The search took " + timeElapsed + " ns to run.");
                    System.out.println("------------------------------------");
                }
            } while (nextVal > 0);

            System.out.println("Goodbye for now!");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open the file: " + args[0]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The first command line argument should be a sorted list of numbers.");
        }
    }

    /**
     * This performs linear search on the collection sorted of integers.
     *
     * @param collection
     *            An array of sorted integers.
     * @param target
     *            The number we are searching for.
     *
     * @return True if we found it, false otherwise.
     */
    private static boolean contains(int[] collection, int target) {
        int i = 0;
        while (i < collection.length) {
            if (collection[i] == target) {
                return true;
            }

            i++;
        }

        return false;
    }

    /**
     * This performs linear search on the collection sorted of integers.
     *
     * @param collection
     *            An array of sorted integers.
     * @param target
     *            The number we are searching for.
     *
     * @return The array index where we found the number if we found it, -1 otherwise.
     */
    private static int containsIndex(int[] collection, int target) {
        int foundIndex = -1;
        int i = 0;
        while (i < collection.length && foundIndex == -1) {
            if (collection[i] == target) {
                foundIndex = i;
            }

            i++;
        }

        return foundIndex;
    }
}