----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    06:54:41 05/09/2023 
-- Design Name: 
-- Module Name:    mux4x1 - Behavioral 
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

entity mux4x1 is
    Port ( i0,i1,i2,i3,s0,s1 : in  STD_LOGIC;
           y : out  STD_LOGIC);
end mux4x1;

architecture Behavioral of mux4x1 is
component mux2x1
	 Port ( i0,i1,s : in  STD_LOGIC;
           y : out  STD_LOGIC);
end component;
signal y0,y1: std_logic;
begin

m1: mux2x1 port map(i0,i1,s0,y0);
m2: mux2x1 port map(i2,i3,s0,y1);
m3: mux2x1 port map(y0,y1,s1,y);


end Behavioral;

