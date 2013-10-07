package de.rmkata.code;

public enum Direction {
	NORTH(0, new Pos(0,1)),
	EAST(1, new Pos(1,0)),
	SOUTH(2, new Pos(0,-1)),
	WEST(3, new Pos(-1,0));
	
	final private int value;
	final private Pos pos;
	
	private Direction(int v, Pos pos){ 
		this.value = v;
		this.pos = pos;
	}
	
	public int getValue() {
		return value;
	}
	
	public Pos getPos() {
		return pos;
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