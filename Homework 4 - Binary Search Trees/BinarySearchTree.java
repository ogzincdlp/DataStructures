import javax.print.attribute.standard.NumberUpSupported;

public class BinarySearchTree<E extends Comparable<E>> {
    class Node {
	E value;
	Node leftChild = null;
	Node rightChild = null;
	Node(E value) {
	    this.value = value;
	}
	@Override
	public boolean equals(Object obj) {
	    if ((obj instanceof BinarySearchTree.Node) == false)
		return false;
	    Node other = (BinarySearchTree.Node)obj;
	    return other.value.compareTo(value) == 0 &&
		    other.leftChild == leftChild && other.rightChild == rightChild;
	}
    }

    protected Node root = null;

    protected void visit(Node n) {
	System.out.println(n.value);
    }

    public boolean contains(E val) {
	return contains(root, val);
    }

    protected boolean contains(Node n, E val) {
	if (n == null) return false;

	if (n.value.equals(val)) {
	    return true;
	} else if (n.value.compareTo(val) > 0) {
	    return contains(n.leftChild, val);
	} else {
	    return contains(n.rightChild, val);
	}
    }

    public boolean add(E val) {
	if (root == null) {
	    root = new Node(val);
	    return true;
	}
	return add(root, val);
    }

    protected boolean add(Node n, E val) {
	if (n == null) {
	    return false;
	}
	int cmp = val.compareTo(n.value);
	if (cmp == 0) {
	    return false; // this ensures that the same value does not appear more than once
	} else if (cmp < 0) {
	    if (n.leftChild == null) {
		n.leftChild = new Node(val);
		return true;
	    } else {
		return add(n.leftChild, val);
	    } 	
	} else {
	    if (n.rightChild == null) {
		n.rightChild = new Node(val);
		return true;
	    } else {
		return add(n.rightChild, val);
	    } 	
	}
    }	

    public boolean remove(E val) {
	return remove(root, null, val);
    }

    protected boolean remove(Node n, Node parent, E val) {
	if (n == null) return false;

	if (val.compareTo(n.value) == -1) {
	    return remove(n.leftChild, n, val);
	} else if (val.compareTo(n.value) == 1) {
	    return remove(n.rightChild, n, val);
	} else {
	    if (n.leftChild != null && n.rightChild != null){
		n.value = maxValue(n.leftChild);
		remove(n.leftChild, n, n.value);
	    } else if (parent == null) {
		root = n.leftChild != null ? n.leftChild : n.rightChild;
	    } else if (parent.leftChild == n){
		parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
	    } else {
		parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
	    }
	    return true;
	}
    }

    protected E maxValue(Node n) {
	if (n.rightChild == null) {
	    return n.value;
	} else {
	    return maxValue(n.rightChild);
	}
    }


    /*********************************************
     * 
     * IMPLEMENT THE METHODS BELOW!
     *
     *********************************************/


    // Method #1.
    public Node findNode(E val) {

	/* IMPLEMENT THIS METHOD! */
	
	if (val == null) return null;

	return findNode(root, val);
    }

    protected Node findNode(Node node, E val) {
	if (node == null) return null;
	if (node.value.compareTo(val) == 0) return node;
	else if (node.value.compareTo(val) > 0) {
	    return findNode(node.leftChild, val);
	} else {
	    return findNode(node.rightChild, val);
	}
    }

    // Method #2.
    protected int depth(E val) {

	/* IMPLEMENT THIS METHOD! */
	if (val == null) return -1;
	return depth(val, root, -1);
    }
    
    protected int depth(E val, Node n, int parentDepth) {
	if (n == null) return -1;

	if (n.value.equals(val)) {
	    return parentDepth + 1;
	} else if (n.value.compareTo(val) > 0) {
	    return depth(val, n.leftChild, parentDepth + 1);
	} else {
	    return depth(val, n.rightChild, parentDepth + 1);
	}
    }

    // Method #3.
    protected int height(E val) {

	/* IMPLEMENT THIS METHOD! */
	
	return val == null ? -1 : height(findNode(val));

    }
    
    protected int height(Node n) {
	if (n == null) return -1;
	else
	    return 1 + Math.max((n.leftChild == null ? -1 : height(n.leftChild)),
		    (n.rightChild == null ? -1 : height(n.rightChild)));
    }


    // Method #4.
    protected boolean isBalanced(Node n) {

	/* IMPLEMENT THIS METHOD! */
	
	if (n == null) return false;
	if (findNode(n.value) == null) return false;
	if (Math.abs(height(n.leftChild) -
		height(n.rightChild)) <= 1) {
	    return true;
	}

	return false;
    }
    
    protected boolean areChildrenBalanced(Node n) {
	return isBalanced(n) && isBalanced(n.leftChild) &&
		isBalanced(n.rightChild);
    }

    // Method #5. .
    public boolean isBalanced() {

	/* IMPLEMENT THIS METHOD! */
	return areChildrenBalanced(root);
    }
}
