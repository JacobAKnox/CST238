package editor;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EditorTextArea extends JTextArea {

	private static final long serialVersionUID = 1L;

	protected int style = Font.PLAIN;
	protected String fontFamily = Font.SANS_SERIF;

	public EditorTextArea() {
		setEditable(true);
		style = this.getFont().getStyle();
		fontFamily = this.getFont().getFontName();
	}

	public void setStyle(int style) {
		if (style != Font.PLAIN && style != Font.BOLD && style != Font.ITALIC)
			throw new IllegalArgumentException("Invalid style");

		this.style = style;
		this.setFont(new Font(fontFamily, style, this.getFont().getSize()));
	}

	public void setFontFamily(String family) {
		if (family != Font.SANS_SERIF && family != Font.SERIF && family != Font.MONOSPACED)
			throw new IllegalArgumentException("Invalid font family");
		this.fontFamily = family;
		this.setFont(new Font(fontFamily, style, this.getFont().getSize()));
	}

	public void save() {
		JFileChooser jfc = new JFileChooser();
		int returnValue = jfc.showSaveDialog(this);

		if (returnValue != JFileChooser.APPROVE_OPTION) {
			return;
		}

		if (jfc.getSelectedFile() == null) {
			return;
		}

		String path = jfc.getSelectedFile().getAbsolutePath();
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			writer.write(this.getText());
			writer.close();
		} catch (IOException e) {
			System.out.println(String.format("Failed to open file: %s", path));
			return;
		}
	}

	public void load() {
		JFileChooser jfc = new JFileChooser();
		int returnValue = jfc.showOpenDialog(this);

		if (returnValue != JFileChooser.APPROVE_OPTION) {
			return;
		}

		if (jfc.getSelectedFile() == null) {
			return;
		}

	}

}
