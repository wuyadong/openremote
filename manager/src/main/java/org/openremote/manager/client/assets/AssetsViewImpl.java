package org.openremote.manager.client.assets;

import org.jboss.errai.ioc.client.api.LoadAsync;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.openremote.manager.client.app.AppView;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.logging.Logger;

@LoadAsync(AssetsView.class)
@Singleton
@Templated("../app/AppView.html")
//@Page(path = "assets", role = AssetsView.class)
public class AssetsViewImpl extends AppView<AssetsPresenter> implements AssetsView {

    private static final Logger LOG = Logger.getLogger(AssetsViewImpl.class.getName());

/*
    @Inject
    @DataField
    AssetsBrowserImpl content;
*/

    @Inject
    public AssetsViewImpl(AssetsPresenter presenter) {
        super(presenter);
    }
}
