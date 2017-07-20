import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

public class MovieRatingsTest {
    
    TreeMap<String, PriorityQueue<Integer>> movieRatings;

    @Before
    public void setUp() throws Exception {
	movieRatings = new TreeMap<>();
    }

    @Test
    public void testMovieRatingParser() {
	UserMovieRating rating1 = new UserMovieRating("fight club", 4);
	UserMovieRating rating2 = new UserMovieRating("se7en", 5);
	
	List<UserMovieRating> ratingList =
		new ArrayList<UserMovieRating>();
	
	ratingList.add(rating1);
	ratingList.add(rating2);
	
	movieRatings =
		MovieRatingsParser.parseMovieRatings(ratingList);
	
	assertTrue(movieRatings.size() == 2);
    }
    
    @Test
    public void testMovieRatingParserNullInput() {
	
	List<UserMovieRating> ratingList = null;	
	
	movieRatings =
		MovieRatingsParser.parseMovieRatings(ratingList);
	
	assertFalse(movieRatings == null);
	assertTrue(movieRatings.size() == 0);
    }
    
    @Test
    public void testMovieRatingParserNullObject() {
	UserMovieRating rating1 = new UserMovieRating("fight club", 4);
	UserMovieRating rating2 = null;
	
	List<UserMovieRating> ratingList =
		new ArrayList<UserMovieRating>();
	
	ratingList.add(rating1);
	ratingList.add(rating2);
	
	movieRatings =
		MovieRatingsParser.parseMovieRatings(ratingList);
	
	assertTrue(movieRatings.size() == 1);
    }
    
    @Test
    public void testMovieRatingParserNullName() {
	UserMovieRating rating1 = new UserMovieRating("fight club", 4);
	UserMovieRating rating2 = new UserMovieRating(null, 5);
	
	List<UserMovieRating> ratingList =
		new ArrayList<UserMovieRating>();
	
	ratingList.add(rating1);
	ratingList.add(rating2);
	
	movieRatings =
		MovieRatingsParser.parseMovieRatings(ratingList);
	
	assertTrue(movieRatings.size() == 1);
    }
    
    @Test
    public void testMovieRatingParserEmptyName() {
	UserMovieRating rating1 = new UserMovieRating("fight club", 4);
	UserMovieRating rating2 = new UserMovieRating("", 5);
	
	List<UserMovieRating> ratingList =
		new ArrayList<UserMovieRating>();
	
	ratingList.add(rating1);
	ratingList.add(rating2);
	
	movieRatings =
		MovieRatingsParser.parseMovieRatings(ratingList);
	
	assertTrue(movieRatings.size() == 1);
    }
    
    @Test
    public void testMovieRatingParserNegativeRating() {
	UserMovieRating rating1 = new UserMovieRating("fight club", 4);
	UserMovieRating rating2 = new UserMovieRating("se7en", -1);
	
	List<UserMovieRating> ratingList =
		new ArrayList<UserMovieRating>();
	
	ratingList.add(rating1);
	ratingList.add(rating2);
	
	movieRatings =
		MovieRatingsParser.parseMovieRatings(ratingList);
	
	assertTrue(movieRatings.size() == 1);
    }
    
    @Test
    public void testMovieRatingParserMultipleRatings() {
	UserMovieRating rating1 = new UserMovieRating("fight club", 4);
	UserMovieRating rating2 = new UserMovieRating("se7en", 5);
	UserMovieRating rating3 = new UserMovieRating("se7en", 3);
	
	List<UserMovieRating> ratingList =
		new ArrayList<UserMovieRating>();
	
	ratingList.add(rating1);
	ratingList.add(rating2);
	ratingList.add(rating3);
	
	movieRatings =
		MovieRatingsParser.parseMovieRatings(ratingList);
	
	assertTrue(movieRatings.size() == 2);
	assertTrue(movieRatings.get("se7en").size() == 2);
    }
    
    @Test
    public void testMovieRatingParserMultipleEqualRatings() {
	UserMovieRating rating1 = new UserMovieRating("fight club", 4);
	UserMovieRating rating2 = new UserMovieRating("se7en", 5);
	UserMovieRating rating3 = new UserMovieRating("se7en", 5);
	
	List<UserMovieRating> ratingList =
		new ArrayList<UserMovieRating>();
	
	ratingList.add(rating1);
	ratingList.add(rating2);
	ratingList.add(rating3);
	
	movieRatings =
		MovieRatingsParser.parseMovieRatings(ratingList);
	
	assertTrue(movieRatings.size() == 2);
	assertTrue(movieRatings.get("se7en").size() == 2);
    }
    
    @Test
    public void testMovieRatingParserMultipleMoviesEqualRatings() {
	UserMovieRating rating1 = new UserMovieRating("fight club", 4);
	UserMovieRating rating2 = new UserMovieRating("se7en", 4);
	
	List<UserMovieRating> ratingList =
		new ArrayList<UserMovieRating>();
	
	ratingList.add(rating1);
	ratingList.add(rating2);
	
	movieRatings =
		MovieRatingsParser.parseMovieRatings(ratingList);
	
	assertTrue(movieRatings.size() == 2);
    }
    
