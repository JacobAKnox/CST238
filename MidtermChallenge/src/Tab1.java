import javax.swing.*;
import java.awt.*;

public class Tab1 extends JPanel {

    Tab1() {
        super();

        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        add(new JLabel("Tab 1"), c);
        c.gridwidth = 1;

        JRadioButton[] radioButtons = new JRadioButton[3];
        radioButtons[0] = new JRadioButton("Radio Button 1");
        radioButtons[1] = new JRadioButton("Radio Button 2");
        radioButtons[2] = new JRadioButton("Radio Button 3");

        ButtonGroup buttonGroup = new ButtonGroup();
        int i = 0;
        c.gridy = 1;
        for (JRadioButton radioButton : radioButtons) {
            c.gridx = i++;
            buttonGroup.add(radioButton);
            add(radioButton, c);
        }

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        c.gridheight = 3;
        c.fill = GridBagConstraints.BOTH;
        add(new JTextArea("Text Area 1"), c);
    }

}
