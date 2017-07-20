/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;


public class MovieRatingsProcessor {

    public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {

	/* IMPLEMENT THIS METHOD! */

	return getAlphabeticalMoviesAboveRating(movieRatings, 0);

    }

    public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {

	PriorityQueue<String> movieQueue = new PriorityQueue<>();
	List<String> movieList = new LinkedList<String>();

	if (movieRatings == null) return movieList;

	for (Map.Entry<String, PriorityQueue<Integer>> entry :
	    movieRatings.entrySet()) {
	    if (entry.getValue().peek() > rating)
	        movieQueue.add(entry.getKey());
	}

	for (String movieName : movieQueue) {
	    movieList.add(movieName);
	}

	return movieList; // this line is here only so this code will compile if you don't modify it
    }

    public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {

	/* IMPLEMENT THIS METHOD! */
	TreeMap<String, Integer> removedRatings = new TreeMap<>();
	List<String> moviesToBeRemoved = new ArrayList<>();
	if (movieRatings == null) return removedRatings;
	
	for (Map.Entry<String, PriorityQueue<Integer>> entry :
	    movieRatings.entrySet()) {
	    int removed = 0;
	    while (entry.getValue().peek() != null &&
		    entry.getValue().peek() < rating) {
		entry.getValue().remove();
		removed++;
	    }
	    if (entry.getValue().peek() == null) {
		moviesToBeRemoved.add(entry.getKey());
	    }
	    
	    if (removed > 0) {
		removedRatings.put(entry.getKey(), removed);
	    }
	}
	
	for (String movieName : moviesToBeRemoved) {
	    movieRatings.remove(movieName);
	}

	return removedRatings; // this line is here only so this code will compile if you don't modify it
    }
}
