package calculator.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberButton extends JButton {

    protected int value;
    protected CalculatorScreen screen;
    public NumberButton(int label, CalculatorScreen screen) {
        super(Integer.toString(label));
        this.value = label;
        this.screen = screen;
        addActionListener(new Action());
    }

    protected class Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            screen.addDigit(Integer.toString(value));
        }
    }
}
