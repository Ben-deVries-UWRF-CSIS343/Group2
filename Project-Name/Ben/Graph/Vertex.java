public class Vertex {

    // used toas a unique id for the vertex
    private long uniqueCreationTime;
    private ArrayList<Edge> _egdes;

    public void Vertex(ArrayList<Edge> edges) {
        _edges = edges;
        uniqueCreationTime = System.name();
    }

    public void Vertex() {
        uniqueCreationTime = System.name();
    }

    public void addEdge(edge edge) {
        _edges.add(edge);
    }

    public ArrayList<Edge> getEdges() {
        return _edges;
    }

    public ArrayList<distanceToVertex> getAllAjoiningVerticesWeight() {
        ArrayList<distanceToVertex> distance = new ArrayList<distanceToVertex>();
        // iderate through all the connected edges and get the other vertex, add it to a
        // list of verticies and return the list
        for (Edge edge : _edges) {

            distanceToVertex dist = new distanceToVertex();
            dist.distance = edge.getWeight();

            // the edge has 2 vertecies 1 of them is this vertex
            if (!(edge.getVertex1().equals(this))) {
                dist.vertex = edge.getVertex1();
            } else {
                dist.vertex = edge.getVertex2();
            }

            distance.add(dist);
        }
        return distance;
    }

    public Long getUnique() {
        return uniqueCreationTime;
    }

    @Override
    public boolean equals(Object other) {

        // if they are not the same type they cannot be type casted to the Vertex and
        // are by defenition not the same thing
        if (!(other instanceof Vertex)) {
            return false;
        }

        // type cast
        Vertex vertexOther = (Vertex) other;

        // Compare the data members and return accordingly
        return this.uniqueCreationTime == other.getUnique();
    }
}