package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenPM implements ActionListener {
	private Calculator main;

	 
	public ActionListenPM(int num, CalculatorFace face, Calculator main) {
		this.main = main;
	}
	
	public void actionPerformed(ActionEvent e) {
		main.PM();
	}

}
