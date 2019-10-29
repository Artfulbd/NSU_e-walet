package Version2;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class SecondFile extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JButton btnCancelTea, btnCancelCoffee, btnCancelSan, btnCancelSet, btnCancelBur,btnCancelPizza;
	private JTextField textFieldItemCount;
	private JLabel lblYourServiceIs,lblPleaseContactTo;
	private static JButton btnNewButton;
	private static Map<String, Integer>  mapPrice = new HashMap<String,Integer>();
	static void setPrice() {
		mapPrice.put("Tea", 10);
		mapPrice.put("Coffee", 25);
		mapPrice.put("Sandwich", 50);
		mapPrice.put("Set Menu 1", 145);
		mapPrice.put("Burger", 90);
		mapPrice.put("Pizza", 110);
	}

	private static Map<String, Integer> mapItem= new HashMap<String,Integer>(); 
	private static int totalAdded, hold, got, payable;
	private static JTextArea txtBill;
	private static String bl = "", finalBl = "";

	static void clearQuantity() {
		mapItem.put("Tea", 0);
		mapItem.put("Coffee", 0);
		mapItem.put("Sandwich", 0);
		mapItem.put("Set Menu 1", 0);
		mapItem.put("Burger", 0);
		mapItem.put("Pizza", 0);
		totalAdded = 0;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondFile frame = new SecondFile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public SecondFile() {
		IdValidator iv = new IdValidator(UserData.getId());
		
		setTitle("Full_of_BUgs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1267, 725);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		if(iv.isValid())itemViewer();
		else InvalidMsgViewer();
		
	}
	private void itemViewer() {
		
		JLabel lblTea = new JLabel("Tea");
		lblTea.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblTea.setForeground(Color.GREEN);
		lblTea.setBounds(81, 115, 57, 41);
		contentPane.add(lblTea);

		JLabel lblCoffee = new JLabel("Coffee");
		lblCoffee.setForeground(Color.GREEN);
		lblCoffee.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblCoffee.setBounds(81, 188, 98, 41);
		contentPane.add(lblCoffee);

		JLabel lblSandwotch = new JLabel("Sandwich");
		lblSandwotch.setForeground(Color.GREEN);
		lblSandwotch.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblSandwotch.setBounds(81, 281, 166, 41);
		contentPane.add(lblSandwotch);

		JLabel lblHashBrownies = new JLabel("Set menu ");
		lblHashBrownies.setForeground(Color.GREEN);
		lblHashBrownies.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblHashBrownies.setBounds(73, 372, 174, 41);
		contentPane.add(lblHashBrownies);

		JLabel lblBurger = new JLabel("Burger");
		lblBurger.setForeground(Color.GREEN);
		lblBurger.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblBurger.setBounds(81, 463, 102, 41);
		contentPane.add(lblBurger);

		JLabel lblPizza = new JLabel("Pizza (one slice)");
		lblPizza.setForeground(Color.GREEN);
		lblPizza.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblPizza.setBounds(73, 554, 244, 41);
		contentPane.add(lblPizza);

		JLabel lblPleaseYourItem = new JLabel("Please select your item");
		lblPleaseYourItem.setForeground(Color.ORANGE);
		lblPleaseYourItem.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblPleaseYourItem.setBounds(496, 10, 350, 41);
		contentPane.add(lblPleaseYourItem);

		JLabel lblTakaEach = new JLabel("10 taka");
		lblTakaEach.setForeground(new Color(255, 255, 0));
		lblTakaEach.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblTakaEach.setBounds(345, 120, 112, 41);
		contentPane.add(lblTakaEach);

		JLabel lblTaka = new JLabel("25 taka");
		lblTaka.setForeground(Color.YELLOW);
		lblTaka.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblTaka.setBounds(345, 201, 112, 41);
		contentPane.add(lblTaka);

		JLabel lblTaka_1 = new JLabel("50 taka");
		lblTaka_1.setForeground(Color.YELLOW);
		lblTaka_1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblTaka_1.setBounds(345, 286, 112, 41);
		contentPane.add(lblTaka_1);

		JLabel lblTaka_2 = new JLabel("145 taka");
		lblTaka_2.setForeground(Color.YELLOW);
		lblTaka_2.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblTaka_2.setBounds(345, 377, 130, 41);
		contentPane.add(lblTaka_2);

		JLabel lblTaka_3 = new JLabel("90 taka");
		lblTaka_3.setForeground(Color.YELLOW);
		lblTaka_3.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblTaka_3.setBounds(345, 468, 112, 41);
		contentPane.add(lblTaka_3);

		JLabel lblTaka_4 = new JLabel("110 taka");
		lblTaka_4.setForeground(Color.YELLOW);
		lblTaka_4.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblTaka_4.setBounds(345, 559, 130, 41);
		contentPane.add(lblTaka_4);

		Choice choiceTea = new Choice();
		choiceTea.setFont(new Font("SansSerif", Font.PLAIN, 34));
		choiceTea.setBounds(515, 107, 57, 49);
		choiceTea.add("0");
		choiceTea.add("1");
		choiceTea.add("2");
		choiceTea.add("3");
		contentPane.add(choiceTea);

		Choice choiceCoffee = new Choice();
		choiceCoffee.setFont(new Font("SansSerif", Font.PLAIN, 34));
		choiceCoffee.setBounds(515, 193, 60, 49);
		choiceCoffee.add("0");
		choiceCoffee.add("1");
		choiceCoffee.add("2");
		choiceCoffee.add("3");
		contentPane.add(choiceCoffee);

		Choice choiceSan = new Choice();
		choiceSan.setFont(new Font("SansSerif", Font.PLAIN, 34));
		choiceSan.setBounds(515, 273, 60, 41);
		choiceSan.add("0");
		choiceSan.add("1");
		choiceSan.add("2");
		choiceSan.add("3");
		contentPane.add(choiceSan);

		Choice choiceSet = new Choice();
		choiceSet.setFont(new Font("SansSerif", Font.PLAIN, 34));
		choiceSet.setBounds(515, 364, 60, 49);
		choiceSet.add("0");
		choiceSet.add("1");
		choiceSet.add("2");
		choiceSet.add("3");
		contentPane.add(choiceSet);

		Choice choiceBur = new Choice();
		choiceBur.setFont(new Font("SansSerif", Font.PLAIN, 34));
		choiceBur.setBounds(515, 463, 60, 49);
		choiceBur.add("0");
		choiceBur.add("1");
		choiceBur.add("2");
		choiceBur.add("3");
		contentPane.add(choiceBur);

		Choice choicePizza = new Choice();
		choicePizza.setFont(new Font("SansSerif", Font.PLAIN, 34));
		choicePizza.setBounds(515, 554, 60, 49);
		choicePizza.add("0");
		choicePizza.add("1");
		choicePizza.add("2");
		choicePizza.add("3");
		contentPane.add(choicePizza);

		JButton btnClearAll = new JButton("Clear Cart");
		btnClearAll.setToolTipText("Click here to clear your cart");
		btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearQuantity();
				choiceTea.select(0);
				choiceBur.select(0);
				choiceCoffee.select(0);
				choicePizza.select(0);
				choiceSan.select(0);
				choiceSet.select(0);
				textFieldItemCount.setText(Integer.toString(totalAdded));
				rander();
			}
		});
		btnClearAll.setBackground(new Color(255, 99, 71));
		btnClearAll.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnClearAll.setBounds(439, 627, 174, 41);
		contentPane.add(btnClearAll);

		JLabel lblCart = new JLabel("Cart");
		lblCart.setIcon(new ImageIcon("I:\\JavA\\Workplace\\Vendor machine\\Resource\\iconfinder_Food-Dome_379338.png"));
		lblCart.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCart.setForeground(new Color(255, 140, 0));
		lblCart.setBounds(1062, 0, 88, 41);
		contentPane.add(lblCart);

		textFieldItemCount = new JTextField();
		textFieldItemCount.setBackground(new Color(255, 250, 205));
		textFieldItemCount.setEditable(false);
		textFieldItemCount.setFont(new Font("Tahoma", Font.PLAIN, 33));
		textFieldItemCount.setText(Integer.toString(totalAdded));
		textFieldItemCount.setBounds(1003, 42, 57, 41);
		contentPane.add(textFieldItemCount);
		textFieldItemCount.setColumns(10);

		JLabel lblAdded = new JLabel("item added");
		lblAdded.setForeground(new Color(255, 0, 0));
		lblAdded.setBackground(new Color(255, 165, 0));
		lblAdded.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblAdded.setBounds(1062, 43, 164, 40);
		contentPane.add(lblAdded);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setForeground(Color.RED);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 33));
		lblTotal.setBackground(new Color(255, 165, 0));
		lblTotal.setBounds(920, 43, 73, 40);
		contentPane.add(lblTotal);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(new Color(210, 105, 30));
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblQuantity.setBounds(532, 60, 128, 41);
		contentPane.add(lblQuantity);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(new Color(210, 105, 30));
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblPrice.setBounds(346, 66, 74, 41);
		contentPane.add(lblPrice);

		JLabel lblItem = new JLabel("Item");
		lblItem.setForeground(new Color(210, 105, 30));
		lblItem.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblItem.setBounds(81, 64, 74, 41);
		contentPane.add(lblItem);

		JButton btnAddTea = new JButton("Add to cart");
		btnAddTea.setToolTipText("Click here to add Tea to your cart");
		btnAddTea.setBackground(new Color(255, 218, 185));
		btnAddTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				got = Integer.parseInt(choiceTea.getSelectedItem());
				hold =  got + mapItem.get("Tea");
				mapItem.put("Tea", hold);
				totalAdded += got;
				textFieldItemCount.setText(Integer.toString(totalAdded));
				rander();
			}
		});
		btnAddTea.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnAddTea.setBounds(598, 115, 153, 33);
		contentPane.add(btnAddTea);

		JButton btnAddCoffee = new JButton("Add to cart");
		btnAddCoffee.setToolTipText("Click here to add Coffee to your cart");
		btnAddCoffee.setBackground(new Color(255, 218, 185));
		btnAddCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				got = Integer.parseInt(choiceCoffee.getSelectedItem());
				hold =  got + mapItem.get("Coffee");
				mapItem.put("Coffee", hold);
				totalAdded += got;
				textFieldItemCount.setText(Integer.toString(totalAdded));
				rander();
			}
		});
		btnAddCoffee.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnAddCoffee.setBounds(598, 199, 153, 33);
		contentPane.add(btnAddCoffee);

		JButton btnAddSan = new JButton("Add to cart");
		btnAddSan.setToolTipText("Click here to add Sandwich to your cart");
		btnAddSan.setBackground(new Color(255, 218, 185));
		btnAddSan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				got = Integer.parseInt(choiceSan.getSelectedItem());
				hold =  got + mapItem.get("Sandwich");
				mapItem.put("Sandwich", hold);
				totalAdded += got;
				textFieldItemCount.setText(Integer.toString(totalAdded));
				rander();
			}
		});
		btnAddSan.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnAddSan.setBounds(598, 281, 153, 33);
		contentPane.add(btnAddSan);

		JButton btnAddSet = new JButton("Add to cart");
		btnAddSet.setToolTipText("Click here to add Set menu to your cart");
		btnAddSet.setBackground(new Color(255, 218, 185));
		btnAddSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				got = Integer.parseInt(choiceSet.getSelectedItem());
				hold =  got + mapItem.get("Set Menu 1");
				mapItem.put("Set Menu 1", hold);
				totalAdded += got;
				textFieldItemCount.setText(Integer.toString(totalAdded));
				rander();
			}
		});
		btnAddSet.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnAddSet.setBounds(598, 372, 153, 33);
		contentPane.add(btnAddSet);

		JButton btnAddBur = new JButton("Add to cart");
		btnAddBur.setToolTipText("Click here to add Burger to your cart");
		btnAddBur.setBackground(new Color(255, 218, 185));
		btnAddBur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				got = Integer.parseInt(choiceBur.getSelectedItem());
				hold =  got + mapItem.get("Burger");
				mapItem.put("Burger", hold);
				totalAdded += got;
				textFieldItemCount.setText(Integer.toString(totalAdded));
				rander();
			}
		});
		btnAddBur.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnAddBur.setBounds(598, 471, 153, 39);
		contentPane.add(btnAddBur);

		JButton btnAddPizza = new JButton("Add to cart");
		btnAddPizza.setToolTipText("Click here to add Pizza to your cart");
		btnAddPizza.setBackground(new Color(255, 218, 185));
		btnAddPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				got = Integer.parseInt(choicePizza.getSelectedItem());
				hold =  got + mapItem.get("Pizza");
				mapItem.put("Pizza", hold);
				totalAdded += got;
				textFieldItemCount.setText(Integer.toString(totalAdded));
				rander();
			}
		});
		btnAddPizza.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnAddPizza.setBounds(598, 561, 153, 41);
		contentPane.add(btnAddPizza);

		btnCancelTea = new JButton("Cancel");
		btnCancelTea.setToolTipText("Click here to cancel Tea");
		btnCancelTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hold = mapItem.get("Tea");
				if(hold != 0) {
					totalAdded -= hold;
					mapItem.put("Tea", 0);
					textFieldItemCount.setText(Integer.toString(totalAdded));
				}
				choiceTea.select(0);
				rander();
			}
		});
		btnCancelTea.setBackground(new Color(255, 69, 0));
		btnCancelTea.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnCancelTea.setBounds(777, 115, 112, 33);
		contentPane.add(btnCancelTea);

		btnCancelCoffee = new JButton("Cancel");
		btnCancelCoffee.setToolTipText("Click here to cancel Coffee");
		btnCancelCoffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hold = mapItem.get("Coffee");
				if(hold != 0) {
					totalAdded -= hold;
					mapItem.put("Coffee", 0);
					textFieldItemCount.setText(Integer.toString(totalAdded));
				}
				choiceCoffee.select(0);
				rander();
			}
		});
		btnCancelCoffee.setBackground(new Color(255, 69, 0));
		btnCancelCoffee.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnCancelCoffee.setBounds(777, 199, 112, 33);
		contentPane.add(btnCancelCoffee);

		btnCancelSan = new JButton("Cancel");
		btnCancelSan.setToolTipText("Click here to cancel Sandwich");
		btnCancelSan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hold = mapItem.get("Sandwich");
				if(hold != 0) {
					totalAdded -= hold;
					mapItem.put("Sandwich", 0);
					textFieldItemCount.setText(Integer.toString(totalAdded));
				}
				choiceSan.select(0);
				rander();
			}
		});
		btnCancelSan.setBackground(new Color(255, 69, 0));
		btnCancelSan.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnCancelSan.setBounds(777, 281, 112, 33);
		contentPane.add(btnCancelSan);

		btnCancelSet = new JButton("Cancel");
		btnCancelSet.setToolTipText("Click here to cancel Set menu");
		btnCancelSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hold = mapItem.get("Set Menu 1");
				if(hold != 0) {
					totalAdded -= hold;
					mapItem.put("Set Menu 1", 0);
					textFieldItemCount.setText(Integer.toString(totalAdded));
				}
				choiceSet.select(0);
				rander();
			}
		});
		btnCancelSet.setBackground(new Color(255, 69, 0));
		btnCancelSet.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnCancelSet.setBounds(777, 372, 112, 33);
		contentPane.add(btnCancelSet);

		btnCancelBur = new JButton("Cancel");
		btnCancelBur.setToolTipText("Click here to cancel Burger");
		btnCancelBur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hold = mapItem.get("Burger");
				if(hold != 0) {
					totalAdded -= hold;
					mapItem.put("Burger", 0);
					textFieldItemCount.setText(Integer.toString(totalAdded));
				}
				choiceBur.select(0);
				rander();
			}
		});
		btnCancelBur.setBackground(new Color(255, 69, 0));
		btnCancelBur.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnCancelBur.setBounds(777, 474, 112, 33);
		contentPane.add(btnCancelBur);

		btnCancelPizza = new JButton("Cancel");
		btnCancelPizza.setToolTipText("Click here to cancel Pizza");
		btnCancelPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hold = mapItem.get("Pizza");
				if(hold != 0) {
					totalAdded -= hold;
					mapItem.put("Pizza", 0);
					textFieldItemCount.setText(Integer.toString(totalAdded));
				}
				choicePizza.select(0);
				rander();
			}
		});
		btnCancelPizza.setBackground(new Color(255, 69, 0));
		btnCancelPizza.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnCancelPizza.setBounds(777, 565, 112, 33);
		contentPane.add(btnCancelPizza);

		txtBill = new JTextArea();
		txtBill.setToolTipText("This is your bill");
		txtBill.setFont(new Font("Monospaced", Font.BOLD, 20));
		txtBill.setBounds(899, 102, 343, 488);
		contentPane.add(txtBill);
		
		btnNewButton = new JButton("Place order");
		btnNewButton.setToolTipText("Click here to place your order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserData.setAmount(payable);
				UserData.setReceipt(finalBl);
				ValidationViewer();
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Monotype Corsiva", Font.BOLD, 36));
		btnNewButton.setBounds(977, 600, 197, 65);
		contentPane.add(btnNewButton);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setToolTipText("Need help? Click here.");
		btnHelp.setFont(new Font("Monotype Corsiva", Font.BOLD, 29));
		btnHelp.setBackground(new Color(255, 192, 203));
		btnHelp.setBounds(81, 17, 98, 41);
		contentPane.add(btnHelp);
		
		JLabel lblId = new JLabel("1722231042");
		lblId.setForeground(new Color(255, 51, 102));
		lblId.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblId.setBounds(244, 20, 144, 30);
		lblId.setText(UserData.getId());
		contentPane.add(lblId);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeScreen wl = new WelcomeScreen();
				dispose();
				wl.setVisible(true);
			}
		});
		btnBack.setToolTipText("Click here to cancle purchase");  
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(40, 627, 144, 41);
		contentPane.add(btnBack);
		
		rander();

	}
	private String getTime() {
		Date date = new Date(System.currentTimeMillis());
		return new SimpleDateFormat("'Time' HH:mm  'Date:'dd.MM.yy").format(date);
	}

	private void rander() {
		// making slip
		payable = 0;
		if(totalAdded == 0) {
			txtBill.setText("\n\n    Nothing selected\n\n-----------------------------\n Total payable amount: 0 ");
			btnNewButton.setEnabled(false);
		}
		else {
			bl = "  -->Bill<--  ID:"+UserData.getId()+"\n "+getTime()+"\n***********************"
					+ "******\n Item  (qty X rate) = price"
					+ "\n-----------------------------\n";
			got = mapItem.get("Tea");
			if(got != 0) {
				hold = mapPrice.get("Tea");
				payable += got*hold;
				bl+=" Tea          "+got+"X"+hold+"  =  "+(got*hold)+"\r\n";
			}
			got = mapItem.get("Coffee");
			if(got != 0) {
				hold = mapPrice.get("Coffee");
				payable += got*hold;
				bl+=" Coffee       "+got+"X"+hold+"  =  "+(got*hold)+"\r\n";
			}
			got = mapItem.get("Sandwich");
			if(got != 0) {
				hold = mapPrice.get("Sandwich");
				payable += got*hold;
				bl+=" Sandwich     "+got+"X"+hold+"  =  "+(got*hold)+"\r\n";
			}
			got = mapItem.get("Set Menu 1");
			if(got != 0) {
				hold = mapPrice.get("Set Menu 1");
				payable += got*hold;
				bl+=" Set Menu     "+got+"X"+hold+" =  "+(got*hold)+"\r\n";
			}
			got = mapItem.get("Burger");
			if(got != 0) {
				hold = mapPrice.get("Burger");
				payable += got*hold;
				bl+=" Burger       "+got+"X"+hold+"  =  "+(got*hold)+"\r\n";
			}
			got = mapItem.get("Pizza");
			if(got != 0) {
				hold = mapPrice.get("Pizza");
				payable += got*hold;
				bl+=" Pizza        "+got+"X"+hold+" =  "+(got*hold)+"\r\n";
			}
			finalBl = bl + "------------------------------\n Total payable amount:"+payable+
					"\n****************************\n     Thanks for using\n      \"Bull_Of_Bugs\" ";
			
			bl+="------------------------------\n Total payable amount:"+payable+
				"\n****************************\n Please check again and\n place your order.\n     Thanks for using\n      \"Bull_Of_Bugs\" ";
			txtBill.setText(bl);
			btnNewButton.setEnabled(true);
		}

	}
	
	public void InvalidMsgViewer() {
		
		lblYourServiceIs = new JLabel("Your service is blocked.");
		lblYourServiceIs.setForeground(Color.YELLOW);
		lblYourServiceIs.setFont(new Font("Consolas", Font.BOLD, 67));
		lblYourServiceIs.setBounds(236, 206, 883, 79);
		contentPane.add(lblYourServiceIs);
		
		lblPleaseContactTo = new JLabel("Please contact to IT.");
		lblPleaseContactTo.setForeground(new Color(255, 99, 71));
		lblPleaseContactTo.setFont(new Font("Consolas", Font.BOLD, 67));
		lblPleaseContactTo.setBounds(278, 295, 773, 79);
		contentPane.add(lblPleaseContactTo);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeScreen wl = new WelcomeScreen();
				dispose();;
				wl.setVisible(true);
				
			}
		});
		btnBack.setToolTipText("Click me to scan ID card");
		btnBack.setFont(new Font("Trebuchet MS", Font.PLAIN, 44));
		btnBack.setBackground(new Color(152, 251, 152));
		btnBack.setBounds(889, 496, 162, 55);
		contentPane.add(btnBack);
		
	}
	
	static int passCount = 2;
	private static final String msg = " If you forgot your PIN, reset it from your RDS and try again later", al = "trials left";
	private static JTextField txttrl;
	public void ValidationViewer() {
		setTitle("Full_of_BUgs");
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
		
		JLabel lblID = new JLabel(UserData.getId());
		lblID.setForeground(Color.ORANGE);
		lblID.setFont(new Font("Comic Sans MS", Font.BOLD, 67));
		lblID.setBounds(373, 137, 383, 79);
		contentPane.add(lblID);
		
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
		
		
	
		JButton button = new JButton("Place order");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseController pc = new PurchaseController(passwordField.getText().toString());
				if(passCount>0) {
					if(pc.isOk()) {         // call purchase
						if(pc.purchase()) { // successful purchase
							
						}
						else {              // show here the reason
							
						}
						
						
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
		
		JButton btnCncl = new JButton("Cancle");
		btnCncl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeScreen wl = new WelcomeScreen();
				dispose();;
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
		txtRecp.setText(UserData.getReceipt());
		txtRecp.setEditable(false);
		contentPane.add(txtRecp);
		
		randerMsg();
	}
	private static void randerMsg() {
		if(passCount>0)txttrl.setText("                                              "+Integer.toString(passCount+1)+" "+al);
		else txttrl.setText(msg);
		
	}

}
