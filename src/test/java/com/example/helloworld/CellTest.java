package com.example.helloworld;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CellTest {
	@Test
	public void testToString() {
		assertEquals(" ", Cell.EMPTY.toString());
		assertEquals("X", Cell.X.toString());
		assertEquals("O", Cell.O.toString());
	}
}
