package tut3c.dropwizard.resources;

import tut3c.dropwizard.model.Game;

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

    @GET
    @Path("/init")
    public List<String> initTestData() {
        games.clear();
        games.add(new Game(1));
        games.add(new Game(2));
        games.add(new Game(3));
        return getGames();
    }

    @POST
    public Response createGame() {
        int id = nextGameId.incrementAndGet();
        Game game = new Game(id);
        games.add(game);
        return Response.created(new GameResource(game, uriInfo).getUri()).build();
    }

    @Path("{id}")
    public GameResource getGame(@PathParam("id") int id) {
        return games.stream()
                .filter(game -> id == game.getId())
                .findFirst()
                .map(game -> new GameResource(game, uriInfo))
                .orElse(null);
    }

    @GET
    public List<String> getGames() {
        return games.stream()
                .map(game -> new GameResource(game, uriInfo))
                .map(GameResource::getUri)
                .map(URI::toString)
                .collect(Collectors.toList());
    }

}
