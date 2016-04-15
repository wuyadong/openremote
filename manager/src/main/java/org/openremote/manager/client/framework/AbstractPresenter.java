package org.openremote.manager.client.framework;

public abstract class AbstractPresenter<V extends View> {

    final V view;

    public AbstractPresenter(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }
}
