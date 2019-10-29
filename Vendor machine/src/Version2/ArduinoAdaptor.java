package Version2;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class ArduinoAdaptor extends Thread{
	private  SerialPort[] ports;
	private SerialPort serialPort;
	private String errorMsg, data = "";

	ArduinoAdaptor(){
		ports = SerialPort.getCommPorts();	
	}
	public boolean isReadable() {
		if(ports.length == 0) {
			errorMsg = "Unable to connected with arduino.";
			return false;
		}
		serialPort = ports[0];
		if(!serialPort.isOpen())if(serialPort.openPort())return true;
		errorMsg = "Serial port not found";
		return false;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void close() {
		serialPort.closePort();
	}

	//@Override
	public void run() {
		serialPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
		serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 0, 0);
		try {Thread.sleep(1000);} catch (InterruptedException e) {}
		serialPort.writeBytes( "s".getBytes(), 1); // sending scanning signal
		startReading();
		
	}
	private void startReading() { // support of test1
		serialPort.addDataListener(new SerialPortDataListener() {
			@Override
			public int getListeningEvents() { return SerialPort.LISTENING_EVENT_DATA_RECEIVED; }
			@Override
			public void serialEvent(SerialPortEvent event)
			{
				String[] rawData = new String(event.getReceivedData()).split("\n",25); 
				for(int i = 0; i<rawData.length; i++)rawData[i] = rawData[i].trim();
				data = getID(rawData);
				if(!data.equals("Error") && data.length() > 6) {// got id huhu 
					UserData.setId(data);
					serialPort.writeBytes("o".getBytes(), 1); // sending stop signal
					return;
				}
				try {Thread.sleep(1000);} catch (InterruptedException e) {}
			}
		});
		

	}
	
	private String getID(String[] names){
		String name = names[2];
		int count = 0;
		for(int i = 0; i < names.length; i++){
			if(name.equalsIgnoreCase(names[i]))count++;
			if(count>5 && !name.equals("Nothing to give"))return name.toUpperCase();
		}
		return "Error";
	}
	

}
