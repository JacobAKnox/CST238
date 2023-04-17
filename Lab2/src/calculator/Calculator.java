package calculator;

import calculator.ui.CalculatorScreen;

import java.util.ArrayList;
import java.util.Arrays;

// Jacob Knox CST238 Lab2 4/16/2023

// class that handles the functionality of the calculator
public class Calculator {

    protected double storedValue;
    protected String storedOperator;
    protected CalculatorScreen screen;

    final protected ArrayList<String> validOperators = new ArrayList<String>(Arrays.asList("+", "-", "*", "/", "C", "=", "±"));
    final static protected ArrayList<String> singleOperators = new ArrayList<String>(Arrays.asList("C", "=", "±"));

    public Calculator(CalculatorScreen screen) {
        storedValue = 0;
        storedOperator = "";
        this.screen = screen;
    }

    public void performOperation(String operator) {
        if (operator.equals("")) {
            // = will call this with a blank operator if there is no stored operator
            // this is to prevent an error from being thrown
            return;
        }
        if (!validOperators.contains(operator)) {
            // if the operator is not valid, throw an error
            throw new IllegalArgumentException("Invalid operator");
        }

        // if it is not an operator that can be used on its own, store the operator, reset the screen, and return
        // allows you to put a number in and then use an operator on it then but the second number in
        if (storedOperator.equals("") && !singleOperators.contains(operator)) {
            storedValue = screen.getValue();
            storedOperator = operator;
            screen.setReset();
            return;
        }

        // if it is not an operator that can be used on its own, execute the stored operator and then store the new one
        // this allows you to chain operations together
        if (!singleOperators.contains(operator)) {
            String tempOperator = storedOperator;
            storedOperator = operator;
            operator = tempOperator;
        }

        // do nothing if you hit operators in a row
        if (screen.getReset()) {
            return;
        }

        // perform the operation
        double currentValue = screen.getValue();
        double result = 0;

        switch (operator) {
            case "+" -> result = storedValue + currentValue;
            case "-" -> result = storedValue - currentValue;
            case "*" -> result = storedValue * currentValue;
            case "/" -> result = storedValue / currentValue;
            case "C" -> storedOperator = ""; // clear the stored operator, result will be 0, screen will be reset
            case "±" -> {screen.setValue(-currentValue); return;} // negate the current value and return
            case "=" -> {performOperation(storedOperator); storedOperator=""; return;} // perform the stored operation and return
        }

        screen.setValue(result); // set the screen to the result
        screen.setReset(); // reset the screen for the next number
        storedValue = result; // set the stored value to the result for the next operation
    }
}
