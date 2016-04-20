package org.openremote.manager.client;

import org.jboss.errai.ioc.client.api.AfterInitialization;
import org.jboss.errai.ioc.client.api.EntryPoint;

@EntryPoint
public class AppEntryPoint {

    @AfterInitialization
    public native void init() /*-{
        console.log("Application startup complete");
    }-*/;

}
