package de.rmkata.code;

public class Pos {
	
	private int x;
	private int y;
	
	public Pos(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pos other = (Pos) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	public String toString() {
		return(Integer.toString(x) + " " + Integer.toString(y));
	}

	public static Pos add(Pos summand1, Pos summand2) {
		return new Pos(summand1.getX()+summand2.getX(),summand1.getY()+summand2.getY());
	}

	public static Pos addModulo(Pos summand1, Pos summand2, int modX, int modY) {
		Pos posHelp = add(summand1,summand2);
		// a mod b = ( a % b + b) % b  Um zu prüfen, ob die Zahl größer als der Planet ist
		return new Pos((posHelp.getX() % modX + modX)%modX, (posHelp.getY() % modY + modY)%modY);
	}

	public static Pos subtrModulo(Pos minuend, Pos subtrahend, int modX, int modY) {
		Pos posHelp = new Pos(-subtrahend.getX(),-subtrahend.getY());
		return addModulo(minuend,posHelp,modX,modY);
	}
	
	public static Pos getNegative(Pos pos){
		return new Pos(-pos.getX(),-pos.getY());
	}

}
