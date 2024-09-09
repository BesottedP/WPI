package wpialgs.day06;

import wpialgs.day05.Node;

/**
 * This is a linked-list implementation exercise to be completed in class.
 *
 * @author Roger Van Scoy
 * @author Yu-Shan Sun
 *
 * @version 2.0
 */
public class LinkedList<E> {

    // Class attributes
    private Node<E> headNode;
    private Node<E> tailNode;
    private int listLength;

    /**
     * <p>
     * Default constructor
     * </p>
     */
    public LinkedList() {
        headNode = null;
        tailNode = null;
        listLength = 0;
    }

    /**
     * <p>
     * Returns the head of the list.
     * </p>
     *
     * @return Node representing the beginning of the list.
     */
    public Node<E> getHeadOfList() {
        return headNode;
    }

    /**
     * <p>
     * Returns the tail of the list.
     * </p>
     *
     * @return Node representing the end of the list.
     */
    public Node<E> getTailOfList() {
        return tailNode;
    }

    /**
     * <p>
     * Adds newData to the beginning of the list.
     * </p>
     *
     * @param newData
     *            Element to be added.
     */
    public void insertAtHead(E newData) {
        //Case 1: Empty
        if(headNode == null){
            headNode = new Node<>(newData, null);
            tailNode = headNode;
        }

        //Case 2: List not empty
        else{
            Node<E> temp = new Node<>(newData, headNode);
            headNode = temp;

            // headnode = newNode<>(newData, headNode);
        }

    }

    /**
     * <p>
     * Adds newData to the end of the list.
     * </p>
     *
     * @param newData
     *            Element to be added.
     */
    public void insertAtTail(E newData) {
        if (headNode == null){
            headNode = new Node<>(newData, null);
            tailNode = headNode;
        }
        else{
            Node<E> temp = new Node<>(newData, null);
            tailNode.insertAfter(temp);
            tailNode = temp;
        }
    }

    /**
     * <p>
     * Prints the contents of the list.
     * </p>
     */
    public void printList() {
        Node<E> current = headNode;
        while(current != null){
            System.out.println(current.getDataVal());
            current = current.getNext();
        }

    }

    /**
     * <p>
     * Checks to see if the list is empty.
     * </p>
     *
     * @return {@code true} if the list is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return false; // FIX ME!
    }

    /**
     * <p>
     * Checks to see if the list is full.
     * </p>
     *
     * @return {@code true} if the list is full, {@code false} otherwise.
     */
    public boolean isFull() {
        return false; // since there's really no way to know this
    }

    /**
     * <p>
     * Returns the number of elements in the linked list.
     * </p>
     *
     * @return The length of the linked list.
     */
    public int getListLength() {
        return listLength;
    }

    /**
     * <p>
     * Clears the entire linked list.
     * </p>
     */
    public void clearList() {

    }

    /**
     * <p>
     * Searches the entire linked list looking for particular value. You may assume that {@link E} has a properly
     * implemented {@link Object#equals(Object)} and {@link Object#hashCode()} methods.
     * </p>
     *
     * @param searchData
     *            Element that we are going to look for in our list.
     *
     * @return The node that contains this element.
     */
    public Node<E> findNode(E searchData) {

        Node<E> current = headNode;
        while (current != null) {
            if (current.getDataVal().equals(searchData)) {
                return current;
            }
            current = current.getNext();
        }
        return current;
    }

    /**
     * <p>
     * Attempts to replaces an element in our linked list. If the element does not exist in our list, then no change is
     * made to the list.
     * </p>
     *
     * @param searchData
     *            Element that we are going to look for in our list.
     * @param newData
     *            New element that will replace {@code searchData}.
     */
    public void replaceNode(E searchData, E newData) {

    }

    /**
     * <p>
     * Attempts to insert before an element in our linked list. If the element does not exist in our list, then no
     * change is made to the list.
     * </p>
     *
     * @param searchData
     *            Element that we are going to look for in our list.
     * @param newData
     *            New element that will be inserted before {@code searchData}.
     */
    public void insertBefore(E searchData, E newData) {

    }

    /**
     * <p>
     * Attempts to insert after an element in our linked list. If the element does not exist in our list, then no change
     * is made to the list.
     * </p>
     *
     * @param searchData
     *            Element that we are going to look for in our list.
     * @param newData
     *            New element that will be inserted after {@code searchData}.
     */
    public void insertAfter(E searchData, E newData) {

    }

    /**
     * <p>
     * Attempts to remove an element in our linked list. If the element does not exist in our list, then no change is
     * made to the list.
     * </p>
     *
     * @param searchData
     *            Element that we are going to look for in our list.
     *
     * @return A node containing the element that we removed. If we didn't remove anything from our list, this method
     *         returns {@code null}.
     */
    public Node<E> removeNode(E searchData) {
        return null; // FIX ME!
    }
}