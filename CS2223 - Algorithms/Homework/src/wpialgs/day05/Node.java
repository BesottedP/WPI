package wpialgs.day05;

/**
 * This is a generic node class that can be used to build a linked structure.
 *
 * @author Roger Van Scoy
 * @author Yu-Shan Sun
 *
 * @version 2.0
 */
public class Node<E> {

    private E dataVal; // Node data
    private Node<E> nextNode; // Reference to the next node

    /**
     * This creates a new node with data and next location.
     *
     * @param dataInit
     *            Data to be stored at this node.
     * @param nextLoc
     *            Next location
     */
    public Node(E dataInit, Node<E> nextLoc) {
        this.dataVal = dataInit;
        this.nextNode = nextLoc;
    }

    /**
     * This returns the value stored at this node.
     *
     * @return Node value.
     */
    public E getDataVal() {
        return dataVal;
    }

    /**
     * This updates the value at this node.
     *
     * @param newValue
     *            The new value for this node.
     */
    public void setDataVal(E newValue) {
        dataVal = newValue;
    }

    /**
     * This returns the location pointed by the next node.
     *
     * @return The next node.
     */
    public Node<E> getNext() {
        return this.nextNode;
    }

    /**
     * This inserts a new node after this one.
     *
     * @param newNextNode
     *            The new next node for this node.
     */
    public void insertAfter(Node<E> newNextNode) {
        nextNode = newNextNode;
    }
}