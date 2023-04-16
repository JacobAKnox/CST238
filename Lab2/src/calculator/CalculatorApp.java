package calculator;

import calculator.ui.Layout;

import javax.swing.*;


// Jacob Knox CST238 Lab2 4/16/2023

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
