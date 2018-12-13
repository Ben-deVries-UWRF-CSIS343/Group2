package org.springframework.projectname;

import org.springframework.projectname.graph.Edge;
import org.springframework.projectname.graph.Graph;
import org.springframework.projectname.graph.Vertex;

import java.io.IOException;
import java.util.ArrayList;

public class edgeWeightCalculator{
    private Graph _workingGraph = null;
    private int status = -1;

    private IMapsInteractor _maps = null;

    public edgeWeightCalculator(Graph g, IMapsInteractor mi){
        _workingGraph = g;
        _maps = mi;
        if (mi == null){
            System.err.println("the val is null at init");
        }
        else{
            System.out.println("Working");
        }
    }


    public void calculate() {
        if (status == statusEnumeration.error) {
            // if status is in the error state this will fall through.
            return;
        }
        if (_workingGraph == null) {
            // cannot do anything with a messed up graph
            status = statusEnumeration.error;
            return;
        }

        // place the verticies in an array
        ArrayList<Vertex> vtxs = (ArrayList<Vertex>) _workingGraph.getVerticies();
        //iterate the array with a current and a cursor to get every combination
        int currentIdx = 0;
        int cursor = 1;
        //outter loop to move the element being processed
        while ((currentIdx) != vtxs.size()) {
            while ((cursor) != vtxs.size()) {
                // get the 2 verticies and ad an edge between them

                Vertex v1 = vtxs.get(currentIdx);
                Vertex v2 = vtxs.get(cursor);

                // create the edge


                Edge e = new Edge();
                // set the verticies
                e.setVertex1(v1);
                e.setVertex2(v2);


                double distance = getWeight(e.getVertex1().getAddress(), e.getVertex2().getAddress());
                System.out.println("Address: " + e.getVertex1().getAddress().toString() + " " + e.getVertex2().getAddress().toString() + "\n" + "Distance: " + distance + "\n");

                if (distance < 0) {
                    // an error occured
                    distance = Double.MAX_VALUE;
                    System.out.print("An error has occured calculating the distance between: " + e.getVertex1().getAddress() +" and " + e.getVertex2().getAddress());
                    // no way from point a to b
                } else {
                    e.setWeight(distance);
                }
                v1.addEdge(e);
                v2.addEdge(e);

                // increment the cursor
                cursor++;
            }
            currentIdx++;
            cursor = currentIdx + 1;
        }
    }

    private void leftovercode() {
        // this will create the edges and add them to the list
        for (Vertex outter: _workingGraph.getVerticies()) {
            for (Vertex inner: _workingGraph.getVerticies()) {
                // check if these are the same vertex
                if (outter.equals(inner)) {
                    continue;
                }

                // check if the edge already exists
                for (Edge e: outter.getEdges()) {
                    if (e.getVertex1().equals(outter) && e.getVertex2().equals(inner)) {
                        // edge exists
                        continue;
                    } else if(e.getVertex1().equals(inner) && e.getVertex2().equals(outter)){
                        // edge exists
                        continue;
                    }
                }
                // if not create and add weight the edge
                Edge e = new Edge();
                // set the verticies
                e.setVertex1(outter);
                e.setVertex2(inner);


                double distance = getWeight(e.getVertex1().getAddress(), e.getVertex2().getAddress());
                if (distance < 0) {
                    // an error occured
                    distance = Double.MAX_VALUE;
                    System.out.print("An error has occured calculating the distance between: " + e.getVertex1().getAddress() +" and " + e.getVertex2().getAddress());
                    // no way from point a to b
                } else {
                    e.setWeight(distance);
                }
                inner.addEdge(e);
                outter.addEdge(e);
            }
        }
    }


    private double getWeight(Address source, Address destination) {
        // returns the distance from point a to b if valid addresses are passed
        //otherwise returns a non positave number and set the error status of this object

        try {
            return _maps.getDistanceFromAddress(source, destination);
        } catch (IOException e) {
            status = statusEnumeration.error;
            return -1;
        }
    }

    class statusEnumeration {
        public final static int edgesQueued = 0;
        public final static int edgesFinished = 1;
        public final static int error = 2;

        public int status = -1;
    }

}