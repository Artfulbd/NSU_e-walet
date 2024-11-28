package Version4;

class PurchaseController {
	private String pass, apires, trancID;
	

	private boolean isCalled = false;
	
	PurchaseController(String pass){
		this.pass = pass;
	}
	
	
	boolean purchase() {
		if(pass.length() != 4) {
			apires = "Invalin pin";
			return false;
		}
		//after  encryption
		apires = "Tranction Successful"; 
		trancID = "df65g4s8f4g9";
		isCalled = true;   
		return true;      //if successful, else return false
	}



	String getApires() {
		if(isCalled)return apires;
		return "No transction done yet";
	}
	String getTrancID() {
		if(isCalled)return trancID;
		return "No transction done yet";
	}
	


}
