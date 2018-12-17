package org.springframework.projectname;

import java.util.List;

public interface MapsInterface {

    public void addAddress(tudeAddress addr);

    public void removeAddress(tudeAddress addr);

    public List<String> computeRoute();

    public void clearAddresses();

}