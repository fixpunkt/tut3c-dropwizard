package tut3c.dropwizard.resources;

import tut3c.dropwizard.model.Player;

import javax.ws.rs.GET;

public class PlayerResource {
    private final Player player;

    public PlayerResource(Player player) {
        this.player = player;
    }

    @GET
    public Player getPlayer() {
        return player;
    }
}
