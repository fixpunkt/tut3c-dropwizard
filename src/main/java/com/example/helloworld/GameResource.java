package com.example.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/game")
public class GameResource {

    @GET
    public String getSaying() {
        return "hello world";
    }
}
