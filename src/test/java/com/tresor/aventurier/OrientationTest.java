package com.tresor.aventurier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrientationTest {

	
	
	@Test
	public void getOrientation() {
		String orientationChar = "N";
		Orientation orientationExpected = Orientation.getOrientation(orientationChar);
		assertEquals(new Orientation(0,-1), orientationExpected);
		
		orientationChar = "S";
		orientationExpected = Orientation.getOrientation(orientationChar);
		assertEquals(new Orientation(0,1), orientationExpected);
		
		orientationChar = "O";
		orientationExpected = Orientation.getOrientation(orientationChar);
		assertEquals(new Orientation(-1,0), orientationExpected);
		
		orientationChar = "E";
		orientationExpected = Orientation.getOrientation(orientationChar);
		assertEquals(new Orientation(1,0), orientationExpected);
	}
}