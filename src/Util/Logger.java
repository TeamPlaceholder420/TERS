package Util;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class Logger {
	
	static Logger logger = new Logger();
	
	ArrayList<Log> logs = new ArrayList<>(); 
	
	static public void log(Color c, String msg) {
		logger.logs.add(new Log(c, msg));
	}
	
	

	public static void addToTextPane(JTextPane logTextPane) {
		logTextPane.setText("");
		for(Log l : logger.logs) {
			StyleContext sc = StyleContext.getDefaultStyleContext();
	        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, l.color);
	
	        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
	        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
	
	        int len = logTextPane.getDocument().getLength();
	        logTextPane.setCaretPosition(len);
	        logTextPane.setCharacterAttributes(aset, false);
	        logTextPane.replaceSelection(l.text + "\n");
		}
		
	}
	
	public static void clear() {
		logger.logs.clear();
	}
}

class Log {
	public Color color;
	public String text;
	
	public Log(Color c, String msg) {
		if(c==null)
			color = Color.BLACK;
		else
			color = c;
		
		text = msg;
	}
}