import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Examples {

    IBinTree mt = new EmptyBT();

    @Test
    public void validateAddedContainsElt() {
        MaxHeapValidator validator = new MaxHeapValidator();
        assertTrue(validator.validAdd(mt, 3, new NodeBT(3, mt, mt)));
        assertFalse(validator.validAdd(mt, 3, new NodeBT(4, mt, mt)));
    }

    @Test
    public void validateAddedContainsElt2() {
        BinaryTree bt = new BinaryTree();
        for(int i = 15; i >= 0; i--) {
            bt.addInt(i);
        }
        bt.setValidator(new MaxHeapValidator());

        BinaryTree goodHeap = new BinaryTree(bt);
        goodHeap.setStrategy(new MaxHeapStrategy1());

        BinaryTree badHeap = new BinaryTree(bt);
        badHeap.setStrategy(new FaultyMaxHeapStrategy1());

        assertTrue(goodHeap.addInt(2));
        assertFalse(badHeap.addInt(4));
    }

    @Test
    public void validateRemoveContainsElt() {
        MaxHeapValidator validator = new MaxHeapValidator();
        assertTrue(validator.validRemove(new NodeBT(3, mt, mt), 3, mt));
        assertFalse(validator.validRemove(new NodeBT(4, mt, mt), 4, new NodeBT(4, mt, mt)));
    }
}
