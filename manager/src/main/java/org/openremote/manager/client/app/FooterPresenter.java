package org.openremote.manager.client.app;

import org.openremote.manager.client.framework.AbstractPresenter;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.logging.Logger;

@Singleton
public class FooterPresenter extends AbstractPresenter<FooterView> {

    private static final Logger LOG = Logger.getLogger(FooterPresenter.class.getName());

    @Inject
    public FooterPresenter(FooterView view) {
        super(view);
    }

}
