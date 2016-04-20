package org.openremote.manager.client.map;

import org.jboss.errai.ioc.client.api.LoadAsync;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.openremote.manager.client.app.AppView;
import org.openremote.manager.client.app.Header;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import static org.openremote.manager.client.app.AppView.NavigationItem.CONNECT;
import static org.openremote.manager.client.app.AppView.NavigationItem.LOCATE;

@Singleton
@LoadAsync(MapView.class)
@Templated("../app/AppView.html")
@Page(path = "map", role = MapView.class)
public class MapViewImpl extends AppView implements MapView {

    @Inject
    @DataField
    Header header;

    @Inject
    @DataField
    MapContent content;

    @PostConstruct
    @Override
    public void init() {
        super.init();
    }

    @Override
    public Header getHeader() {
        return header;
    }

    @Override
    public NavigationItem getSelectedNavigationItem() {
        return LOCATE;
    }

}
