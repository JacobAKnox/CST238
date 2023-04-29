import javax.swing.*;
import java.awt.*;

public class Tab2 extends JPanel {

    Tab2() {
        super();

        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;

        add(new JLabel("Tab 2"), c);

        c.gridwidth = 1;

        JCheckBox[] checkBoxes = new JCheckBox[3];
        checkBoxes[0] = new JCheckBox("Check Box 1");
        checkBoxes[1] = new JCheckBox("Check Box 2");
        checkBoxes[2] = new JCheckBox("Check Box 3");

        int i = 0;
        c.gridy = 1;
        for (JCheckBox checkBox : checkBoxes) {
            c.gridx = i++;
            add(checkBox, c);
        }
    }
}
