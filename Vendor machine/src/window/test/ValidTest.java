package window.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import version9.WelcomeScreen;


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

		JLabel lblYourServiceIs = new JLabel();
		lblYourServiceIs.setForeground(Color.YELLOW);
		lblYourServiceIs.setFont(new Font("Consolas", Font.BOLD, 67));
		lblYourServiceIs.setBounds(162, 172, 1038, 79);
		contentPane.add(lblYourServiceIs);

		JLabel lblPleaseContactTo = new JLabel();
		lblPleaseContactTo.setForeground(new Color(255, 99, 71));
		lblPleaseContactTo.setFont(new Font("Consolas", Font.BOLD, 67));
		lblPleaseContactTo.setBounds(172, 261, 894, 79);
		contentPane.add(lblPleaseContactTo);
		
		JLabel lblIfAnyProblem = new JLabel("If any problem, contact to IT.");
		lblIfAnyProblem.setFont(new Font("Sylfaen", Font.ITALIC, 28));
		lblIfAnyProblem.setForeground(Color.RED);
		lblIfAnyProblem.setBounds(664, 341, 365, 38);
		contentPane.add(lblIfAnyProblem);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeScreen wl = new WelcomeScreen();
				dispose();
				wl.setVisible(true);
			}
		});
		btnBack.setToolTipText("Click me to scan ID card");
		btnBack.setFont(new Font("Trebuchet MS", Font.PLAIN, 44));
		btnBack.setBackground(new Color(152, 251, 152));
		btnBack.setBounds(889, 496, 162, 55);
		contentPane.add(btnBack);
		
		
	}
}
