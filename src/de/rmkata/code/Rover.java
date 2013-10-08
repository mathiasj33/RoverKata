package de.rmkata.code;

public class Rover {
	
	private Direction direction;
	private Pos position;
	private Planet planet;
	
	public Rover(Planet pl, Pos pos, Direction dir) {
		position = pos;
		direction = dir;
		planet = pl;
	}
	
	public Pos getPosition() {
		return position;
	}
	
	public void setPosition(Pos pos) {
		position = pos;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public Obstacle receiveCommands(String commands) {
		for(int i = 0; i < commands.length(); i++) {
			Obstacle o = doCommand(commands.charAt(i));
			if (o!=null)
				return o;
		}
		return null;
	}
	
	private Obstacle doCommand(Character command) {
		Obstacle obstacle = null;
		Pos directionVector = direction.getPos();
		if (command=='b')
			directionVector = Pos.getNegative(directionVector);
		
		switch (command) {
		case 'f':
		case 'b':
			Pos tryPosition = Pos.addModulo(position, directionVector, planet.getWidth(), planet.getHeight());
			obstacle = planet.getObstacleAt(tryPosition);
			if (obstacle==null)
				position = tryPosition;
			break;
		case 'r':
			direction = Direction.directionToTheRight(direction);
			break;
		case 'l':
			direction = Direction.directionToTheLeft(direction);
			break;
		}
		return obstacle;
	}

}
