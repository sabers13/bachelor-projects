#include <mega16.h>
#include <delay.h>

void main (){
int i;
DDRD=0X00;
PORTD=0x01;
DDRB=0xFF;
PORTB=0X00;

while(1){

   
  if(PIND.0==1);// FIRST OFF
     delay_ms(100);
      if(PIND.0==0){  
        delay_ms(100);
for(i=0;i<1000; i++) {
  

PORTB= PORTB << 1;
if (PORTB==0)
 PORTB=0b00000001 ; 
    delay_ms(200);
if (PIND.0==0)  {
     delay_ms(100);
   PORTB=0;   
  
break;
 }
   
}
}
    
   }  

   }  
     
