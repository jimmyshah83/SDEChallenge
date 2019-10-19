package com.paytm.labs.sde.challenge;

import java.util.Arrays;
import java.util.Optional;

/**
 * Moving average data structure using an array with the size defined by constructor.
 * If the capacity exceeds the given size, a new array is created with the size doubled from the original size
 */
public class MovingAverageImpl implements IMovingAverage<Integer> {
	
	private int[] elements;
	private int endIndex = 0;
	private int totalSum = 0;
	private double movingAverage = 0;
	
	public MovingAverageImpl(int size) {
		this.elements = new int[size];
	}

	/**
	 * Fetch the moving average for the last n elements <br /> If n is greater than the data structure size, we return the moving average of the entire data structure
	 * @param n last n elements
	 * @return moving average
	 */
	@Override
	public Double getMovingAverage(int n) {
		if (n > endIndex-1) 
			return movingAverage;
		double sum = 0;
		int elementCount = 0;
		for (int i = endIndex-1; i >= endIndex-n; i--) {
			sum+=elements[i];
			elementCount++;
		}
		return sum/elementCount;
	}

	/**
     * Add an element to the data structure
     * @param t element to be added
     */
	@Override
	public void addElement(Integer t) {
		if (endIndex > elements.length-1) {
			int newSize = (elements.length)*2;
			elements =  Arrays.copyOf(elements, newSize);
		}
		totalSum+=t;
		elements[endIndex++] = t;
		movingAverage=totalSum/endIndex;
	}

	/**
     * Fetch the element from the data structure for a given index
     * @param t index location of the element to be fetched
     */
	@Override
	public Integer getElement(int index) {
		return Optional.ofNullable(elements[index]).orElse(0);
	}

	/**
     * Returns the size of the current data structure
     * @return size of the data structure
     */
	@Override
	public int getSize() {
		return endIndex;
	}

}
