#include <MFRC522.h>  // MFRC522 RFID module library.
#include <SPI.h>      // SPI device communication library.
#define pinRST 8      // leonardo
#define pinSS 7  

byte readCard[4];     // Array that will hold UID of the RFID card.
int successRead;
int lstSignal = 0,inByte = 0, i, scanning = 12, gotS = 11;         // incoming serial byte
String data = "", hold;

MFRC522 mfrc522(pinSS, pinRST);   // Creates MFRC522 instance.
MFRC522::MIFARE_Key key;          // Creates MIFARE key instance.


void setup() {
  // start serial port at 9600 bps:
  Serial.begin(9600);
  pinMode(scanning, OUTPUT);
  pinMode(gotS, OUTPUT);

   SPI.begin();        // Initiates SPI connection between RFID module and Arduino.
  mfrc522.PCD_Init(); // Initiates MFRC522 RFID module.
 
}

void loop() {
  if (Serial.available() > 0) {
    inByte = Serial.read();
    if( inByte == 115  ){                      //{s} read
      do{
        digitalWrite(scanning, HIGH);   
        delay(50);                    
      }while(!getID());
      digitalWrite(scanning, LOW); 
      digitalWrite(gotS, HIGH);   
      delay(500);                    
      digitalWrite(gotS, LOW); 
    }
    else if(inByte == 111){                  //{o} flush 
     data = "";
    }// else do nothing    
  }// end of receivig signal
  
  // no signal then keep printing
    Serial.println(data);  
    delay(50);
}
bool getID() // Function that will read and print the RFID cards UID.
{
  if ( ! mfrc522.PICC_IsNewCardPresent())  // If statement that looks for new cards.
  {
    return false;
  }

  if ( ! mfrc522.PICC_ReadCardSerial())    // If statement that selects one of the cards.
  {
    return false;
  }  
  data = "";
  for (byte i = 0; i < 4; i++)data += String(mfrc522.uid.uidByte[i], HEX);  
  mfrc522.PICC_HaltA();     // Stops the reading process.
  return true;
}
