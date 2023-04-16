package calculator.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberButton extends CalculatorButton {
    public NumberButton(int label, CalculatorScreen screen) {
        super(label, screen);
        addActionListener(new Action());
    }

    public NumberButton(char label, CalculatorScreen screen) {
        super(label, screen);
        addActionListener(new Action());
    }

    protected class Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            screen.addDigit(value);
        }
    }
}
