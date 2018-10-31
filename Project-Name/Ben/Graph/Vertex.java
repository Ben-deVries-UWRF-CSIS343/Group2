public class Vertex {

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

    public ArrayList<distanceToVertex> getAllAjoiningVertices() {

    }

}

public class distanceToVertex {
    public Vertex vertex;
    public double distance;
}

public class myLockable<T> {
    private T locking;
    private boolean locked = false;

    public T getLocking() {
        return locking;
    }

    public void setLocking(T newVal) {
        if (locked = false) {
            locking = newVal;
        }
    }

    public void lock() {
        locked = true;
    }

}