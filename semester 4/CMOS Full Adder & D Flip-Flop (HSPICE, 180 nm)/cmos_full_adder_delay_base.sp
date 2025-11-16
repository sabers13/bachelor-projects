
*************CMOS Inverter HSPICE netlist************ 
.include 'C:\synopsys\Examples\mosistsmc180.lib'
*netlist--------------------------------------- 
.param SUPPLY=1.8
.param WN=0.36u
.param WP=0.72u
.param LSD=0.36u


*VDD Vdd 0 1.8 
VDD Vdd 0 'SUPPLY'
VA 2 0 PULSE 0 'SUPPLY' 0NS 100PS 100PS 8NS 16NS 	*input line: square wave, amp. rise t, fall t, on t, period 
VB 3 0 0 
VC 7 0 0

*Darin Gate Source Bulk Model_Name L=length W=width AS="Area of Source" PS="Perimeter of Source" AD PD
MP1 vdd 2 5 vdd PMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MP2 vdd 3 5 vdd PMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MP3 vdd 3 6 vdd PMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MP4 5 7 8 vdd PMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MP5 6 2 8 vdd PMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MP6 vdd 2 12 vdd PMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MP7 vdd 3 12 vdd PMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MP8 vdd 7 12 vdd PMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MP9 12 8 13 vdd PMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MP10 vdd 2 15 vdd PMOS L=.18u W='WP*3' AS='WP*3*LSD' PS='2*WP*3+2*LSD' AD='WP*3*LSD' PD='2*WP*3+2*LSD'
MP11 15 3 16 vdd PMOS L=.18u W='WP*3' AS='WP*3*LSD' PS='2*WP*3+2*LSD' AD='WP*3*LSD' PD='2*WP*3+2*LSD'
MP12 16 7 13 vdd PMOS L=.18u W='WP*3' AS='WP*3*LSD' PS='2*WP*3+2*LSD' AD='WP*3*LSD' PD='2*WP*3+2*LSD'
MP13 vdd 8 11 vdd PMOS L=.18u W='WP' AS='WP*LSD' PS='2*WP+2*LSD' AD='WP*LSD' PD='2*WP+2*LSD'
MP14 vdd 13 19 vdd PMOS L=.18u W='WP' AS='WP*LSD' PS='2*WP+2*LSD' AD='WP*LSD' PD='2*WP+2*LSD'

MN1 9 2 0 vdd NMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MN2 9 3 0 vdd NMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MN3 10 3 3 vdd NMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MN4 8 7 9 vdd NMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MN5 8 2 10 vdd NMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MN6 14 2 0 vdd NMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MN7 14 3 0 vdd NMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MN8 14 7 0 vdd NMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MN9 13 8 14 vdd NMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MN10 17 2 18 vdd NMOS L=.18u W='WP*3' AS='WP*3*LSD' PS='2*WP*3+2*LSD' AD='WP*3*LSD' PD='2*WP*3+2*LSD'
MN11 18 3 0 vdd NMOS L=.18u W='WP*3' AS='WP*3*LSD' PS='2*WP*3+2*LSD' AD='WP*3*LSD' PD='2*WP*3+2*LSD'
MN12 13 7 17 vdd NMOS L=.18u W='WP*3' AS='WP*3*LSD' PS='2*WP*3+2*LSD' AD='WP*3*LSD' PD='2*WP*3+2*LSD'
MN13 11 8 0 vdd NMOS L=.18u W='WP' AS='WP*LSD' PS='2*WP+2*LSD' AD='WP*LSD' PD='2*WP+2*LSD'
MN14 19 13 0 vdd NMOS L=.18u W='WP' AS='WP*LSD' PS='2*WP+2*LSD' AD='WP*LSD' PD='2*WP+2*LSD'


CLC 11 gnd 50fF
CLS 19 gnd 50fF

*extra control information--------------------- 
.options post=2 nomod 
.op 
*analysis-------------------------------------- 
.TRAN 10ps 16ns * transient analysis: Step end_time 
.measure charge INTEGRAL I(Vdd) FROM=0ns TO=30ns
.measure energy param='-charge * 1.8'

.measure tpdr				* rising propagation delay

+     TARG v(19)	  	VAL='SUPPLY/2' RISE=1
.measure tpdf				* falling propagation delay

+     TARG v(19)  	VAL='SUPPLY/2' FALL=2 
.measure tpd param='(tpdr+tpdf)/2'	* average propagation delay

.measure trise					* rise time

+	TARG v(19)	VAL='0.9 * SUPPLY' RISE=1
.measure tfall					* fall time

+	TARG v(19)	VAL='0.1 * SUPPLY' FALL=2


.END 