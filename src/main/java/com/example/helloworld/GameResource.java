package com.example.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Produces("application/json")
public class GameResource {

    private final Game game;

    public GameResource(Game g) {
        this.game = g;
    }

    @GET
    public String getSaying() {
        return "hello world";
    }

}
