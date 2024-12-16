library IEEE;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
use IEEE.NUMERIC_STD.ALL;
use IEEE.STD_LOGIC_1164.all;

entity control_unit is  
	PORT(	CLK: in std_logic;
		 	reset: in std_logic;
			ROUTIR :in std_logic_vector(6 downto 0):="0000000";
			ZR0, ZR1, ZR2, ZR3: in std_logic;
		 	LD0, LD1, LD2, LD3, LDPC, LDIR, INC, BUS_Sel: out std_logic;
		    CMD, Sel0, Sel1: out std_logic_vector(1 downto 0));

end control_unit;


architecture control_unit of control_unit is	  
type state is (S0, S1, D, S2, S3, S4, S5, S6, S7, S8);
Signal ZR : std_logic_vector(3 downto 0); 
Signal pr_state: state;
signal x : std_logic_vector(1 downto 0) ;
signal Reg_num : integer;
signal y : std_logic_vector(2 downto 0) ;
begin
	x <= ROUTIR(3 downto 2); --Reg source
	Reg_num <= to_integer(unsigned(x));
	y <= ROUTIR(6 downto 4); --op code
	ZR(0) <= ZR0;
	ZR(1) <= ZR1;
	ZR(2) <= ZR2;
	ZR(3) <= ZR3; 
	process(CLK, reset)
	begin
	   if( reset = '1') then
			pr_state <= S0;
			LDIR <='0';
			INC <= '0';
			LD0 <= '0';
			LD1 <= '0';
			LD2 <= '0';
			LD3 <= '0';	
			BUS_Sel <= '0';
			
	   elsif rising_edge(CLK) then	   
			Case pr_state is 
			When S0 => 
				pr_state <= S1;
		        LDPC <='0';
			    LD0 <= '0';
			    LD1 <= '0'; 
			    LD2 <= '0';
			    LD3 <= '0';
				INC <= '1'; --	PC <- PC+1
			    LDIR <= '1'; --IR <- M[PC]
				BUS_Sel <= '0'; --Rx <- M[PC]
		    When S1 =>
				pr_state <= D;
				INC <= '0';	
			    LDIR <= '0';
			when D =>
				if( ROUTIR = "1111111")then -- hlt 
					pr_state <= S2;
				else
					if(y = "000")then
						pr_state <= S3; -- Load
					elsif(y = "001")then
						pr_state <= S4; -- Add
					elsif(y = "010")then
						pr_state <= S5;	-- Sub
					elsif(y = "100")then
						pr_state <= S8; -- Multiply
					else
						if( ZR(Reg_num) = '0' )then
							pr_state <= S7;	-- Rx is (0) -> next address
						else
							pr_state <= S6;	-- Rx is not (0) -> jump
						end if;
					end if;
				end if;
				
			when S2 =>
				pr_state <= S2;-- hlt
			
			when S3 =>	-- Load
				if(x = "00")then --Load R0
					LD0 <= '1';
				elsif(x = "01")then --Load R1
					LD1 <= '1';
				elsif(x = "10")then --Load R2
					LD2 <= '1';
				elsif(x = "11")then --Load R3
					LD3 <= '1';
				end if;
				INC <= '1'; --PC <- PC+1
				BUS_Sel <= '0'; --Rx <- M[PC]
				pr_state <= S0;
				
			when S4 => -- Add
			
				if(x = "00")then --Load R0
					LD0 <= '1';
				elsif(x = "01")then --Load R1
					LD1 <= '1';
				elsif(x = "10")then --Load R2
					LD2 <= '1';
				elsif(x = "11")then --Load R3
					LD3 <= '1';
				end if;
				
				Sel0 <= x;--Reg source
				Sel1 <= ROUTIR(3 downto 2); --Reg destination
				CMD <= "00";
				BUS_Sel <= '1';--Rx <- ALURes
				pr_state <= S0;
				
			when S5 => -- Sub
			
				if(x = "00")then --Load R0
					LD0 <= '1';
				elsif(x = "01")then --Load R1
					LD1 <= '1';
				elsif(x = "10")then --Load R2
					LD2 <= '1';
				elsif(x = "11")then --Load R3
					LD3 <= '1';
				end if;
				
				Sel0 <= x;--Reg source
				Sel1 <= ROUTIR(3 downto 2); --Reg destination
				
				CMD <= "01";
				BUS_Sel <= '1';--Rx <- ALURes
				pr_state <= S0;
			
			when S6 =>
				LDPC <= '1';
				BUS_Sel <= '0'; -- Rx <- M[PC]
				pr_state <= S0;
				
			when S7 =>
				INC <= '1';-- PC <- PC+1
				pr_state <= S0;
				
			when S8 => -- multipy
				if(x = "00")then -- Load R0
					LD0 <= '1';
				elsif(x = "01")then -- Load R1
					LD1 <= '1';
				elsif(x = "10")then -- Load R2
					LD2 <= '1';
				elsif(x = "11")then -- Load R3
					LD3 <= '1';
				end if;
				
				Sel0 <= x; -- Reg source
				Sel1 <= ROUTIR(3 downto 2); -- Reg destination
				
				CMD <= "10";
				BUS_Sel <= '1';--Rx <- ALURes
				
				pr_state <= S0;
			end case;
		end if;
	end process;

end control_unit;
