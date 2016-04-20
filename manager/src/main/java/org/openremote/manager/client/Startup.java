package org.openremote.manager.client;

import org.jboss.errai.ioc.client.api.AfterInitialization;
import org.jboss.errai.ioc.client.api.EntryPoint;

@EntryPoint
public class Startup {

    @AfterInitialization
    public native void init() /*-{
        // Force layout of resizable event listeners
        $wnd.setTimeout(function() {
            $wnd.dispatchEvent(new Event('resize'));
        }, 500);
        console.log("Application startup complete");
    }-*/;

}
