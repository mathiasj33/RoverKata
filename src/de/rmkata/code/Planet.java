package de.rmkata.code;

import java.util.ArrayList;

public class Planet {
	
	private String name;
	private int height;
	private int width;
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

	public Planet(String string, int i, int j) {
		name = string;
		width = i;
		height = j;
	}

	public void addObstacle(Pos p) {
		obstacles.add(new Obstacle(p));
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public boolean isObstacleAt(Pos p) {
		for(Obstacle o:obstacles) {
			if(o.getPosition().equals(p)) {
				return true;
			}
		}
		return false;
	}
	
	public Obstacle getObstacleAt(Pos p) {
		for(Obstacle o:obstacles) {
			if(o.getPosition().equals(p)) {
				return o;
			}
		}
		return null;
	}
	
	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}
	
	public String getName() {
		return name;
	}

}
