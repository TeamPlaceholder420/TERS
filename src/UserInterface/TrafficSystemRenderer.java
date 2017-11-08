package UserInterface;

import java.awt.*;
import javax.swing.*;

public class TrafficSystemRenderer extends JComponent {
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		int w = getWidth();
		int h = getHeight();
		

		
		g2.drawString("Indevelopment", 10, 10);
	}
}
