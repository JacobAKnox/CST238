package calculator;

import calculator.ui.Layout;

import javax.swing.*;

public class CalculatorApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        // add the calculator layout to the frame
        frame.add(new Layout());

        frame.setVisible(true);
    }
}
