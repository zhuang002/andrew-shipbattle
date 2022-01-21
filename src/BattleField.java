import javax.swing.JPanel;
import java.awt.GridLayout;

public class BattleField extends JPanel {

	/**
	 * Create the panel.
	 */
	GridButton[][] buttons = new GridButton[10][10];
	public BattleField() {
		setLayout(new GridLayout(10, 10, 5, 5));
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				GridButton btn = new GridButton(i,j);
				buttons[i][j] = btn;
				this.add(btn);
			}
		}
	}
	public void displayGrid(GridStatus[][] gridData, boolean displayShip) {
		// TODO Auto-generated method stub
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				GridButton btn = buttons[i][j];
				if (displayShip || gridData[i][j] != GridStatus.PartOfShip)
					btn.setStatus(gridData[i][j]);
				else
					btn.setStatus(GridStatus.Default);
			}
		}
	}
	
	@Override
	public void setEnabled(boolean enable) {
		super.setEnabled(enable);
		
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				buttons[i][j].setEnabled(enable);
			}
		}
	}

}
