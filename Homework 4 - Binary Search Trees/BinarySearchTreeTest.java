import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
    BinarySearchTree<Integer> numbers;
    BinarySearchTree<String> words;

    @Before
    public void setUp() throws Exception {
	numbers = new BinarySearchTree<>();
	words = new BinarySearchTree<>();
    }

    @Test
    public void testFindNodeEmptyTree() {
	
	assertTrue(numbers.findNode(6) == null);
    }
    
    @Test
    public void testFindNode() {
	numbers.add(5);
	numbers.add(7);
	
	assertTrue(numbers.findNode(5).value.equals(5));
	assertTrue(numbers.findNode(7).value.equals(7));
	assertTrue(numbers.findNode(6) == null);
    }
    
    @Test
    public void testFindNodeGrandchild() {
	numbers.add(8);
	numbers.add(6);
	numbers.add(16);
	numbers.add(4);
	numbers.add(10);
	numbers.add(20);
	numbers.add(2);
	numbers.add(9);
	numbers.add(12);
	
	assertTrue(numbers.findNode(4).value.equals(4));
	assertTrue(numbers.findNode(9).value.equals(9));
    }
    
    @Test
    public void testDepthRoot() {
	numbers.add(5);
	numbers.add(7);
	
	assertEquals(0, numbers.depth(5));
    }
    
    @Test
    public void testDepthNodeNotFound() {
	numbers.add(5);
	numbers.add(7);
	
	assertEquals(-1, numbers.depth(4));
    }
    
    @Test
    public void testDepthLeaf() {
	numbers.add(5);
	numbers.add(4);
	numbers.add(3);
	numbers.add(8);
	numbers.add(6);

	
	assertEquals(0, numbers.depth(5));
	assertEquals(1, numbers.depth(4));
	assertEquals(2, numbers.depth(3));
	assertEquals(1, numbers.depth(8));
	assertEquals(2, numbers.depth(6));
    }
    
    @Test
    public void testHeightRoot() {
	numbers.add(8);
	numbers.add(6);
	numbers.add(16);
	numbers.add(4);
	numbers.add(10);
	numbers.add(20);
	numbers.add(2);
	numbers.add(9);
	numbers.add(12);

	
	assertEquals(3, numbers.height(8));
    }
    
    @Test
    public void testHeightLeaves() {
	numbers.add(8);
	numbers.add(6);
	numbers.add(16);
	numbers.add(4);
	numbers.add(10);
	numbers.add(20);
	numbers.add(2);
	numbers.add(9);
	numbers.add(12);

	
	assertEquals(0, numbers.height(2));
	assertEquals(0, numbers.height(9));
	assertEquals(0, numbers.height(12));
	assertEquals(0, numbers.height(20));
    }
    
    @Test
    public void testHeightInternalNodes() {
	numbers.add(8);
	numbers.add(6);
	numbers.add(16);
	numbers.add(4);
	numbers.add(10);
	numbers.add(20);
	numbers.add(2);
	numbers.add(9);
	numbers.add(12);

	
	assertEquals(2, numbers.height(6));
	assertEquals(2, numbers.height(16));
	assertEquals(1, numbers.height(10));
	assertEquals(1, numbers.height(4));
    }
    
    @Test
    public void testHeightNodeNotFound() {
	numbers.add(8);
	numbers.add(6);
	numbers.add(16);
	numbers.add(4);
	numbers.add(10);
	numbers.add(20);
	numbers.add(2);
	numbers.add(9);
	numbers.add(12);

	
	assertEquals(-1, numbers.height(1));
    }
    
    @Test
    public void testIsBalanced() {
	numbers.add(8);
	numbers.add(6);
	numbers.add(16);
	numbers.add(4);
	numbers.add(10);
	numbers.add(20);
	numbers.add(2);
	numbers.add(9);
	numbers.add(12);

	
	assertTrue(numbers.isBalanced(numbers.findNode(16)));
	assertFalse(numbers.isBalanced(numbers.findNode(6)));
    }

}
