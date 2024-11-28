package version9;

public class Master {
	private static final String host = "https://nfb.grayscalehost.com/eWalletAPI/e_wallet/";
	private static final String idValidator = host+"userlist.php";
	private static final String purchase = host+"purchase.php";
	
	

	private static String receipt, id = "",bl = "", blForApi;
	
	private static int amount;
	private static  ArduinoAdaptor ad;
	private static boolean er = false;
	static long time;

	static String getIdvalidatorURL() {
		return idValidator;
	}
	static String getPurchaseURL() {
		return purchase;
	}
	
	static boolean isEr() {
		return er;
	}

	static String getAdError() {
		return ad.getErrorMsg();
	}
	static void showElapsedTime() {
		System.out.println("It needs "+( System.currentTimeMillis() - time)+ " second.");
	}
	
	private static boolean run() {
		ad = new ArduinoAdaptor();
		if(ad.isReadable()) {
			time = System.currentTimeMillis();
			ad.run();
			while(id.equals("")) {//hold
				try {Thread.sleep(500);} catch (InterruptedException e) {}
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
		Master.amount = amout;
	}
	
	static String getBlForApi() {
		return blForApi;
	}

	static void setBlForApi(String blForApi) {
		Master.blForApi = blForApi;
	}

	static String getReceipt() {
		return bl+receipt;
	}
	static String getReceiptWithTrId(String trid) {
		return bl+"Tranc ID:"+trid+'\n'+receipt;
	}

	static void setReceipt(String receipt ,String receipt2) {
		Master.receipt = receipt2;
		Master.bl = receipt;
	}

	static String getId() {
		return id;
	}

	static void setId(String id) {
		Master.id = id;
	}
	
	public String encode(String data, int key) {
		if(key == 1107 || key == 1887)return enc(data).trim();
		return "You fool";
	}
	
	
	private String enc(String t) {
		String main = "",store ="";
		String[] s = t.split(" ");
		int r, h, l ;
		for(String st: s) {
			l = st.length();
			for(int i = 0; i<l ;i++) {   
				r = 95+(int)(Math.random()*500)%29;
				h = st.charAt(i);
				h = (h + r) % 127;
				store += Integer.toString(r)+" "+Integer.toString(h)+" ";
			}
			main += store+"| ";
			store = "";
		}
		return main;
	}
	
	public String decode(String data, int key) {
		if(key == 1107)return dec(data);
		return "You fool";
	}
	
	private String dec(String t) {
		boolean b = true;
		String main = "",h1 = "", h2 = "";
		String[] s = t.split(" ");
		int i = 0, h = 0, ho;
		try {
			for(String st: s) {
				if(st.equals("|"))main+=" ";
				else {
					if(i % 2 == 0)h1 = st;
					else {
						h2 = st;
						h = (127 - Integer.parseInt(h1)) + Integer.parseInt(h2);
						ho = Integer.parseInt(h1);
						if(ho < 94  || ho > 123) {
							b = false;
							break;
						}
						if(h == 137 || h == 10)main +='\n';
						else main +=(char)h;
					}
					i++;
				}
			}
		}catch( NumberFormatException E) {
			b = false;
		}
		if(b && main != "")return main;
		else return " Wrong code ..!";
	}
	
	
	

}
