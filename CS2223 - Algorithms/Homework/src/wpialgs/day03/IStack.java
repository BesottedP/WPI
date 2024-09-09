package wpialgs.day03;

/**
 * This is an interface for defining the stack operations
 *
 * @author Yu-Shan Sun
 *
 * @version 1.0
 */
public interface IStack<E> extends Iterable<E> {

    /**
     * This adds an element to the top of the stack.
     *
     * @param item
     *            The element to be added.
     */
    void push(E item);

    /**
     * This removes the top element of the stack.
     *
     * @return Top element in the stack.
     */
    E pop();

    /**
     * This checks whether the stack is empty.
     *
     * @return {@code true} when the stack is empty, {@code false} otherwise.
     */
    boolean isEmpty();

    /**
     * This checks whether the stack is full.
     *
     * @return {@code true} when the stack is full, {@code false} otherwise.
     */
    boolean isFull();

    /**
     * This returns the size of the stack.
     *
     * @return The number of items on the stack.
     */
    int size();

}