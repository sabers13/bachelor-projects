--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   22:37:25 04/17/2023
-- Design Name:   
-- Module Name:   C:/Users/vboxuser/Desktop/New folder/lc4/bit2Comp_TB.vhd
-- Project Name:  lc4
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: bit2Comp
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
 
ENTITY bit2Comp_TB IS
END bit2Comp_TB;
 
ARCHITECTURE behavior OF bit2Comp_TB IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT bit2Comp
    PORT(
         A : IN  std_logic;
         B : IN  std_logic;
         H : OUT  std_logic;
         L : OUT  std_logic;
         E : OUT  std_logic
        );
    END COMPONENT;
    

   --Inputs
   signal A : std_logic := '0';
   signal B : std_logic := '0';

 	--Outputs
   signal H : std_logic;
   signal L : std_logic;
   signal E : std_logic;
   -- No clocks detected in port list. Replace <clock> below with 
   -- appropriate port name 
 
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: bit2Comp PORT MAP (
          A => A,
          B => B,
          H => H,
          L => L,
          E => E
        );

 

   -- Stimulus process
   stim_proc: process
   begin	
		A<='0';
		B<='0';
		wait for 100ns;
		A<='1';
		B<='0';
		wait for 100ns;
		A<='0';
		B<='1';
		wait for 100ns;
		A<='1';
		B<='1';
		wait for 100ns;
		

   end process;

END;
