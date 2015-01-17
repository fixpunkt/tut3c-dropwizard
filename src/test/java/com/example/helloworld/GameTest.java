package com.example.helloworld;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {
	@Test
	public void test() {
		Game game = new Game(0);
		Assert.assertEquals(0, game.getId());
		System.out.println(game.toString());
		System.out.println("asdf");
	}
	
}
