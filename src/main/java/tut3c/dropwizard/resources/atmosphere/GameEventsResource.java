package tut3c.dropwizard.resources.atmosphere;

import org.atmosphere.config.service.AtmosphereHandlerService;
import org.atmosphere.cpr.AtmosphereHandler;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.cpr.AtmosphereResponse;

import java.io.IOException;
import java.util.Map;

@AtmosphereHandlerService(path = "/gameevents")
public class GameEventsResource implements AtmosphereHandler {

    public GameEventsResource() {
    }

    @Override
    public void onRequest(AtmosphereResource resource) throws IOException {
        Map<String, String[]> parameterMap = resource.getRequest().getParameterMap();
        resource.suspend();
    }

    @Override
    public void onStateChange(AtmosphereResourceEvent event) throws IOException {
        AtmosphereResource r = event.getResource();
        AtmosphereResponse res = r.getResponse();

        if (r.isSuspended()) {
            res.getWriter().write(event.getMessage().toString());
            switch (r.transport()) {
                case JSONP:
                case LONG_POLLING:
                case UNDEFINED:
                    event.getResource().resume();
                    break;
                case WEBSOCKET:
                case STREAMING:
                    res.getWriter().flush();
                    break;
            }
        } else if (!event.isResuming()) {
            event.broadcaster().broadcast("say bye bye!");
        }
    }

    @Override
    public void destroy() {

    }
}
