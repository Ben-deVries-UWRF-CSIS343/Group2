public class Graph {
    private ArrayList<Vertex> _vertecies;

    // NOTE we are passing around objects and as such if the originals change it
    // will screw up the objects
    public void Graph(ArrayList<Vertex> vertecies) {
        _vertecies = vertecies;
    }

    public void Graph() {
    }

    public void addVertex(vertex vtx) {
        _vertecies.add(vtx);
    }

    public ArrayList<Vertex> getVerticies() {
        return _vertecies;
    }

    public void clear() {
        _vertecies = new ArrayList<Vertex>();
    }

}