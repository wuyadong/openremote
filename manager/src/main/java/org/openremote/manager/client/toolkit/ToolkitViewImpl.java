package org.openremote.manager.client.toolkit;

import org.jboss.errai.ioc.client.api.LoadAsync;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.openremote.manager.client.app.AppView;
import org.openremote.manager.client.app.Header;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import static org.openremote.manager.client.app.AppView.NavigationItem.LOCATE;

@Singleton
@LoadAsync(ToolkitView.class)
@Templated("../app/AppView.html")
@Page(path = "toolkit", role = {DefaultPage.class, ToolkitView.class})
public class ToolkitViewImpl extends AppView implements ToolkitView {

    @Inject
    @DataField
    Header header;

    @Inject
    @DataField
    ToolkitContent content;

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
        return null;
    }
}
