package de.rmkata.test;

import org.junit.Assert;

import org.junit.Test;

import de.rmkata.code.Pos;

public class TestPos {
	
	@Test
	public void testEquals() {
		Pos pos1 = new Pos(10,10);
		Pos pos2 = new Pos(10,10);
		Assert.assertEquals(pos1, pos2);
	}
	
	@Test
	public void testAdd(){
		Pos summand1 = new Pos(2,-1);
		Pos summand2 = new Pos(-3,2);
		Pos summe = Pos.add(summand1,summand2);
		Assert.assertEquals(new Pos(-1,1), summe);
	}
	
	@Test
	public void testAddModulo(){
		Pos summand1 = new Pos(2,1);
		Pos summand2 = new Pos(-3,11);
		Pos summeModulo = Pos.addModulo(summand1,summand2,8,10);
		Assert.assertEquals(new Pos(7,2), summeModulo);
	}
	
	@Test
	public void testSubtrModulo(){
		Pos minuend = new Pos(2,1);
		Pos subtrahend = new Pos(3,-11);
		Pos diffModulo = Pos.subtrModulo(minuend,subtrahend,8,10);
		Assert.assertEquals(new Pos(7,2), diffModulo);
	}
	
	

}
