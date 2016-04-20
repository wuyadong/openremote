package org.openremote.manager.client.assets;

import com.google.gwt.user.client.Event;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.vaadin.VaadinGridElement;
import org.jboss.errai.ioc.client.api.LoadAsync;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.SinkNative;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.openremote.manager.client.map.MapView;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LoadAsync(AssetsView.class)
@Templated
public class AssetsContent {

    @DataField
    VaadinGridElement assetsGrid = Polymer.createElement(VaadinGridElement.TAG);

    @Inject
    Navigation navigation;

    @EventHandler("navButton")
    @SinkNative(Event.ONCLICK)
    public void onClick(Event event) {
        navigation.goToWithRole(MapView.class);
    }

}
