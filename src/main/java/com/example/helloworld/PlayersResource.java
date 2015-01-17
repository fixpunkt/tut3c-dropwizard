package com.example.helloworld;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
public class PlayersResource {
    private final List<Player> players;
    private final UriBuilder uriBuilder;

    public PlayersResource(List<Player> players, UriBuilder uriBuilder) {
        this.players = players;
        this.uriBuilder = uriBuilder;
    }

    @POST
    public Response createPlayer(String playerName) {
        if (players.size() > 1) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        int playerId = players.size() + 1;
        UriBuilder playerUriBuilder = uriBuilder.path(Integer.toString(playerId));
        players.add(new Player(playerName, playerId, playerUriBuilder));
        return Response.created(playerUriBuilder.build()).build();
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
