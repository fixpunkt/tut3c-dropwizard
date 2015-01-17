package com.example.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Produces(MediaType.APPLICATION_JSON)
public class GameResource {

    private final Game game;
    private final UriInfo uriInfo;

    public GameResource(Game game, UriInfo uriInfo) {
        this.game = game;
        this.uriInfo = uriInfo;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Game getGame() {
        return game;
    }

    @Path("players")
    public PlayersResource getPlayers() {
        return new PlayersResource(game.getPlayers(), uriInfo);
    }

    @Path("moves")
    public MovesResource getMoves() {
        return new MovesResource(game);
    }

    public URI getUri() {
        return uriInfo.getAbsolutePathBuilder().path(Integer.toString(game.getId())).build();
    }
}
