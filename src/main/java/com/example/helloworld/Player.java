package com.example.helloworld;

import javax.ws.rs.core.UriBuilder;

public class Player {
    private final String name;
    private final int id;
    private final UriBuilder uriBuilder;

    public Player(String name, int id, UriBuilder uriBuilder) {
        this.name = name;
        this.id = id;
        this.uriBuilder = uriBuilder;
    }

    public String getName() {
        return name;
    }

}
