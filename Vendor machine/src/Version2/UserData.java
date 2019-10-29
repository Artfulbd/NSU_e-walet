package Version2;

public class UserData {
	private static String receipt, id = "";
	private static int amount;
	private static  ArduinoAdaptor ad;
	private static boolean er = false;

	
	static boolean isEr() {
		return er;
	}

	static String getAdError() {
		return ad.getErrorMsg();
	}
	
	public static boolean run() {
		ad = new ArduinoAdaptor();
		if(ad.isReadable()) {
			ad.run();
			while(id.equals("")) {
				//hold
				try {Thread.sleep(1000);} catch (InterruptedException e) {}
				System.out.println();
			}
			ad.close();
			ad.interrupt();
			return true;
		}
		else return false;
	}
	
    void start() {
		receipt = id = "";
		amount = 0;
		if(run()) {
			er = false;
			SecondFile.setPrice();
			SecondFile.clearQuantity();
			SecondFile frame2 = new SecondFile();
			frame2.setVisible(true);
		}
		else {
			er = true;
			WelcomeScreen frame = new WelcomeScreen();
			frame.setVisible(true);	
		}
	}

	static int getAmount() {
		return amount;
	}

	static void setAmount(int amout) {
		UserData.amount = amout;
	}

	static String getReceipt() {
		return receipt;
	}

	static void setReceipt(String receipt) {
		UserData.receipt = receipt;
	}

	static String getId() {
		return id;
	}

	static void setId(String id) {
		UserData.id = id;
	}
	
	static boolean isIdReceived() {
		return (id.equals("")) ? false: true;
	}
	
	static boolean isReceptGenerated() {
		return (receipt.equals("")) ? false: true;
	}
	
	
	

}
