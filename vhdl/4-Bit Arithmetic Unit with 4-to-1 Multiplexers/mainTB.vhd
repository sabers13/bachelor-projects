--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   00:06:04 06/17/2023
-- Design Name:   
-- Module Name:   C:/Users/vboxuser/Desktop/New folder/proaz/mainTB.vhd
-- Project Name:  proaz
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: main
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
 
ENTITY mainTB IS
END mainTB;
 
ARCHITECTURE behavior OF mainTB IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT main
    PORT(
         cin : IN  std_logic;
         s1 : IN  std_logic;
         s0 : IN  std_logic;
         a0 : IN  std_logic;
         a1 : IN  std_logic;
         a2 : IN  std_logic;
         a3 : IN  std_logic;
         b0 : IN  std_logic;
         b1 : IN  std_logic;
         b2 : IN  std_logic;
         b3 : IN  std_logic;
         d0 : OUT  std_logic;
         d1 : OUT  std_logic;
         d2 : OUT  std_logic;
         d3 : OUT  std_logic;
         cout : OUT  std_logic
        );
    END COMPONENT;
    

   --Inputs
   signal cin : std_logic := '0';
   signal s1 : std_logic := '0';
   signal s0 : std_logic := '0';
   signal a0 : std_logic := '0';
   signal a1 : std_logic := '0';
   signal a2 : std_logic := '0';
   signal a3 : std_logic := '0';
   signal b0 : std_logic := '0';
   signal b1 : std_logic := '0';
   signal b2 : std_logic := '0';
   signal b3 : std_logic := '0';

 	--Outputs
   signal d0 : std_logic;
   signal d1 : std_logic;
   signal d2 : std_logic;
   signal d3 : std_logic;
   signal cout : std_logic;
   -- No clocks detected in port list. Replace <clock> below with 
   -- appropriate port name 

 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: main PORT MAP (
          cin => cin,
          s1 => s1,
          s0 => s0,
          a0 => a0,
          a1 => a1,
          a2 => a2,
          a3 => a3,
          b0 => b0,
          b1 => b1,
          b2 => b2,
          b3 => b3,
          d0 => d0,
          d1 => d1,
          d2 => d2,
          d3 => d3,
          cout => cout
        );

  
 

   -- Stimulus process
   stim_proc: process
   begin		
      s0 <= '0';
      s1 <= '0';
		cin <= '0';
		a0 <= '0';
		a1 <= '1';
      a2 <= '1';
      a3 <= '0';
      b0 <= '1';
      b1 <= '0';
		b2 <= '1';
		b3 <= '0';
		
      wait for 100 ns;
		
		s0 <= '1';
      s1 <= '0';
		cin <= '0';
		a0 <= '0';
		a1 <= '1';
      a2 <= '1';
      a3 <= '0';
      b0 <= '1';
      b1 <= '0';
		b2 <= '1';
		b3 <= '0';
		
      wait for 100 ns;
		s0 <= '0';
      s1 <= '1';
		cin <= '0';
		a0 <= '0';
		a1 <= '1';
      a2 <= '1';
      a3 <= '0';
      b0 <= '1';
      b1 <= '0';
		b2 <= '1';
		b3 <= '0';
		
      wait for 100 ns;
		s0 <= '1';
      s1 <= '1';
		cin <= '0';
		a0 <= '0';
		a1 <= '1';
      a2 <= '1';
      a3 <= '0';
      b0 <= '1';
      b1 <= '0';
		b2 <= '1';
		b3 <= '0';
		
      wait for 100 ns;
	   s0 <= '0';
      s1 <= '0';
		cin <= '1';
		a0 <= '0';
		a1 <= '1';
      a2 <= '1';
      a3 <= '0';
      b0 <= '1';
      b1 <= '0';
		b2 <= '1';
		b3 <= '0';
		
      wait for 100 ns;
		
		s0 <= '1';
      s1 <= '0';
		cin <= '1';
		a0 <= '0';
		a1 <= '1';
      a2 <= '1';
      a3 <= '0';
      b0 <= '1';
      b1 <= '0';
		b2 <= '1';
		b3 <= '0';
		
      wait for 100 ns;
		s0 <= '0';
      s1 <= '1';
		cin <= '1';
		a0 <= '0';
		a1 <= '1';
      a2 <= '1';
      a3 <= '0';
      b0 <= '1';
      b1 <= '0';
		b2 <= '1';
		b3 <= '0';
		
      wait for 100 ns;
		s0 <= '1';
      s1 <= '1';
		cin <= '1';
		a0 <= '0';
		a1 <= '1';
      a2 <= '1';
      a3 <= '0';
      b0 <= '1';
      b1 <= '0';
		b2 <= '1';
		b3 <= '0';
		
      wait for 100 ns;
		
      wait;
   end process;

END;
