package tut3c.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.atmosphere.cpr.ApplicationConfig;
import org.atmosphere.cpr.AtmosphereServlet;
import tut3c.dropwizard.resources.GamesResource;

import javax.servlet.ServletRegistration;

public class TicTacToeApplication extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new TicTacToeApplication().run(args);
    }

    @Override
    public String getName() {
        return "tut3c-dropwizard";
    }

    @Override
    public void run(Configuration configuration, Environment environment) {
        environment.jersey().register(new GameTextPlainMessageBodyWriter());
        final GameHealthCheck healthCheck = new GameHealthCheck();
        environment.healthChecks().register("game", healthCheck);
        final GamesResource resource = new GamesResource();
        environment.jersey().register(resource);

        AtmosphereServlet servlet = new AtmosphereServlet();
        servlet.framework().addInitParameter("com.sun.jersey.config.property.packages", "tut3c.dropwizard.resources.atmosphere");
        servlet.framework().addInitParameter(ApplicationConfig.WEBSOCKET_CONTENT_TYPE, "application/json");
        servlet.framework().addInitParameter(ApplicationConfig.WEBSOCKET_SUPPORT, "true");
        ServletRegistration.Dynamic servletHolder = environment.servlets().addServlet("gameevents", servlet);
        servletHolder.addMapping("/gameevents/*");
    }

}
