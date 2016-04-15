package org.openremote.manager.client.assets;

import org.jboss.errai.ioc.client.api.LoadAsync;
import org.openremote.manager.client.framework.AbstractPresenter;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.logging.Logger;

@Singleton
@LoadAsync(AssetsView.class)
public class AssetsBrowserPresenter extends AbstractPresenter<AssetsBrowser> {

    private static final Logger LOG = Logger.getLogger(AssetsBrowserPresenter.class.getName());

    @Inject
    public AssetsBrowserPresenter(AssetsBrowser view) {
        super(view);
    }

}
