package editor;

import javax.swing.JFileChooser;
import javax.swing.JTextArea;

import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EditorTextArea extends JTextArea {

	private static final long serialVersionUID = 1L;

	protected int style = Font.PLAIN;
	protected String fontFamily = Font.SANS_SERIF;

	public EditorTextArea() {
		// make the text area editable
		setEditable(true);
		// set the font to the default font style and family
		style = this.getFont().getStyle();
		fontFamily = this.getFont().getFontName();
	}

	public void setStyle(int style) {
		// make sure the style is valid
		if (style != Font.PLAIN && style != Font.BOLD && style != Font.ITALIC)
			throw new IllegalArgumentException("Invalid style");

		// set the style and update the font
		this.style = style;
		this.setFont(new Font(fontFamily, style, this.getFont().getSize()));
	}

	public void setFontFamily(String family) {
		// make sure the font family is valid
		if (family != Font.SANS_SERIF && family != Font.SERIF && family != Font.MONOSPACED)
			throw new IllegalArgumentException("Invalid font family");

		// set the font family and update the font
		this.fontFamily = family;
		this.setFont(new Font(fontFamily, style, this.getFont().getSize()));
	}

	public void save() {
		// create a file chooser and open it
		JFileChooser jfc = new JFileChooser();
		int returnValue = jfc.showSaveDialog(this);

		// if the user didn't select a file, return
		if (returnValue != JFileChooser.APPROVE_OPTION) {
			return;
		}

		if (jfc.getSelectedFile() == null) {
			return;
		}

		// write the text to the file
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
		// create a file chooser and open it
		JFileChooser jfc = new JFileChooser();
		int returnValue = jfc.showOpenDialog(this);

		// if the user didn't select a file, return
		if (returnValue != JFileChooser.APPROVE_OPTION) {
			return;
		}

		if (jfc.getSelectedFile() == null) {
			return;
		}

		// read the file into the text area
		String path = jfc.getSelectedFile().getAbsolutePath();
		try {
			this.setText(new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(path))));
		} catch (IOException e) {
			System.out.println(String.format("Failed to open file: %s", path));
			return;
		}

	}

}
