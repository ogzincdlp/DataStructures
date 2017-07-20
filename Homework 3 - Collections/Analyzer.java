import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {

    /*
     * Implement this method in Part 1
     */
    public static List<Sentence> readFile(String filename) {

	/* IMPLEMENT THIS METHOD! */
	ArrayList<Sentence> sentences = new ArrayList<>();

	if (filename == null) return sentences;

	try {
	    BufferedReader br = new BufferedReader(new FileReader(filename));
	    String line = br.readLine();
	    while (line != null) {
		String[] words = line.split(" ");
		try {
		    int rating = Integer.parseInt(words[0]);
		    if (rating >= -2 && rating <= 2) {
			words = Arrays.copyOfRange(words, 1, words.length);
			if (words.length > 0) {
			    String text = String.join(" ", words);
			    Sentence sentence = new Sentence(rating, text);
			    sentences.add(sentence);
			}
		    }
		} catch (NumberFormatException e) {

		} catch (ArrayIndexOutOfBoundsException e) {

		}

		finally {
		    line = br.readLine();
		}
	    }
	    br.close();
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}


	return sentences; // this line is here only so this code will compile if you don't modify it

    }

    /*
     * Implement this method in Part 2
     */
    public static Set<Word> allWords(List<Sentence> sentences) {

	/* IMPLEMENT THIS METHOD! */
	HashSet<Word> words = new HashSet<>();

	if (sentences == null) return words;

	for (Sentence sentence : sentences) {
	    if (sentence == null) continue;
	    StringTokenizer st = new StringTokenizer(sentence.getText());

	    while (st.hasMoreTokens()) {
		String word = st.nextToken().toLowerCase();
		if (word.charAt(0) >= 'a' && word.charAt(0) <= 'z') {
		    word = word.replaceAll("[\\W]|_", "");
		    Word newWord = new Word(word);
		    if (words.contains(newWord)) {
			for (Word w : words) {
			    if (w.equals(newWord)) {
				w.increaseTotal(sentence.getScore());
			    }
			}
		    } else {
			newWord.increaseTotal(sentence.getScore());
			words.add(newWord);
		    }
		}
	    }
	}

	return words; // this line is here only so this code will compile if you don't modify it

    }

    /*
     * Implement this method in Part 3
     */
    public static Map<String, Double> calculateScores(Set<Word> words) {

	/* IMPLEMENT THIS METHOD! */
	Map<String, Double> scores = new HashMap<>();

	if (words == null) return scores;

	for (Word word : words) {
	    if (word != null) 
		scores.put(word.getText(), word.calculateScore());
	}

	return scores; // this line is here only so this code will compile if you don't modify it

    }

    /*
     * Implement this method in Part 4
     */
    public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

	/* IMPLEMENT THIS METHOD! */
	double sentiment = 0;
	int count = 0;

	if (sentence == null || sentence.length() == 0
		|| wordScores == null) return sentiment;
	StringTokenizer st = new StringTokenizer(sentence);

	while (st.hasMoreTokens()) {
	    String word = st.nextToken().toLowerCase();
	    if (word.charAt(0) >= 'a' && word.charAt(0) <= 'z') {
		word = word.replaceAll("[\\W]|_", "");
		if (wordScores.containsKey(word)) {
		    sentiment += wordScores.get(word);
		}
		count++;
	    }
	}

	if (sentiment == 0) return 0;
	return sentiment/count; // this line is here only so this code will compile if you don't modify it

    }

    /*
     * This method is here to help you run your program. Y
     * You may modify it as needed.
     */
    public static void main(String[] args) {

	String filename = "C:/Users/Oguz/Desktop/test.txt";
	//	List<Sentence> sentences = readFile(filename);
	//	Set<Word> words = allWords(sentences);
	//	if (args.length == 0) {
	//	    System.out.println("Please specify the name of the input file");
	//	    System.exit(0);
	//	}
	//	String filename = args[0];
	//	System.out.print("Please enter a sentence: ");
	//	Scanner in = new Scanner(System.in);
	//	String sentence = in.nextLine();
	//	in.close();
	String sentence = "Because I am so happy";
	List<Sentence> sentences = Analyzer.readFile(filename);
	System.out.println(sentences.size());
	Set<Word> words = Analyzer.allWords(sentences);
	System.out.println(words.size());
	Map<String, Double> wordScores = Analyzer.calculateScores(words);
	double score = Analyzer.calculateSentenceScore(wordScores, sentence);
	System.out.println("The sentiment score is " + score);

    }
}
