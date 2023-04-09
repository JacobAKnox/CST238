package editor.menu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import editor.EditorTextArea;
import editor.listeners.FontListener;
import editor.listeners.StyleListener;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;

	public MenuBar(EditorTextArea area) {
		JMenu menu = new JMenu("File");
		JMenuItem item;
    item = new JMenuItem("Save");
    item.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        area.save();
      }
    });
		menu.add(item);
    item = new JMenuItem("Load");
    item.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        area.load();
      }
    });
		menu.add(item);
		item = new JMenuItem("Exit");
		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(item);
		add(menu);

		menu = new JMenu("Font");
		item = new JMenuItem("Mono");
		item.addActionListener(new FontListener(Font.MONOSPACED, area));
		menu.add(item);
		item = new JMenuItem("Serif");
		item.addActionListener(new FontListener(Font.SERIF, area));
		menu.add(item);
		item = new JMenuItem("Sans-Serif");
		item.addActionListener(new FontListener(Font.SANS_SERIF, area));
		menu.add(item);
		add(menu);

		menu = new JMenu("Style");
		item = new JMenuItem("Plain");
		item.addActionListener(new StyleListener(Font.PLAIN, area));
		menu.add(item);
		item = new JMenuItem("Italics");
		item.addActionListener(new StyleListener(Font.ITALIC, area));
		menu.add(item);
		item = new JMenuItem("Bold");
		item.addActionListener(new StyleListener(Font.BOLD, area));
		menu.add(item);
		add(menu);
	}
}
