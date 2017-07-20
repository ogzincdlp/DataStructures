import java.util.PriorityQueue;

public class Mentee implements Comparable<Mentee> {
    
    protected int year;
    protected String name;
    
    

    public Mentee(String name, int year) {
	this.year = year;
	this.name = name;
    }



    @Override
    public int compareTo(Mentee other) {
	// TODO Auto-generated method stub
	return this.year - other.year;
    }
    
    public static String[] acceptMenteesIntoProgram(
	    int numMentorsAvailable,
	    PriorityQueue<Mentee> interestedMentees) {
	
	int numToAccept = Math.min(interestedMentees.size(),
		numMentorsAvailable);
	
	String[] menteesInProgram = new String[numToAccept];
	
	for (int i = 0; i < numToAccept; i++) {
	    Mentee mentee = interestedMentees.remove();
	    menteesInProgram[i] = mentee.name;
	}
	
	
	return menteesInProgram;
    }
    
    public static void main(String[] args) {
	Mentee kathy = new Mentee("Kathy", 2);
	Mentee jane = new Mentee("Jane", 1);
	Mentee eliana = new Mentee("Eliana", 3);
	Mentee yujie = new Mentee("Yujie", 5);
	Mentee swapneel = new Mentee("Swapneel", 4);
	
	PriorityQueue<Mentee> interestedMentees =
		new PriorityQueue<>();
	
	interestedMentees.add(kathy);
	interestedMentees.add(jane);
	interestedMentees.add(eliana);
	interestedMentees.add(yujie);
	interestedMentees.add(swapneel);
	
	int numMentorsAvailable = 3;
	
	String[] mentees = acceptMenteesIntoProgram(
		numMentorsAvailable, interestedMentees);
	
	for (String mentee : mentees) {
	    System.out.println(mentee);
	}
    }

}
