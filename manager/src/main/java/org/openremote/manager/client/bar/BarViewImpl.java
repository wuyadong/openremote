package org.openremote.manager.client.bar;

import org.jboss.errai.ioc.client.api.LoadAsync;
import org.openremote.manager.client.app.AppView;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.inject.Inject;
import javax.inject.Singleton;

@LoadAsync(BarView.class)
@Singleton
@Templated("../app/AppView.html")
@Page(path = "bar", role = BarView.class)
public class BarViewImpl extends AppView implements BarView {

    @Inject
    @DataField
    BarContent content;
}
