library IEEE;
use IEEE.numeric_std.all;
use IEEE.STD_LOGIC_1164.all;

entity Memory is
	PORT( address : in std_logic_vector( 6 downto 0);
		  Data : out std_logic_vector( 6 downto 0));
end Memory;

architecture Memory of Memory is   
type ROM is array ( 127 downto 0) of std_logic_vector(6 downto 0);
Signal instruction : ROM;
begin
	--part 1: add 7 with 4
	-- instruction(0) <= "0000000" ;-- load R0
	-- instruction(1) <= "0000111" ;-- 07
	-- instruction(2) <= "0000100" ;-- load R1
	-- instruction(3) <= "0000100" ;-- 04	
	-- instruction(4) <= "0010001" ;-- Add 
	-- instruction(5) <= "1111111" ; 	 
	
	
	--part 2: multiplying 8 by 6 with software focus
	instruction(0) <= "0000000" ;-- load R0
	instruction(1) <= "0001000" ;-- 8
	instruction(2) <= "0000100" ;-- load R1
	instruction(3) <= "0000110" ;-- 6
	instruction(4) <= "0001000" ;-- load R2
	instruction(5) <= "0000000" ;-- 0 
	instruction(6) <= "0001100" ;-- load R3
	instruction(7) <= "0000001" ;-- 1
		
	instruction(8) <= "0110100" ;-- JNZ checks if R1 is (0)
	instruction(9) <= "0001011" ;-- if R1 is not (0) jump to instruction 11
	
	instruction(10) <= "1111111" ;-- else R1 is initiated with (0) then hlt 
		
	instruction(11) <= "0011000" ;-- Add R0 (8) to R2 (initially 0) 
	instruction(12) <= "0100111" ;-- Sub subtracts (1) from R1 (initially 6)
	instruction(13) <= "0110100" ;-- JNZ checks if R1 is zero 
	instruction(14) <= "0001011" ;-- if R1 is not (0) jump to instruction 11
	instruction(15) <= "0111111" ;-- else R1 is (0) then hlt 
	
	--part 3: multiplying 8 by 6 with hardware focus
	-- instruction(0) <= "0001000" ;-- load R2
	-- instruction(1) <= "0001000" ;-- 8
	-- instruction(2) <= "0001100" ;-- load R3
	-- instruction(3) <= "0000110" ;-- 6
	-- instruction(4) <= "1001110" ;-- mulultiple
	-- instruction(5) <= "1111111" ;  
	
	Data <= instruction(to_integer(unsigned(address)));	

end Memory;
