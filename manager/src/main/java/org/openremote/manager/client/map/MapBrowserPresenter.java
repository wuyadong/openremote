package org.openremote.manager.client.map;

import org.jboss.errai.ioc.client.api.LoadAsync;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.openremote.manager.client.framework.AbstractPresenter;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.logging.Logger;

@Singleton
@LoadAsync(MapView.class)
public class MapBrowserPresenter extends AbstractPresenter<MapBrowser> {

    private static final Logger LOG = Logger.getLogger(MapBrowserPresenter.class.getName());

    @Inject
    Navigation navigation;

    @Inject
    public MapBrowserPresenter(MapBrowser view) {
        super(view);
    }

    public void processClick() {
        LOG.info("### PROCESSING CLICK IN PRESENTER");
        //navigation.goToWithRole(AssetsView.class);
    }

}
