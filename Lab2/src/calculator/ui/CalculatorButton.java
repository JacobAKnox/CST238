package calculator.ui;

import javax.swing.*;

public class CalculatorButton extends JButton {
    protected String value;
    protected CalculatorScreen screen;
    public CalculatorButton(int label, CalculatorScreen screen) {
        super(Integer.toString(label));
        this.value = Integer.toString(label);
        this.screen = screen;
    }

    public CalculatorButton(char label, CalculatorScreen screen) {
        super(String.valueOf(label));
        this.value = String.valueOf(label);
        this.screen = screen;
    }
}
