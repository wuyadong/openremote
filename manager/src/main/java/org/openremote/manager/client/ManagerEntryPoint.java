package org.openremote.manager.client;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

//@EntryPoint
public class ManagerEntryPoint {

    private static final Logger LOG = Logger.getLogger(ManagerEntryPoint.class.getName());

/*
    @Inject
    private Navigation navigation;
*/

    @PostConstruct
    private void init() {


        //Div header = (Div) querySelector("#header");
        //header.appendChild(headerView.getElement());

        //RootPanel.get("content").add(navigation.getContentPanel());

/*
        Div footer = (Div) querySelector("#footer");
        footer.appendChild(footerView.getElement());
*/

    }
}