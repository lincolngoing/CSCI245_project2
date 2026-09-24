package calc;

public class DefaultFunc extends Function {

	
	protected DefaultFunc() {
		super(null);
		
	}
	
	/**
	 * this returns current to be stored in save
	 */
	protected double implement(double saved, double current) {
		return current;
	}
	
	
}
