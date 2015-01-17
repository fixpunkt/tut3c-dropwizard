package com.example.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
public class GameResource {

    private final Game game;

    public GameResource(Game game) {
        this.game = game;
    }

    @GET
    public Game getGame() {
        return game;
    }

}
