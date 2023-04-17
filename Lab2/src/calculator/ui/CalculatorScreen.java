package calculator.ui;

import javax.swing.JTextField;
import java.awt.*;

// Jacob Knox CST238 Lab2 4/16/2023

public class CalculatorScreen extends JTextField {

    protected boolean resetOnPress = false;
    protected boolean decimal = false;

    public CalculatorScreen(int width) {
        super(width);
        setFont(new Font(Font.MONOSPACED, Font.PLAIN, 24));
        setHorizontalAlignment(JTextField.RIGHT);
        setEditable(false);
        setText("0");
    }

    public void addDigit(String digit) {
        String text;

        // if the screen is reset, clear the screen to 0
        if (resetOnPress) {
            text = "0";
            decimal = false; // reset decimal flag
        } else {
            text = getText();
        }

        if (digit.equals(".") && decimal) // can only have one decimal
            return;
        else if (digit.equals("."))
            decimal = true;

        // remove leading 0 if digit is not a decimal
        if (text.equals("0") && !digit.equals("."))
            text = "";

        resetOnPress = false;

        setText(text + digit);
    }

    public double getValue() {
        try {
            return Double.parseDouble(getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void setValue(double value) {
        setText(Double.toString(value));
    }

    public void setReset() {
        resetOnPress = true;
    }

    public boolean getReset() {
        return resetOnPress;
    }
}
