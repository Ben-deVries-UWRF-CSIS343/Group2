import java.util.*;

public class BFStrategy implements IRouteStrategy {
    private List<vDistance> thingsToConsider = null;

    public String[] computeRoute(Graph g) {
        if (thingsToConsider == null) {
            for (Vertex v : g.getVerticies()) {
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

        // take the lowest item from the 'thingsToConsider' and compute all of it's next
        // locations.
        if (thingsToConsider.size() > 0) {

            // grab the lowest item.
            vDistance thingConsidering = thingsToConsider.get(0);

            // iterate all the verticies and grab the shortest distance one
            for (Vertex v : g.getVerticies()) {
                // remove the ones already contained in teh route
                // create the char sequence
                String creationTime = new String(v.getUnique().toString());
                if (thingConsidering.route.contains(creationTime)) {
                    // we have already hit this vertex, ignore it
                    continue;
                } else {
                    // create a new vDistance object adding the current vertex to the route and
                    // insert it into the thingsToConsider

                    Double distance = thingConsidering.distance;
                    String route = thingConsidering.route;
                    Vertex vtx = v;

                    for (Edge e : vtx.getEdges()) {
                        if ((e.getVertex1().equals(vtx) && e.getVertex2().equals(thingConsidering.vertex))
                                || (e.getVertex2().equals(vtx) && e.getVertex1().equals(thingConsidering.vertex))) {
                            // get the distance of the edge and add it to the distance variable
                            distance += e.getWeight();
                            break;
                        }
                    }

                    vDistance newDistance = new vDistance(vtx, distance);
                    newDistance.route = route;
                    newDistance.addLink(vtx);

                    thingsToConsider.add(newDistance);

                    System.out.println("added");
                }
            }

            // then remove the currently examined object from the DintancesToConsider
            thingsToConsider.remove(0);
            // check to see if there are any compleated routes.
            // The first compleated is the fastest

        } else {
            // we should never hit this
            System.err.println("Compute route in BFStretegy has reached an empty list");
        }

        // check for finish case
        for (vDistance route : thingsToConsider) {
            // if the route contains n-1 pipes ('|') then there are n verticies in thr route
            // since we only allow a vertx to be placed in the route once
            // route found

            String[] idxs = route.route.split("|", 2);

            // System.out.println("length: " + route.route.split("|").length);
            System.out.println("length two: " + idxs.length);
            System.out.println("size: " + g.getVerticies().size());

            if (route.route.split("|").length == g.getVerticies().size()) {
                return route.route.split("|");
            }
        }

        return computeRoute(g);
    }

    class vDistance implements Comparable {
        public Vertex vertex;
        public Double distance;
        public String route = "";

        vDistance(Vertex _v, Double _d) {
            vertex = _v;
            distance = _d;
            route = _v.getUnique().toString();
        }

        public void addLink(Vertex v) {
            route += "|" + v.getUnique();
        }

        public String getRoute() {
            return route;
        }

        public int compareTo(Object o) {
            if (o instanceof vDistance) {

                vDistance v2 = (vDistance) o;
                if (distance > v2.distance) {
                    return 1;
                } else if (distance < v2.distance) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                // this should never be hit
                return 1;
            }
        }
    }
}
