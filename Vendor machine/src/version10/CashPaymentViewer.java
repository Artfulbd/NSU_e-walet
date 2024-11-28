package version10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class CashPaymentViewer extends JFrame {

	private JPanel contentPane;
	public CashPaymentViewer() {
		setTitle("NSU_e-Wallet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 725);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTranctionId = new JLabel("Please collect your receipt");
		lblTranctionId.setForeground(new Color(127, 255, 0));
		lblTranctionId.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
		lblTranctionId.setBounds(99, 255, 522, 47);
		contentPane.add(lblTranctionId);
		
		JTextArea txtRecp = new JTextArea();
		txtRecp.setToolTipText("This is your bill");
		txtRecp.setFont(new Font("Monospaced", Font.BOLD, 20));
		txtRecp.setBounds(784, 76, 343, 535);
		txtRecp.setText(Master.getReceipt());
		txtRecp.setEditable(false);
		contentPane.add(txtRecp);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeScreen frame = new WelcomeScreen();
				dispose();
				frame.setVisible(true);	
			}
		});
		btnHome.setToolTipText("Click me to scan ID card");
		btnHome.setFont(new Font("Times New Roman", Font.PLAIN, 44));
		btnHome.setBackground(new Color(255, 160, 122));
		btnHome.setBounds(276, 496, 162, 55);
		contentPane.add(btnHome);
		
		JLabel lblAndGotOt = new JLabel("and pay it to cash counter.");
		lblAndGotOt.setForeground(new Color(127, 255, 0));
		lblAndGotOt.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
		lblAndGotOt.setBounds(109, 301, 532, 47);
		contentPane.add(lblAndGotOt);
	}

}
