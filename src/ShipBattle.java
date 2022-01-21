import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

public class ShipBattle implements BattleShipController {

	private JFrame frame;
	BattleField myField;
	BattleField rivalField;
	GuiState state = GuiState.setting;
	JButton btnReset = null;
	JButton btnToss = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipBattle window = new ShipBattle();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShipBattle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		frame.setBounds(100, 100, 900, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelAction = new JPanel();
		frame.getContentPane().add(panelAction, BorderLayout.NORTH);
		
		BattleShipLogic battleShipLogic = BattleShipLogic.getInstance(this);
		
		JPanel panelBattleField = new JPanel();
		panelBattleField.setBorder(new EmptyBorder(20, 40, 40, 40));
		frame.getContentPane().add(panelBattleField, BorderLayout.CENTER);
		panelBattleField.setLayout(new GridLayout(0, 2, 20, 20));
		
		myField = new BattleField();
		myField.setEnabled(false);
		rivalField = new BattleField();
		rivalField.setEnabled(false);
		panelBattleField.add(myField);
		panelBattleField.add(rivalField);
		
		
		
		
		btnReset = new JButton("Reset");
		btnToss = new JButton("Toss");
		panelAction.add(btnReset);
		panelAction.add(btnToss);
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BattleShipLogic backend = BattleShipLogic.getInstance();
				backend.reset();
				placeShips();
				try {
					backend.placeRivalShips();

				} catch (InvalidShipPlacementException expt) {
					JOptionPane.showMessageDialog(frame, "Stupid AI!");
				}
			}
			
		});
		
		
		
		btnToss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnToss.setEnabled(false);
				battleShipLogic.toss(); 
				setState(GuiState.play);
			}
		});
		
		setState(GuiState.setting);
	}
	
	
	private void placeShips() {
		// TODO Auto-generated method stub
		DlgPlaceShip dialog = new DlgPlaceShip();
		dialog.show(true);
		
	}


	public void setState(GuiState state) {
		// TODO Auto-generated method stub
		if (state == GuiState.setting) {
			btnReset.setEnabled(true);
			btnToss.setEnabled(false);
			rivalField.setEnabled(false);
		} else if (state == GuiState.toss) {
			btnReset.setEnabled(false);
			btnToss.setEnabled(true);
			rivalField.setEnabled(false);
		} else if (state == GuiState.finish) {
			btnReset.setEnabled(true);
			btnToss.setEnabled(false);
			rivalField.setEnabled(false);
		} else if (state == GuiState.play) {
			btnReset.setEnabled(false);
			btnToss.setEnabled(false);
			rivalField.setEnabled(true);
		}
	}


	@Override
	public void updateMyField(GridStatus[][] gridData) {
		// TODO Auto-generated method stub
		myField.displayGrid(gridData, true);
	}

	@Override
	public void updateRivalField(GridStatus[][] gridData) {
		// TODO Auto-generated method stub
		rivalField.displayGrid(gridData, false);
	}

	@Override
	public void gameFinished(int who) {
		// TODO Auto-generated method stub
		if (who == 0) {
			JOptionPane.showMessageDialog(frame, "You Win!");
		} else {
			JOptionPane.showMessageDialog(frame, "I Win!");
		}
		this.setState(GuiState.finish);
	}

}
