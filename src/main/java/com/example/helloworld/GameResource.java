package com.example.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Produces(MediaType.APPLICATION_JSON)
public class GameResource {

    private final Game game;
    private final UriBuilder uriBuilder;

    public GameResource(Game game, UriBuilder gameUriBuilder) {
        this.game = game;
        this.uriBuilder = gameUriBuilder;
    }

    @GET
    public Game getGame() {
        return game;
    }

    @Path("players")
    public PlayersResource getPlayers() {
        return new PlayersResource(game.getPlayers(), uriBuilder.path("players"));
    }

}
