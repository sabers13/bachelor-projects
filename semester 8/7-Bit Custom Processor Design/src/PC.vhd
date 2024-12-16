library IEEE;
use IEEE.STD_LOGIC_1164.all;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity PC is  
	PORT( 	RIN : in std_logic_vector(6 downto 0);
			ROUT : out std_Logic_vector(6 downto 0);
		   	CLK, LD, INC, CLR : in std_logic);
end PC;

architecture Behavioral of PC is
signal res : std_logic_vector(6 downto 0) := "0000000";
begin
	Process(CLR,CLK)
	 variable inBUS : std_logic_vector(6 downto 0) ;
	 begin
		if( CLR = '1') then	 
			inBUS := "0000000";  
		elsif rising_edge(CLK) then
			if( LD = '1') then
				inBUS := RIN;
			end if;
			if ( INC = '1') then
				inBUS := inBUS + 1;
			end if;
		end if;
		res <= inBUS;
	end process; 
	ROUT <= res;
end Behavioral;
