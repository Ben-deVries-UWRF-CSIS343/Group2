package org.springframework.projectname;

import java.io.IOException;

public interface IMapsInteractor {
    public double getDistanceFromAddress(tudeAddress source, tudeAddress destination) throws IOException;
}
