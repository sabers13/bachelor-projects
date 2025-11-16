--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   07:00:03 05/09/2023
-- Design Name:   
-- Module Name:   C:/Users/vboxuser/Desktop/New folder/lc5.1/mux4x1TB.vhd
-- Project Name:  lc5.1
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: mux4x1
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
 
ENTITY mux4x1TB IS
END mux4x1TB;
 
ARCHITECTURE behavior OF mux4x1TB IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT mux4x1
    PORT(
         i0 : IN  std_logic;
         i1 : IN  std_logic;
         i2 : IN  std_logic;
         i3 : IN  std_logic;
         s0 : IN  std_logic;
         s1 : IN  std_logic;
         y : OUT  std_logic
        );
    END COMPONENT;
    

   --Inputs
   signal i0 : std_logic := '0';
   signal i1 : std_logic := '0';
   signal i2 : std_logic := '0';
   signal i3 : std_logic := '0';
   signal s0 : std_logic := '0';
   signal s1 : std_logic := '0';

 	--Outputs
   signal y : std_logic;
   -- No clocks detected in port list. Replace <clock> below with 
   -- appropriate port name 
 
  -- constant <clock>_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: mux4x1 PORT MAP (
          i0 => i0,
          i1 => i1,
          i2 => i2,
          i3 => i3,
          s0 => s0,
          s1 => s1,
          y => y
        );

  

   -- Stimulus process
   stim_proc: process
   begin		
      s0<='0';
		s1<='0';
		i0<='1';
		i1<='0';
		i2<='0';
		i3<='0';
		
      wait for 100 ns;	
		 s0<='1';
		s1<='0';
		i0<='0';
		i1<='1';
		i2<='0';
		i3<='0';
		
      wait for 100 ns;	
		 s0<='0';
		s1<='1';
		i0<='0';
		i1<='0';
		i2<='1';
		i3<='0';
		
      wait for 100 ns;	
		 s0<='1';
		s1<='1';
		i0<='0';
		i1<='0';
		i2<='0';
		i3<='1';
		
      
		

      -- insert stimulus here 

      wait;
   end process;

END;
