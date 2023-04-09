package editor.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import editor.EditorTextArea;

public class StyleListener implements ActionListener {
	
	protected int style;
	protected EditorTextArea area;
	
	public StyleListener(int style, EditorTextArea area) {
		this.style = style;
		this.area = area;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		area.setStyle(style);
	}

}
