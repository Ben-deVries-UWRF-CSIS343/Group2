package org.springframework.projectname.graph;

import org.springframework.projectname.Address;
import org.springframework.projectname.tudeAddress;

import java.util.ArrayList;

public class Vertex {

    // used as a unique id for the vertex
    private long uniqueCreationTime;
    private ArrayList<Edge> _edges = new ArrayList<Edge>();
    private tudeAddress _address;

    public Vertex(tudeAddress addr) {
        uniqueCreationTime = System.nanoTime();
        _address = addr;
    }

    public void addEdge(Edge edge) {
        _edges.add(edge);
    }
    public void removeAllEdges() {
        _edges = new ArrayList<Edge>();
    }

    // determine if an edge exists between this vertex and another 'otherVertex'
    // returning null means that it oes not exist, otherwise it will return the edge
    public Edge hasEdge(Vertex otherVertex) {
        Edge foundEdge = null;
        for (Edge edge : _edges) {
            if (edge.getVertex1().equals(otherVertex) || edge.getVertex2().equals(otherVertex)) {
                foundEdge = edge;
                break;
            }
        }
        return foundEdge;
    }

    public ArrayList<Edge> getEdges() {
        return _edges;
    }

    public tudeAddress getAddress() {
        return _address;
    }

    // note setting this may render the edge weights invalid
    public void setAddress(tudeAddress newAddress) {
        _address = newAddress;
    }

    public ArrayList<distanceToVertex> getAlladjoiningVerticesWeight() {
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

            // the distance is the same regardless
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
        return this.uniqueCreationTime == vertexOther.getUnique();
    }
}