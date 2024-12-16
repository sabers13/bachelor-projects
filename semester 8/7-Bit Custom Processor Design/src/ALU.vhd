library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.NUMERIC_STD.ALL;

entity ALU is
    Port ( IN1, IN2 : in STD_LOGIC_VECTOR (6 downto 0);
           CMD : in STD_LOGIC_VECTOR (1 downto 0);
           Result : out STD_LOGIC_VECTOR (6 downto 0));
end ALU;

architecture Behavioral of ALU is
begin
    process(IN1, IN2, CMD)
		variable res : std_logic_vector(13 downto 0);
		variable temp : std_logic_vector(13 downto 0);
		variable in1_ext : std_logic_vector(13 downto 0);
        variable in2_ext : std_logic_vector(13 downto 0);
    begin
		res := (others => '0');
		in1_ext := std_logic_vector(resize(unsigned(IN1), 14)); -- Extend IN1 to 14 bits
        in2_ext := std_logic_vector(resize(unsigned(IN2), 14)); -- Extend IN2 to 14 bits
        case CMD is
            when "00" => res := std_logic_vector((unsigned(in1_ext) + unsigned(in2_ext)) );
            when "01" => res := std_logic_vector((unsigned(in1_ext) - unsigned(in2_ext)) );
            when "10" => -- shift and add multiplication
                for i in 0 to 6 loop
                    if IN1(i) = '1' then
                        temp := std_logic_vector(shift_left(unsigned(in2_ext) , i));
                        res := std_logic_vector(unsigned(res) + unsigned(temp));
                    end if;
                end loop;
			when others => res := (others => '0');
        end case;
	Result <= std_logic_vector(res(6 downto 0)); -- Taking lower 7 bits of the result;
	end process;
end Behavioral;
