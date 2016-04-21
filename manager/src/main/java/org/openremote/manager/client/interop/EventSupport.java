package org.openremote.manager.client.interop;

import org.jboss.errai.common.client.dom.EventListener;
import org.jboss.errai.common.client.dom.HTMLElement;

import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public abstract class EventSupport {

    private static final Logger LOG = Logger.getLogger(EventSupport.class.getName());

    class Registration {
        final HTMLElement element;
        final String type;
        final EventListener listener;

        public Registration(HTMLElement element, String type, EventListener listener) {
            this.element = element;
            this.type = type;
            this.listener = listener;
        }
    }

    final protected List<Registration> registrations = new ArrayList<>();

    public void addEventListener(HTMLElement element, String type, EventListener listener) {
        element.addEventListener(type, listener, false);
        registrations.add(new Registration(element, type, listener));
    }

    @PreDestroy
    public void unregister() {
        LOG.info("Removing event registrations: " + registrations.size());
        for (Registration registration : registrations) {
            registration.element.removeEventListener(registration.type, registration.listener, false);
        }
    }

}
