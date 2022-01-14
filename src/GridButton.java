import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class GridButton extends JButton {
	public int x = 0;
	public int y = 0;
	
	public GridButton(int x, int y) {
		super("");
		this.x = x;
		this.y = y;
		this.setBorder(new LineBorder(Color.DARK_GRAY));
		this.setBackground(Color.lightGray);
	}
}
