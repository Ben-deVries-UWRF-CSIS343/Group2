package org.springframework.projectname;

import java.io.IOException;

public interface IMapsInteractor {
    public double getDistanceFromAddress(Address source, Address destination) throws IOException;
}
