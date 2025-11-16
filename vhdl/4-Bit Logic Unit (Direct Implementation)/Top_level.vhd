----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    05:01:38 06/17/2023 
-- Design Name: 
-- Module Name:    azhw - Behavioral 
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

entity azhw is
    Port ( a : in  STD_LOGIC_VECTOR (0 downto 3);
           b : in  STD_LOGIC_VECTOR (0 downto 3);
           s : in  STD_LOGIC_VECTOR (0 downto 1);
           e : out  STD_LOGIC_VECTOR (0 downto 3));
end azhw;

architecture Behavioral of azhw is

begin


process(s,a,b)

	begin
	if(s = "00")then e<= a and b;
	elsif(s = "01")then e<= a or b;
	elsif(s = "10")then e<= a xor b;
	else e<= not a;
	end if;
	end process;




end Behavioral;

