package com.example.helloworld;

import java.util.Arrays;
import java.util.stream.Stream;

public class Game {

<<<<<<< HEAD
=======
	public long getId() {
		return id;
	}

>>>>>>> e004467bf97bb41cb482474b06d6c9d876a1d40a
	private long id;
	private Cell[][] cells;

	public Game(int id) {
		this.id = id;
		reset();
	}

<<<<<<< HEAD
	public long getId() {
		return id;
	}
	
=======
>>>>>>> e004467bf97bb41cb482474b06d6c9d876a1d40a
	public void reset() {
		cells = new Cell[][] {
				new Cell[] { Cell.EMPTY, Cell.EMPTY, Cell.EMPTY },
				new Cell[] { Cell.EMPTY, Cell.EMPTY, Cell.EMPTY },
				new Cell[] { Cell.EMPTY, Cell.EMPTY, Cell.EMPTY }, };
	}

	public Cell[][] getCells() {
		return cells;
	}

<<<<<<< HEAD
	public void setCell(int i, int j, Cell x) {
		if (isSet(i, j)) {
=======
	public void setValue(int i, int j, Cell x) {
		if (cells[i][j] != Cell.EMPTY) {
>>>>>>> e004467bf97bb41cb482474b06d6c9d876a1d40a
			throw new IllegalStateException();
		}
		cells[i][j] = x;
	}

<<<<<<< HEAD
	public boolean isSet(int i, int j) {
		return cells[i][j] != Cell.EMPTY;
	}

	public Cell getCell(int i, int j) {
		return cells[i][j];
	};
	
=======
>>>>>>> e004467bf97bb41cb482474b06d6c9d876a1d40a
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
