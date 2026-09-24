package calc;

public class DotAdder implements NumAdder {

	//stores the depth of the decimal for each instance
	private int dotNum = 1;
	
	
	/**
	 * This method adds a number onto the decimal chain. 
	 * adds the number numerically by using PM to determine if it is positive or negative and puts it in the correct slot by dividing by 10^dotNum
	 */
	public double addNum(double current, double toAdd, double PM) {
		
		current += ((toAdd*PM) / Math.pow(10, dotNum)); 
		this.dotNum++;
		return current;
	}
	
	/**
	 * Returns the same instance if a dot is accidentally pressed twice
	 */
	public NumAdder getDotAdder() {
		return this;
	}

}
