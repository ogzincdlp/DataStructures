

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {
    private static int hamiltonTest = 0;

    public static int minDistance(Graph graph, String src, String dest) {

	/* IMPLEMENT THIS METHOD! */
	
	if (graph == null || src == null || dest == null ||
		!graph.containsElement(src) ||
		!graph.containsElement(dest)) {
	    return -1;
	}
	
	BreadthFirstSearch search = new BreadthFirstSearch(graph);
	
	if (search.bfs(graph.getNode(src), dest)) {
	    return search.getDistance();
	}

	return -1; // this line is here only so this code will compile if you don't modify it
    }


    public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {

	/* IMPLEMENT THIS METHOD! */
	
	if (graph == null || src == null || distance < 1 || 
		!graph.containsElement(src)) return null;
	
	DepthFirstSearch search = new DepthFirstSearch(graph);
	
	Set<Node> visitedNodes = 
		search.searchDistance(graph.getNode(src), distance);
	
	if (visitedNodes.contains(graph.getNode(src))) {
	    visitedNodes.remove(graph.getNode(src));
	}
	Set<String> nodeNames = new HashSet<>();
	
	for (Node node : visitedNodes) {
	    nodeNames.add(node.getElement());
	}
	
	return nodeNames;
    }


    public static boolean isHamiltonianPath(Graph g, List<String> values) {

	/* IMPLEMENT THIS METHOD! */
	
	//invalid inputs
	if (g == null || values == null ||
		values.isEmpty()) {
	    return false;
	}
	
	Iterator<String> iter = values.iterator();
	Node start = g.getNode((String)iter.next());
	Node previous = start;
	Set<Node> visited = new HashSet<>();
	visited.add(start);
	
	while (iter.hasNext()) {
	    Node current = g.getNode((String)iter.next());
	    
	    //there is no edge between two nodes
	    if (!g.getNodeNeighbors(previous).contains(current)) {
		return false;
	    }
	    
	    //same node visited twice
	    if (iter.hasNext() && visited.contains(current)) {
		return false;
	    }
	    
	    visited.add(current);
	    previous = current;
	}
	
	//check if the path is a cycle
	if (previous != start) {
	    return false;
	}
	
	//not all nodes are visited
	if (g.getAllNodes().size() != visited.size()) {
	    return false;
	}
	
	return true;	
    }

}
