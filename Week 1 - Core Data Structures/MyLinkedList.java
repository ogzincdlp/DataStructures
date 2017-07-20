
public class MyLinkedList {

    class Node {
	int value;
	Node next = null;

	Node(int value) {
	    this.value = value;
	}
    }

    protected Node head = null;
    protected Node tail = null;


    /*
     * add element to the front of the linked list
     */
    public void addToFront(int value) {
	Node newNode = new Node(value);
	newNode.next = head;
	head = newNode;

	if (newNode.next == null) {
	    tail = newNode;
	}
    }

    /*
     * add element to the back of the linked list
     */
    public void addToBack(int value) {
	Node newNode = new Node(value);

	if (tail == null) {
	    head = newNode;
	} else {
	    tail.next = newNode;
	}
	tail = newNode;

    }

    /*
     * add element at an index
     */
    public void addAtIndex(int index, int value) {

	if (index < 0) {
	    throw new IndexOutOfBoundsException();
	} else if (index == 0) {
	    addToFront(value);
	} else {

	    Node newNode = new Node(value);
	    Node current = head;

	    for (int i = 0; i < index - 1; i++) {
		if (current == null) {
		    throw new IndexOutOfBoundsException();
		}
		current = current.next;
	    }
	    if (current.next == null) { //adding to tail
		addToBack(value);
	    } else {
		newNode.next = current.next;
		current.next = newNode;
	    }
	}


    }

    public boolean contains(int value) {
	Node current = head;

	while (current != null) {
	    if (current.value == value) return true;
	    current = current.next;
	}
	return false;
    }

    public int getByIndex(int index) {
	if (index < 0) {
	    throw new IndexOutOfBoundsException();
	} else {
	    Node current = head;
	    for (int i = 0; i < index; i++) {
		if (current == null || current.next == null) {
		    throw new IndexOutOfBoundsException();
		}
		current = current.next;
	    }

	    return current.value;
	}
    }

    public void removeFromFront() {
	if (head != null) {
	    head = head.next;
	}

	if (head == null) {
	    tail = null;
	}
    }

    public void removeFromBack() {

	if (head == null) return; //empty list
	else if (head.equals(tail)) { //single element list
	    head = null;
	    tail = null;
	} else {
	    Node current = head;

	    while (current.next != tail) {
		current = current.next;
	    }

	    tail = current;
	    tail.next = null;
	}
    }
    
    public void removeAtIndex(int index) {
	if (index < 0) {
	    throw new IndexOutOfBoundsException();
	} else if (index == 0) {
	    removeFromFront();
	} else {
	    Node current = head;
	    for (int i = 0; i < index - 1; i++) {
		if (current == null) {
		    throw new IndexOutOfBoundsException();
		}
		current = current.next;
	    }
	    current.next = current.next.next;
	    if (current.next == null) { //removing last node
		tail = current;
	    }
	    
	}
    }

}
