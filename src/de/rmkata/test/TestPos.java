package de.rmkata.test;

import org.junit.Assert;

import org.junit.Test;

import de.rmkata.code.Pos;

public class TestPos {
	
	@Test
	public void testEquals() {
		Pos pos1 = new Pos(10,10);
		Pos pos2 = new Pos(10,10);
		Assert.assertEquals(pos1, pos2);
	}

}
