package version7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

class PurchaseController {
	private String pass, apires, trancID, toId = "123456";
	
	

	private boolean isCalled = false;
	
	PurchaseController(String pass){
		this.pass = pass;
	}
	boolean isLengthInvalid() {
		if(pass.length() == 4) return false;
		return true;
	}
	
	
	boolean purchase() {
		if(isLengthInvalid())return false;
		System.out.println("Amount:"+Master.getAmount());
		System.out.println("ID:"+Master.getId());
		System.out.println("List:"+Master.getBlForApi());
		System.out.println("To:"+toId);
		String payLoad;
		int n =  (int)(Math.random()*500) % 2 ;
		if(n == 0) {
			payLoad ="{\"data\" : \""+new Master().encode(Integer.toString(Master.getAmount())+";"+pass, 1887)+"\",\n"
					+"\"sec\" : \""+new Master().encode(Master.getId(), 1887)+"\",\n";
		}
		else {
			payLoad ="{\"data\" : \""+new Master().encode(Integer.toString(Master.getAmount())+";"+Master.getId(), 1887)+"\",\n"
					+"\"sec\" : \""+new Master().encode(pass, 1887)+"\",\n";
		}
		payLoad   += "\"body\" : \""+new Master().encode(Master.getBlForApi(), 1887)+"\",\n"
			   	+ "\"ano\" : \""+new Master().encode(toId, 1887)+"\"}";
		
		//after  encryption
		System.out.println("Payload**:"+payLoad+":**");
		trancID = makeTranc(payLoad);
		isCalled = true;  
		if(apires.equals("ok") || apires.equals("manual"))return true;
		return false;      //if successful, else return false
	}



	String getApires() {
		if(isCalled)return apires;
		return "No transction done yet";
	}
	String getTrancID() {
		if(isCalled)return trancID;
		return "No transction done yet";
	}
    private String makeTranc(String payload) {    //calling API
		
	    try {
	        URL url = new URL(Master.getPurchaseURL());
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
	        
	        JSONObject obj = new JSONObject(jsonString.toString());
	        apires = (String) obj.get("status");
	        if(apires.equals("ok") || apires.equals("manual")) {
	        	return (String) obj.get("trid");
	        }
	        return "";
	        
	    } catch (Exception e) {
	    	  apires = "Device not connected to Server";
	          return "";
	    }

	}
	


}
