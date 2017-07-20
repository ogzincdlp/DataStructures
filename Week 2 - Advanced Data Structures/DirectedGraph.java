
public class DirectedGraph extends Graph {

    public DirectedGraph() {
	super();
    }

    @Override
    public boolean addEdge(Node source, Node dest, int weight) {
	// TODO Auto-generated method stub
	
	addNode(source);
	addNode(dest);
	
	boolean addSuccess = addEdgeFromTo(source, dest, weight);
	
	if (addSuccess) numEdges++;
	
	return addSuccess;
    }

    @Override
    public boolean removeEdge(Node node1, Node node2, int weight) {
	// TODO Auto-generated method stub
	return false;
    }

}
