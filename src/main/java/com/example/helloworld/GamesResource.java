package com.example.helloworld;

import io.dropwizard.servlets.assets.ResourceNotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Path("/games")
@Produces("application/json")
public class GamesResource {

    @Context
    private UriInfo uriInfo;

    private List<Game> games = Collections.synchronizedList(new ArrayList<Game>());
    private AtomicInteger nextGameId = new AtomicInteger(0);

    @POST
    public Response createGame() {
        Game g = new Game(nextGameId.incrementAndGet());
        URI gameUri = uriInfo.getAbsolutePathBuilder().path(Long.toString(g.getId())).build();
        return Response.created(gameUri).build();
    }

    @Path("{id}")
    public GameResource getGame(@PathParam("id") long id) {
        return games.stream()
                .filter(game -> id == game.getId())
                .findFirst()
                .map(game -> new GameResource(game))
                .orElse(null);
    }

    @GET
    public List<String> getGames() {
        return games.stream()
                .map(Game::getId)
                .map(id -> uriInfo.getBaseUriBuilder().path(Long.toString(id)).build().toString())
                .collect(Collectors.toList());
    }

}
