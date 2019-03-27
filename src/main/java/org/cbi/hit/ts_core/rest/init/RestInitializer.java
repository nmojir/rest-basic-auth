package org.cbi.hit.ts_core.rest.init;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.apache.shiro.web.jaxrs.ShiroFeature;
import org.cbi.hit.ts_core.rest.impl.PersonService;

@ApplicationPath("")
public class RestInitializer extends Application {
	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(ShiroFeature.class);
        resources.add(PersonService.class);

        return resources;
    }
	
	
}
