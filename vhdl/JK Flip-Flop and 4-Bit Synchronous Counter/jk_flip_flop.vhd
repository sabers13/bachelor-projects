----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    05:25:44 05/09/2023 
-- Design Name: 
-- Module Name:    jkff - Behavioral 
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

entity jkff is
	port( j,k,clk,pr,clr : in std_logic;
		q,qnot : out std_logic);
end jkff;

architecture Behavioral of jkff is
signal answer : std_logic;

begin
	process(clk,clr,pr)
	begin
		if(clr='1') then
			answer <= '0';
		elsif(pr='1') then
			answer <= '1';
		elsif rising_edge(clk) then
			if(j='0' and k='0') then
				answer <= answer;
			elsif(j='0' and k='1') then
				answer <= '0';
			elsif(j='1' and k='0') then
				answer <= '1';
			elsif(j='1' and k='1') then
				answer <= not(answer);
			end if;
		end if;
	end process;
	q <= answer;
	qnot <= not(answer);
			

			


end Behavioral;

