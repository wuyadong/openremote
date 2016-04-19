package org.openremote.manager.client.foo;

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
@LoadAsync(FooView.class)
@Templated("../app/AppView.html")
@Page(path = "foo", role = {DefaultPage.class, FooView.class})
public class FooViewImpl extends AppView implements FooView {

    @Inject
    @DataField
    Header header;

    @Inject
    @DataField
    FooContent content;

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
        return LOCATE;
    }
}
