package com.example.helloworld;

import java.util.Arrays;
import java.util.stream.Stream;

public class Game {

	private long id;
	private Cell[][] cells;

	public Game(int id) {
		this.id = id;
		reset();
	}

	public long getId() {
		return id;
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

	public void setCell(int i, int j, Cell x) {
		if (isSet(i, j)) {
			throw new IllegalStateException();
		}
		cells[i][j] = x;
	}

	public boolean isSet(int i, int j) {
		return cells[i][j] != Cell.EMPTY;
	}

	public Cell getCell(int i, int j) {
		return cells[i][j];
	};
	
	@Override
	public String toString() {
		Stream<Object> map = Arrays.stream(cells).map(
				array -> {
					return Arrays.stream(array).map(Object::toString)
							.reduce((x, y) -> x + "|" + y).get();
				});
		String determinator = "+-+-+-+";
		return (String) map.map(l -> determinator + "\n|" + l + "|")
				.reduce((x, y) -> x + "\n" + y).get()
				+ "\n" + determinator;
	}

}
