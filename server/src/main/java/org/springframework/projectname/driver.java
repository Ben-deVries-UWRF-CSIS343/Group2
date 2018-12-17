package org.springframework.projectname;

import org.springframework.projectname.graph.Graph;
import org.springframework.projectname.graph.Vertex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class driver {

    public static void main(String args[]) {


        tudeAddress a1 = new tudeAddress();
        tudeAddress a2 = new tudeAddress();
        tudeAddress a3 = new tudeAddress();

        // NOTE ALL LAT'S MUST BE IN LAT North
        a1.setLat(44.9643235);
        // NOTE ALL LON'S MUST BE IN LON West
        a1.setLon(-92.7381284);
        a1.isStartingPoint = true;


        a2.setLat(44.974761);
        a2.setLon(-92.720635);

        a3.setLat(44.8595);
        a3.setLon(-92.6266);


        Vertex v1 = new Vertex(a1);
        Vertex v2 = new Vertex(a2);
        Vertex v3 = new Vertex(a3);


        Graph g = new Graph();
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);

        // will return the number of edges
        // also, the Graph.addEdges() will print to the console the addresses of the edge being calculated and the distance result of that calculation
        int edgeCount = g.addEdges();

        // This is the big part that you need
        // The strategy that is set up to be usable
        IRouteStrategy routeStrat = new BFStrategy();
        // the array of addresses in the order they need to be hit is returned by the computeRoute(graph) function
        tudeAddress[] linkings = routeStrat.computeRoute(g);

        // iterate the array returned and print the address information
        for (tudeAddress a: linkings) {
            System.out.println(a.toString());
        }
    }
}