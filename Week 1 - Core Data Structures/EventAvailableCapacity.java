import java.util.LinkedList;
import java.util.Queue;

public class EventAvailableCapacity {
    
    protected Queue<Integer> ticketRequests;
    protected int availableCapacity;
    
    public EventAvailableCapacity(int maxCapacity) {
	ticketRequests = new LinkedList<Integer>();
	this.availableCapacity = maxCapacity;
    }
    
    public void addTicketRequest(int numPeople) {
	ticketRequests.add(numPeople);
    }
     
    public int processUntilNoCapacity() {
	int numRequestsProcessed = 0;
	while(!ticketRequests.isEmpty()) {
	    int remainAfterRequest = availableCapacity -
		    ticketRequests.peek();
	    if (remainAfterRequest < 0)
		return numRequestsProcessed;
	    availableCapacity -= ticketRequests.remove();
	    numRequestsProcessed++;
	}
	return 0;
    }

}
