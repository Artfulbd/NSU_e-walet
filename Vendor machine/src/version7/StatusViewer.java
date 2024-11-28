package version7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class StatusViewer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatusViewer frame = new StatusViewer();
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
	public StatusViewer() {
		setTitle("Full_of_BUgs");
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
		txtRecp.setText(Master.getReceiptWithTrId("g"));
		txtRecp.setEditable(false);
		contentPane.add(txtRecp);

		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "1. Choose your food item/items by adding quantity.\n"
						+ "2. Click on \"Add to cart\" for every food item you select.\n"
						+ "3. If \"Add to cart\" is not clicked, that item will not be added on your receipt.\n"
						+ "4. Click on \"cancel\" to cancel corrosponding food item.\n"
						+ "5. Click on \"clear cart\" to clear your entire receipt.\n"
						+ "6. If you need any item more then 4, then first choose 4 to quantity\n"
						+ "    add it to your cart and choose rest of your quantity again,add it to cart.\n."
						+ "    You can do it as many time as you need.\n"
						+ "7. \"Back\" button will cancel everything and rander you to Home screen.\n"
						+ "8. Before placeing order, make sure you added everything to your cart\n"
						+ "9. After this page you can cancle you order, but can't add more food item.";
				JOptionPane.showMessageDialog(StatusViewer.this, msg,"Help",JOptionPane.INFORMATION_MESSAGE);
				return;				
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
