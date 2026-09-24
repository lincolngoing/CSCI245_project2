//Made by Lincoln Going

//credit for decimal formatting https://stackoverflow.com/questions/14204905/how-to-remove-trailing-zeros-from-a-double
//credit for converting double to string https://www.digitalocean.com/community/tutorials/java-convert-double-to-string
package calc;

import java.text.DecimalFormat;

public class Calculator {

	private CalculatorFace face;

	// numbers the calculator needs to remember
	private double current = 0;
	private double saved = 0;
	// private Dot theDot = new Dot(1);

	// operator
	private Function operator = new DefaultFunc();
	private NumAdder numAdder = new NormalAdder();

	// PM, 1 for positive, -1 for negative
	private int PM = 1;
	// equalChanger is multiplied to current every time a number button is hit. It
	// is set to 0 when equal is hit to reset the calculator.
	private int equalChanger = 1;

	private String print = "";
	private DecimalFormat formatter = new DecimalFormat("0.######");

	public Calculator(CalculatorFace face) {
		this.face = face;

	}

	/**
	 * This implements the last function pressed and stores it in saved, then prints
	 * it Then it resets the equalchanger and PM updates operator to the new
	 * function pressed resets numAdder to normal resets current to zero
	 * 
	 * @param func is the new function pressed
	 */
	public void setFunction(Function func) {
		this.saved = operator.implement(saved, current);
		this.print = String.valueOf(this.saved);
		print();
		this.PM = 1;
		equalChanger = 1;
		this.operator = func;
		this.numAdder = new NormalAdder();
		this.current = 0;
	}

	/**
	 * this is called when the equal button is hit. 
	 * It resets the function to default function
	 * sets equal changer to zero ---- this will reset the calculator if a number is the next thing pressed
	 * then it sets current to saved and saved to 0 ----- this is because the default function puts current into saved
	 */
	public void hitEqual() {
		setFunction(new DefaultFunc());
		this.equalChanger = 0;
		this.current = this.saved;
		this.saved = 0;

	}

	
	/**
	 * getDotAdder returns the same instance in a DotAdder and returns a new DotAdder in a NormalAdder
	 */
	public void dot() {
		numAdder = numAdder.getDotAdder();
	}

	
	/**
	 * resets everything and prints a blank screen
	 */
	public void clear() {
		this.saved = 0;
		this.current = 0;
		this.operator = new DefaultFunc();
		this.numAdder = new NormalAdder();
		this.PM = 1;
		print = "";
		print();

	}

	/**
	 * current is multiplied by equalchanger --- this will reset it if equals is the last thing pressed (* by 1 if not)
	 * the new number is added using different strategies (NormalAddder or DotAdder)
	 * current is printed to the screen
	 * @param num is the button pressed
	 */
	public void num(double num) {
		this.current *= equalChanger;
		this.equalChanger = 1;
		this.current = numAdder.addNum(current, num, PM);
		this.print = this.formatter.format(this.current);
		print();
	}

	/**
	 * flips the sign of current and the PM variable
	 * prints current
	 */
	public void PM() {
		this.PM *= -1;
		this.current *= -1;
		this.print = String.valueOf(this.current);
		print();
	}

	/**
	 * IFS ALLOWED
	 * format the answer for the screen and prints
	 */
	public void print() {
		if (print.length() > 15) {
			print = print.substring(0, 15);
		} else {
			print = print.substring(0, print.length());
		}
		face.writeToScreen(print);
	}

}
