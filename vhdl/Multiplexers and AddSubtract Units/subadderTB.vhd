--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   07:32:44 05/09/2023
-- Design Name:   
-- Module Name:   C:/Users/vboxuser/Desktop/New folder/addsub/subadderTB.vhd
-- Project Name:  addsub
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: subadder
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
 
ENTITY subadderTB IS
END subadderTB;
 
ARCHITECTURE behavior OF subadderTB IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT subadder
    PORT(
         A0 : IN  std_logic;
         A1 : IN  std_logic;
         A2 : IN  std_logic;
         A3 : IN  std_logic;
         B0 : IN  std_logic;
         B1 : IN  std_logic;
         B2 : IN  std_logic;
         B3 : IN  std_logic;
         OP : IN  std_logic;
         R0 : OUT  std_logic;
         R1 : OUT  std_logic;
         R2 : OUT  std_logic;
         R3 : OUT  std_logic;
         overflow : OUT  std_logic;
         Cout : OUT  std_logic
        );
    END COMPONENT;
    

   --Inputs
   signal A0 : std_logic := '0';
   signal A1 : std_logic := '0';
   signal A2 : std_logic := '0';
   signal A3 : std_logic := '0';
   signal B0 : std_logic := '0';
   signal B1 : std_logic := '0';
   signal B2 : std_logic := '0';
   signal B3 : std_logic := '0';
   signal OP : std_logic := '0';

 	--Outputs
   signal R0 : std_logic;
   signal R1 : std_logic;
   signal R2 : std_logic;
   signal R3 : std_logic;
   signal overflow : std_logic;
   signal Cout : std_logic;
   -- No clocks detected in port list. Replace <clock> below with 
   -- appropriate port name 
 
  -- constant <clock>_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: subadder PORT MAP (
          A0 => A0,
          A1 => A1,
          A2 => A2,
          A3 => A3,
          B0 => B0,
          B1 => B1,
          B2 => B2,
          B3 => B3,
          OP => OP,
          R0 => R0,
          R1 => R1,
          R2 => R2,
          R3 => R3,
          overflow => overflow,
          Cout => Cout
        );


   -- Stimulus process
   stim_proc: process
   begin		
      A0 <= '1';
      A1 <= '0';
      A2 <= '0';
      A3 <= '0';
      B0 <= '1';
      B1 <= '0';
		B2 <= '0';
		B3 <= '0';
		OP <= '0';
      wait for 100 ns;	
		A0 <= '1';
      A1 <= '0';
      A2 <= '0';
      A3 <= '0';
      B0 <= '1';
      B1 <= '0';
		B2 <= '0';
		B3 <= '0';
		OP <= '1';
      wait for 100 ns;	
		A0 <= '1';
      A1 <= '0';
      A2 <= '1';
      A3 <= '0';
      B0 <= '1';
      B1 <= '0';
		B2 <= '1';
		B3 <= '0';
		OP <= '1';
      wait for 100 ns;	
		A0 <= '1';
      A1 <= '0';
      A2 <= '1';
      A3 <= '0';
      B0 <= '1';
      B1 <= '0';
		B2 <= '0';
		B3 <= '0';
		OP <= '1';
      wait for 100 ns;	
		A0 <= '1';
      A1 <= '0';
      A2 <= '0';
      A3 <= '0';
      B0 <= '1';
      B1 <= '1';
		B2 <= '1';
		B3 <= '0';
		OP <= '0';
      wait for 100 ns;	
		A0 <= '1';
      A1 <= '1';
      A2 <= '1';
      A3 <= '1';
      B0 <= '1';
      B1 <= '1';
		B2 <= '1';
		B3 <= '1';
		OP <= '0';
      wait for 100 ns;	
		A0 <= '1';
      A1 <= '0';
      A2 <= '0';
      A3 <= '0';
      B0 <= '1';
      B1 <= '0';
		B2 <= '1';
		B3 <= '0';
		OP <= '1';
      wait for 100 ns;	

      wait;
   end process;

END;
