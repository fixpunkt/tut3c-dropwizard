package com.example.helloworld;

import java.net.URI;

public class Player {
    private final String name;
    private final int id;
    private final URI uri;

    public Player(String name, int id, URI uri) {
        this.name = name;
        this.id = id;
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

}
