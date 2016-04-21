package org.openremote.manager.client.toolkit;

import org.jboss.errai.ioc.client.api.LoadAsync;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.inject.Singleton;

@Singleton
@LoadAsync(ToolkitView.class)
@Templated
public class ToolkitContent {
}
