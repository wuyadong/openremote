package org.openremote.manager.client.presenter;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.workingflows.js.jscore.client.api.promise.Promise;
import elemental.json.Json;
import elemental.json.JsonObject;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.TextCallback;
import org.openremote.manager.client.rest.MapRestService;
import org.openremote.manager.client.view.MapView;

import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MapActivity
    extends AbstractActivity<OverviewPlace>
    implements MapView.Presenter {

    private static final Logger LOG = Logger.getLogger(MapActivity.class.getName());

    private final MapView view;
    private final MapRestService mapRestService;
    private final PlaceController placeController;
    private final EventBus bus;

    @Inject
    public MapActivity(MapView view,
                       MapRestService mapRestService,
                       PlaceController placeController,
                       EventBus bus) {
        this.view = view;
        this.mapRestService = mapRestService;
        this.placeController = placeController;
        this.bus = bus;
    }

    @Override
    protected void init(OverviewPlace place) {

    }

    @Override
    public void start(AcceptsOneWidget container, com.google.gwt.event.shared.EventBus activityBus) {
        view.setPresenter(this);
        container.setWidget(view.asWidget());

        if (!view.isMapInitialised()) {
            Promise p = new Promise((resolve, reject) -> {
                // Make call to server
                mapRestService.getOptions(new TextCallback() {
                    @Override
                    public void onFailure(Method method, Throwable exception) {
                        LOG.log(Level.SEVERE, "Error retrieving map settings", exception);
                        reject.rejected(null);
                    }

                    @Override
                    public void onSuccess(Method method, String response) {
                        resolve.resolve(response);
                    }
                });
            });

            p.then(obj -> {
                JsonObject settings = Json.parse((String) obj);
                view.initialiseMap(settings);
                return null;
            }).catchException(obj -> {
                return null;
            });
        } else {
            //TODO: Reconfigure the map
        }
    }

    @Override
    public void goTo(Place place) {
        placeController.goTo(place);
    }
}