package org.springframework.projectname;

import java.util.List;

public interface MapsInterface {

    public void addAddress(Address addr);

    public void removeAddress(Address addr);

    public List<String> computeRoute();

    public void clearAddresses();

}