package org.openremote.manager.client.app;

import com.google.gwt.user.client.Event;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.SinkNative;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.openremote.manager.client.bar.BarView;
import org.openremote.manager.client.foo.FooView;
import org.openremote.manager.client.notifications.NotificationsToolbar;
import org.openremote.manager.client.paper.PaperButton;

import javax.inject.Inject;

import static org.openremote.manager.client.app.AppView.NavigationItem.*;

@Templated
public class Header {

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
        navigation.goToWithRole(FooView.class);
    }

    @EventHandler("manage")
    @SinkNative(Event.ONCLICK)
    void onManage(Event event) {
        navigation.goToWithRole(BarView.class);
    }

    public void setSelected(AppView.NavigationItem item) {
        locate.getClassList().remove("selected");
        manage.getClassList().remove("selected");
        connect.getClassList().remove("selected");
        if (item.equals(LOCATE))
            locate.getClassList().add("selected");
        if (item.equals(MANAGE))
            manage.getClassList().add("selected");
        if (item.equals(CONNECT))
            connect.getClassList().add("selected");
    }

}
