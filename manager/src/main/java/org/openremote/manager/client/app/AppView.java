package org.openremote.manager.client.app;

import org.jboss.errai.ui.shared.api.annotations.Bundle;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Bundle("bundle.json")
@Templated
public abstract class AppView {

    public enum NavigationItem {
        LOCATE,
        MANAGE,
        CONNECT
    }

    public void init() {
        getHeader().setSelected(getSelectedNavigationItem());
    }

    abstract public Header getHeader();

    abstract public NavigationItem getSelectedNavigationItem();

}
