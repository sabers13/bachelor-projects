----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    00:29:20 05/09/2023 
-- Design Name: 
-- Module Name:    counter - Behavioral 
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

entity counter is
	PORT ( clk : in std_logic;
			rst : in std_logic;
			counterO : out std_logic_vector(3 downto 0)
			);
end counter;

architecture Behavioral of counter is
signal count: std_logic_vector(3 downto 0);
begin
	process(clk)
	begin
		if(rising_edge(clk)) then
			if(rst='1') then
				count <= x"0";
			else
				count <= count + x"1";
			end if;
		end if;
	end process;
	counterO <= count;


end Behavioral;

