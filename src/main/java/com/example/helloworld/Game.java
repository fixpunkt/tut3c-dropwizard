package com.example.helloworld;

import java.util.Arrays;
import java.util.stream.Stream;

public class Game {

        public long getId() {
                return id;
        }

        private long id;
        private Cell[][] cells;

        public Game(int id) {
                this.id = id;
                reset();
        }

        public void reset() {
                cells = new Cell[][] {
                                new Cell[] { Cell.EMPTY, Cell.EMPTY, Cell.EMPTY },
                                new Cell[] { Cell.EMPTY, Cell.EMPTY, Cell.EMPTY },
                                new Cell[] { Cell.EMPTY, Cell.EMPTY, Cell.EMPTY }, };
        }

        public Cell[][] getCells() {
                return cells;
        }

        @Override
        public String toString() {
                Stream<Object> map = Arrays.stream(cells).map(array -> {
                        return Arrays.stream(array).map(Object::toString).reduce((x, y) -> x + ", " + y);
                });
                map.reduce((x, y) -> x + "\n" +  y);
                return "";
        }
}

