package com.example.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@Produces(MediaType.APPLICATION_JSON)
public class GameResource {

    private final Game game;
    private final URI uri;

    public GameResource(Game game, URI uri) {
        this.game = game;
        this.uri = uri;
    }

    @GET
    public Game getGame() {
        return game;
    }

    @Path("players")
    public PlayersResource getPlayers() {
        return new PlayersResource(game.getPlayers(), UriBuilder.fromUri(uri).path("players").build());
    }

    @Path("moves")
    public MovesResource getMoves() {
        return new MovesResource(game);
    }

}
