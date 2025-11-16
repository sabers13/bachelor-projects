
*************CMOS Inverter HSPICE netlist************ 
.include 'C:\synopsys\mosistsmc180.lib'
*netlist--------------------------------------- 
.param SUPPLY=1.8
.param WN=0.36u
.param WP=0.72u
.param LSD=0.36u


*VDD Vdd 0 1.8 
VDD Vdd 0 'SUPPLY'
VA A 0 PULSE 0 'SUPPLY' 0NS 100PS 100PS 8NS 16NS 	*input line: square wave, amp. rise t, fall t, on t, period 
VB B 0 PULSE 0 0
VC Cin 0 PULSE 0 0

*Darin Gate Source Bulk Model_Name L=length W=width AS="Area of Source" PS="Perimeter of Source" AD PD
MP1 vdd A 5 vdd PMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MP2 vdd B 5 vdd PMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MP3 vdd B 6 vdd PMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MP4 5 Cin 8 vdd PMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MP5 6 A 8 vdd PMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MP6 vdd A 12 vdd PMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MP7 vdd B 12 vdd PMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MP8 vdd Cin 12 vdd PMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MP9 12 8 13 vdd PMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MP10 vdd A 15 vdd PMOS L=.18u W='WP*3' AS='WP*3*LSD' PS='2*WP*3+2*LSD' AD='WP*3*LSD' PD='2*WP*3+2*LSD'
MP11 15 B 16 vdd PMOS L=.18u W='WP*3' AS='WP*3*LSD' PS='2*WP*3+2*LSD' AD='WP*3*LSD' PD='2*WP*3+2*LSD'
MP12 16 Cin 13 vdd PMOS L=.18u W='WP*3' AS='WP*3*LSD' PS='2*WP*3+2*LSD' AD='WP*3*LSD' PD='2*WP*3+2*LSD'
MP13 vdd 8 Cout vdd PMOS L=.18u W='WP' AS='WP*LSD' PS='2*WP+2*LSD' AD='WP*LSD' PD='2*WP+2*LSD'
MP14 vdd 13 Sum vdd PMOS L=.18u W='WP' AS='WP*LSD' PS='2*WP+2*LSD' AD='WP*LSD' PD='2*WP+2*LSD'

MN1 9 A 0 vdd NMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MN2 9 B 0 vdd NMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MN3 10 B 0 vdd NMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MN4 8 Cin 9 vdd NMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MN5 8 A 10 vdd NMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MN6 14 A 0 vdd NMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MN7 14 B 0 vdd NMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MN8 14 Cin 0 vdd NMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MN9 13 8 14 vdd NMOS L=.18u W='WP*2' AS='WP*2*LSD' PS='2*WP*2+2*LSD' AD='WP*2*LSD' PD='2*WP*2+2*LSD'
MN10 17 A 18 vdd NMOS L=.18u W='WP*3' AS='WP*3*LSD' PS='2*WP*3+2*LSD' AD='WP*3*LSD' PD='2*WP*3+2*LSD'
MN11 18 B 0 vdd NMOS L=.18u W='WP*3' AS='WP*3*LSD' PS='2*WP*3+2*LSD' AD='WP*3*LSD' PD='2*WP*3+2*LSD'
MN12 13 Cin 17 vdd NMOS L=.18u W='WP*3' AS='WP*3*LSD' PS='2*WP*3+2*LSD' AD='WP*3*LSD' PD='2*WP*3+2*LSD'
MN13 Cout 8 0 vdd NMOS L=.18u W='WP' AS='WP*LSD' PS='2*WP+2*LSD' AD='WP*LSD' PD='2*WP+2*LSD'
MN14 Sum 13 0 vdd NMOS L=.18u W='WP' AS='WP*LSD' PS='2*WP+2*LSD' AD='WP*LSD' PD='2*WP+2*LSD'


CLC Cout gnd 50fF
CLS Sum gnd 50fF

*extra control information--------------------- 
.options post=2 nomod 
.op 
*analysis-------------------------------------- 
.TRAN 10ps 16ns * transient analysis: Step end_time 
.measure charge INTEGRAL I(vdd) FROM=0ns TO=8ns
.measure energy param='-charge * 1.8'
.measure power param='energy*1000000000/8'

.measure tpdr				* rising propagation delay
+     TRIG v(A)		VAL='SUPPLY/2' RISE=1 
+     TARG v(Sum)	  	VAL='SUPPLY/2' RISE=1
.measure tpdf				* falling propagation delay
+     TRIG v(A)  	VAL='SUPPLY/2' FALL=1
+     TARG v(Sum)  	VAL='SUPPLY/2' FALL=1 
.measure tpd param='(tpdr+tpdf)/2'	* average propagation delay

.measure trise					* rise time
+	TRIG v(Sum)	VAL='0.1 * SUPPLY' RISE=1
+	TARG v(Sum)	VAL='0.9 * SUPPLY' RISE=1
.measure tfall					* fall time
+	TRIG v(Sum)	VAL='0.9 * SUPPLY' FALL=1
+	TARG v(Sum)	VAL='0.1 * SUPPLY' FALL=1

.END 