package org.openremote.manager.client.assets;

import org.jboss.errai.ioc.client.api.LoadAsync;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.openremote.manager.client.app.AppView;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.logging.Logger;

@LoadAsync(AssetsView.class)
@Singleton
@Templated
public class AssetsBrowserImpl extends AppView<AssetsBrowserPresenter> implements AssetsBrowser {

    private static final Logger LOG = Logger.getLogger(AssetsBrowserImpl.class.getName());

    @Inject
    public AssetsBrowserImpl(AssetsBrowserPresenter presenter) {
        super(presenter);
    }
}
