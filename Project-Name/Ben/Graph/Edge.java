
public class Edge {
    private double _weight = 0;

    private Vertex _vertex1;
    private Vertex _vertex2;

    public Edge(double weight, Vertex v1, Vertex v2) {
        _weight = weight;
        _vertex1 = v1;
        _vertex2 = v2;
    }

    public Edge() {
    }

    public double getWeight() {
        return _weight;
    }

    public void setWeight(double weight) {
        _weight = weight;
    }

    public Vertex getVertex1() {
        return _vertex1;
    }

    public void setVertex1(Vertex vtx) {
        _vertex1 = vtx;
    }

    public Vertex getVertex2() {
        return _vertex2;
    }

    public void setVertex2(Vertex vtx) {
        _vertex2 = vtx;
    }

}