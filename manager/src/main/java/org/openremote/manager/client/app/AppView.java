package org.openremote.manager.client.app;

import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.inject.Inject;

@Templated
public abstract class AppView {

    @Inject
    @DataField
    Header header;

}
