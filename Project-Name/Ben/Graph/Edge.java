public class Edge {
    private double _weight;

    private Vertex _vertex1;
    private Vertex _vertex2;

    public void Edge(double weight, Vertex v1, Vertex v2) {
        _weight = weight;
        vertex1 = v1;
        vertex2 = v2;
    }

    public void Edge() {
    }

    public double getWeight() {
        return _weight;
    }

    public void setWeight(int weight) {
        _weight = weight;
    }

    public double getVertex1() {
        return _vertex1;
    }

    public void setWeight(vertex vtx) {
        _vertex1 = vtx;
    }

    public double getVertex2() {
        return _vertex2;
    }

    public void setWeight(Vertex vtx) {
        _vertex2 = vtx;
    }

}