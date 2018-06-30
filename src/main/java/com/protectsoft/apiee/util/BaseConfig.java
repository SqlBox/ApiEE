
package com.protectsoft.apiee.util;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * middleware for when the web app starts
 * 
 */
public class BaseConfig extends ResourceConfig  {
    
    public BaseConfig() {
         super();
         register(JacksonJaxbJsonProvider.class);
         packages("com.protectsoft.apiee.base.endpoint;" 
                + "com.protectsoft.apiee.core.exceptions.providers;" 
                + "com.protectsoft.apiee.base.endpoint.jaxrs;" 
         );
    }
        
    public BaseConfig(String packages,Class<?>... classes){
        this();
        packages(packages);
        for(Class<?> c: classes){
            register(c);
        }       
    }
}
