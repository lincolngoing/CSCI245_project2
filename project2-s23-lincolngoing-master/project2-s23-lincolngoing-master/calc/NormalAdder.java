package calc;

public class NormalAdder implements NumAdder {


	/**
	 * Adds the new number in the correct place holder and changing it based upon the sign
	 */
	public double addNum(double current, double toAdd, double PM) {
		current *= 10;
		current += (toAdd * PM);
		return current;
	}

	/**
	 * returns a new DotAdder to be stored in the calculator if the dot button is pressed
	 */
	public NumAdder getDotAdder() {
		return new DotAdder();
	}

}
