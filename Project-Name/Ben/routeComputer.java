public class routeComputer implements maps {
    // the container for all the addresses
    private List<string> addresses = new Lins<String>();

    // is uesd to determine wether the path needs to start and end at the same
    // location
    private boolean _isCircut = true;

    // will add the given address to the list of addreses
    // will not add duplicate addresses
    //
    // THE FIRST ELMELEMT IS ASSUMED TO BE THE START
    //
    // █████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
    // should verify that the given thing is a valid address, by changing from a
    // string to a custom address type
    public void addAddress(String address) {
        if (!(addresses.contains(address))) {
            addresses.add(address);
        }
    }

    // will remove an address from the addresses list
    public void removeAddress(String address) {
        addresses.remove(address);
    }

    // will remove all addresses from the list
    public void clearAddresses() {
        addresses.clear();
    }

    // sets the _isCircit variable, if true the start and end are the same otherwise
    // the start is the first element addres to the addresses list
    // and the end is the last destenation
    public void setIsCircut(boolean isCircut) {
        _isCircut = isCircut;
    }

    // do the nasty calculations
    // this will use multithreading and may need some horse-power
    // █████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████
    public List<String> computeRoute() {

    }

}