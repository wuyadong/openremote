package org.openremote.manager.client.assets;

import org.jboss.errai.common.client.dom.EventListener;
import org.jboss.errai.ioc.client.api.LoadAsync;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.openremote.manager.client.interop.EventSupport;
import org.openremote.manager.client.interop.or.OrToast;
import org.openremote.manager.client.interop.paper.PaperButton;
import org.openremote.manager.client.map.MapView;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.logging.Logger;

@Singleton
@LoadAsync(AssetsView.class)
@Templated
public class AssetsContent extends EventSupport {

    private static final Logger LOG = Logger.getLogger(AssetsContent.class.getName());

    @Inject
    Navigation navigation;

    @Inject
    @DataField
    PaperButton navButton;

    @Inject
    @DataField
    OrToast toast;

    EventListener showToast = event -> {
        toast.show(false, "Hello World!!!", 1000);
    };

    EventListener goToMap = event -> {
        navigation.goToWithRole(MapView.class);
    };

    EventListener toastShown = event -> {
        LOG.info("### TOAST SHOWN: " + event);
    };

    @PostConstruct
    public void registerEvents() {
        addEventListener(navButton, "mouseover", showToast);
        addEventListener(navButton, "click", goToMap);
        addEventListener(toast, "iron-announce", toastShown);
    }

}
