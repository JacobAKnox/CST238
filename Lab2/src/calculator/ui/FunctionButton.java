package calculator.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunctionButton extends CalculatorButton {

    public FunctionButton(char label, CalculatorScreen screen) {
        super(label, screen);
        addActionListener(new Action());
    }

    protected class Action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //temp for testing, to be hooked up to the calculation class
            System.out.println("Function " + value + " pressed" );
        }
    }
}
