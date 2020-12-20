package by.bsu.algorithms.classes;

public class Edge {
    private Vertex fromVertex;
    private Vertex toVertex;

    public Edge(Vertex fromVertex, Vertex toVertex) {
        if(fromVertex.getName() != toVertex.getName()){
            this.fromVertex = fromVertex;
            this.toVertex = toVertex;
        }
    }

    public Vertex getFromVertex(){
        return fromVertex;
    }

    public Vertex getToVertex(){
        return toVertex;
    }

    @Override
    public String toString() {
        return "[" +
                fromVertex.getName() +
                "," + toVertex.getName() +
                ']';
    }
}
