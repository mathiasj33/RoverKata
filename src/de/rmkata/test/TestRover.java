package de.rmkata.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.rmkata.code.Direction;
import de.rmkata.code.Obstacle;
import de.rmkata.code.Planet;
import de.rmkata.code.Pos;
import de.rmkata.code.Rover;

public class TestRover {
	
	private Rover rover;
	
	@Before
	public void setUp() {
		rover = new Rover(new Planet("Mars",100,100),new Pos(0,0),Direction.NORTH);
	}
	
	@Test
	public void testForward() {
		rover.receiveCommands("f");
		Assert.assertEquals(0, rover.getPosition().getX());
		Assert.assertEquals(1, rover.getPosition().getY());
	}
	
	@Test
	public void testBackward() {
		rover.receiveCommands("b");
		Assert.assertEquals(0, rover.getPosition().getX());
		Assert.assertEquals(100, rover.getPosition().getY());
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
	public void testDriveAroundPlanet() {
		rover.receiveCommands("b");
		Assert.assertEquals(100, rover.getPosition().getY());
		rover.receiveCommands("f");
		Assert.assertEquals(0, rover.getPosition().getY());
		rover.receiveCommands("lf");
		Assert.assertEquals(100, rover.getPosition().getX());
		rover.receiveCommands("b");
		Assert.assertEquals(0, rover.getPosition().getX());
	}
	
	@Test
	public void testExample() {
		rover.receiveCommands("ffrff");
		Assert.assertEquals(2, rover.getPosition().getY());
		Assert.assertEquals(2, rover.getPosition().getX());
	}
	
	@Test
	public void testPlanet() {
		Planet pluto = new Planet("Pluto",5,5);
		rover = new Rover(pluto,new Pos(0,0),Direction.NORTH);
		rover.receiveCommands("ffrffffff");
		Assert.assertEquals(2, rover.getPosition().getY());
		Assert.assertEquals(0, rover.getPosition().getX());
	}
	
	@Test
	public void testDirection() {
		rover.receiveCommands("ffl");
		Assert.assertEquals(Direction.WEST, rover.getDirection());
		rover = new Rover(new Planet("Pluto", 5,5), new Pos(0,0), Direction.NORTH);
		rover.receiveCommands("l");
		Assert.assertEquals(Direction.WEST, rover.getDirection());
		rover.receiveCommands("f");
		Assert.assertEquals(new Pos(5,0), rover.getPosition());
		Assert.assertEquals(Direction.WEST, rover.getDirection());
	}

	@Test
	public void testExample2WithObstacles() {
		Planet venus = new Planet("Venus",50,40); // der Rover soll auf Planeten beliebiger Größe fahren können
		venus.addObstacle(new Pos(5,1));
		Rover rover2 = new Rover(venus,new Pos(0,0),Direction.NORTH);
		Obstacle obstacle = rover2.receiveCommands("rfffffl");
		Assert.assertTrue(obstacle==null);
		Assert.assertEquals(0,rover2.getPosition().getY());
		Assert.assertEquals(5, rover2.getPosition().getX());
		obstacle = rover2.receiveCommands("f");
		Assert.assertTrue(obstacle!=null);
		Assert.assertEquals(5,obstacle.getPosition().getX());
		Assert.assertEquals(1,obstacle.getPosition().getY());
		Assert.assertEquals(5,rover2.getPosition().getX());
		Assert.assertEquals(0,rover2.getPosition().getY());
	}
	
	@Test
	public void testDetectObstacleWhileDriving() {
		Planet mars = new Planet("Mars",100,100);
		mars.addObstacle(new Pos(2,2));
		rover = new Rover(mars,new Pos(0,0),Direction.NORTH);
		Obstacle o = rover.receiveCommands("ffrfflf");  //Jetzt soll das Hinderniss während dem Fahren entdeckt werden
		Assert.assertTrue(o != null);
		Assert.assertEquals(2, rover.getPosition().getY());
		Assert.assertEquals(1, rover.getPosition().getX());
	}

}