

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * SD2x Homework #6
 * This is an implementation of Breadth First Search (BFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class BreadthFirstSearch {
    protected Set<Node> marked;
    protected Graph graph;
    private int distance;
    protected Set<Edge> connections;

    public BreadthFirstSearch(Graph graphToSearch) {
	marked = new HashSet<Node>();
	graph = graphToSearch;
	distance = -1;
	connections = new HashSet<Edge>();
    }

    /**
     * This method was discussed in the lesson
     */
    public boolean bfs(Node start, String elementToFind) {
	if (!graph.containsNode(start)) {
	    return false;
	}
	distance++;
	if (start.getElement().equals(elementToFind)) {
	    return true;
	}
	Queue<Node> toExplore = new LinkedList<Node>();
	marked.add(start);
	toExplore.add(start);
	while (!toExplore.isEmpty()) {
	    Node current = toExplore.remove();
	    for (Node neighbor : graph.getNodeNeighbors(current)) {
		if (!marked.contains(neighbor)) {
		    connections.add(new Edge(current, neighbor));
		    if (neighbor.getElement().equals(elementToFind)) {
			distance = minDistance(start, neighbor);
			return true;
		    }
		    marked.add(neighbor);
		    toExplore.add(neighbor);
		}
	    }
	}
	return false;
    }
    
    public int minDistance(Node src, Node dest) {
	int dist = 0;
	Node current = dest;
	
	while (!current.equals(src)) {
	    for (Edge edge : connections) {
		if (edge.getDestination().equals(current)) {
		    current = edge.getSource();
		    dist++;
		}
	    }
	}
	
	return dist;
    }
    
    public Set<Edge> getConnections() {
	return connections;
    }
    
    public int getDistance() {
	return distance;
    }
}
