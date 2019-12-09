package version7;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeScreen extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen frame = new WelcomeScreen();
					frame.setVisible(true);	
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WelcomeScreen() {
		setTitle("NSU_e-Wallet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 725);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JLabel lblWelcomeToFull = new JLabel("Welcome");
		lblWelcomeToFull.setForeground(Color.ORANGE);
		lblWelcomeToFull.setFont(new Font("Brush Script MT", Font.PLAIN, 75));
		lblWelcomeToFull.setBounds(428, 83, 203, 93);
		contentPane.add(lblWelcomeToFull);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setForeground(new Color(255, 0, 51));
		lblTo.setFont(new Font("Script MT Bold", Font.PLAIN, 45));
		lblTo.setBounds(623, 157, 39, 55);
		contentPane.add(lblTo);
		
		JLabel lblFullofbugs = new JLabel("Full_of_BUgs");
		lblFullofbugs.setForeground(new Color(255, 0, 0));
		lblFullofbugs.setFont(new Font("CentSchbkCyrill BT", Font.BOLD, 70));
		lblFullofbugs.setBounds(397, 207, 478, 86);
		contentPane.add(lblFullofbugs);
		
		JLabel lblPleasePunchYour = new JLabel("Please press the scan button");
		lblPleasePunchYour.setForeground(new Color(255, 255, 0));
		lblPleasePunchYour.setFont(new Font("Consolas", Font.BOLD, 52));
		lblPleasePunchYour.setBounds(188, 422, 806, 62);
		contentPane.add(lblPleasePunchYour);
			
		JLabel lblAndPunchYour = new JLabel("and punch your ID card ");
		lblAndPunchYour.setForeground(Color.YELLOW);
		lblAndPunchYour.setFont(new Font("Consolas", Font.BOLD, 52));
		lblAndPunchYour.setBounds(187, 479, 662, 62);
		contentPane.add(lblAndPunchYour);
		
		
		JButton btnNewButton = new JButton("Scan");
		btnNewButton.setToolTipText("Click me to scan ID card");
		btnNewButton.setBackground(new Color(152, 251, 152));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 44));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Master us = new Master();
				us.start();
				dispose();
			}
		});
		btnNewButton.setBounds(940, 530, 162, 55);
		contentPane.add(btnNewButton);
		
		if(Master.isEr()) {
			JLabel lblScannerIsNot = new JLabel("Scanner is not connected");
			lblScannerIsNot.setForeground(Color.RED);
			lblScannerIsNot.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
			lblScannerIsNot.setBounds(455, 567, 278, 30);
			contentPane.add(lblScannerIsNot);
		}
			
	}
}
