package editor.listeners;

import java.awt.event.ActionEvent;
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
		area.setFontFamily(font);
	}

}
