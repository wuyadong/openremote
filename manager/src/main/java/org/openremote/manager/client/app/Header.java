package org.openremote.manager.client.app;

import com.google.gwt.user.client.Event;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.SinkNative;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.openremote.manager.client.bowercomponents.paper.PaperButton;
import org.openremote.manager.client.foo.FooView;

import javax.inject.Inject;

@Templated
public class Header {

    @Inject
    @DataField
    PaperButton nav1;

    @Inject
    Navigation navigation;

    @EventHandler("nav1")
    @SinkNative(Event.ONCLICK)
    public void onNavOne(Event event) {
        nav1.getStyle().setProperty("color", "red");
        navigation.goToWithRole(FooView.class);
    }

}
