#include <mega16.h>     
#include <delay.h>   

void main(void)
{
 
DDRA=0XFF;
DDRB=0Xff;
 
while (1)
 {   

PORTB= 0b00000001;
PORTA= 0b11111111;
delay_ms(1);

PORTB= 0b00000010;
PORTA= 0b10110101;
delay_ms(1);

PORTB= 0b00000100;
PORTA= 0b10110111;
delay_ms(1);

PORTB= 0b00001000;
PORTA= 0b10110101;
delay_ms(1);

PORTB= 0b00010000;
PORTA= 0b10000101;
delay_ms(1);

PORTB= 0b00100000;
PORTA= 0b10110101;
delay_ms(1);

PORTB= 0b01000000;
PORTA= 0b10110101;
delay_ms(1);

PORTB= 0b10000000;
PORTA= 0b11111111;
delay_ms(1);
}}





