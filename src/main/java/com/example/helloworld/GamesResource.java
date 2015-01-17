package com.example.helloworld;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Path("/games")
@Produces(MediaType.APPLICATION_JSON)
public class GamesResource {

    @Context
    private UriInfo uriInfo;

    private List<Game> games = Collections.synchronizedList(new ArrayList<Game>());
    private AtomicInteger nextGameId = new AtomicInteger(0);

    @POST
    public Response createGame() {
        int id = nextGameId.incrementAndGet();
        Game game = new Game(id);
        games.add(game);
        URI gameUri = getGameUriBuilder(id).build();
        return Response.created(gameUri).build();
    }

    private UriBuilder getGameUriBuilder(int id) {
        return uriInfo.getAbsolutePathBuilder().path(Long.toString(id));
    }

    @Path("{id}")
    public GameResource getGame(@PathParam("id") int id) {
        return games.stream()
                .filter(game -> id == game.getId())
                .findFirst()
                .map(game -> new GameResource(game, getGameUriBuilder(id)))
                .orElse(null);
    }

    @GET
    public List<String> getGames() {
        return games.stream()
                .map(Game::getId)
                .map(this::getGameUriBuilder)
                .map(uriBuilder -> uriBuilder.build())
                .map(URI::toString)
                .collect(Collectors.toList());
    }

}
