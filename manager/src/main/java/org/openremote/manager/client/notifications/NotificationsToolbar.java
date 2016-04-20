package org.openremote.manager.client.notifications;

import com.vaadin.polymer.Polymer;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated("#notificationToolbar")
public class NotificationsToolbar {

    static {
        Polymer.importHref("iron-icons/iron-icons");
        Polymer.importHref("paper-button");
        Polymer.importHref("paper-badge");

    }

}
