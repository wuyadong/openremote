package org.openremote.manager.client.framework;

public abstract class AbstractView<P> implements View {

    final P presenter;

    public AbstractView(P presenter) {
        this.presenter = presenter;
    }

    public P getPresenter() {
        return presenter;
    }

}
