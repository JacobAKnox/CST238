import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Jacob Knox Midterm Challenge");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(500, 500);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Tab 1", new Tab1());
        tabbedPane.addTab("Tab 2", new Tab2());

        frame.add(tabbedPane);

        frame.setVisible(true);
    }
}