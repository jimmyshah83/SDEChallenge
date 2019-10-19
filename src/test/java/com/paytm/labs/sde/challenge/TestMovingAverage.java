package com.paytm.labs.sde.challenge;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestMovingAverage {
	
	private IMovingAverage<Integer> movingAverage;
	
	@Before
	public void init() {
		movingAverage = new MovingAverageImpl(3);
	}

	@Test
	public void testAddElement() {
		movingAverage.addElement(1);
		movingAverage.addElement(2);
		movingAverage.addElement(3);
		Assert.assertEquals(movingAverage.getSize(), 3);
		movingAverage.addElement(4);
		movingAverage.addElement(5);
		movingAverage.addElement(6);
		Assert.assertEquals(movingAverage.getSize(), 6);
		movingAverage.addElement(7);
		Assert.assertEquals(movingAverage.getSize(), 7);
	}
	
	@Test
	public void testGetMovingAverage() {
		movingAverage.addElement(1);
		movingAverage.addElement(2);
		movingAverage.addElement(3);
		Assert.assertEquals(movingAverage.getMovingAverage(5), 2.0d);
		movingAverage.addElement(4);
		movingAverage.addElement(5);
		movingAverage.addElement(6);
		Assert.assertEquals(movingAverage.getMovingAverage(5), 4.0d);
	}
}
