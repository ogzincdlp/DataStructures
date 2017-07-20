import java.util.HashSet;
import java.util.Set;

public class DepthFirstSearch {
    
    private Set<Node> marked;
    private Graph graph;

    public DepthFirstSearch(Graph graphToSearch) {
	// TODO Auto-generated constructor stub
	marked = new HashSet<Node>();
	graph = graphToSearch;
    }
    
    public boolean dfs(String elementToFind, Node start) {
	if (!graph.containsNode(start)) return false;
	
	if (start.getElement().equals(elementToFind)) return true;
	else {
	    marked.add(start);
	    for (Node neighbor : graph.getNeighbors(start)) {
		if (dfs(elementToFind, neighbor)) {
		    return true;
		}
	    }
	    return false;
	}
    }

}
