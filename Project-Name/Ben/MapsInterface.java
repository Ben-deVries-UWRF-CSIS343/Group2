interface maps {

    //
    // !!!The first element is assumed to be the start!!!
    //
    public void addAddress(String address);

    public void setIsCircut(boolean isCircut);

    public List<String> computeRoute();

    public void clearAddresses();

    public void removeAddress(String address);
}