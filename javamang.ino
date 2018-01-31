#include <Wire.h>
#include <AM2320.h>
AM2320 th;
int i=0;
void setup(){
  Serial.begin(9600);
}

void loop(){
  switch(th.Read()){
    case 2:
      Serial.println("CRC failed");
      break;
    case 1:
      Serial. println("Sensor offline");
      break;
    case 0:
      Serial.print("Humidity: ");
      Serial.print(th.h);
      Serial.println("%");
      Serial.print("Temterature: ");
      Serial.print(th.t);
      Serial.println("*C");
      break;
  }
  delay(1000);
}

