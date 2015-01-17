package com.example.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/game")
@Produces("application/json")
public class GameResource {

    private final Game game;

    @Context
    private UriInfo uriInfo;

    public GameResource(Game g) {
        this.game = g;
    }

    @GET
    public String getSaying() {
        return "hello world";
    }

    public URI getUri() {
        return uriInfo.getBaseUri();
    }
}
