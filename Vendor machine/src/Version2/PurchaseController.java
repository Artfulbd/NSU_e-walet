package Version2;

class PurchaseController {
	private String pass, apires;
	private boolean isCalled = false;
	
	PurchaseController(String pass){
		this.pass = pass;
	}
	
	boolean isOk() {
		if(pass.length() != 4)return false;
		// call api (id->en, pass->en)
		return false;
	}
	boolean purchase() {
		apires = " After encription: successfull, transid:df65g4s8f4g9";
		isCalled = true;   
		return true;      //if successfull, else return false
	}

	String getApires() {
		if(isCalled)return apires;
		return "No transction done yet";
	}
	


}
