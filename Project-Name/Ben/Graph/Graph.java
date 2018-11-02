public class Graph {
    private ArrayList<Vertex> _vertecies;

    // NOTE we are passing around objects and as such if the originals change it
    // will screw up the objects
    public void Graph(ArrayList<Vertex> vertecies) {
        _vertecies = vertecies;
    }

    public void Graph() {
        _vertecies = new ArrayList<Vertex>();
    }

    public void addVertex(Vertex vtx) {
        // verify that the graph does not already have the vertex that is being added by
        // checking the 'unique' value

        boolean alreadyExists = false;
        for (Vertex v : _vertecies) {
            if (v.getUnique() == vtx.getUnique()) {
                alreadyExists = true;
                break;
            }
        }
        if (!alreadyExists) {
            _vertecies.add(vtx);
        }
    }

    // note: this will return a collection of objects and will return them as a
    // byRef
    public ArrayList<Vertex> getVerticies() {
        return _vertecies;
    }

    public void clear() {
        _vertecies = new ArrayList<Vertex>();
    }

}