library IEEE;
use IEEE.STD_LOGIC_1164.all;

entity IR is  
	PORT(	RIN : in STD_LOGIC_VECTOR(6 downto 0);
			ROUT : out STD_LOGIC_VECTOR(6 downto 0);
			CLK, LD : in std_logic);
end IR;

architecture Behavioral of IR is 
signal res : std_logic_vector(6 downto 0);
begin
	Process(CLK)
	begin 	
 		if rising_edge(CLK) then
			if(LD = '1')then
				res <= RIN;
			end if;
		end if;	 	
	end process;
	ROUT <= res;
end Behavioral;
