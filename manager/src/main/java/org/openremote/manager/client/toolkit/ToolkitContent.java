package org.openremote.manager.client.toolkit;

import com.google.gwt.user.client.Event;
import org.jboss.errai.ioc.client.api.LoadAsync;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.SinkNative;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.openremote.manager.client.assets.AssetsView;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LoadAsync(ToolkitView.class)
@Templated
public class ToolkitContent {

    @Inject
    Navigation navigation;

    @EventHandler("navButton")
    @SinkNative(Event.ONCLICK)
    public void onClick(Event event) {
        navigation.goToWithRole(AssetsView.class);
    }

}
