package window.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import version5.Master;
import version5.WelcomeScreen;

public class ValidTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ValidTest frame = new ValidTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private JPasswordField passwordField;
	private static JTextField txttrl;
	public ValidTest() {
		setTitle("NSU_e-Wallet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 725);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("ID: ");
		lblId.setForeground(Color.YELLOW);
		lblId.setFont(new Font("Consolas", Font.BOLD, 67));
		lblId.setBounds(140, 259, 147, 79);
		contentPane.add(lblId);

		JLabel lblPass = new JLabel("Pin:");
		lblPass.setForeground(Color.YELLOW);
		lblPass.setFont(new Font("Consolas", Font.BOLD, 67));
		lblPass.setBounds(216, 248, 147, 79);
		contentPane.add(lblPass);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter your 4 digit pin here");
		passwordField.setBackground(SystemColor.info);
		passwordField.setFont(new Font("Comic Sans MS", Font.BOLD, 67));
		passwordField.setBounds(387, 248, 277, 79);
		contentPane.add(passwordField);

		txttrl = new JTextField();
		txttrl.setForeground(new Color(255, 0, 0));
		txttrl.setBackground(new Color(0, 0, 51));
		txttrl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txttrl.setText("3 trials left");
		txttrl.setBounds(184, 344, 543, 28);
		contentPane.add(txttrl);
		txttrl.setColumns(10);

		JLabel lblInvalid = new JLabel();
		lblInvalid.setText("Invalid PIN");
		lblInvalid.setForeground(new Color(255, 69, 0));
		lblInvalid.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 55));
		lblInvalid.setBounds(353, 520, 311, 64);
		lblInvalid.setVisible(false);
		contentPane.add(lblInvalid);



		JButton button = new JButton("Place order");
		button.setToolTipText("Click here to place your order");
		button.setFont(new Font("Monotype Corsiva", Font.BOLD, 36));
		button.setBackground(Color.GREEN);
		button.setBounds(310, 417, 197, 65);
		contentPane.add(button);

		JButton btnCncl = new JButton("Cancel");
		btnCncl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeScreen wl = new WelcomeScreen();
				dispose();
				wl.setVisible(true);
			}
		});
		btnCncl.setToolTipText("Click here to cancel your order");
		btnCncl.setFont(new Font("Monotype Corsiva", Font.BOLD, 36));
		btnCncl.setBackground(new Color(255, 127, 80));
		btnCncl.setBounds(980, 601, 134, 49);
		contentPane.add(btnCncl);

		JTextArea txtRecp = new JTextArea();
		txtRecp.setToolTipText("This is your bill");
		txtRecp.setFont(new Font("Monospaced", Font.BOLD, 20));
		txtRecp.setBounds(860, 85, 343, 488);
		txtRecp.setText("");
		txtRecp.setEditable(false);
		contentPane.add(txtRecp);
		
		JLabel lblTranctionSuccessfullYou = new JLabel("Transaction successful");
		lblTranctionSuccessfullYou.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 55));
		lblTranctionSuccessfullYou.setForeground(Color.GREEN);
		lblTranctionSuccessfullYou.setBounds(140, 136, 645, 64);
		contentPane.add(lblTranctionSuccessfullYou);
	}

}
