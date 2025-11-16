.INCLUDE "M32DEF.INC"
	.ORG 0
	RJMP main
	.ORG $100
	.DB $3F,$06,$DB,$CF,$E6,$ED,$FD,$07,$FF,$EF
	.ORG $300
main:	LDI R16,$0F;OUTPUT
		OUT DDRA,R16
		CLR R16
	 	OUT SFIOR,R16
		CLR R16
	  	OUT DDRD,R16
	  	SER R16
		OUT DDRB,R16
  	    OUT DDRC,R16
		LDI R17,$01;$01=red,$02=orange,$04=green
		CLR R18;number of seconds
		CLR R19
		CLR R20
		CLR R22;
		CLR R25;i
		CLR R26
	  	CLR R27
	  	CLR R28
	  	CLR R29
	 	CLR R30
		CLR R31

		LDI R16,$05;$05;normal counter with 1024 prescaling
		MOV R15,R16
		LDI R16,10
		MOV R14,R16;start point of counting
		LDI R16,$01
		MOV R13,R16;SET TIFR
		LDI R16,10
		MOV R10,R16
		MOV R24,R16
		LDI R16,15
		MOV R9,R16
		LDI R16,14
		MOV R8,R16
		CLR R16


red:	LDI R17,$01;turn on red light
		LDI R18,$0A
		INC R25
		RJMP start

orange1:LDI R17,$02;turn on orange light
		LDI R18,$02
		INC R25
		RJMP start

green:	LDI R17,$04 ;turn on green light
		LDI R18,$08
		INC R25
		RJMP start

orange2:LDI R17,$02;turn on orange light
		LDI R18,$02
		CLR R25
		RJMP start


start:	OUT TCNT0,R14
		OUT TCCR0,R15
		MOV R21,R18;set default time
		MOV R22,R18
		;LDI R23,$01


loop:	OUT PORTA,R17;light on
wait:	MOV R22,R21;seconds remaining(binary)
		CLR R27
l1:	  	
		CPI R22,10
	  	BRLO exit
	  	SUBI R22,10;first decimal number
	  	INC R27;second decimal number
	  	RJMP l1
exit: 	LDI R31,$02
	  	MOV R30,R22
	  	LPM R29,Z
	  	MOV R30,R27
	 	LPM R26,Z
		

		OUT PORTB,R29
		OUT PORTC,R26
		
		;MUL R11,R10
		;ADD R23,R0
		;MOV R16,R23
		MOV R11,R23;save input
		IN R23,PIND
		CP R23,R24;compare with "on key"
		BRNE skip
		;MOV R18,R23
		;MUL R11,R10
		;ADD R23,R0
		CPI R25,3
		BREQ cong;convert green to red

		CPI R25,1
		BREQ conr;convert red to green		
cnt:
		

		MOV R21,R11;set new time
		;LDI R24,30;set a number larger than 16  to prevent program to stuck
		
		
skip:	CPI R23,10
		BREQ skip1;r23 is no longer equals to 10 
		LDI R24,10;set r24 to 10(on key)

skip1:	IN R12,TIFR
		SBRS R12,0;counter check
		RJMP wait 
		OUT TIFR,R13
		OUT TCNT0,R14
		INC R19
		CPI R19,4;we need about 980 cycles to get to one second(245*4)
	 	BRNE wait

		

		DEC R21;conting seconds
		CLR R19
		INC R20

		CPI R21,0;number of seconds*1 second
	 	BRNE wait
		CLR R20		
		OUT PORTA,R20

		CLR R18
		CLR R21
				
		CPI R25,0
		BREQ redjmp


		CPI R25,1
		BREQ ornjmp


		CPI R25,$02
		BREQ grnjmp


		CPI R25,$03
		BREQ orange2

		;CPI R25,$00
		;BREQ red
		;CPI R25,$01
		;BREQ orange1
		;CPI R25,$02
		;BREQ green
		;CPI R25,$03
		;BREQ orange2


		RJMP loop




redjmp:	RJMP red
ornjmp:	RJMP orange1
grnjmp:	RJMP green





conr:	CP R11,R9
		BREQ orn1
		RJMP cnt

orn1:	LDI R24,30
		RJMP orange1




cong:	CP R11,R8
		BREQ orn2
		RJMP cnt

orn2:	LDI R24,30
		RJMP orange2



