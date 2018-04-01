
package com.protectsoft.apiee.util;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * middleware for when the web app starts
 * 
 */
public class BaseConfig extends ResourceConfig  {
    
    public BaseConfig() {
         super();
         packages("com.protectsoft.apiee.core.exceptions;"
                + "com.protectsoft.apiee.base.endpoint;" 
                + "com.protectsoft.apiee.core.exceptions.providers;" 
         );
        register(org.glassfish.jersey.media.multipart.MultiPartFeature.class);
    }
        
    public BaseConfig(String packages,Class<?>... classes){
        this();
        packages(packages);
        for(Class<?> c: classes){
            register(c);
        }
       
        register(StartUpHandler.class);
    }
}
