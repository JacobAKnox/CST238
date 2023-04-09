package editor.listeners;

import java.awt.event.ActionEvent;

//Jacob Knox CST238 Lab 1

import java.awt.event.ActionListener;

import editor.EditorTextArea;

public class FontListener implements ActionListener {

	protected String font;
	protected EditorTextArea area;

	public FontListener(String font, EditorTextArea area) {
		this.font = font;
		this.area = area;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// set the passed font family in the passed text area
		area.setFontFamily(font);
	}

}
