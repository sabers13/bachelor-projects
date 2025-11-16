----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    04:34:46 06/17/2023 
-- Design Name: 
-- Module Name:    mux - Behavioral 
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

entity mux is
    Port ( i1 : in  STD_LOGIC_VECTOR (0 downto 3);
           i2 : in  STD_LOGIC_VECTOR (0 downto 3);
           i3 : in  STD_LOGIC_VECTOR (0 downto 3);
           i4 : in  STD_LOGIC_VECTOR (0 downto 3);
           s : in  STD_LOGIC_VECTOR (0 downto 1);
           y : out  STD_LOGIC_VECTOR (0 downto 3));
end mux;

architecture Behavioral of mux is

begin

process(s,i1,i2,i3,i4)

	begin
	if(s = "00")then y<=i1;
	elsif(s = "01")then y<=i2;
	elsif(s = "10")then y<=i3;
	else y<=i4;
	end if;
	end process;



end Behavioral;

