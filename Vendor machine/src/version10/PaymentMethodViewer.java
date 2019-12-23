package version10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class PaymentMethodViewer extends JFrame {

	private JPanel contentPane;

	public PaymentMethodViewer() {
		setTitle("NSU_e-Wallet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 725);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblChosePaymentMemthod = new JLabel("Choose payment memthod");
		lblChosePaymentMemthod.setForeground(Color.YELLOW);
		lblChosePaymentMemthod.setFont(new Font("Consolas", Font.BOLD, 52));
		lblChosePaymentMemthod.setBounds(312, 116, 657, 62);
		contentPane.add(lblChosePaymentMemthod);

		JButton btnCashPaymet = new JButton("Cash Payment");
		btnCashPaymet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CashPaymentViewer cv = new CashPaymentViewer();
				dispose();
				cv.setVisible(true);
			}
		});
		btnCashPaymet.setToolTipText("It will print receipt, you can pay it from cash counter");
		btnCashPaymet.setFont(new Font("Times New Roman", Font.PLAIN, 44));
		btnCashPaymet.setBackground(new Color(255, 255, 153));
		btnCashPaymet.setBounds(459, 255, 298, 55);
		contentPane.add(btnCashPaymet);

		JButton btnEwallet = new JButton("e-Wallet");
		btnEwallet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidationViewer vv = new ValidationViewer();
				dispose();
				vv.setVisible(true);
			}
		});
		btnEwallet.setToolTipText("Click here to use NSU_e-Wallet");
		btnEwallet.setFont(new Font("Trebuchet MS", Font.PLAIN, 44));
		btnEwallet.setBackground(Color.ORANGE);
		btnEwallet.setBounds(459, 366, 298, 55);
		contentPane.add(btnEwallet);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeScreen wl = new WelcomeScreen();
				dispose();
				wl.setVisible(true);
			}
		});
		btnCancel.setToolTipText("Click here to clear your cart");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnCancel.setBackground(new Color(255, 102, 51));
		btnCancel.setBounds(131, 553, 144, 41);
		contentPane.add(btnCancel);
		
		JButton btnTest = new JButton("add more item");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SecondFile frame2 = new SecondFile(1);
				dispose();
				frame2.setVisible(true);
			}
		});
		btnTest.setToolTipText("Click here to add more item");
		btnTest.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 33));
		btnTest.setBackground(new Color(51, 255, 102));
		btnTest.setBounds(728, 553, 186, 45);
		contentPane.add(btnTest);

		if(Master.getAmount()<50) {
			btnEwallet.setBackground(SystemColor.info);
			btnEwallet.setEnabled(false);

			JLabel lblScannerIsNot = new JLabel("Amount less then 50 taka, not allowed to use e-Wallet");
			lblScannerIsNot.setForeground(Color.RED);
			lblScannerIsNot.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
			lblScannerIsNot.setBounds(297, 479, 648, 30);
			contentPane.add(lblScannerIsNot);
		}
	}
}
