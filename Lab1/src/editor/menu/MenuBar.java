package editor.menu;

import javax.swing.*;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;

	public MenuBar() {
		JMenu file = new JMenu("File");
		file.add(new JMenuItem("Save"));
		file.add(new JMenuItem("Load"));
		file.add(new JMenuItem("Exit"));
		
		add(file);
	}
}
