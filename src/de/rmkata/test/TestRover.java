package de.rmkata.test;

import static org.mockito.Mockito.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.rmkata.code.Direction;
import de.rmkata.code.Obstacle;
import de.rmkata.code.Planet;
import de.rmkata.code.Rover;

public class TestRover {
	
	private Rover rover;
	
	@Before
	public void setUp() {
		rover = new Rover(new Planet("Mars",100,100),0,0,Direction.NORTH);
	}
	
	@Test
	public void testForward() {
		rover.receiveCommands("f");
		Assert.assertEquals(0, rover.getPosX());
		Assert.assertEquals(1, rover.getPosY());
	}
	
	@Test
	public void testBackward() {
		rover.receiveCommands("b");
		Assert.assertEquals(0, rover.getPosX());
		Assert.assertEquals(99, rover.getPosY());
	}
	
	@Test
	public void testTurnRight() {
		rover.receiveCommands("r");
		Assert.assertEquals(Direction.EAST, rover.getDirection());
	}
	
	@Test
	public void testTurnLeft() {
		rover.receiveCommands("l");
		Assert.assertEquals(Direction.WEST, rover.getDirection());
	}
	
	@Test
	public void testExample() {
		rover.receiveCommands("ffrff");
		Assert.assertEquals(2, rover.getPosX());
		Assert.assertEquals(2, rover.getPosY());
	}

	@Test
	public void testExample2WithObstacles() {
		Planet venus = new Planet("Venus",50,40); // der Rover soll auf Planeten beliebiger Groesse fahren können
		venus.addObstacle(48,38);
		Rover rover2 = new Rover(venus,0,0,Direction.NORTH);
		Obstacle obstacle = rover2.receiveCommands("bblf");
		Assert.assertTrue(obstacle==null);
		Assert.assertEquals(38,rover2.getPosY());
		Assert.assertEquals(49, rover2.getPosX());
		obstacle = rover2.receiveCommands("f");
		Assert.assertTrue(obstacle!=null);
		Assert.assertEquals(48,obstacle.getPosX());
		Assert.assertEquals(38,obstacle.getPosY());
		Assert.assertEquals(38,rover2.getPosY());
		Assert.assertEquals(49,rover2.getPosX());
	}

}

