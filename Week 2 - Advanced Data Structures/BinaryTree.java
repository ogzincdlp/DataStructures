
public class BinaryTree {

    class Node {
	int value;
	Node leftChild = null;
	Node rightChild = null;

	Node(int value) {
	    this.value = value;
	}

    }

    protected Node root = null;


    public void inorderTraversal(Node n) {
	if (n == null) return;
	inorderTraversal(n.leftChild);
	visit(n);
	inorderTraversal(n.rightChild);
    }

    public void visit(Node n) {
	System.out.println(n.value);
    }

    public boolean binaryTreeSearch(Node n, int value) {
	if (n == null) return false;

	if (n.value == value) return true;
	else if (n.value > value)
	    return binaryTreeSearch(n.leftChild, value);
	else
	    return binaryTreeSearch(n.rightChild, value);
    }

    public boolean add(Node n, int value) {
	if (n.value == value) {
	    return false;  //no duplicates
	}
	else if (n.value > value) {
	    if (n.leftChild == null) {
		n.leftChild = new Node(value);
		return true;
	    } else {
		return add(n.leftChild, value);
	    }
	} else {
	    if (n.rightChild == null) {
		n.rightChild = new Node(value);
		return true;
	    } else {
		return add(n.rightChild, value);
	    }
	}

    }

    public boolean remove(Node n, Node parent, int val) {
	if (n == null) {
	    return false; //value is not in the tree
	}
	
	if (val < n.value) {
	    return remove(n.leftChild, n, val);
	} else if (val > n.value) {
	    return remove(n.rightChild, n, val);
	} else { //found the value to be removed
	    
	    if (n.leftChild != null && n.rightChild != null) {
		n.value = maxValue(n.leftChild);
		remove(n.leftChild, n, n.value);
	    } else if (parent.leftChild == n) {
		parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
	    } else { //parent.rightChild == n
		parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
	    }
	    return true;
	}

    }
    
    public int maxValue(Node n) {
	return 0;
    }

}
