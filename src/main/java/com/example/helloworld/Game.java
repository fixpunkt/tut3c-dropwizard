package com.example.helloworld;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

public class Game {

    @Context
    private UriInfo uriInfo;

    public enum Cell {
        EMPTY, X, O
    }

    private Cell[][] cells;

    public Game() {
        cells = new Cell[][]{
                new Cell[]{Cell.EMPTY, Cell.EMPTY, Cell.EMPTY},
                new Cell[]{Cell.EMPTY, Cell.EMPTY, Cell.EMPTY},
                new Cell[]{Cell.EMPTY, Cell.EMPTY, Cell.EMPTY},
        };
    }

    public Cell[][] getCells() {
        return cells;
    }

    public String getUri() {
        return uriInfo.getBaseUri().toString();
    }
}
