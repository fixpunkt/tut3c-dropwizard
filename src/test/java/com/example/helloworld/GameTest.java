package com.example.helloworld;

import static org.junit.Assert.*;
import org.junit.Test;

public class GameTest {
	@Test
	public void test() {
		Game game = new Game(0);
		assertEquals(0, game.getId());
		
		String emptyField = "+-+-+-+\n| | | |\n+-+-+-+\n| | | |\n+-+-+-+\n| | | |\n+-+-+-+";
		assertEquals(emptyField, game.toString());
		
		game.setCell(0, 0, Cell.X);
		game.setCell(1, 1, Cell.X);
		game.setCell(2, 2, Cell.X);
		game.setCell(2, 1, Cell.O);
		
		assertEquals(Cell.O, game.getCell(2, 1));
		
		assertEquals(
				"+-+-+-+\n|X| | |\n+-+-+-+\n| |X| |\n+-+-+-+\n| |O|X|\n+-+-+-+",
				game.toString());
		
		boolean exceptionThrown = false;
		try {
			game.setCell(0, 0, Cell.X);
		} catch (IllegalStateException ex) {
			exceptionThrown = true;
		}
		assertTrue(
				"Es müsste das setzen eines Feldes zum zweiten Mal zu einem Fehler führen!",
				exceptionThrown);

		game.reset();
		assertEquals(emptyField, game.toString());
	}

	@Test
	public void testNextPlayer() {
		Game game = new Game(1);
		assertEquals(Cell.X, game.getNextPlayer());
		game.setCell(0, 0, Cell.X);
		assertEquals(Cell.O, game.getNextPlayer());
		game.setCell(1, 0, Cell.O);
		assertEquals(Cell.X, game.getNextPlayer());
	}

}
