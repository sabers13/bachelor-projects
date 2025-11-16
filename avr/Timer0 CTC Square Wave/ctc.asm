.INCLUDE "M32DEF.INC"
	.ORG 0
	RJMP main
	.ORG $100
main:	SBI DDRB,3
		LDI R16,49		
		LDI R17,$19	
		OUT OCR0,R16
		OUT TCCR0,R17
wait:	RJMP wait
		

