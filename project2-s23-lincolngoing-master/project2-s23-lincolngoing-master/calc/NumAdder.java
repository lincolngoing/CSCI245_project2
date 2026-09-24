package calc;

public interface NumAdder {

	/**
	 * Adds a new number to current properly
	 * @param current
	 * @param toAdd
	 * @param PM
	 * @return
	 */
	public double addNum(double current, double toAdd, double PM);
	
	
	/**
	 * 
	 * @return Returns the existing DotAdder, or a new one
	 */
	public NumAdder getDotAdder();
}
