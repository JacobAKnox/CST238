package editor;

import javax.swing.JTextArea;

import java.awt.Font;

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

}
