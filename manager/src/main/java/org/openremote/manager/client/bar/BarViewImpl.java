package org.openremote.manager.client.bar;

import org.jboss.errai.ioc.client.api.LoadAsync;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.openremote.manager.client.app.AppView;
import org.openremote.manager.client.app.Header;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import static org.openremote.manager.client.app.AppView.NavigationItem.MANAGE;

@Singleton
@LoadAsync(BarView.class)
@Templated("../app/AppView.html")
@Page(path = "bar", role = BarView.class)
public class BarViewImpl extends AppView implements BarView {

    @Inject
    @DataField
    Header header;

    @Inject
    @DataField
    BarContent content;

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
        return MANAGE;
    }

}
