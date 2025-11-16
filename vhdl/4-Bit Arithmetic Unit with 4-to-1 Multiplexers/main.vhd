----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    22:26:38 06/16/2023 
-- Design Name: 
-- Module Name:    main - Behavioral 
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

entity main is
    Port ( cin : in  STD_LOGIC;
           s1 : in  STD_LOGIC;
           s0 : in  STD_LOGIC;
           a0 : in  STD_LOGIC;
           a1 : in  STD_LOGIC;
           a2 : in  STD_LOGIC;
           a3 : in  STD_LOGIC;
			  b0 : in  STD_LOGIC;
           b1 : in  STD_LOGIC;
           b2 : in  STD_LOGIC;
           b3 : in  STD_LOGIC;
           d0 : out  STD_LOGIC;
           d1 : out  STD_LOGIC;
           d2 : out  STD_LOGIC;
           d3 : out  STD_LOGIC;
           cout : out  STD_LOGIC);
end main;

architecture Behavioral of main is

component fulladder is
	port( A,B,OP: in std_logic;
		R,C: out std_logic);
end component;


component mux4to1 is
Port ( s0 : in  STD_LOGIC;
           s1 : in  STD_LOGIC;
           i0 : in  STD_LOGIC;
           i1 : in  STD_LOGIC;
           i2 : in  STD_LOGIC;
           i3 : in  STD_LOGIC;
           y : out  STD_LOGIC);
end component;

signal C1,C2,C3,y0,y1,y2,y3: std_logic;




begin

mux0: mux4to1 port map(s0,s1,b0,not b0,'0','1',y0);
mux1: mux4to1 port map(s0,s1,b1,not b1,'0','1',y1);
mux2: mux4to1 port map(s0,s1,b2,not b2,'0','1',y2);
mux3: mux4to1 port map(s0,s1,b3,not b3,'0','1',y3);

FA0: fulladder port map(a0,y0,cin,d0,C1);
FA1: fulladder port map(a1,y1,C1,d1,C2);
FA2: fulladder port map(a2,y2,C2,d2,C3);
FA3: fulladder port map(a3,y3,C3,d3,Cout);


end Behavioral;

