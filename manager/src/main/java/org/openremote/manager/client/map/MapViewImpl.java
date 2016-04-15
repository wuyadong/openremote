package org.openremote.manager.client.map;

import org.jboss.errai.ioc.client.api.LoadAsync;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.openremote.manager.client.app.AppView;
import org.openremote.manager.client.app.FooterViewImpl;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.logging.Logger;

@Singleton
@LoadAsync(MapView.class)
@Templated("../app/AppView.html")
@Page(path = "map", role = DefaultPage.class)
public class MapViewImpl extends AppView<MapPresenter> implements MapView {

    private static final Logger LOG = Logger.getLogger(MapViewImpl.class.getName());

    /*
    @Inject
    @DataField
    Div header;

  @Inject
    @DataField
    MapBrowserImpl content;


*/
    @Inject
    @DataField
    FooterViewImpl footer;

    @Inject
    public MapViewImpl(MapPresenter presenter) {
        super(presenter);
    }

}
