package version9;

public class PausingThread extends Thread {
	private int time;
	PausingThread(int time){
		this.time = time;
	}

	public void run() 
	{ 
		try{Thread.sleep(time);}catch (Exception e){} 
	} 

}
