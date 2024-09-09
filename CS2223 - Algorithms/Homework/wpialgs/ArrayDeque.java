/*
 * ArrayDeque.java
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
package wpialgs;

/**
 * <p>
 * An array implementation of {@link IDeque}.
 * </p>
 *
 * @version 1.0
 */
public class ArrayDeque<E> extends AbsDeque<E> implements IDeque<E> {

    // ===========================================================
    // Member Fields
    // ===========================================================

    /**
     * <p>
     * Where the data is stored. myQ[0] is the front of the deque.
     * </p>
     */
    private final E[] myQ;

    /**
     * <p>
     * Tracks how many items in the deque, also used to find the end of the deque.
     * </p>
     */
    private int myLength;

    // ===========================================================
    // Constructors
    // ===========================================================

    /**
     * <p>
     * This creates a new array-based deque that is initially empty.
     * </p>
     *
     * @param capacity
     *            Maximum number of elements that can be stored in this deque.
     */
    @SuppressWarnings("unchecked")
    public ArrayDeque(int capacity) {
        // TODO: Replace the following line with your implementation
        throw new UnsupportedOperationException("IMPLEMENT ME!");
    }

    // ===========================================================
    // Public Methods
    // ===========================================================

    @Override
    public void enqueue(E item) {
        // TODO: Replace the following line with your implementation
        throw new UnsupportedOperationException("IMPLEMENT ME!");
    }

    @Override
    public E dequeue() {
        // TODO: Replace the following line with your implementation
        throw new UnsupportedOperationException("IMPLEMENT ME!");
    }

    @Override
    public void inject(E item) {
        // TODO: Replace the following line with your implementation
        throw new UnsupportedOperationException("IMPLEMENT ME!");
    }

    @Override
    public E removeLast() {
        // TODO: Replace the following line with your implementation
        throw new UnsupportedOperationException("IMPLEMENT ME!");
    }

    @Override
    public E peek() {
        // TODO: Replace the following line with your implementation
        throw new UnsupportedOperationException("IMPLEMENT ME!");
    }

    @Override
    public E endOfDeque() {
        // TODO: Replace the following line with your implementation
        throw new UnsupportedOperationException("IMPLEMENT ME!");
    }

    @Override
    public int length() {
        // TODO: Replace the following line with your implementation
        throw new UnsupportedOperationException("IMPLEMENT ME!");
    }

    @Override
    public void clear() {
        // TODO: Replace the following line with your implementation
        throw new UnsupportedOperationException("IMPLEMENT ME!");
    }
}