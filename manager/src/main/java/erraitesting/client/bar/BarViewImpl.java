package erraitesting.client.bar;

import erraitesting.client.app.AppView;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Templated("../app/AppView.html")
@Page(path = "bar", role = BarView.class)
public class BarViewImpl extends AppView implements BarView {

    @Inject
    @DataField
    BarContent content;
}
