package org.springframework.projectname;

import org.springframework.projectname.graph.Graph;

public interface IRouteStrategy {
    public Address[] computeRoute(Graph g);
}
