package com.example.helloworld;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
public class PlayersResource {
    private final List<Player> players;
    private final UriInfo uriInfo;

    public PlayersResource(List<Player> players, UriInfo uriInfo) {
        this.players = players;
        this.uriInfo = uriInfo;
    }

    @POST
    public Response createPlayer(String playerName) {
        if (players.size() > 1) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        int playerId = players.size() + 1;
        URI playerUri = uriInfo.getAbsolutePathBuilder().path(Integer.toString(playerId)).build();
        players.add(new Player(playerName, playerId));
        return Response.created(playerUri).build();
    }

    @GET
    public List<Player> getPlayers() {
        return players;
    }

    @Path("{playerId}")
    public PlayerResource getPlayer(@PathParam("playerId") int playerId) {
        if (playerId < 0 || playerId >= players.size()) {
            return null;
        }
        return new PlayerResource(players.get(playerId));
    }

}
