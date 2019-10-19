package com.paytm.labs.sde.challenge;

public interface IMovingAverage<T> {

	/**
	 * Fetch the moving average for the last n elements
	 * @param n last n elements
	 * @return moving average
	 */
    public Double getMovingAverage(int n);
    
    /**
     * Add an element to the data structure
     * @param t element to be added
     */
    public void addElement(T t);
    
    /**
     * Fetch the element from the data structure for a given index
     * @param t index location of the element to be fetched
     */
    public T getElement(int index);
    
    /**
     * Returns the size of the current data structure
     * @return size of the data structure
     */
    public int getSize();
}
