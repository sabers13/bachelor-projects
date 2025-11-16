--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   05:06:56 06/17/2023
-- Design Name:   
-- Module Name:   C:/Users/vboxuser/Desktop/New folder/azhwfinal/hwtb.vhd
-- Project Name:  azhwfinal
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: azhw
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
 
ENTITY hwtb IS
END hwtb;
 
ARCHITECTURE behavior OF hwtb IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT azhw
    PORT(
         a : IN  std_logic_vector(0 to 3);
         b : IN  std_logic_vector(0 to 3);
         s : IN  std_logic_vector(0 to 1);
         e : OUT  std_logic_vector(0 to 3)
        );
    END COMPONENT;
    

   --Inputs
   signal a : std_logic_vector(0 to 3) := (others => '0');
   signal b : std_logic_vector(0 to 3) := (others => '0');
   signal s : std_logic_vector(0 to 1) := (others => '0');

 	--Outputs
   signal e : std_logic_vector(0 to 3);
   -- No clocks detected in port list. Replace <clock> below with 
   -- appropriate port name 

 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: azhw PORT MAP (
          a => a,
          b => b,
          s => s,
          e => e
        );


 

   -- Stimulus process
   stim_proc: process
   begin		
      s <= "00";
		a <= "0101";
		b <= "1010";
      wait for 100 ns;	

   
   end process;

END;
