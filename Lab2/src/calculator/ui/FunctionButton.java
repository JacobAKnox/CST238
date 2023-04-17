package calculator.ui;

import calculator.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Jacob Knox CST238 Lab2 4/16/2023

public class FunctionButton extends JButton {

    private static final long serialVersionUID = 1L;
	protected Calculator calculator;
    protected String value;

    public FunctionButton(char label, Calculator calculator) {
        super(String.valueOf(label));
        this.value = String.valueOf(label);
        addActionListener(new Action());
        this.calculator = calculator;
    }

    protected class Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // perform the operation on the calculator
            calculator.performOperation(value);
        }
    }
}
