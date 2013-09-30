package de.rmkata.test;

import junit.framework.Assert;

import org.junit.Test;

import de.rmkata.code.Direction;

public class DirectionTest {
	

	@Test
	public void testDirectionToTheRight() {
		Assert.assertEquals(Direction.EAST, Direction.directionToTheRight(Direction.NORTH));
		Assert.assertEquals(Direction.SOUTH, Direction.directionToTheRight(Direction.EAST));
		Assert.assertEquals(Direction.WEST, Direction.directionToTheRight(Direction.SOUTH));
		Assert.assertEquals(Direction.NORTH, Direction.directionToTheRight(Direction.WEST));
	}

	@Test
	public void testDirectionToTheLeft() {
		Assert.assertEquals(Direction.WEST, Direction.directionToTheLeft(Direction.NORTH));
		Assert.assertEquals(Direction.NORTH, Direction.directionToTheLeft(Direction.EAST));
		Assert.assertEquals(Direction.EAST, Direction.directionToTheLeft(Direction.SOUTH));
		Assert.assertEquals(Direction.SOUTH, Direction.directionToTheLeft(Direction.WEST));
	}

}
