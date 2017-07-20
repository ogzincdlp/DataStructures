import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Graph {
    
    private Map<Node, Set<Edge>> adjacencySets;
    private int numNodes;
    protected int numEdges;
    
    public Graph() {
	adjacencySets = new HashMap<Node, Set<Edge>>();
	numNodes = 0;
	numEdges = 0;
    }

    public int getNumNodes() { return numNodes; }
    public int getNumEdges() { return numEdges; }
    
    public boolean containsNode(Node node) {
	return adjacencySets.containsKey(node);
    }
    
    public boolean addNode(Node newNode) {
	if (newNode == null || containsNode(newNode)) {
	    return false;
	}
	
	Set<Edge> newAdjacencySet = new HashSet<>();
	adjacencySets.put(newNode, newAdjacencySet);
	numNodes++;
	return true;
    }
    
    public Set<Node> getNeighbors(Node node) {
	if (node == null || !containsNode(node)) {
	    return null;
	}
	
	Set<Edge> nodeEdges = adjacencySets.get(node);
	Set<Node> nodeNeighbors = new HashSet<>();
	
	for (Edge e : nodeEdges) {
	    Node neighbor = e.getDestination();
	    nodeNeighbors.add(neighbor);
	}
	
	return nodeNeighbors;
    }
    
    public abstract boolean addEdge(
	    Node node1, Node node2, int weight);
    public abstract boolean removeEdge(
	    Node node1, Node node2, int weight);
    
    protected boolean addEdgeFromTo(Node source,
	    Node destination, int weight) {
	Edge newEdge = new Edge(source, destination, weight);
	Set<Edge> sourceEdges = adjacencySets.get(source);
	
	if (!sourceEdges.contains(newEdge)) {
	    sourceEdges.add(newEdge);
	    return true;
	}
	
	return false;
    }
    
    

}
