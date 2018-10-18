public class routeComputer implements maps {
    // the container for all the addresses
    private List<address> addresses = new Lins<address>();

    // will add the given address to the list of addreses
    // will not add duplicate addresses
    // █████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
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
    // this will use multithreading and may need some horse-power
    // █████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
    public List<String> computeRoute() {
        addresses.clear();

    }

}