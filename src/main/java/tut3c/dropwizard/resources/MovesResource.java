package tut3c.dropwizard.resources;

import org.atmosphere.cpr.BroadcasterFactory;
import org.atmosphere.util.SimpleBroadcaster;
import tut3c.dropwizard.model.Cell;
import tut3c.dropwizard.model.Game;
import tut3c.dropwizard.model.Move;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

public class MovesResource {

    private Game game;

    private SimpleBroadcaster broadcaster = new SimpleBroadcaster();

    public MovesResource(Game game) {
        this.game = game;
    }

    @POST
    public Response createMove(Move move) {
        game.setCell(move.getRow(), move.getColumn(), Cell.valueOf(move.getMark()));
        BroadcasterFactory.getDefault().lookup("/gameevents").broadcast(game);
        return Response.status(Response.Status.CREATED).build();
    }
}
