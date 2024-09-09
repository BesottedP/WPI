/**
 * Implements the BTValidator interface and provides methods to validate
 * the addition and removal of values in a max heap tree while still keeping the tree a max heap.
 */

public class MaxHeapValidator implements BTValidator {

    /**
     * Check if adding i to the old tree and getting the new tree is possible with the current invariants
     * @param oldTree the given tree we assume respects the invariants
     * @param i the value to add
     * @param newTree the new tree which we are validating
     * @return true if we determine that the new tree respects the invariants
     */
    @Override
    public boolean validAdd(IBinTree oldTree, int i, IBinTree newTree) {
        return isMaxHeap(newTree) &&
                contains(newTree, i) &&
                containsAll(oldTree, newTree) &&
                newTree.size() == oldTree.size() + 1;
    }

    /**
     * Check if removing i from the old tree and getting the new tree is possible with the current invariants
     * @param oldTree the given tree we assume respects the invariants
     * @param i the value to remove
     * @param newTree the new tree which we are validating
     * @return true if we determine that the new tree respects the invariants
     */
    @Override
    public boolean validRemove(IBinTree oldTree, int i, IBinTree newTree) {
        return isMaxHeap(newTree) &&
                !contains(newTree, i) &&
                containsAll(newTree, oldTree) &&
                newTree.size() == oldTree.size() - 1;
    }

    /**
     * Check if a binary tree contains a specific value.
     *
     * @param tree    the binary tree to search
     * @param target  the value to search for
     * @return true if the value is present in the tree, false otherwise
     */
    private boolean contains(IBinTree tree, int target) {
        if (tree.isEmpty()) {
            return false;
        } else if (tree.getRoot() == target) {
            return true;
        } else {
            return contains(tree.getLeft(), target) || contains(tree.getRight(), target);
        }
    }

     /**
     * Check if a max heap tree contains all values from another tree.
     *
     * @param treeToCheck  the tree to check for containing only values from the master tree
     * @param masterTree  the tree with values assumed to be present
     * @return true if the check tree contains all values of the master tree, false otherwise
     */
    private boolean containsAll(IBinTree treeToCheck, IBinTree masterTree) {
        if (treeToCheck.isEmpty()) {
            return true;
        }
        if (!contains(masterTree, treeToCheck.getRoot())) {
            return false;
        }
        return (containsAll(treeToCheck.getLeft(), masterTree) && containsAll(treeToCheck.getRight(), masterTree));
    }

    /**
     * Check if a tree is a max heap tree.
     *
     * @param tree  the tree to check
     * @return true if the tree is a max heap tree, false otherwise
     */
    private boolean isMaxHeap(IBinTree tree) {
        if (tree.isEmpty() || tree.getLeft().isEmpty() || tree.getRight().isEmpty()) {
            return true;
        }
        if (tree.getLeft().getRoot() > tree.getRoot() || tree.getRight().getRoot() > tree.getRoot()) {
            return false;
        } else {
            return isMaxHeap(tree.getLeft()) && isMaxHeap(tree.getRight());
        }
    }
}
