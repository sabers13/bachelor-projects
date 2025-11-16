
#include "DHT.h"

#define DHTOPIN 8
#define DHT1PIN 9
#define DHTTYPE DHT22
#define Cooler_Low_PIN
#define Cooler_High_PIN
DHT dht0(DHTOPIN, DHTTYPE);
DHT dht1(DHT 1PIN, DHTTYPE):
10
void setup() {
Serial.begin(9600);
Serial.println("DHTxx test!");
14
pinMode(Cooler_Low_PIN OUTPUT);
pinMode(Cooler_High_PIN OUTPUT);
17
dhto.begin():
dht1.begin();
}
21
void loop() {
digitalWrite(Cooler_Low_PINLOW);
digitalWrite(Cooler_High_PINHIGH);
delay(1000);
digitalWrite(Cooler_Low_PINHIGH);
digitalWrite(Cooler_High_PINLOW);
delay(1000);
float h0= dht0.readHumidity();
float t0 = dht0.readTemperature();
float h1 = dht1.readHumidity();
float t1= dht1.readTemperature();
if (isnan(h0) || isnan(t0)) {
Serial.println("Failed to read from DHT sensor!');
return;

}

Serial.print("Humidity0: ");
Serial.print(h0);
Serial.print("%   ");
Serial.print("Temperature0: ");
Serial.print(t0);
Serial.println("*C");
Serial.print("Humidity1: ");
Serial.print(h1);
Serial.print("%   ");
Serial.print("Temperature1: ");
Serial.print(t1);
Serial.println("*C"):
}
