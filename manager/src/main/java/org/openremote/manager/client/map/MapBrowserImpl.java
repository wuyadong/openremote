package org.openremote.manager.client.map;

import com.google.gwt.user.client.Event;
import org.jboss.errai.ioc.client.api.LoadAsync;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.SinkNative;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.openremote.manager.client.framework.AbstractView;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LoadAsync(MapView.class)
@Templated
public class MapBrowserImpl extends AbstractView<MapBrowserPresenter> implements MapBrowser {

    @Inject
    public MapBrowserImpl(MapBrowserPresenter presenter) {
        super(presenter);
    }

    @EventHandler("helloButton")
    @SinkNative(Event.ONCLICK)
    public void onClick(Event event) {
        getPresenter().processClick();
    }

}
