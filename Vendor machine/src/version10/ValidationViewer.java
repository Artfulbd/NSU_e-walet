package version10;

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

public class ValidationViewer extends JFrame {

	private JPanel contentPane;

	private static final String msg = " If you forgot your PIN, reset it from your RDS and try again later", al = "trials left";
	private static JTextField txttrl;
	private int passCount = 2;
	public ValidationViewer() {
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
		lblId.setBounds(216, 147, 147, 79);
		contentPane.add(lblId);

		JLabel lblID = new JLabel(Master.getId());
		lblID.setForeground(Color.ORANGE);
		lblID.setFont(new Font("Comic Sans MS", Font.BOLD, 67));
		lblID.setBounds(373, 137, 434, 79);
		contentPane.add(lblID);

		JLabel lblPass = new JLabel("Pin:");
		lblPass.setForeground(Color.YELLOW);
		lblPass.setFont(new Font("Consolas", Font.BOLD, 67));
		lblPass.setBounds(216, 248, 147, 79);
		contentPane.add(lblPass);

		JPasswordField passwordField = new JPasswordField();
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
		lblInvalid.setText("");
		lblInvalid.setForeground(new Color(255, 69, 0));
		lblInvalid.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 55));
		lblInvalid.setBounds(257, 511, 528, 64);
		lblInvalid.setVisible(false);
		contentPane.add(lblInvalid);

		JTextField txtprb = new JTextField();
		txtprb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CashPaymentViewer cv = new CashPaymentViewer();
				dispose();
				cv.setVisible(true);
			}
		});
		txtprb.setText("Connection problem, please try cash payment, Click here");
		txtprb.setForeground(Color.RED);
		txtprb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtprb.setColumns(10);
		txtprb.setBackground(new Color(0, 0, 51));
		txtprb.setBounds(257, 594, 519, 28);
		txtprb.setVisible(false);
		txtprb.setToolTipText("Click here to pay in cash.");
		contentPane.add(txtprb);


		JButton button = new JButton("Place order");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseController pc = new PurchaseController(new String(passwordField.getPassword()));
				passwordField.setText("");
				if(passCount>0) {
					// call purchase
					if(pc.purchase()) { // successful purchase
						PaymentStatusViewer pv = new PaymentStatusViewer(pc);
						dispose();
						pv.setVisible(true);
					}
					else {              // show here the reason
						System.out.println("From validator:"+pc.getApires()+"*");
						if(pc.isLengthInvalid() || pc.getApires().equals("invalid")) {
							lblInvalid.setText("Invalid PIN");
						}else if(pc.getApires().equals("error")) {
							lblInvalid.setText("Error");
							txtprb.setVisible(true);
						}else if(pc.getApires().equals("Insufficient balance")) {
							lblInvalid.setText("Insufficient balance");
							txtprb.setText("Try cash payment, Click here");
							txtprb.setBounds(257, 594, 268, 28);
							passwordField.setEditable(false);
							button.setEnabled(false);
							txtprb.setVisible(true);
						}else {
							txtprb.setVisible(true);
						}
						
						lblInvalid.setVisible(true);
					}
					--passCount;
					randerMsg();
				}
				else{                              //show invalid pass, fold for a few
					//got to root
					randerMsg();
					passwordField.setEditable(false);
					button.setEnabled(false);
					try {Thread.sleep(4000);} catch (InterruptedException e1) {}
					WelcomeScreen wl = new WelcomeScreen();
					dispose();
					wl.setVisible(true);
				}
			}
		});
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
		txtRecp.setText(Master.getReceipt());
		txtRecp.setEditable(false);
		contentPane.add(txtRecp);
		
		randerMsg();
	}
	private void randerMsg() {
		if(passCount>0)txttrl.setText("                                              "+Integer.toString(passCount+1)+" "+al);
		else txttrl.setText(msg);

	}

}
