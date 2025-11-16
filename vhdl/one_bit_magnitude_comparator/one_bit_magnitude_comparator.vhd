----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    22:08:35 04/17/2023 
-- Design Name: 
-- Module Name:    bit2Comp - Behavioral 
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
use IEEE.STD_LOGIC_UNSIGNED.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity bit2Comp is
	Port ( A,B : STD_LOGIC ;
		H,L,E : out STD_LOGIC) ;
end bit2Comp;

architecture Behavioral of bit2Comp is

begin
		
	H <= '1' when a<b else '0';
	L <= '1' when a>b else '0';
	E <= '1' when a=b else '0';
	
			

end Behavioral;

