
package com.protectsoft.apiee.util;

import org.glassfish.jersey.server.spi.AbstractContainerLifecycleListener;
import org.glassfish.jersey.server.spi.Container;

/**
 *
 */
public class StartUpHandler extends  AbstractContainerLifecycleListener {
        
    public StartUpHandler() {}
    
    @Override
    public void onStartup(Container container)  {
    }
        
}



