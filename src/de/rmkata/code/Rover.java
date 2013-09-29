package de.rmkata.code;


public class Rover {
	
	private Direction direction;
	private int posX;
	private int posY;
	
	public Rover(int x, int y, Direction dir) {
		posX = x;
		posY = y;
		direction = dir;
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
	
	public void receiveCommands(String[] commands) {
		for(int i = 0; i < commands.length; i++) {
			if(commands[i].equals("f") || commands[i].equals("b") || commands[i].equals("r") || commands[i].equals("l")) {
				doCommand(commands[i]);
			}
		}	
	}
	
	public void doCommand(String command) {
		if(command.equals("f")) {
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
		else if(command.equals("b")) {
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
		else if(command.equals("r")) {
			if(direction.equals(Direction.NORTH)) {
				direction = Direction.EAST;
			}
			else if(direction.equals(Direction.EAST)) {
				direction = Direction.SOUTH;
			}
			else if(direction.equals(Direction.SOUTH)) {
				direction = Direction.WEST;
			}
			else if(direction.equals(Direction.WEST)) {
				direction = Direction.NORTH;
			}
		}
		else if(command.equals("l")) {
			if(direction.equals(Direction.NORTH)) {
				direction = Direction.WEST;
			}
			else if(direction.equals(Direction.EAST)) {
				direction = Direction.NORTH;
			}
			else if(direction.equals(Direction.SOUTH)) {
				direction = Direction.EAST;
			}
			else if(direction.equals(Direction.WEST)) {
				direction = Direction.SOUTH;
			}
		}
	}

}
