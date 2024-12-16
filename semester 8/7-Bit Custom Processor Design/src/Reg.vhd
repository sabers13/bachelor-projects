library IEEE;
use IEEE.STD_LOGIC_1164.all;

entity Reg is 
	PORT(	RIN : in STD_LOGIC_VECTOR(6 downto 0); 	
			ROUT : out STD_LOGIC_VECTOR(6 downto 0);
			CLK, LD : in std_logic;
			ZR : out std_logic);
end Reg;

architecture Behavioral of Reg is	 
signal res : std_logic_vector(6 downto 0) := "0000000";
begin
	process(CLK)
	begin
		if rising_edge(CLK) then
			if(LD = '1')then
				res <= RIN;
			end if;
		end if;
	end process;  
	process(res)
		begin
		   if(res = "0000000")then
			   ZR <= '1';
		   else
			   ZR <= '0' ;
		   end if;		   
	end process;
	ROUT <= res;
end Behavioral;
