package calc;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;

public class ActionListenNum implements ActionListener {

	private double num;
	private Calculator main;
	 
	public ActionListenNum(int num,  Calculator main) {
		this.num = num;
		this.main = main;
	}
	
	//this.num stores the initialized number for each action listener i.e. '0'
	public void actionPerformed(ActionEvent e) {

		main.num(this.num);
	}

}
