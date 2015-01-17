package tut3c.dropwizard;

import org.junit.Test;
import tut3c.dropwizard.model.Cell;

import static org.junit.Assert.assertEquals;

public class CellTest {
	@Test
	public void testToString() {
		assertEquals(" ", Cell.EMPTY.toString());
		assertEquals("X", Cell.X.toString());
		assertEquals("O", Cell.O.toString());
	}
}
