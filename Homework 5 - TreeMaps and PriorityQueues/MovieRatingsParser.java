/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

    public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {

	/* IMPLEMENT THIS METHOD! */
	TreeMap<String, PriorityQueue<Integer>> ratingMap =
		new TreeMap<>();

	if (allUsersRatings == null) return ratingMap;

	for (UserMovieRating rating : allUsersRatings) {
	    if (rating == null || rating.movie == null ||
		    rating.movie.length() == 0 ||
		    rating.userRating < 0) {
		continue;
	    } else {
		String title = rating.movie.toLowerCase();
		if (ratingMap.containsKey(title)) {
		    ratingMap.get(title).add(rating.userRating);
		} else {
		    PriorityQueue<Integer> ratingQueue =
			    new PriorityQueue<>();
		    ratingQueue.add(rating.userRating);
		    ratingMap.put(title, ratingQueue);
		}
	    }
	}

	return ratingMap; // this line is here only so this code will compile if you don't modify it
    }

}
