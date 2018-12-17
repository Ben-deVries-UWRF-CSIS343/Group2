package org.springframework.projectname.graph;

import org.springframework.projectname.edgeWeightCalculator;
import org.springframework.projectname.googleMapsInteracter;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Vertex> _vertecies;
    private edgeWeightCalculator weightCalculator = new edgeWeightCalculator(this, new googleMapsInteracter());

    // NOTE we are passing around objects and as such if the originals change it
    // will screw up the objects
    public Graph() {
        _vertecies = new ArrayList<Vertex>();
    }

    public Graph(List<Vertex> vertecies) {
        _vertecies = vertecies;
    }

    public void addVertex(Vertex vtx) {
        // verify that the graph does not already have the vertex that is being added by
        // checking the 'unique' value

        // if a null list was passed at creation time we should make a default list
        if (_vertecies == null) {
            _vertecies = new ArrayList<Vertex>();
        }

        boolean alreadyExists = false;
        for (Vertex v : _vertecies) {
            if (v.getUnique() == vtx.getUnique()) {
                alreadyExists = true;
                break;
            }
        }
        if (!alreadyExists) {
            // this is supposed to be a fully connected graph
            _vertecies.add(vtx);
        }
    }

    // note: this will return a collection of objects and will return them as a
    // byRef
    public List<Vertex> getVerticies() {
        return _vertecies;
    }

    public void clear() {
        _vertecies = new ArrayList<Vertex>();
    }

    // returns the number of edges
    public int addEdges() {
        for (Vertex v : _vertecies) {
            v.removeAllEdges();
        }

        weightCalculator.calculate();
        return getEdgeCount();
    }

    public int getEdgeCount() {
        int count = 0;
        double totalWeight = 0;
        for (Vertex v : _vertecies) {
            count += v.getEdges().size();
            // get the total weight
            for (Edge e : v.getEdges()) {
                totalWeight += e.getWeight();
            }
        }
        // the /2 is because we are counting the references to edges and every edge is
        // references twice (once by the vertex on each end)
        return count / 2;

    }
}