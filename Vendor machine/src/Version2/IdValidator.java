package Version2;

public class IdValidator {
	private String id;
	private String[] list = {"716C75D5","36817DF7"};
	
	IdValidator(String id){
		this.id = id;
	}
	boolean isValid() {
		for(String hold: list) {
			if(hold.equals(id))return true;
		}
		
		return false;
	}

}
