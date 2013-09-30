package de.rmkata.code;



public class Rover {
	
	private Direction direction;
	private int posX;
	private int posY;
	private Planet planet;
	
	public Rover(Planet pl, int x, int y, Direction dir) {
		posX = x;
		posY = y;
		direction = dir;
		planet = pl;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setPosX(int x) {
		posX = x;
	}
	
	public void setPosY(int y) {
		posY = y;
	}
	
	public Obstacle receiveCommands(String commands) {
		for(int i = 0; i < commands.length(); i++) {
			Character c = commands.charAt(i);
			if(c.equals('f') || c.equals('b') || c.equals('r') || c.equals('l')) {
				doCommand(c);
			}
		}
		return null;
	}
	
	public void doCommand(Character command) {
		if(command.equals('f')) {
			if(direction.equals(Direction.NORTH)) {  //Hier kann man noch sehr gut refactoren
				if(posY == 99) posY = 0;
				else posY++;
			}
			else if(direction.equals(Direction.EAST)) {
				if(posX == 99) posX = 0;
				else posX++;
			}
			else if(direction.equals(Direction.SOUTH)) {
				if(posY == 0) posY = 99;
				else posY--;
			}
			else if(direction.equals(Direction.WEST)) {
				if(posX == 0) posX = 99;
				else posX++;
			}
		}
		else if(command.equals('b')) {
			if(direction.equals(Direction.NORTH)) {
				if(posY == 0) posY = 99;
				else posY--;
			}
			else if(direction.equals(Direction.EAST)) {
				if(posX == 0) posX = 99;
				else posX--;
			}
			else if(direction.equals(Direction.SOUTH)) {
				if(posY == 99) posY = 0;
				else posY++;
			}
			else if(direction.equals(Direction.WEST)) {
				if(posX == 99) posX = 0;
				else posX++;
			}
		}
		else if(command.equals('r')) {
			direction = Direction.directionToTheRight(direction);
		}
		else if(command.equals('l')) {
			direction = Direction.directionToTheLeft(direction);
		}
	}

}
