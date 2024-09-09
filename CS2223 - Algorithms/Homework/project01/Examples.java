/*
 * Examples.java
 *
 * Author: Your Name
 * Submitted on: Insert Date
 *
 * Academic Honesty Declaration:
 *
 * The following code represents my own work and I have neither received nor given assistance
 * that violates the collaboration policy posted with this assignment. I have not copied or modified code
 * from any other source other than the homework assignment, course textbook, or course lecture slides.
 * Any unauthorized collaboration or use of materials not permitted will be subjected to academic integrity policies of
 * WPI and CS 2223.
 *
 * I acknowledge that this homework assignment is based upon an assignment created by WPI and that any publishing or
 * posting of this code is prohibited unless I receive written permission from WPI.
 */
package wpialgs.project01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This class provides test cases for our homework 1.
 *
 * @version 1.0
 */
public class Examples {

    // Fields
    public List<String> EMPTY_LIST;
    public List<String> LIST1;

    // Constructor
    public Examples() {
        EMPTY_LIST = Collections.emptyList();
        LIST1 = new ArrayList<>();
    }

    // ===========================================================
    // JUnit Test Methods
    // ===========================================================

    // -----------------------------------------------------------
    // Constructor (Given)
    // -----------------------------------------------------------

    /**
     * Testing the constructor and checking we have an empty deque.
     */
    @Test
    public void testConstructor() {
        IDeque<String> deque = new ArrayDeque<>(10);
        assertEquals(EMPTY_LIST.toString(), deque.toString());
        assertEquals(0, deque.length());
    }

    // -----------------------------------------------------------
    // enqueue
    // -----------------------------------------------------------

    // -----------------------------------------------------------
    // dequeue
    // -----------------------------------------------------------

    // -----------------------------------------------------------
    // inject
    // -----------------------------------------------------------

    // -----------------------------------------------------------
    // removeLast
    // -----------------------------------------------------------

    // -----------------------------------------------------------
    // peek
    // -----------------------------------------------------------

    // -----------------------------------------------------------
    // endOfDeque
    // -----------------------------------------------------------

    // -----------------------------------------------------------
    // length
    // -----------------------------------------------------------

    // -----------------------------------------------------------
    // clear
    // -----------------------------------------------------------
}