package org.openremote.manager.client.interop.dom;

import com.vaadin.polymer.elemental.DOMTokenList;
import jsinterop.annotations.JsType;

import static jsinterop.annotations.JsPackage.GLOBAL;

@JsType(isNative=true, namespace=GLOBAL)
public interface MutableDOMTokenList extends DOMTokenList {

    void add(String token);

    void remove(String token);

    void replace(String token, String replacement);

    boolean toggle(String token);

}
