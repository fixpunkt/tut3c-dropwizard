package com.example.helloworld;

public class Game {

    public long getId() {
        return id;
    }

    public enum Cell {
        EMPTY, X, O
    }

    private long id;
    private Cell[][] cells;

    public Game(int id) {
        this.id = id;        
        cells = new Cell[][]{
                new Cell[]{Cell.EMPTY, Cell.EMPTY, Cell.EMPTY},
                new Cell[]{Cell.EMPTY, Cell.EMPTY, Cell.EMPTY},
                new Cell[]{Cell.EMPTY, Cell.EMPTY, Cell.EMPTY},
        };
    }

    public Cell[][] getCells() {
        return cells;
    }

}
