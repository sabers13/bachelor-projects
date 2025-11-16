#include <mega16.h>
#include <delay.h>

void main(){
DDRB=0XFF;
while(1){
PORTB.1=1;
delay_ms(250);
PORTB.1=0;
delay_ms(250) ;
}}
