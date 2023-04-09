package editor.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import editor.EditorTextArea;

//Jacob Knox CST238 Lab 1

public class StyleListener implements ActionListener {

	protected int style;
	protected EditorTextArea area;

	public StyleListener(int style, EditorTextArea area) {
		this.style = style;
		this.area = area;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// set the passed style in the passed text area
		area.setStyle(style);
	}

}
