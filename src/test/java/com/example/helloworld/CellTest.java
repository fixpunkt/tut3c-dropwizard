package com.example.helloworld;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {
	@Test
	public void testToString() {
		assertEquals(" ", Cell.EMPTY.toString());
		assertEquals("X", Cell.X.toString());
		assertEquals("O", Cell.O.toString());
	}
}
