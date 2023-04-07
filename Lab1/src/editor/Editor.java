package editor;

import java.awt.BorderLayout;

import javax.swing.*;

import editor.menu.MenuBar;

public class Editor {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Editor");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(true);
		
		frame.add(scrollPane);
		
		frame.add(BorderLayout.NORTH, new MenuBar());
		
		frame.setVisible(true);
	}

}
