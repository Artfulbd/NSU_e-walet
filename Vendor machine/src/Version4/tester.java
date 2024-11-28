package Version4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


public class tester {
	private static final String requestUrl = "http://localhost/eWalletAPI/false/userlist.php";
	public static void main(String[] args) {
		 String payLoad ="{\"data\" : \"105 81 107 85 104 95 113 87 120 66 98 71 107 95 | \"}";
		 ArrayList<String> ids = getAllId(payLoad);
		 System.out.println("Size: "+ids.size());
		 for(String hold: ids) {
				System.out.println(hold);
		}
		
		
		
		
		
		// TODO Auto-generated method stub
		//String bl = enc("'id:781ACF9A'");
		//String bl = enc("9999");
		//System.out.println("Encrypted: "+bl+"\n size: "+bl.length());
		
		//IdValidator ivv = IdValidator.getIdValidator();
		//System.out.println("Is valid "+ivv.isValid("511ED5"));
		
		
	}
	public static ArrayList<String> getAllId(String payload) {    //calling API
		ArrayList<String> ids = new ArrayList<>();
	    try {
	        URL url = new URL(requestUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	        connection.setDoInput(true);
	        connection.setDoOutput(true);
	        connection.setRequestMethod("POST");
	        connection.setRequestProperty("Accept", "application/json");
	        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	     
	        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
	        writer.write(payload);
	        writer.close();
	        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        StringBuffer jsonString = new StringBuffer();
	        String line;
	        while ((line = br.readLine()) != null) {
	                jsonString.append(line);
	        }
	        br.close();
	        connection.disconnect();
	        
	        
	        final String regex = "\\w*[^\\[\\]\\{\":\\},ids]";
			final String string = jsonString.toString();
			final Pattern pattern = Pattern.compile(regex);
			final Matcher matcher = pattern.matcher(string);
			while (matcher.find())ids.add(matcher.group(0));
	        return ids;
	    } catch (Exception e) {
	          return ids;
	    }

	}
	
	
	public static String enc(String t) {
		String main = "",store ="";
		String[] s = t.split(" ");
		for(String i: s)System.out.println("spilting: "+i);
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
	public static String dec(String t) {
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
