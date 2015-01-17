package com.example.helloworld;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TicTacToeApplication extends Application<HelloWorldConfig> {

    public static void main(String[] args) throws Exception {
        new TicTacToeApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfig> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(HelloWorldConfig configuration, Environment environment) {
        final GamesResource resource = new GamesResource();
        GameResource gr = new GameResource();
        environment.jersey().register(resource);
        environment.jersey().register(gr);
    }

}
