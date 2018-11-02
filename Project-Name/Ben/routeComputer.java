import java.util.List;

public class routeComputer implements maps {
    // the container for all the addresses
    private List<address> addresses = new List<address>();

    // will add the given address to the list of addreses
    // will not add duplicate addresses
    public void addAddress(address addr) {
        if (!(addresses.contains(addr))) {
            addresses.add(addr);
        }
    }

    // will remove an address from the addresses list
    public void removeAddress(address addr) {
        addresses.remove(addr);
    }

    // will remove all addresses from the list
    public void clearAddresses() {
        addresses.clear();
    }

    // do the nasty calculations
    // this will use multithreading and may need some !!horse-power!!
    // █████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
    public ArrayList<String> computeRoute() {
        // make an ajacency matrix
        // make a 2D array with the height and width of the size of addresses
        if (addresses.size() == 0) {
            return null;
        }

        int matrix[][] = new int[addresses.size()][addresses.size()];

        // loop through all pairs of the addresses to get the distance from source to
        // destination

        for (address source : addresses) {
            // this should go from 0 to n where n is the length - 1
            for (address dest : addresses) {
                if (addresses.indexOf(dest) > addresses.indexOf(source)) {
                    matrix[addresses.indexOf(source)][addresses.indexOf(dest)] = googleMapsInteracter
                            .getDistanceFromAddress(source, dest);
                } else if (address.indexOf(dest) == addresses.indexOf(source)) {
                    // if the source is the destination the cost to get there is irrelevent because
                    // there is not need to go to where you are, firethermore, this will mess up the
                    // algorithm because it findes the shortest to alls
                    matrix[addresses.indexOf(source)][addresses.indexOf(dest)] = Integer.MAX_VALUE;
                }
            }
        }

        // do all the crap
    }

}