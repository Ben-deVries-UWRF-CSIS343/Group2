package org.springframework.projectname;

import org.springframework.projectname.graph.Graph;
import org.springframework.projectname.graph.Vertex;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class driver {

    public static void main(String args[]) {

        Address a1 = new Address();
        a1.addressLine1 = "642 cherrywood ln";
        a1.city = "hudson";
        a1.state = "wi";
        a1.zipCode = 54016;
        a1.isStartingPoint = true;
        Vertex v1 = new Vertex(a1);

        Address a2 = new Address();
        a2.addressLine1 = "481 Old Highway 35";
        a2.city = "hudson";
        a2.state = "wi";
        a2.zipCode = 54016;
        Vertex v2 = new Vertex(a2);

        Address a3 = new Address();
        a3.addressLine1 = "9 2nd st";
        a3.city = "hudson";
        a3.state = "wi";
        a3.zipCode = 54016;
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
        Address[] linkings = routeStrat.computeRoute(g);

        // iterate the array returned and print the address information
        for (Address a: linkings) {
            System.out.println(a.toString());
        }
    }
}