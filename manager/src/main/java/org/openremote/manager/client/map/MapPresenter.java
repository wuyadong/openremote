package org.openremote.manager.client.map;

import org.jboss.errai.ioc.client.api.LoadAsync;
import org.openremote.manager.client.framework.AbstractPresenter;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.logging.Logger;

@Singleton
@LoadAsync(MapView.class)
public class MapPresenter extends AbstractPresenter<MapView> {

    private static final Logger LOG = Logger.getLogger(MapPresenter.class.getName());

    @Inject
    public MapPresenter(MapView view) {
        super(view);
        LOG.info("### INIT MAP PRESENTER");
    }
}
