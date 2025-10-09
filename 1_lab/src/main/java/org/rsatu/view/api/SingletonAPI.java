package org.rsatu.view.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class SingletonAPI extends Application {
    private Set<Object> singletons = new HashSet<Object>();

    public SingletonAPI() {
        singletons.add(new CreatorAPI());
        singletons.add(new ReaderAPI());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
