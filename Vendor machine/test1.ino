const int lf1 = 22, lf2 = 24, lb1 = 26, lb2 = 28, rf1 = 30, rf2 = 32, rb1 = 34, rb2= 36;
int spd = 150; 
const int lf = 4, lb = 5, rf = 6, rb = 7;
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9400);
  pinMode(lf, OUTPUT);
  pinMode(lb, OUTPUT);
  pinMode(rf, OUTPUT);
  pinMode(rb, OUTPUT);
  for(int i = 22; i<37; i+=2)pinMode(i, OUTPUT);
}

void loop() {
  digitalWrite(lf1, HIGH);
  digitalWrite(lf2, LOW);
  digitalWrite(rf1, HIGH);
  digitalWrite(rf2, LOW);
  digitalWrite(lb1, HIGH);
  digitalWrite(lb2, LOW);
  digitalWrite(rb1, HIGH);
  digitalWrite(rb2, LOW);
  analogWrite(lf, spd);
  analogWrite(lb, spd+30);
  analogWrite(rf, spd+30);
  analogWrite(rb, spd);
  delay(1000);
  
  digitalWrite(lf1, LOW);
  digitalWrite(lf2, HIGH);
  digitalWrite(rf1, LOW);
  digitalWrite(rf2, HIGH);
  digitalWrite(lb1, LOW);
  digitalWrite(lb2, HIGH);
  digitalWrite(rb1, LOW);
  digitalWrite(rb2, HIGH);
  analogWrite(lf, spd);
  analogWrite(lb, spd+30);
  analogWrite(rf, spd+30);
  analogWrite(rb, spd);
  delay(1000);
}
