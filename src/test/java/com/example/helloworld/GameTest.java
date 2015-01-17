package com.example.helloworld;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {
	@Test
	public void test() {
		Game game = new Game(0);
		Assert.assertEquals(0, game.getId());
		
		String emptyField = "+-+-+-+\n| | | |\n+-+-+-+\n| | | |\n+-+-+-+\n| | | |\n+-+-+-+";
		Assert.assertEquals(emptyField, game.toString());
		
<<<<<<< HEAD
		game.setCell(0, 0, Cell.X);
		game.setCell(1, 1, Cell.X);
		game.setCell(2, 2, Cell.X);
		game.setCell(2, 1, Cell.O);
		
		Assert.assertEquals(Cell.O, game.getCell(2, 1));
=======
		game.setValue(0, 0, Cell.X);
		game.setValue(1, 1, Cell.X);
		game.setValue(2, 2, Cell.X);
		game.setValue(2, 1, Cell.O);
>>>>>>> e004467bf97bb41cb482474b06d6c9d876a1d40a
		
		Assert.assertEquals(
				"+-+-+-+\n|X| | |\n+-+-+-+\n| |X| |\n+-+-+-+\n| |O|X|\n+-+-+-+",
				game.toString());
		
		boolean exceptionThrown = false;
		try {
<<<<<<< HEAD
			game.setCell(0, 0, Cell.X);
=======
			game.setValue(0, 0, Cell.X);
>>>>>>> e004467bf97bb41cb482474b06d6c9d876a1d40a
		} catch (IllegalStateException ex) {
			exceptionThrown = true;
		}
		Assert.assertTrue(
				"Es müsste das setzen eines Feldes zum zweiten Mal zu einem Fehler führen!",
				exceptionThrown);

		game.reset();
		Assert.assertEquals(emptyField, game.toString());
	}

}
