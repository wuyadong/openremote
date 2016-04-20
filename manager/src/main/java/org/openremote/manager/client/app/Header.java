package org.openremote.manager.client.app;

import com.google.gwt.user.client.Event;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.SinkNative;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.openremote.manager.client.assets.AssetsView;
import org.openremote.manager.client.interop.paper.PaperButton;
import org.openremote.manager.client.map.MapView;
import org.openremote.manager.client.notifications.NotificationsToolbar;

import javax.inject.Inject;
import java.util.logging.Logger;

import static org.openremote.manager.client.app.AppView.NavigationItem.*;

@Templated
public class Header {

    private static final Logger LOG = Logger.getLogger(Header.class.getName());

    @Inject
    @DataField
    PaperButton locate;

    @Inject
    @DataField
    PaperButton manage;

    @Inject
    @DataField
    PaperButton connect;

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
        locate.getClassList().remove("selected");
        manage.getClassList().remove("selected");
        connect.getClassList().remove("selected");
        if (item != null) {
            if (item.equals(LOCATE))
                locate.getClassList().add("selected");
            if (item.equals(MANAGE))
                manage.getClassList().add("selected");
            if (item.equals(CONNECT))
                connect.getClassList().add("selected");
        }
    }

}
