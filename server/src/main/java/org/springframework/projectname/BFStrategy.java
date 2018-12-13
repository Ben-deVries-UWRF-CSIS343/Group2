package org.springframework.projectname;

import org.springframework.projectname.graph.Edge;
import org.springframework.projectname.graph.Graph;
import org.springframework.projectname.graph.Vertex;

import java.util.*;

public class BFStrategy implements IRouteStrategy {
    private List<vDistance> thingsToConsider = null;
    public static final String delimiteChar = "a";

    public Address[] computeRoute(Graph g) {
        if (thingsToConsider == null) {
            for (Vertex v: g.getVerticies()) {
                if (v.getAddress().isStartingPoint) {
                    // prime the list with the first needed thingy
                    thingsToConsider = new ArrayList<vDistance>();
                    thingsToConsider.add(new vDistance(v, 0.0));
                }
            }
        }


        // this should sort the list by the distance to get to it
        Collections.sort(thingsToConsider);
        // thingsToConsider.sort();

        // take the lowest item from the 'thingsToConsider' and compute all of it's next locations.
        if(thingsToConsider.size() > 0) {

            // grab the lowest item.
            vDistance thingConsidering = thingsToConsider.get(0);

            // iterate all the verticies and grab the shortest distance one
            for (Vertex v : g.getVerticies()) {
                // remove the ones already contained in teh route
                // create the  char sequence
                String creationTime = new String(v.getUnique().toString());
                if (thingConsidering.route.contains(creationTime)) {
                    // we have already hit this vertex, ignore it
                    continue;
                } else {
                    // create a new vDistance object adding the current vertex to the route and insert it into the thingsToConsider

                    Double distance = thingConsidering.distance;
                    String route = thingConsidering.route;
                    Vertex vtx = v;

                    for (Edge e: vtx.getEdges()) {
                        if ((e.getVertex1().equals(vtx) && e.getVertex2().equals(thingConsidering.vertex)) || (e.getVertex2().equals(vtx) && e.getVertex1().equals(thingConsidering.vertex))) {
                            // get the distance of the edge and add it to the distance variable
                            distance += e.getWeight();
                            break;
                        }
                    }

                    vDistance newDistance = new vDistance(vtx, distance);
                    newDistance.route = route;
                    newDistance.addLink(vtx);

                    thingsToConsider.add(newDistance);
                }
            }

            // then remove the currently examined object from the DintancesToConsider
            thingsToConsider.remove(0);
            // check to see if there are any compleated routes.
            // The first compleated is the fastest

        } else {
            // we should never hit this
            System.err.println("Compute route in BFStretegy has reached an empty list");
            // this should cause a fairly small error in the console and the above error line should be visible.
            return null;
        }

        // check for finish case
        for (vDistance route: thingsToConsider) {
            // if the route contains n-1 pipes ('|') then there are n verticies in thr route
            // since we only allow a vertx to be placed in the route once
            // route found

            String[] idxs = route.route.split(delimiteChar);

            if (idxs.length == g.getVerticies().size()) {
                // the list of vertex uniquue ids in the correct order
                String[] IDs = route.route.split(delimiteChar);
                // array for converting the vertex ids back to an address
                Address[] addresses = new Address[IDs.length];

                // for each vertex(a) id in IDs
                for (int i = 0; i < IDs.length; i++) {
                    // for each vertex(b) in the graph's verticies
                    for (Vertex v: g.getVerticies()) {
                        // if a.unique == b.unique
                        if (v.getUnique().toString().equals(IDs[i])) {
                            // we have the same vertex so set the address in the addresses array
                            addresses[i] = v.getAddress();
                        }
                    }
                }
                return addresses;
            }
        }

        return computeRoute(g);
    }




    class vDistance implements Comparable{
        public Vertex vertex;
        public Double distance;
        public String route = "";


        vDistance(Vertex _v, Double _d){
            vertex = _v;
            distance = _d;
            route = _v.getUnique().toString();
        }

        public void addLink(Vertex v) {
            route += BFStrategy.delimiteChar + v.getUnique();
        }

        public String getRoute() {
            return route;
        }

        public int compareTo(Object o) {
            if (o instanceof vDistance){

                vDistance v2 = (vDistance)o;
                if (distance > v2.distance){
                    return 1;
                } else if (distance < v2.distance) {
                    return -1;
                } else {
                    return 0;
                }
            }else {
                // this should never be hit
                return 1;
            }
        }
    }
}
