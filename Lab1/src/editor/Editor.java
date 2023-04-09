package editor;

import java.awt.BorderLayout;

import javax.swing.*;

import editor.menu.MenuBar;

public class Editor {

	public static void main(String[] args) {
		// create the frame
		JFrame frame = new JFrame();
		frame.setTitle("Editor");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// make the text area and add it to the frame with a scroll pane so it can be
		// scrolled
		EditorTextArea textArea = new EditorTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(true);

		// add the scroll pane to the frame and the menu bar to the frame
		frame.add(scrollPane);

		// add the menu bar to the top of the frame
		frame.add(BorderLayout.NORTH, new MenuBar(textArea));

		// make the frame visible
		frame.setVisible(true);
	}

}
