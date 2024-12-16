library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity MUX2x1 is
    Port ( I0, I1 : in STD_LOGIC_VECTOR (6 downto 0);
           S : in STD_LOGIC;
           output : out STD_LOGIC_VECTOR (6 downto 0));
end MUX2x1;

architecture Behavioral of MUX2x1 is
begin
    process(I0, I1, S)
    begin
        case S is
            when '0' =>
                output <= I0;
            when '1' =>
                output <= I1;
            when others =>
                output <= (others => '0');
        end case;
    end process;
end Behavioral;