    @Test
    public void testMovieRatingParserMultipleMoviesDifferentCase() {
	UserMovieRating rating1 = new UserMovieRating("fight club", 4);
	UserMovieRating rating2 = new UserMovieRating("Fight Club", 4);
	
	List<UserMovieRating> ratingList =
		new ArrayList<UserMovieRating>();
	
	ratingList.add(rating1);
	ratingList.add(rating2);
	
	movieRatings =
		MovieRatingsParser.parseMovieRatings(ratingList);
	
	assertTrue(movieRatings.size() == 1);
	assertTrue(movieRatings.get("fight club").size() == 2);
    }
    
    
    @Test
    public void testMovieRatingProcessorGetAlphabeticalList() {
	UserMovieRating rating1 = new UserMovieRating("fight club", 4);
	UserMovieRating rating2 = new UserMovieRating("godfather", 5);
	UserMovieRating rating3 = new UserMovieRating("casablanca", 4);
	UserMovieRating rating4 = new UserMovieRating("forest gump", 5);
	
	List<UserMovieRating> ratingList =
		new ArrayList<UserMovieRating>();
	
	ratingList.add(rating1);
	ratingList.add(rating2);
	ratingList.add(rating3);
	ratingList.add(rating4);
	
	
	movieRatings =
		MovieRatingsParser.parseMovieRatings(ratingList);
	
	List<String> movieList =
		MovieRatingsProcessor.getAlphabeticalMovies(movieRatings);
	
	assertTrue(movieList.size() == 4);
	assertEquals("casablanca", movieList.get(0));
	assertEquals("fight club", movieList.get(1));
	assertEquals("forest gump", movieList.get(2));
	assertEquals("godfather", movieList.get(3));
    }
    
    @Test
    public void testMovieRatingProcessorGetAlphabeticalListAboveRating() {
	UserMovieRating rating1 = new UserMovieRating("fight club", 3);
	UserMovieRating rating2 = new UserMovieRating("godfather", 5);
	UserMovieRating rating3 = new UserMovieRating("casablanca", 4);
	UserMovieRating rating4 = new UserMovieRating("forest gump", 5);
	
	List<UserMovieRating> ratingList =
		new ArrayList<UserMovieRating>();
	
	ratingList.add(rating1);
	ratingList.add(rating2);
	ratingList.add(rating3);
	ratingList.add(rating4);
	
	
	movieRatings =
		MovieRatingsParser.parseMovieRatings(ratingList);
	
	List<String> movieList =
		MovieRatingsProcessor.getAlphabeticalMoviesAboveRating(movieRatings, 4);
	
	assertTrue(movieList.size() == 3);
	assertEquals("casablanca", movieList.get(0));
	assertEquals("forest gump", movieList.get(1));
	assertEquals("godfather", movieList.get(2));
    }
    
    @Test
    public void testMovieRatingProcessorRemoveRatings() {
	UserMovieRating rating1 = new UserMovieRating("fight club", 3);
	UserMovieRating rating2 = new UserMovieRating("fight club", 5);
	UserMovieRating rating3 = new UserMovieRating("fight club", 4);
	UserMovieRating rating4 = new UserMovieRating("fight club", 5);
	
	List<UserMovieRating> ratingList =
		new ArrayList<UserMovieRating>();
	
	ratingList.add(rating1);
	ratingList.add(rating2);
	ratingList.add(rating3);
	ratingList.add(rating4);
	
	
	movieRatings =
		MovieRatingsParser.parseMovieRatings(ratingList);
	
	TreeMap<String, Integer> removedRatings =
		MovieRatingsProcessor.removeAllRatingsBelow(movieRatings, 4);
	
	assertTrue(movieRatings.size() == 1);
	assertTrue(movieRatings.get("fight club").size() == 3);
	assertTrue(removedRatings.size() == 1);
	assertTrue(removedRatings.get("fight club") == 1);
    }
    
    
    @Test
    public void testMovieRatingProcessorRemoveRatingsNoChange() {
	UserMovieRating rating1 = new UserMovieRating("fight club", 3);
	UserMovieRating rating2 = new UserMovieRating("fight club", 5);
	UserMovieRating rating3 = new UserMovieRating("fight club", 4);
	UserMovieRating rating4 = new UserMovieRating("fight club", 5);
	
	List<UserMovieRating> ratingList =
		new ArrayList<UserMovieRating>();
	
	ratingList.add(rating1);
	ratingList.add(rating2);
	ratingList.add(rating3);
	ratingList.add(rating4);
	
	
	movieRatings =
		MovieRatingsParser.parseMovieRatings(ratingList);
	
	TreeMap<String, Integer> removedRatings =
		MovieRatingsProcessor.removeAllRatingsBelow(movieRatings, 3);
	
	assertTrue(movieRatings.size() == 1);
	assertTrue(movieRatings.get("fight club").size() == 4);
	assertTrue(removedRatings.size() == 0);
    }
    
    @Test
    public void testMovieRatingProcessorRemoveMovie() {
	UserMovieRating rating1 = new UserMovieRating("baby driver", 3);
	UserMovieRating rating2 = new UserMovieRating("fight club", 5);
	UserMovieRating rating3 = new UserMovieRating("fight club", 4);
	UserMovieRating rating4 = new UserMovieRating("fight club", 5);
	
	List<UserMovieRating> ratingList =
		new ArrayList<UserMovieRating>();
	
	ratingList.add(rating1);
	ratingList.add(rating2);
	ratingList.add(rating3);
	ratingList.add(rating4);
	
	
	movieRatings =
		MovieRatingsParser.parseMovieRatings(ratingList);
	
	TreeMap<String, Integer> removedRatings =
		MovieRatingsProcessor.removeAllRatingsBelow(movieRatings, 4);
	
	assertTrue(movieRatings.size() == 1);
	assertFalse(movieRatings.containsKey("baby driver"));
	assertTrue(removedRatings.size() == 1);
    }

}
