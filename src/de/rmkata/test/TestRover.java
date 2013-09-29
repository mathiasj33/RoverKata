package de.rmkata.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.rmkata.code.Direction;
import de.rmkata.code.Rover;

public class TestRover {
	
	private Rover rover;
	private String[] commands;
	
	@Before
	public void setUp() {
		rover = new Rover(0,0,Direction.NORTH);
	}
	
	@Test
	public void testForward() {
		commands = new String[]{"f"};
		rover.receiveCommands(commands);
		Assert.assertEquals(0, rover.getPosX());
		Assert.assertEquals(1, rover.getPosY());
	}
	
	@Test
	public void testBackward() {
		commands = new String[]{"b"};
		rover.receiveCommands(commands);
		Assert.assertEquals(0, rover.getPosX());
		Assert.assertEquals(99, rover.getPosY());
	}
	
	@Test
	public void testTurnRight() {
		commands = new String[]{"r"};
		rover.receiveCommands(commands);
		Assert.assertEquals(Direction.EAST, rover.getDirection());
	}
	
	@Test
	public void testTurnLeft() {
		commands = new String[]{"l"};
		rover.receiveCommands(commands);
		Assert.assertEquals(Direction.WEST, rover.getDirection());
	}
	
	@Test
	public void testExample() {
		commands = new String[]{"f","f","r","f","f"};
		rover.receiveCommands(commands);
		Assert.assertEquals(2, rover.getPosX());
		Assert.assertEquals(2, rover.getPosY());
	}
}

