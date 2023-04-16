package calculator.ui;

import calculator.Calculator;

import java.awt.*;

// Jacob Knox CST238 Lab2 4/16/2023

public class Layout extends javax.swing.JPanel {

    protected CalculatorScreen screen;
    protected NumberButton[] numberButtons;
    protected NumberButton zeroButton;
    protected NumberButton decimalButton;

    protected FunctionButton[] functionButtons;

    protected Calculator calculator;

    // array of x and y coordinates for the buttons
    static int[] x = {0, 1, 2, 0, 1, 2, 0, 1, 2};
    static int[] y = {2, 2, 2, 1, 1, 1, 0, 0, 0};
    public Layout() {
        this.screen = new CalculatorScreen(20);

        this.calculator = new Calculator(screen);

        this.numberButtons = new NumberButton[10]; // 1-9
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new NumberButton(i, screen);
        }

        this.zeroButton = numberButtons[0]; // zero needs to be handled differently
        this.decimalButton = new NumberButton('.', screen);

        this.functionButtons = new FunctionButton[7]; // function buttons are in order along the top then down the right
        functionButtons[0] = new FunctionButton('C', calculator);
        functionButtons[1] = new FunctionButton('±', calculator);
        functionButtons[2] = new FunctionButton('/', calculator);
        functionButtons[3] = new FunctionButton('*', calculator);
        functionButtons[4] = new FunctionButton('-', calculator);
        functionButtons[5] = new FunctionButton('+', calculator);
        functionButtons[6] = new FunctionButton('=', calculator);

        // set the layout
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        GridBagConstraints constraints = new GridBagConstraints();

        // screen is at the top across the whole width, does not expand or shrink vertically
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(screen, constraints);

        // prepare constraints for the function buttons
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridwidth = 1;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.BOTH;

        // top row function buttons, C, ±, /, *
        for (int i = 0; i <= 3; i++) {
            constraints.gridx = i;
            add(functionButtons[i], constraints);
        }

        //plus and minus buttons
        constraints.gridx = 3;
        constraints.gridy = 2;
        add(functionButtons[4], constraints);

        constraints.gridy = 3;
        add(functionButtons[5], constraints);

        // equals button
        constraints.gridy = 4;
        constraints.gridheight = 2;
        add(functionButtons[6], constraints);
        constraints.gridheight = 1;

        // prepare constraints for the number buttons
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;

        // put 9 in the top right corner 1 in the bottom left corner
        for (int i = 1; i < 10; i++) {
            constraints.gridx = x[i - 1];
            constraints.gridy = y[i - 1] + 2;
            add(numberButtons[i], constraints);
        }

        // add 0 and . buttons
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        add(zeroButton, constraints);
        constraints.gridwidth = 1;

        constraints.gridx = 2;
        constraints.gridy = 5;
        add(decimalButton, constraints);
    }

}
