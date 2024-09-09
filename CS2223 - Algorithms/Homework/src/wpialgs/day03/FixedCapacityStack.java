package wpialgs.day03;

import java.util.Iterator;

/**
 * This is a simplified version from p. 141 implementation (no resize) and implements the {@link IStack} interface.
 *
 * @author George Heineman
 * @author Yu-Shan Sun
 *
 * @version 2.0
 */
public class FixedCapacityStack<E> implements Iterable<E>, IStack<E> {

    private E[] a; // holds the items
    private int N; // number of items in stack

    /**
     * This creates an empty stack with the given capacity.
     *
     * @param capacity
     *            Maximum number of elements that this stack can hold.
     */
    public FixedCapacityStack(int capacity) {
        a = (E[]) new Object[capacity]; // You cannot create an array of Es using the new keyword. However, all classes
                                        // extend Object...
        N = 0;
    }

    /**
     * This adds an element to the top of the stack.
     *
     * @param item
     *            The element to be added.
     */
    @Override
    public void push(E item) {
        a[N++] = item;
    }

    /**
     * This removes the top element of the stack.
     *
     * @return Top element in the stack.
     */
    @Override
    public E pop() {
        E item = a[--N];
        a[N] = null; // Avoid loitering (see text).
        return item;
    }

    /**
     * This checks whether the stack is empty.
     *
     * @return {@code true} when the stack is empty, {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * This checks whether the stack is full.
     *
     * @return {@code true} when the stack is full, {@code false} otherwise.
     */
    @Override
    public boolean isFull() {
        return N == a.length;
    }

    /**
     * This produces an {@link Iterator} that can be used to iterate over the elements in the array.
     *
     * @return An {@link Iterator} object.
     */
    @Override
    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }

    /**
     * This returns the size of the stack.
     *
     * @return The number of items on the stack.
     */
    @Override
    public int size() {
        return N;
    }

    /**
     * This overrides the default {@link Object#toString()} method to produce a string representation of a stack.
     *
     * @return A string representation of the stack.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < N; i++) {
            sb.append(a[i]);
            sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

    /**
     * Returns values in order that you would get them if you pop'd them one at a time.
     */
    private class ReverseArrayIterator implements Iterator<E> {
        private int i = N;

        /**
         * This checks if we can keep iterating.
         *
         * @return {@code true} if there are more elements, {@code false} otherwise.
         */
        public boolean hasNext() {
            return i > 0;
        }

        /**
         * This returns the next element to be iterated.
         *
         * @return Next element in the array.
         */
        public E next() {
            return a[--i];
        }
    }
}