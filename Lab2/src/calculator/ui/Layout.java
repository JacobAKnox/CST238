package calculator.ui;

import java.awt.*;

public class Layout extends javax.swing.JPanel {

    protected CalculatorScreen screen;
    protected NumberButton[] numberButtons;

    static int[] x = {0, 1, 2, 0, 1, 2, 0, 1, 2};
    static int[] y = {2, 2, 2, 1, 1, 1, 0, 0, 0};
    public Layout() {
        Dimension maxScreenSize = new Dimension(1000, 1000);
        this.screen = new CalculatorScreen(20);

        this.numberButtons = new NumberButton[10]; // 0-9
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new NumberButton(i, screen);
        }

        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(screen, constraints);

        // prepare constraints for the number buttons
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;

        // put 9 in the top right corner 1 in the bottom left corner
        for (int i = 1; i < 10; i++) {
            constraints.gridx = x[i - 1];
            constraints.gridy = y[i - 1] + 1;
            add(numberButtons[i], constraints);
        }
    }

}
