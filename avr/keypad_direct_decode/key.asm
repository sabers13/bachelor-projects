.INCLUDE "M32DEF.INC"
	.ORG 0
	RJMP main
	.ORG $100
	;.DB  $EE,$ED,$EB,$E7,$DE,$DD,$DB,$D7,$BE,$BD,$BB,$B7,$7E,$7D,$7B,$77
	;.ORG $300
main:	LDI R16,$0F
	 	OUT DDRA,R16
	 	CLR R16
	 	OUT SFIOR,R16
	 	SER R16
	 	OUT PORTA,R16
		OUT DDRB,R16
		OUT DDRC,R16
	 	CLR R18
wait1:	IN R16,PINA
	 	ANDI R16,$F0
	 	CPI R16,$F0
	 	BRNE wait1
loop1:	LDI R17,$0E
wait2:	OUT PORTA,R17
		IN R16,PINA
	 	ANDI R16,$F0
	 	CPI R16,$F0
	 	BRNE search
		INC R18
		SEC
		ROL R17
		CPI R18,4
		BRNE wait2
		CLR R18
		RJMP loop1
search:	ANDI R17,$0F
		OR R16,R17

		

		LDI R18,10
		CPI R16,$E7
		BREQ end

		LDI R18,0
		CPI R16,$EB
		BREQ end
		
		LDI R18,11
		CPI R16,$ED
		BREQ end

		LDI R18,12
		CPI R16,$EE
		BREQ end

		LDI R18,1
		CPI R16,$D7
		BREQ end

		LDI R18,2
		CPI R16,$DB
		BREQ end

		LDI R18,3
		CPI R16,$DD
		BREQ end
		
		LDI R18,13
		CPI R16,$DE
		BREQ end

		LDI R18,4
		CPI R16,$B7
		BREQ end

		LDI R18,5
		CPI R16,$BB
		BREQ end

		LDI R18,6
		CPI R16,$BD
		BREQ end

		LDI R18,14
		CPI R16,$BE
		BREQ end

		LDI R18,7
		CPI R16,$77
		BREQ end

		LDI R18,8
		CPI R16,$7B
		BREQ end

		LDI R18,9
		CPI R16,$7D
		BREQ end

		LDI R18,15
		CPI R16,$7E
		BREQ end

end:	OUT PORTC,R18
		
		

		;IN R23,PINA;R18
		;;CLR R18
		;CLR R30
		;LDI R31,$02
;loop2:	;LPM R17,Z
		;CP R17,R16
		;BREQ end1
		;INC R18
		;INC R30
		;CPI R18,16
		;BRNE loop2
		RJMP wait1
end1:	OUT PORTC,R18


