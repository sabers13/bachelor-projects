--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   05:43:38 05/09/2023
-- Design Name:   
-- Module Name:   C:/Users/vboxuser/Desktop/New folder/lc6.1/jkTB.vhd
-- Project Name:  lc6.1
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: jkff
-- 
-- Dependencies:
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
--
-- Notes: 
-- This testbench has been automatically generated using types std_logic and
-- std_logic_vector for the ports of the unit under test.  Xilinx recommends
-- that these types always be used for the top-level I/O of a design in order
-- to guarantee that the testbench will bind correctly to the post-implementation 
-- simulation model.
--------------------------------------------------------------------------------
LIBRARY ieee;
USE ieee.std_logic_1164.ALL;
 
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--USE ieee.numeric_std.ALL;
 
ENTITY jkTB IS
END jkTB;
 
ARCHITECTURE behavior OF jkTB IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT jkff
    PORT(
         j : IN  std_logic;
         k : IN  std_logic;
         clk : IN  std_logic;
         pr : IN  std_logic;
         clr : IN  std_logic;
         q : OUT  std_logic;
         qnot : OUT  std_logic
        );
    END COMPONENT;
    

   --Inputs
   signal j : std_logic := '0';
   signal k : std_logic := '0';
   signal clk : std_logic := '0';
   signal pr : std_logic := '0';
   signal clr : std_logic := '0';

 	--Outputs
   signal q : std_logic;
   signal qnot : std_logic;

   -- Clock period definitions
   constant clk_period : time := 50 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: jkff PORT MAP (
          j => j,
          k => k,
          clk => clk,
          pr => pr,
          clr => clr,
          q => q,
          qnot => qnot
        );

   -- Clock process definitions
   clk_process :process
   begin
		clk <= '0';
		wait for clk_period/2;
		clk <= '1';
		wait for clk_period/2;
   end process;
 

   -- Stimulus process
   stim_proc: process
   begin
		clr<='0';
		pr<='0';
      j<='0';
		k<='0';
      wait for 100 ns;
		j<='1';
		k<='0';
      wait for 100 ns;	
		j<='0';
		k<='1';
      wait for 100 ns;	
		j<='1';
		k<='1';
      wait for 100 ns;	
		clr<='1';
		pr<='0';
      wait for 100 ns;
		clr<='0';
		pr<='1';
      wait for 100 ns;

		

      wait for clk_period*10;

      -- insert stimulus here 

      wait;
   end process;

END;
