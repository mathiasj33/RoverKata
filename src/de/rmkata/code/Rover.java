package de.rmkata.code;

import java.util.ArrayList;




public class Rover {
	
	private Direction direction;
	private Pos position;
	private Planet planet;
	private ArrayList<Pos> vectors;
	
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
		vectors = new ArrayList<Pos>();
		for(int i = 0; i < commands.length(); i++) {
			Character c = commands.charAt(i);
			if(c.equals('f') || c.equals('b')) {
				doCommand(c);
				/*
				position.setX(position.getX() + vectors.get(vectors.size() - 1).getX());
				position.setY(position.getY() + vectors.get(vectors.size() - 1).getY());
				if(position.getX() > planet.getWidth()) position.setX(0);
				else if(position.getX() < 0) position.setX(planet.getWidth());
				else if(position.getY() > planet.getHeight()) position.setY(0);
				else if(position.getY() < 0) position.setY(planet.getHeight());
				for(Obstacle o : planet.getObstacles()) {
					if(o.getPosition().equals(position)) {
						receiveCommands("b");  //Sonst würde der Rover im Obstacle stehen bleiben
						return o;
					}
				} */
				if(vectors.size() == 1) {
					Pos tryPosition = Pos.addModulo(vectors.get(0), position, planet.getWidth(), planet.getHeight());
					for(Obstacle o : planet.getObstacles()) {
						if(o.getPosition().equals(tryPosition)) {
							return o;
						}
					}
					position = tryPosition;
				}
				else {
					Pos tryPosition = Pos.addModulo(vectors.get(vectors.size() - 1), vectors.get(vectors.size() - 2), planet.getWidth(), planet.getHeight());
					for(Obstacle o : planet.getObstacles()) {
						if(o.getPosition().equals(tryPosition)) {
							return o;
						}
					}
					position = tryPosition;
				}
				vectors.add(position);
			}
			else if(c.equals('r') || c.equals('l')) {
				doCommand(c);
			}
		}
		return null;
	}
	
	private void doCommand(Character command) {
		if(command.equals('f')) {
			vectors.add(direction.getPos());
/*			if(direction.equals(Direction.NORTH)) {
				vectors.add(new Pos(0, 1));
			}
			else if(direction.equals(Direction.EAST)) {
				vectors.add(new Pos(1, 0));
			}
			else if(direction.equals(Direction.SOUTH)) {
				vectors.add(new Pos(0, -1));
			}
			else if(direction.equals(Direction.WEST)) {
				vectors.add(new Pos(-1, 0));
			}
*/		}
		else if(command.equals('b')) {
			vectors.add(new Pos(-direction.getPos().getX(),-direction.getPos().getY()));
/*			if(direction.equals(Direction.NORTH)) {
				vectors.add(new Pos(0,  - 1));
			}
			else if(direction.equals(Direction.EAST)) {
				vectors.add(new Pos(- 1, 0));
			}
			else if(direction.equals(Direction.SOUTH)) {
				vectors.add(new Pos(0, 1));
			}
			else if(direction.equals(Direction.WEST)) {
				vectors.add(new Pos( 1, 0));
			}
*/		}
		else if(command.equals('r')) {
			direction = Direction.directionToTheRight(direction);
		}
		else if(command.equals('l')) {
			direction = Direction.directionToTheLeft(direction);
		}
	}

}
