--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   07:42:14 05/09/2023
-- Design Name:   
-- Module Name:   C:/Users/vboxuser/Desktop/New folder/addsub/fulladderTB.vhd
-- Project Name:  addsub
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: fulladder
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
 
ENTITY fulladderTB IS
END fulladderTB;
 
ARCHITECTURE behavior OF fulladderTB IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT fulladder
    PORT(
         A : IN  std_logic;
         B : IN  std_logic;
         OP : IN  std_logic;
         R : OUT  std_logic;
         C : OUT  std_logic
        );
    END COMPONENT;
    

   --Inputs
   signal A : std_logic := '0';
   signal B : std_logic := '0';
   signal OP : std_logic := '0';

 	--Outputs
   signal R : std_logic;
   signal C : std_logic;
   -- No clocks detected in port list. Replace <clock> below with 
   -- appropriate port name 
 
--   constant <clock>_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: fulladder PORT MAP (
          A => A,
          B => B,
          OP => OP,
          R => R,
          C => C
        );

   -- Stimulus process
   stim_proc: process
   begin		
      A <='0';
      B <='1';
      OP <= '0';
      wait for 100 ns;	
		 A <='1';
      B <='1';
      OP <= '0';
      wait for 100 ns;	
		 A <='1';
      B <='1';
      OP <= '1';
      wait for 100 ns;	



      wait;
   end process;

END;
