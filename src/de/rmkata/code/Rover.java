package de.rmkata.code;

import java.util.ArrayList;



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
		ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
		for(int i = 0; i < commands.length(); i++) {
			Character c = commands.charAt(i);
			if(c.equals('f') || c.equals('b') || c.equals('r') || c.equals('l')) {
				obstacles.add(doCommand(c));
			}
		}
		for(Obstacle o:obstacles) {
			if(o != null) return o;  //Evtl. überschreiben, dass die null-obstacles nicht hinzugefügt werden
		}
		return null;
	}
	
	public Obstacle doCommand(Character command) {
		if(command.equals('f')) {
			if(direction.equals(Direction.NORTH)) {  //Hier kann man noch refactoren
				if(posY == planet.getHeight() - 1) posY = 0;
				else if(planet.isObstacleAt(posX, posY + 1)) {
					return planet.getObstacleAt(posX, posY + 1);
				}
				else posY++;
			}
			else if(direction.equals(Direction.EAST)) {
				if(posX == planet.getWidth() - 1) posX = 0;
				else if(planet.isObstacleAt(posX + 1, posY)) {
					return planet.getObstacleAt(posX + 1, posY);
				}
				else posX++;
			}
			else if(direction.equals(Direction.SOUTH)) {
				if(posY == 0) posY = planet.getHeight() - 1;
				else if(planet.isObstacleAt(posX, posY - 1)) {
					return planet.getObstacleAt(posX, posY - 1);
				}
				else posY--;
			}
			else if(direction.equals(Direction.WEST)) {
				if(posX == 0) posX = planet.getWidth() - 1;
				else if(planet.isObstacleAt(posX - 1, posY)) {
					return planet.getObstacleAt(posX - 1, posY);
				}
				else posX--;
			}
			return null;
		}
		else if(command.equals('b')) {
			if(direction.equals(Direction.NORTH)) {
				if(posY == 0) posY = planet.getHeight() - 1;
				else if(planet.isObstacleAt(posX, posY - 1)) {
					return planet.getObstacleAt(posX, posY - 1);
				}
				else posY--;
			}
			else if(direction.equals(Direction.EAST)) {
				if(posX == 0) posX = planet.getWidth() - 1;
				else if(planet.isObstacleAt(posX - 1, posY)) {
					return planet.getObstacleAt(posX - 1, posY);
				}
				else posX--;
			}
			else if(direction.equals(Direction.SOUTH)) {
				if(posY == planet.getHeight() - 1) posY = 0;
				else if(planet.isObstacleAt(posX, posY + 1)) {
					return planet.getObstacleAt(posX, posY + 1);
				}
				else posY++;
			}
			else if(direction.equals(Direction.WEST)) {
				if(posX == planet.getWidth() - 1) posX = 0;
				else if(planet.isObstacleAt(posX + 1, posY)) {
					return planet.getObstacleAt(posX + 1, posY);
				}
				else posX++;
			}
			return null;
		}
		else if(command.equals('r')) {
			direction = Direction.directionToTheRight(direction);
			return null;
		}
		else if(command.equals('l')) {
			direction = Direction.directionToTheLeft(direction);
			return null;
		}
		return null;
	}

}
