library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity MUX4x1 is
    Port ( I0, I1, I2, I3 : in STD_LOGIC_VECTOR (6 downto 0);
           S1, S0 : in STD_LOGIC;
           output : out STD_LOGIC_VECTOR (6 downto 0));
end MUX4x1;

architecture Behavioral of MUX4x1 is
signal S : STD_LOGIC_VECTOR(1 downto 0);
begin
	S <= S1 & S0;
    process(I0, I1, I2, I3, S1, S0)
    begin
        case S is
            when "00" =>
                output <= I0;
            when "01" =>
                output <= I1;
            when "10" =>
                output <= I2;
            when "11" =>
                output <= I3;
            when others =>
                output <= (others => '0');
        end case;
    end process;
end Behavioral;
