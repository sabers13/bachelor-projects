
*************D FLIP FLOP HSPICE netlist************ 
.include 'C:\synopsys\Examples\mosistsmc180.lib'
*netlist---------------------------------------


VDD        vdd       0       1.8

VCLK      clk       gnd     Pulse(0    1.8 0ps 100ps 100ps 5ns 10ns)
VNCLK     Nclk      gnd     Pulse(1.8  0   0ps 100ps 100ps 5ns 10ns)
vD     D      gnd     Pwl(0ns 1.8 4ns 1.8 4.1ns 0 14ns 0 14.1ns 1.8 )

.option scale=90n
.param N=6
.param P=18
.GLOBAL vDD GND

.subckt inv a y N=3 P=9

M1 y a gnd gnd NMOS W='N' L=2 AS='N*5' PS='2*N+10' AD='N*5' PD='2*N+10'
M2 y a vdd vdd PMOS W='P' L=2 AS='P*5' PS='2*P+10' AD='P*5' PD='2*P+10'

.ends


*X1     NOTD   D     inv    N=3   P=9


MP1    D     CLK     1     VDD     PMOS W='P' L=2 AS='P*5' PS='2*P+10' AD='P*5' PD='2*P+10'
MN1    D     NCLK    1     GND     NMOS W='N' L=2 AS='N*5' PS='2*N+10' AD='N*5' PD='2*N+10'

MP2    1     NCLK     2     VDD     PMOS W='P' L=2 AS='P*5' PS='2*P+10' AD='P*5' PD='2*P+10'
MN2    1     CLK    2     GND     NMOS W='N' L=2 AS='N*5' PS='2*N+10' AD='N*5' PD='2*N+10'
 
X2     1      3     inv    N=3   P=9
X3     3      2     inv    N=3   P=9


MP3    3     NCLK    NQ     VDD     PMOS W='P' L=2 AS='P*5' PS='2*P+10' AD='P*5' PD='2*P+10'
MN3    3     CLK     NQ     GND     NMOS W='N' L=2 AS='N*5' PS='2*N+10' AD='N*5' PD='2*N+10'

MP3    NQ     CLK    4     VDD     PMOS W='P' L=2 AS='P*5' PS='2*P+10' AD='P*5' PD='2*P+10'
MN3    NQ     NCLK     4     GND     NMOS W='N' L=2 AS='N*5' PS='2*N+10' AD='N*5' PD='2*N+10'


X4     NQ      Q   inv      N=3   P=9
X5     Q      4   inv      N=3   P=9

*extra control information--------------------- 
.options post=2 nomod 
.op 

*analysis-------------------------------------- 
.TRAN 10ps 30ns * transient analysis: Step end_time 

.END


