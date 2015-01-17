package com.example.helloworld;

import javax.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Game {

	private int id;
	private List<Player> players;	
	private Cell[][] cells;

	public Game(int id) {
		this.id = id;
		reset();
	}

	public int getId() {
		return id;
	}

	public void reset() {
		cells = new Cell[][] {
				new Cell[] { Cell.EMPTY, Cell.EMPTY, Cell.EMPTY },
				new Cell[] { Cell.EMPTY, Cell.EMPTY, Cell.EMPTY },
				new Cell[] { Cell.EMPTY, Cell.EMPTY, Cell.EMPTY }, };
		players = Collections.synchronizedList(new ArrayList<Player>());
	}

	public Cell getNextPlayer() {
		return numberOfMoves() % 2 == 0 ? Cell.X : Cell.O;
	}

	private long numberOfMoves() {
		return Arrays.stream(cells).flatMap(row -> Arrays.stream(row)).filter(cell -> cell != Cell.EMPTY).count();
	}

	public Cell[][] getCells() {
		return cells;
	}

	public void setCell(int i, int j, Cell x) {
		if (isSet(i, j)) {
			throw new FieldAlreadySetException();
		}
		cells[i][j] = x;
	}

	public boolean isSet(int i, int j) {
		return cells[i][j] != Cell.EMPTY;
	}

	public Cell getCell(int i, int j) {
		return cells[i][j];
	};

	public List<Player> getPlayers() {
		return players;
	}
	
	@Override
	public String toString() {
		Stream<Object> map = Arrays.stream(cells).map(
				array -> {
					return Arrays.stream(array).map(Object::toString)
							.reduce((x, y) -> x + "|" + y).get();
				});
		String delimiter = "+-+-+-+";
		return (String) map.map(l -> delimiter + "\n|" + l + "|")
				.reduce((x, y) -> x + "\n" + y).get()
				+ "\n" + delimiter + "\n\nNext player: " + getNextPlayer();
	}

}
