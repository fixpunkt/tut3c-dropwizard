package com.example.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Path("/games")
public class GamesResource {

    private List<Game> games = Collections.synchronizedList(new ArrayList<Game>());
    private AtomicInteger nextGameId = new AtomicInteger(0);

    @GET
    public List<String> getGames() {
        return games.stream().map(Game::getUri).collect(Collectors.toList());
    }

}
