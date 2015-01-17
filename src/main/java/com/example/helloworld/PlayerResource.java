package com.example.helloworld;

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
