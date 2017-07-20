
public class Heap {
    
    int[] values;
    int size = 0;
    
    public Heap(int maxHeight) {
	values = new int[(int)Math.pow(2, maxHeight) - 1];
    }
    
    public void swapValues(int index1, int index2) {
	int temp = values[index1];
	values[index1] = values[index2];
	values[index2] = temp;
    }
    
    public void add(int value) throws Exception {
	if (size == values.length) {
	    throw new Exception("Heap is full");
	}
	
	values[size] = value;
	bubbleUp(size);
	size++;
    }

    public void bubbleUp(int index) {
	if (index == 0) return;
	int parentIndex = (index - 1) / 2;
	if (values[parentIndex] < values[index]) {
	    swapValues(index, parentIndex);
	    bubbleUp(parentIndex);
	}
    }
    
    public int extract() throws Exception {
	if (size == 0) {
	    throw new Exception("The heap is empty");
	}
	
	int extractMax = values[0];
	values[0] = values[size - 1];
	bubbleDown(0);
	size--;
	return extractMax;
    }

    public void bubbleDown(int index) {
	int greaterChild;
	int leftIndex = 2 * index + 1;
	int rightIndex = 2 * index + 2;
	
	if (rightIndex < size &&
		values[rightIndex] > values[leftIndex]) {
	    greaterChild = rightIndex;
	} else if (leftIndex < size) {
	    greaterChild = leftIndex;
	} else return;
	
	if (values[index] < values[greaterChild]) {
	    swapValues(index, greaterChild);
	    bubbleDown(greaterChild);
	}
	
    }

}
