
package com.protectsoft.apiee.core.endpoint;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class ApiContainerResponseFilter implements ContainerResponseFilter {
    
    @Override
    public void filter(ContainerRequestContext requestContext,ContainerResponseContext response) {
        response.getHeaders().add("Access-Control-Allow-Origin", "*");
        response.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Accept, Authorization, Content-Disposition, "
                + "Ignore-Authorization, responseType, X-Total-Count");
        response.getHeaders().putSingle("Access-Control-Expose-Headers", "X-Total-Count");
        this.setHttpMethods(response);
        this.setTotalCountHeader(requestContext,response);
    }
    
    /**
     * sets X-Total-Count in header from requestContext.properties
     */
    public void setTotalCountHeader(ContainerRequestContext requestContext,ContainerResponseContext response) {
        Object property = requestContext.getProperty("X-Total-Count");
        if(property != null) {
            response.getHeaders().add("X-Total-Count", (Long)property);
        }
    } 
    
    public void setHttpMethods(ContainerResponseContext response) {
        response.getHeaders().add("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE, PATCH");
    }
    
}
