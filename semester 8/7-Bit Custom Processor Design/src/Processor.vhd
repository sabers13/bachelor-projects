library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
use IEEE.NUMERIC_STD.ALL;

entity Processor is
    Port ( 	CLK : in STD_LOGIC;
			RESET : in STD_LOGIC;
			R0out, R1out, R2out, R3out : out STD_LOGIC_VECTOR (6 downto 0));
end Processor;

architecture Behavioral of Processor is

    signal RIN, ROUT0, ROUT1, ROUT2, ROUT3, MUXOUT0, MUXOUT1, ROUTIR, PC_OUT, IR_OUT, ALURes, BUSout, MData : STD_LOGIC_VECTOR(6 downto 0);
    signal LD0, LD1, LD2, LD3, LDIR, LDPC, INC, RST : STD_LOGIC;
    signal BUS_Sel : STD_LOGIC;
    signal CMD, S0, S1 : STD_LOGIC_VECTOR(1 downto 0);
    signal ZR0, ZR1, ZR2, ZR3 : STD_LOGIC;
    signal ZR : STD_LOGIC_VECTOR(3 downto 0);

    component Reg is
        Port ( CLK, LD : in STD_LOGIC;
               RIN : in STD_LOGIC_VECTOR (6 downto 0);
			   ZR : out std_logic;
               ROUT : out STD_LOGIC_VECTOR (6 downto 0));
    end component;

    component PC is
        Port ( CLK, LD, INC, CLR : in std_logic;
               RIN : in STD_LOGIC_VECTOR (6 downto 0);
               ROUT : out STD_LOGIC_VECTOR (6 downto 0));
    end component;

    component IR is
        Port ( CLK, LD : in STD_LOGIC;
               RIN : in STD_LOGIC_VECTOR (6 downto 0);
               ROUT : out STD_LOGIC_VECTOR (6 downto 0));
    end component;

    component ALU is
        Port ( IN1, IN2 : in STD_LOGIC_VECTOR (6 downto 0);
               CMD : in STD_LOGIC_VECTOR (1 downto 0);
               Result : out STD_LOGIC_VECTOR (6 downto 0));
    end component;

    component MUX2x1 is
        Port ( I0, I1 : in STD_LOGIC_VECTOR (6 downto 0);
               S : in STD_LOGIC;
               output : out STD_LOGIC_VECTOR (6 downto 0));
    end component;

    component MUX4x1 is
        Port ( I0, I1, I2, I3 : in STD_LOGIC_VECTOR (6 downto 0);
               S0, S1 : in STD_LOGIC;
               output : out STD_LOGIC_VECTOR (6 downto 0));
    end component;

    component Memory is
        Port ( Address : in STD_LOGIC_VECTOR (6 downto 0);
               Data : out STD_LOGIC_VECTOR (6 downto 0));
    end component;

    component control_unit is
        Port ( 	CLK: in std_logic;
		 		reset: in std_logic;
				ZR0, ZR1, ZR2, ZR3: in std_logic;
				ROUTIR :in std_logic_vector(6 downto 0):="0000000";
		 		LD0, LD1, LD2, LD3, LDIR, LDPC, INC, BUS_Sel: out std_logic;
		    	CMD, Sel0, Sel1: out std_logic_vector(1 downto 0));
    end component;

begin
    R0: Reg port map (CLK, LD0, RIN, ZR0, ROUT0);
    R1: Reg port map (CLK, LD1, RIN, ZR1, ROUT1);
    R2: Reg port map (CLK, LD2, RIN, ZR2, ROUT2);
    R3: Reg port map (CLK, LD3, RIN, ZR3, ROUT3);

    ProgramCounter: PC port map (CLK, LDPC, INC, RST, RIN, PC_OUT);
    InsReg: IR port map (CLK, LDIR, RIN, ROUTIR);

    MUX0: MUX4x1 port map (ROUT0, ROUT1, ROUT2, ROUT3, S0(0), S0(1), MUXOUT0);
    MUX1: MUX4x1 port map (ROUT0, ROUT1, ROUT2, ROUT3, S1(0), S1(1), MUXOUT1);
	
	cal: ALU port map (MUXOUT0, MUXOUT1, CMD, ALURes);
	
    BUS_MUX: MUX2x1 port map (MData, ALURes, BUS_Sel, BUSout);

    CU: control_unit port map (CLK, RESET, ZR0, ZR1, ZR2, ZR3, ROUTIR, LD0, LD1, LD2, LD3, LDIR, LDPC, INC, BUS_Sel, CMD, S0, S1);

    MEM: Memory port map (PC_OUT, MData);

    RIN <= BUSout;

    R0out<= ROUT0;
	R1out<= ROUT1; 
	R2out<= ROUT2;	
	R3out<= ROUT3;

end Behavioral;
