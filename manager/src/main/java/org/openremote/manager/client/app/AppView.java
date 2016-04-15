package org.openremote.manager.client.app;

import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.openremote.manager.client.framework.AbstractView;

@Templated
public abstract class AppView<P> extends AbstractView<P> {

    public AppView(P presenter) {
        super(presenter);
    }

}
