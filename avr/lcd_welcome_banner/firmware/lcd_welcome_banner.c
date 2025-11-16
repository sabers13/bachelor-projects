                                                  
#include <mega16.h>
#include <lcd.h>
#include <delay.h>

#asm
.equ __lcd_port=0x1B;
#endasm
char text1[]={'*','W','E','L','C','O','M','E','*'};

void main()
{
    int i,j;
    lcd_init(16);
    while (1)
    {
        for(i=4;i<=12;i++)
        {
            lcd_gotoxy(i,0);
            lcd_putchar(text1[i-4]); 
            delay_ms(200); 
             
        }   
         
         lcd_clear();
        delay_ms(200);
         
               for (j=0;j<=8;j++){
          lcd_gotoxy(j+5,0);
            lcd_putsf("AVR");  
            lcd_gotoxy(j,1);
            lcd_putsf("microcontroller")   ;
            delay_ms(150);   
            lcd_clear();
                }   
                delay_ms(200);  
                
          
     
   
    }}
