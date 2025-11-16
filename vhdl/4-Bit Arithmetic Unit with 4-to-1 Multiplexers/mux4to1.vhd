----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    22:28:46 06/16/2023 
-- Design Name: 
-- Module Name:    mux4to1 - Behavioral 
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

entity mux4to1 is
  Port ( s0 : in  STD_LOGIC ;
           s1 : in  STD_LOGIC;
			  i0 : in  STD_LOGIC;
			  i1 : in  STD_LOGIC;
			  i2 : in  STD_LOGIC;
           i3 : in  STD_LOGIC;
           y : out  STD_LOGIC);
end mux4to1;

architecture Behavioral of mux4to1 is

begin

	process(s0,s1,i0,i1,i2,i3)

	begin
	if(s0 = '0' and s1 = '0')then y<=i0;
	elsif(s0 = '1' and s1 = '0')then y<=i1;
	elsif(s0 = '0' and s1 = '1')then y<=i2;
	else y<=i3;
	end if;
	end process;

end Behavioral;

