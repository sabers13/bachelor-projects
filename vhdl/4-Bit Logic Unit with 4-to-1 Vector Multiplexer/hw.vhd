----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    04:32:40 06/17/2023 
-- Design Name: 
-- Module Name:    hw - Behavioral 
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

entity hw is
    Port ( a : in  STD_LOGIC_VECTOR (0 downto 3);
           b : in  STD_LOGIC_VECTOR (0 downto 3);
           s : in  STD_LOGIC_VECTOR (0 downto 1);
           e : out  STD_LOGIC_VECTOR (0 downto 3));
end hw;

architecture Behavioral of hw is

component mux is
 Port ( i1 : in  STD_LOGIC_VECTOR (0 downto 3);
           i2 : in  STD_LOGIC_VECTOR (0 downto 3);
			  i3 : in  STD_LOGIC_VECTOR (0 downto 3);
			  i4 : in  STD_LOGIC_VECTOR (0 downto 3);
           s : in  STD_LOGIC_VECTOR (0 downto 1);
           y : out  STD_LOGIC_VECTOR (0 downto 3));
end component;


begin

mux0: mux port map(a and b,a or b,a xor b,not a,s,e);

end Behavioral;

