package calc;



/**
 * SetUp
 * 
 * Class to set up and start the calculator, plus
 * facilities for test-driving the calculator.
 *
 * @author Thomas VanDrunen
 * CS 245, Wheaton College
 * June 27, 2014
*/
public class SetUp {

	/**
	 * Method for initializing the calculator internals and
	 * connecting them to the calculator face.
	 * @param face The component representing the user interface of 
	 * the calculator. 
	 */
	
	
	public static void setUpCalculator(CalculatorFace face) {
		Calculator main = new Calculator(face); 
		

		face.addPlusMinusActionListener(new ActionListenPM(-1, face, main));
		
		face.addActionListener('C', (ActionEvent) -> {
			main.clear();
		});
		face.addActionListener('=', (ActionEvent) -> {
			main.hitEqual();
		});
		face.addActionListener('.', (ActionEvent) -> {
			main.dot();
		});

		
		face.addActionListener('/', new Function(main) {
			public double implement(double n, double d) {
				return n/d;
			}
			
		});
		face.addActionListener('*', new Function(main) {
			public double implement(double n, double d) {
				return n*d;
			}

		});
		face.addActionListener('-', new Function(main) {
			public double implement(double n, double d) {
				return n-d;
			}
		});
		face.addActionListener('+', new Function(main) {
			public double implement(double n, double d) {
				return n+d;
			}
		});

		//initializes number action listeners
		for(int i = 0; i < 10; i++) {
			face.addNumberActionListener(i, new ActionListenNum(i, main));
		}
		main.clear();
	}

	

	/**
	 * This main method is for your testing of your calculator.
	 * It will *not* be used during grading. Any changes you make
	 * to this method will be ignored at grading.
	 */
	public static void main(String[] args) {
		setUpCalculator(new PlainCalculatorFace());
	}



}
