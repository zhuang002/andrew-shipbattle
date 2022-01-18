import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		GridButton btn = this;
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BattleShipLogic.getInstance().fire(btn.x,btn.y);
			}
		});
	}

	public void setStatus(GridStatus gridStatus) {
		// TODO Auto-generated method stub
	
		if (gridStatus == GridStatus.PartOfShip) {
			this.setBackground(Color.green);
		} else if (gridStatus == GridStatus.Hit) {
			this.setBackground(Color.orange);
		} else if (gridStatus == GridStatus.Sunk) {
			this.setBackground(Color.red);
		} else if (gridStatus == GridStatus.Miss) {
			this.setBackground(Color.white);
		} else {
			this.setBackground(Color.lightGray);
		}
	}
}
