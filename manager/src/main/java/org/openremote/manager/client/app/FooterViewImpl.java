package org.openremote.manager.client.app;

import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.openremote.manager.client.framework.AbstractView;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.logging.Logger;

@Singleton
@Templated
public class FooterViewImpl extends AbstractView<FooterPresenter> implements FooterView {

    private static final Logger LOG = Logger.getLogger(FooterViewImpl.class.getName());

    @Inject
    public FooterViewImpl(FooterPresenter presenter) {
        super(presenter);
    }
}
