package org.openremote.manager.client.bar;

import com.google.gwt.user.client.Event;
import org.jboss.errai.ioc.client.api.LoadAsync;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.SinkNative;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.openremote.manager.client.foo.FooView;

import javax.inject.Inject;
import javax.inject.Singleton;

@LoadAsync(BarView.class)
@Singleton
@Templated
public class BarContent {

    @Inject
    Navigation navigation;

    @EventHandler("navButton")
    @SinkNative(Event.ONCLICK)
    public void onClick(Event event) {
        navigation.goToWithRole(FooView.class);
    }

}
