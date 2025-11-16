#include <mega16.h>     
#include <delay.h>     
  
void main()
{
      
  char seg[]={0b00000110,0b01001111,0b01101111,0b01101111};    
DDRA=0XFF;

DDRB=0Xff;

while (1)
 {   
   
 PORTA= 0b11111110;
PORTB=seg[0];                                                         
    delay_ms(10);
 
  PORTA= 0b11111101;
PORTB=seg[1];
     delay_ms(10);

 PORTA= 0b11111011;
PORTB=seg[2];
     delay_ms(10);

 PORTA= 0b11110111;
PORTB=seg[3];
     delay_ms(10);
}}