package org.openremote.manager.client.app;

import com.google.gwt.user.client.Event;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.paper.PaperButtonElement;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.SinkNative;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.openremote.manager.client.assets.AssetsView;
import org.openremote.manager.client.interop.dom.MutableDOMTokenList;
import org.openremote.manager.client.map.MapView;
import org.openremote.manager.client.notifications.NotificationsToolbar;

import javax.inject.Inject;
import java.util.logging.Logger;

import static org.openremote.manager.client.app.AppView.NavigationItem.*;

@Templated
public class Header {

    private static final Logger LOG = Logger.getLogger(Header.class.getName());

    static {
        Polymer.importHref("iron-iconset-svg/iron-iconset-svg");
        Polymer.importHref("iron-icons/iron-icons");
        Polymer.importHref("iron-icons/maps-icons");
        Polymer.importHref("iron-icons/hardware-icons");
    }

    @DataField
    PaperButtonElement locate = Polymer.createElement(PaperButtonElement.TAG);

    @DataField
    PaperButtonElement manage = Polymer.createElement(PaperButtonElement.TAG);

    @DataField
    PaperButtonElement connect = Polymer.createElement(PaperButtonElement.TAG);

    @Inject
    @DataField
    NotificationsToolbar notificationsToolbar;

    @Inject
    Navigation navigation;

    @EventHandler("locate")
    @SinkNative(Event.ONCLICK)
    void onLocate(Event event) {
        navigation.goToWithRole(MapView.class);
    }

    @EventHandler("manage")
    @SinkNative(Event.ONCLICK)
    void onManage(Event event) {
        navigation.goToWithRole(AssetsView.class);
    }

    public void setSelected(AppView.NavigationItem item) {
        ((MutableDOMTokenList)locate.getClassList()).remove("selected");
        ((MutableDOMTokenList)manage.getClassList()).remove("selected");
        ((MutableDOMTokenList)connect.getClassList()).remove("selected");
        if (item != null) {
            if (item.equals(LOCATE))
                ((MutableDOMTokenList)locate.getClassList()).add("selected");
            if (item.equals(MANAGE))
                ((MutableDOMTokenList)manage.getClassList()).add("selected");
            if (item.equals(CONNECT))
                ((MutableDOMTokenList)connect.getClassList()).add("selected");
        }
    }

}
