package calculator.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Jacob Knox CST238 Lab2 4/16/2023

public class NumberButton extends JButton {

    protected String value;
    protected CalculatorScreen screen;
    public NumberButton(int label, CalculatorScreen screen) {
        super(Integer.toString(label));
        this.screen = screen;
        this.value = Integer.toString(label);
        addActionListener(new Action());
    }

    public NumberButton(char label, CalculatorScreen screen) {
        super(String.valueOf(label));
        this.screen = screen;
        this.value = String.valueOf(label);
        addActionListener(new Action());
    }

    protected class Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // add the digit to the screen
            screen.addDigit(value);
        }
    }
}
