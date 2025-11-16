----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    07:20:13 05/09/2023 
-- Design Name: 
-- Module Name:    subadder - Behavioral 
-- Project Name: 
-- Target Devices: 
-- Tool versions: 
-- Description: 
--
-- Dependencies: 
--
-- Revision: 
-- Revision 0.01 - File Created
-- Additional Comments: 
--
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity subadder is
    Port ( A0,A1,A2,A3,B0,B1,B2,B3,OP : in  STD_LOGIC;
           R0,R1,R2,R3,overflow,Cout : out  STD_LOGIC);
end subadder;

architecture Behavioral of subadder is
component fulladder is
	port( A,B,OP: in std_logic;
		R,C: out std_logic);
end component;
signal C1,C2,C3,C4,ab0,ab1,ab2,ab3: std_logic;


begin

ab0<= A0 xor B0;
ab1<= A1 xor B1;
ab2<= A2 xor B2;
ab3<= A3 xor B3;
FA0: fulladder port map(A0,ab0,OP,R0,C1);
FA1: fulladder port map(A1,ab1,C1,R1,C2);
FA2: fulladder port map(A2,ab2,C2,R2,C3);
FA3: fulladder port map(A3,ab3,C3,R3,C4);
overflow<= C3 xor C4;
Cout<= C4;


end Behavioral;

