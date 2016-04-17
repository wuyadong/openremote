package erraitesting.client.foo;

import erraitesting.client.app.AppView;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Templated("../app/AppView.html")
@Page(path = "foo", role = {DefaultPage.class, FooView.class})
public class FooViewImpl extends AppView implements FooView {

    @Inject
    @DataField
    FooContent content;
}
