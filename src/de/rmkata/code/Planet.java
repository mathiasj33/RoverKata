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

	public void addObstacle(int i, int j) {
		obstacles.add(new Obstacle(i,j));
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public boolean isObstacleAt(int x, int y) {
		for(Obstacle o:obstacles) {
			if(o.getPosX() == x && o.getPosY() == y) {
				return true;
			}
		}
		return false;
	}
	
	public Obstacle getObstacleAt(int x, int y) {
		for(Obstacle o:obstacles) {
			if(o.getPosX() == x && o.getPosY() == y) {
				return o;
			}
		}
		return null;
	}

}
