package com.example.helloworld;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

public class MovesResource {

    private Game game;

    public MovesResource(Game game) {
        this.game = game;
    }

    @POST
    public Response createMove(Move move) {
        game.setCell(move.getRow(), move.getColumn(), Cell.valueOf(move.getMark()));
        return Response.status(Response.Status.CREATED).build();
    }
}
