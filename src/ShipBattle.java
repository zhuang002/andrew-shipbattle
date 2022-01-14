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
import java.awt.event.ActionEvent;

public class ShipBattle {

	private JFrame frame;
	private JTextField textFieldHitStatus;

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
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelAction = new JPanel();
		frame.getContentPane().add(panelAction, BorderLayout.NORTH);
		
		BattleShipLogic battleShipLogic = BattleShipLogic.getInstance();
		
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTurn = new JLabel("Not Started");
		panel.add(lblTurn, BorderLayout.NORTH);
		
		textFieldHitStatus = new JTextField();
		panel.add(textFieldHitStatus, BorderLayout.CENTER);
		textFieldHitStatus.setColumns(10);
		
		JPanel panelBattleField = new JPanel();
		frame.getContentPane().add(panelBattleField, BorderLayout.CENTER);
		panelBattleField.setLayout(new GridLayout(10, 10, 0, 0));
		
		for (int x=0;x<10;x++) {
			for (int y=0;y<10;y++) {
				GridButton btn = new GridButton(x,y);
				panelBattleField.add(btn);
				
			}
		}
		
		
		JButton btnReset = new JButton("Reset");
		JButton btnToss = new JButton("Toss");
		JButton btnFire = new JButton("Fire");
		panelAction.add(btnReset);
		panelAction.add(btnToss);
		panelAction.add(btnFire);
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeShips();
				lblTurn.setText("Wait for Toss");
				btnToss.setEnabled(true);
				btnFire.setEnabled(false);
				displayStatus(null);
			}

			

			
		});
		
		
		
		btnToss.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnToss.setEnabled(false);
				int toss = battleShipLogic.toss();
				if (toss==0) {
					HitStatus hitStatus= battleShipLogic.computerPlay();
					displayStatus(hitStatus);
					btnFire.setEnabled(true);
				} else {
					
				}
			}
		});
		
		
		
		btnFire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	}
	
	private void displayStatus(HitStatus hitStatus) {
		// TODO Auto-generated method stub
		
	}
	
	private void placeShips() {
		// TODO Auto-generated method stub
		DlgPlaceShip dialog = new DlgPlaceShip();
		dialog.show(true);
	}

}
