package calc;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Function implements ActionListener {
	protected Calculator main;
	 
	
	protected Function(Calculator main) {
		this.main = main;
	}
	
	
	/**
	 * 
	 * @param saved 
	 * @param current
	 * @return  the operator will return the correct implementation to be stored in saved
	 */
	protected abstract double implement(double saved, double current);

	/**
	 * All actionListeners call the same function in the brain
	 */
	public void actionPerformed(ActionEvent e) {
		main.setFunction(this);
	
	}


}
