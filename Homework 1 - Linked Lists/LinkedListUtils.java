

import java.util.LinkedList;

import java.util.Iterator;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

//    public static void insertSorted(LinkedList<Integer> list, int value) {
//
//	/* IMPLEMENT THIS METHOD! */
//	Integer current = list.peek();
//	if (current == null) {
//	    list.add(value);
//	} else {
//	    try {
//		int index = 0;
//		while (current < value) {
//		    index++;
//		    current = list.get(index);
//		}
//		list.add(index, value);
//	    }
//	    catch (IndexOutOfBoundsException e) {
//		list.addLast(value);
//	    }
//	}
//
//    }
    
    
    public static void insertSorted(LinkedList<Integer> list, int value) {

	/* IMPLEMENT THIS METHOD! */
	Integer current = list.peek();
	if (current == null) {
	    list.add(value);
	} else {
	    Iterator iter = list.iterator();
	    int index = 0;
	    while (iter.hasNext()){
		current = (Integer)iter.next();
		if (current > value) break;
		index++;
	    }
	    list.add(index, value);
//	    try {
//		int index = 0;
//		while (current < value) {
//		    index++;
//		    current = list.get(index);
//		}
//		list.add(index, value);
//	    }
//	    catch (IndexOutOfBoundsException e) {
//		list.addLast(value);
//	    }
	}

    }
    
    public static String findMax(LinkedList<String> list) {
	String max = list.peek();
	String current;
	if (max != null) {
	    Iterator iter = list.iterator();
	    while (iter.hasNext()) {
		current = (String)iter.next();
		if (current.compareTo(max) > 0) {
		    max = current;
		}
		
	    }
	}
	return max;
    }
    
    public static void deleteAllOccurences(LinkedList<String> words,
	    String word) {
	boolean deleted;
	while (true) {
	    deleted = words.remove(word);
	    if (!deleted) break;
	}
    }


    public static void removeMaximumValues(LinkedList<String> list, int N) {

	/* IMPLEMENT THIS METHOD! */
	if (list == null || N <= 0) return;
	else {
	    String max = findMax(list);
	    deleteAllOccurences(list, max);
	    removeMaximumValues(list, N - 1);
	}

    }

    public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

	/* IMPLEMENT THIS METHOD! */
	if (one == null || two == null) return false;
	Iterator<Integer> iterOne = one.iterator();
	Iterator<Integer> iterTwo;
	Iterator<Integer> iterSubsequence;
	int index = 0;
	Integer current;
	boolean flag = true;
	
	while (iterOne.hasNext()) {
	    current = (Integer)iterOne.next();
	    if (current == two.peek()) {
		iterTwo = two.iterator();
		iterSubsequence = one.listIterator(index);
		while (iterTwo.hasNext() && iterSubsequence.hasNext()) {
		    flag = flag & (int)iterTwo.next() == (int) iterSubsequence.next();
		}
		if (flag && !iterTwo.hasNext()) return true;
	    } else {
		index++;
	    }
	}

	return false; // this line is here only so this code will compile if you don't modify it
    }

    public static void main(String[] args) {
//	LinkedList<Integer> numbers = new LinkedList<>();
//	numbers.add(5);
//	numbers.add(7);
//	LinkedListUtils.insertSorted(numbers, 6);
//
//	for (Integer num : numbers) {
//	    System.out.println(num);
//	}
	
//	LinkedList<String> words = new LinkedList<>();
//	words.add("a");
//	words.add("z");
//	words.add("c");
//	words.add("d");
//	words.add("a");
	
//	LinkedListUtils.deleteAllOccurences(words, "b");
//	removeMaximumValues(words, 2);
	
//	System.out.println(findMax(words));
//	for (String word : words) {
//	    System.out.println(word);
//	}
//	LinkedList<Integer> one = new LinkedList<>();
//	LinkedList<Integer> two = new LinkedList<>();
//	
//	one.add(4);
//	one.add(5);
//	one.add(6);
//	one.add(7);
//	
//	two.add(4);
//	two.add(5);
//	two.add(6);
//	two.add(7);
//	
//	System.out.println(containsSubsequence(one, two));
    }
}
