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

public class PaymentStatusViewer extends JFrame {

	private JPanel contentPane;

	
	public PaymentStatusViewer(PurchaseController pc) {
		setTitle("NSU_e-Wallet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 725);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTranctionSuccessfullYou = new JLabel("Transaction successful");
		lblTranctionSuccessfullYou.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 55));
		lblTranctionSuccessfullYou.setForeground(Color.GREEN);
		lblTranctionSuccessfullYou.setBounds(140, 136, 645, 64);
		contentPane.add(lblTranctionSuccessfullYou);

		JLabel lblYouCanCheck = new JLabel("You can check your tranction history");
		lblYouCanCheck.setForeground(Color.ORANGE);
		lblYouCanCheck.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblYouCanCheck.setBounds(62, 332, 579, 40);
		contentPane.add(lblYouCanCheck);
		
		
		JLabel lblAsdfcdvlkflndlfkn = new JLabel(pc.getTrancID());
		lblAsdfcdvlkflndlfkn.setForeground(Color.RED);
		lblAsdfcdvlkflndlfkn.setFont(new Font("Courier New", Font.BOLD, 40));
		lblAsdfcdvlkflndlfkn.setBounds(437, 45, 408, 46);
		contentPane.add(lblAsdfcdvlkflndlfkn);

		JLabel lblTranctionId = new JLabel("Tranction ID:");
		lblTranctionId.setForeground(new Color(127, 255, 0));
		lblTranctionId.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
		lblTranctionId.setBounds(173, 41, 254, 47);
		contentPane.add(lblTranctionId);

		JTextArea txtRecp = new JTextArea();
		txtRecp.setToolTipText("This is your bill");
		txtRecp.setFont(new Font("Monospaced", Font.BOLD, 20));
		txtRecp.setBounds(872, 102, 343, 535);
		txtRecp.setText(Master.getReceiptWithTrId(pc.getTrancID()));
		txtRecp.setEditable(false);
		contentPane.add(txtRecp);

		JLabel lblOnYourRds = new JLabel("on your RDS account.");
		lblOnYourRds.setForeground(Color.ORANGE);
		lblOnYourRds.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblOnYourRds.setBounds(62, 382, 394, 40);
		contentPane.add(lblOnYourRds);
		if(pc.getApires().equals("manual")) {
			lblYouCanCheck.setText("on your RDS account soon.");
		}


		JLabel lblPleaseCollectYour = new JLabel("Please collect your receipt.");
		lblPleaseCollectYour.setForeground(new Color(240, 128, 128));
		lblPleaseCollectYour.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
		lblPleaseCollectYour.setBounds(70, 432, 551, 47);
		contentPane.add(lblPleaseCollectYour);

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
		btnHome.setBounds(459, 564, 162, 55);
		contentPane.add(btnHome);
	}

}
