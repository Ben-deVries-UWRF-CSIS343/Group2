//package org.springframework.projectname;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class driver {
//
//    public static void main(String args[]) {
//
//        Address a1 = new Address();
//        a1.addressLine1 = "642 cherrywood ln";
//        a1.city = "hudson";
//        a1.state = "wi";
//        a1.zipCode = 54016;
//        a1.isStartingPoint = true;
//        Vertex v1 = new Vertex(a1);
//
//        Address a2 = new Address();
//        a2.addressLine1 = "481 Old Highway 35";
//        a2.city = "hudson";
//        a2.state = "wi";
//        a2.zipCode = 54016;
//        Vertex v2 = new Vertex(a2);
//
//        Address a3 = new Address();
//        a3.addressLine1 = "9 2nd st";
//        a3.city = "hudson";
//        a3.state = "wi";
//        a3.zipCode = 54016;
//        Vertex v3 = new Vertex(a3);
//
//        Graph g = new Graph();
//        g.addVertex(v1);
//        g.addVertex(v2);
//        g.addVertex(v3);
//
//        googleMapsInteracter gmi = new googleMapsInteracter();
//        System.out.println(gmi.getDistanceFromAddress(a1, a2));
//
//        int edgeCount = g.getEdgeCount();
//        System.out.println(edgeCount);
//
//        edgeCount = g.addEdges();
//
//        System.out.println(edgeCount);
//
//        System.out.println("working");
//
//        IRouteStrategy routeStrat = new BFStrategy();
//        String[] linkings = routeStrat.computeRoute(g);
//
//        System.out.println(linkings);
//    }
//
//}