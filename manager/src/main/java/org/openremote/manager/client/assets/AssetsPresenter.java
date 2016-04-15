package org.openremote.manager.client.assets;

import org.jboss.errai.ioc.client.api.LoadAsync;
import org.openremote.manager.client.framework.AbstractPresenter;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.logging.Logger;

@Singleton
@LoadAsync(AssetsView.class)
public class AssetsPresenter extends AbstractPresenter<AssetsView> {

    private static final Logger LOG = Logger.getLogger(AssetsPresenter.class.getName());

    @Inject
    public AssetsPresenter(AssetsView view) {
        super(view);
        LOG.info("### INIT ASSETS PRESENTER");
    }
}
