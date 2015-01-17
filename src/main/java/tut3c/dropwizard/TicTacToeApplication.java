package tut3c.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import tut3c.dropwizard.resources.GamesResource;

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
    }

}
