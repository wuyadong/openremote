package org.openremote.manager.client.interop.or;

import jsinterop.annotations.JsType;
import org.jboss.errai.common.client.api.annotations.Element;
import org.jboss.errai.common.client.dom.HTMLElement;

@JsType(isNative = true)
@Element("or-toast")
public interface OrToast extends HTMLElement {

    void show(boolean warning, String text, double duration);

    void hide();
}
