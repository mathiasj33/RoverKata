package de.rmkata.code;

public enum Direction {
	NORTH(0),
	EAST(1),
	SOUTH(2),
	WEST(3);
	
	final private int value;
	
	private Direction(int v)
	{ value = v; }
	
	public int getValue() {
		return value;
	}

	public static Direction getDirection(int val) {
	      for (Direction d : Direction.values()) {
	          if (d.value == val) return d;
	      }
	      throw new IllegalArgumentException("Diese Richtung gibts nicht.");
	   }
	
	public static Direction directionToTheRight(Direction d)
	{
		return getDirection((d.getValue()+1)%4);
	}

	public static Direction directionToTheLeft(Direction d)
	{
		return getDirection((d.getValue()+3)%4);
	}

}