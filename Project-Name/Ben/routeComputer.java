import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class routeComputer implements MapsInterface {
    // the container for all the addresses
    private List<Address> addresses = null;

    // will add the given address to the list of addreses
    // will not add duplicate addresses
    public void addAddress(Address addr) {
        if (!(addresses.contains(addr))) {
            addresses.add(addr);
        }
    }

    // will remove an address from the addresses list
    public void removeAddress(Address addr) {
        addresses.remove(addr);
    }

    // will remove all addresses from the list
    public void clearAddresses() {
        addresses.clear();
    }

    public ArrayList<String> computeRoute() {

        Graph g = getGraph();
        if (g == null) {
            return null;
        }

        return null;

    }

    public Graph getGraph() {
        if (addresses.size() == 0) {
            return new Graph();
        }

        Graph g = new Graph();

        // List v = new ArrayList<Vertex>();
        // List e = new ArrayList<edge>();

        // iderate the addresses and add them to the graph as verticies
        for (Address addr : addresses) {
            g.addVertex(new Vertex(addr));
        }

        // generate edges between every pair of verticies
        // ████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
        // MAY WANT MULTI THREADING
        // ████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████

        for (Vertex vtxOutter : g.getVerticies()) {
            for (Vertex vtxInner : g.getVerticies()) {
                // this will execute for every pair of vertecies

                // get the distance between these points using the gooleMapsInteractor

                // ████████████
                // The longest part of this will be waiting for google
                // thus use the outter if to verify that the edge does not already exist.
                // ████████████

                if (vtxOutter.hasEdge(vtxInner) == null)
                    try {
                        // if the edge does not exist create it
                        double miles = 0;
                        // try {
                        // miles = googleMapsInteracter.getDistanceFromAddress(vtxOutter.getAddress(),
                        // vtxInner.getAddress());
                        // } catch (IOException e) {
                        // // TODO Auto-generated catch block
                        // e.printStackTrace();
                        // }
                        Edge edge = new Edge();
                        edge.setWeight(miles);
                        edge.setVertex1(vtxOutter);
                        edge.setVertex2(vtxInner);

                        // add the edge to the verticies
                        vtxOutter.addEdge(edge);
                        vtxInner.addEdge(edge);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
            }
        }

        return g;
    }

}