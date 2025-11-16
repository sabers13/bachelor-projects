--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   00:03:08 04/18/2023
-- Design Name:   
-- Module Name:   C:/Users/vboxuser/Desktop/New folder/lc3/lc3_TB.vhd
-- Project Name:  lc3
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: lc3
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
 
ENTITY lc3_TB IS
END lc3_TB;
 
ARCHITECTURE behavior OF lc3_TB IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT lc3
    PORT(
         A : IN  std_logic;
         B : IN  std_logic;
         Bi : IN  std_logic;
         D : OUT  std_logic;
         Bo : OUT  std_logic
        );
    END COMPONENT;
    

   --Inputs
   signal A : std_logic := '0';
   signal B : std_logic := '0';
   signal Bi : std_logic := '0';

 	--Outputs
   signal D : std_logic;
   signal Bo : std_logic;
   -- No clocks detected in port list. Replace <clock> below with 
   -- appropriate port name 
 

 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: lc3 PORT MAP (
          A => A,
          B => B,
          Bi => Bi,
          D => D,
          Bo => Bo
        );



   -- Stimulus process
   stim_proc: process
   begin		
	
	A <= '0';
	B <= '0';
	Bi <= '0';
	wait for 100ns;
	A <= '1';
	B <= '0';
	Bi <= '0';
	wait for 100ns;
	A <= '0';
	B <= '1';
	Bi <= '0';
	wait for 100ns;
	A <= '1';
	B <= '1';
	Bi <= '0';
	wait for 100ns;
	A <= '0';
	B <= '0';
	Bi <= '1';
	wait for 100ns;
	A <= '1';
	B <= '0';
	Bi <= '1';
	wait for 100ns;
	A <= '0';
	B <= '1';
	Bi <= '1';
	wait for 100ns;
	A <= '1';
	B <= '1';
	Bi <= '1';
	wait for 100ns;

   end process;

END;
