package Version4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdValidator {
	private final String requestUrl = "http://localhost/eWalletAPI/false/userlist.php";
	private static IdValidator personal;
	private static ArrayList<String> ids;
	private static boolean isTested = false;
	
	 private IdValidator(){
		 System.out.println("Singleton constractor called");
		 String payLoad ="{\"data\" : \""+new Master().encode("giveIds ", 1107)+"\"}";
		 IdValidator.ids = getAllId(payLoad);
	}
	public static boolean isConnected() {
		return ids.size() == 0 && isTested ? false:true;
	}
	
	public static IdValidator getIdValidator(){
		isTested = true;
		if(personal != null)return personal;
		else {
			personal = new IdValidator();
			return personal;
		}
	}
	
	public boolean isValid(String id) {
		for(String hold: ids) {
			System.out.println("id:"+hold+"*");
			if(hold.equals(id))return true;
		}
		return false;
	}
	public ArrayList<String> getAllId(String payload) {    //calling API
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


}
