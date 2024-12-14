package fightergame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saber
 */
 

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class res {
    private processor processor;
    private game Game;
    public BufferedImage menuBackground;
    public BufferedImage gameBackground;
    public BufferedImage spOn;
    public BufferedImage spOff;
    
    public BufferedImage player1Agility1;
    public BufferedImage player1AgilityRun1;
    public BufferedImage player1AgilityRun2;
    public BufferedImage player1AgilityRun3;
    public BufferedImage player1AgilityRun4;
    public BufferedImage player1AgilityRun5;
    public BufferedImage player1AgilityRun6;
    public BufferedImage player1AgilityRun7;
    public BufferedImage player1AgilityRun8;
    public BufferedImage player1AgilityAttack1;
    public BufferedImage player1AgilityAttack2;
    public BufferedImage player1AgilityAttack3;
    public BufferedImage player1AgilityAttack4;
    public BufferedImage player1AgilityAttack5;
    public BufferedImage player1AgilityAttack6;
    public BufferedImage player1AgilitySpellAttack1;
    public BufferedImage player1AgilitySpellAttack2;
    public BufferedImage player1AgilitySpellAttack3;
    public BufferedImage player1AgilitySpellAttack4;
    public BufferedImage player1AgilitySpellAttack5;
    public BufferedImage player1AgilitySpellAttack6;
    public BufferedImage player1AgilityDeath1;
    public BufferedImage player1AgilityDeath2;
    public BufferedImage player1AgilityDeath3;
    public BufferedImage player1AgilityDeath4;
    public BufferedImage player1AgilityDeath5;
    public BufferedImage player1AgilityDeath6;
    
    public BufferedImage player1Intelligence1;
    public BufferedImage player1IntelligenceRun1;
    public BufferedImage player1IntelligenceRun2;
    public BufferedImage player1IntelligenceRun3;
    public BufferedImage player1IntelligenceRun4;
    public BufferedImage player1IntelligenceRun5;
    public BufferedImage player1IntelligenceRun6;
    public BufferedImage player1IntelligenceRun7;
    public BufferedImage player1IntelligenceRun8;
    public BufferedImage player1IntelligenceAttack1;
    public BufferedImage player1IntelligenceAttack2;
    public BufferedImage player1IntelligenceAttack3;
    public BufferedImage player1IntelligenceAttack4;
    public BufferedImage player1IntelligenceAttack5;
    public BufferedImage player1IntelligenceAttack6;
    public BufferedImage player1IntelligenceAttack7;
    public BufferedImage player1IntelligenceAttack8;
    public BufferedImage player1IntelligenceSpellAttack1;
    public BufferedImage player1IntelligenceSpellAttack2;
    public BufferedImage player1IntelligenceSpellAttack3;
    public BufferedImage player1IntelligenceSpellAttack4;
    public BufferedImage player1IntelligenceSpellAttack5;
    public BufferedImage player1IntelligenceSpellAttack6;
    public BufferedImage player1IntelligenceSpellAttack7;
    public BufferedImage player1IntelligenceSpellAttack8;
    public BufferedImage player1IntelligenceDeath1;
    public BufferedImage player1IntelligenceDeath2;
    public BufferedImage player1IntelligenceDeath3;
    public BufferedImage player1IntelligenceDeath4;
    public BufferedImage player1IntelligenceDeath5;
    public BufferedImage player1IntelligenceDeath6;
    public BufferedImage player1IntelligenceDeath7;
    
    public BufferedImage player1Strength1;
    public BufferedImage player1StrengthRun1;
    public BufferedImage player1StrengthRun2;
    public BufferedImage player1StrengthRun3;
    public BufferedImage player1StrengthRun4;
    public BufferedImage player1StrengthRun5;
    public BufferedImage player1StrengthRun6;
    public BufferedImage player1StrengthRun7;
    public BufferedImage player1StrengthRun8;
    public BufferedImage player1StrengthAttack1;
    public BufferedImage player1StrengthAttack2;
    public BufferedImage player1StrengthAttack3;
    public BufferedImage player1StrengthAttack4;
    public BufferedImage player1StrengthAttack5;
    public BufferedImage player1StrengthAttack6;
    public BufferedImage player1StrengthAttack7;
    public BufferedImage player1StrengthSpellAttack1;
    public BufferedImage player1StrengthSpellAttack2;
    public BufferedImage player1StrengthSpellAttack3;
    public BufferedImage player1StrengthSpellAttack4;
    public BufferedImage player1StrengthSpellAttack5;
    public BufferedImage player1StrengthSpellAttack6;
    public BufferedImage player1StrengthDeath1;
    public BufferedImage player1StrengthDeath2;
    public BufferedImage player1StrengthDeath3;
    public BufferedImage player1StrengthDeath4;
    public BufferedImage player1StrengthDeath5;
    public BufferedImage player1StrengthDeath6;
    public BufferedImage player1StrengthDeath7;
    public BufferedImage player1StrengthDeath8;
    
    public BufferedImage player2Agility1;
    public BufferedImage player2AgilityRun1;
    public BufferedImage player2AgilityRun2;
    public BufferedImage player2AgilityRun3;
    public BufferedImage player2AgilityRun4;
    public BufferedImage player2AgilityRun5;
    public BufferedImage player2AgilityRun6;
    public BufferedImage player2AgilityRun7;
    public BufferedImage player2AgilityRun8;
    public BufferedImage player2AgilityAttack1;
    public BufferedImage player2AgilityAttack2;
    public BufferedImage player2AgilityAttack3;
    public BufferedImage player2AgilityAttack4;
    public BufferedImage player2AgilityAttack5;
    public BufferedImage player2AgilityAttack6;
    public BufferedImage player2AgilitySpellAttack1;
    public BufferedImage player2AgilitySpellAttack2;
    public BufferedImage player2AgilitySpellAttack3;
    public BufferedImage player2AgilitySpellAttack4;
    public BufferedImage player2AgilitySpellAttack5;
    public BufferedImage player2AgilitySpellAttack6;
    public BufferedImage player2AgilityDeath1;
    public BufferedImage player2AgilityDeath2;
    public BufferedImage player2AgilityDeath3;
    public BufferedImage player2AgilityDeath4;
    public BufferedImage player2AgilityDeath5;
    public BufferedImage player2AgilityDeath6;
    
    public BufferedImage player2Intelligence1;
    public BufferedImage player2IntelligenceRun1;
    public BufferedImage player2IntelligenceRun2;
    public BufferedImage player2IntelligenceRun3;
    public BufferedImage player2IntelligenceRun4;
    public BufferedImage player2IntelligenceRun5;
    public BufferedImage player2IntelligenceRun6;
    public BufferedImage player2IntelligenceRun7;
    public BufferedImage player2IntelligenceRun8;
    public BufferedImage player2IntelligenceAttack1;
    public BufferedImage player2IntelligenceAttack2;
    public BufferedImage player2IntelligenceAttack3;
    public BufferedImage player2IntelligenceAttack4;
    public BufferedImage player2IntelligenceAttack5;
    public BufferedImage player2IntelligenceAttack6;
    public BufferedImage player2IntelligenceAttack7;
    public BufferedImage player2IntelligenceAttack8;
    public BufferedImage player2IntelligenceSpellAttack1;
    public BufferedImage player2IntelligenceSpellAttack2;
    public BufferedImage player2IntelligenceSpellAttack3;
    public BufferedImage player2IntelligenceSpellAttack4;
    public BufferedImage player2IntelligenceSpellAttack5;
    public BufferedImage player2IntelligenceSpellAttack6;
    public BufferedImage player2IntelligenceSpellAttack7;
    public BufferedImage player2IntelligenceSpellAttack8;
    public BufferedImage player2IntelligenceDeath1;
    public BufferedImage player2IntelligenceDeath2;
    public BufferedImage player2IntelligenceDeath3;
    public BufferedImage player2IntelligenceDeath4;
    public BufferedImage player2IntelligenceDeath5;
    public BufferedImage player2IntelligenceDeath6;
    public BufferedImage player2IntelligenceDeath7;
   
    public BufferedImage player2Strength1;
    public BufferedImage player2StrengthRun1;
    public BufferedImage player2StrengthRun2;
    public BufferedImage player2StrengthRun3;
    public BufferedImage player2StrengthRun4;
    public BufferedImage player2StrengthRun5;
    public BufferedImage player2StrengthRun6;
    public BufferedImage player2StrengthRun7;
    public BufferedImage player2StrengthRun8;
    public BufferedImage player2StrengthAttack1;
    public BufferedImage player2StrengthAttack2;
    public BufferedImage player2StrengthAttack3;
    public BufferedImage player2StrengthAttack4;
    public BufferedImage player2StrengthAttack5;
    public BufferedImage player2StrengthAttack6;
    public BufferedImage player2StrengthAttack7;
    public BufferedImage player2StrengthSpellAttack1;
    public BufferedImage player2StrengthSpellAttack2;
    public BufferedImage player2StrengthSpellAttack3;
    public BufferedImage player2StrengthSpellAttack4;
    public BufferedImage player2StrengthSpellAttack5;
    public BufferedImage player2StrengthSpellAttack6;
    public BufferedImage player2StrengthDeath1;
    public BufferedImage player2StrengthDeath2;
    public BufferedImage player2StrengthDeath3;
    public BufferedImage player2StrengthDeath4;
    public BufferedImage player2StrengthDeath5;
    public BufferedImage player2StrengthDeath6;
    public BufferedImage player2StrengthDeath7;
    public BufferedImage player2StrengthDeath8;
    
     public res() {
        
        try {
            menuBackground = ImageIO.read(getClass().getResourceAsStream("/background/menu backgroung.jpg"));
            gameBackground = ImageIO.read(getClass().getResourceAsStream("/background/Mobile - Heroes Saga - Alpine Forest.png"));
            
            spOn = ImageIO.read(getClass().getResourceAsStream("/background/spOn.png"));
            spOff = ImageIO.read(getClass().getResourceAsStream("/background/spOff.png"));
            
            player1Agility1 = ImageIO.read(getClass().getResourceAsStream("/player1/A.png"));
            player1AgilityRun1 = ImageIO.read(getClass().getResourceAsStream("/player1/Arun (1).png"));
            player1AgilityRun2 = ImageIO.read(getClass().getResourceAsStream("/player1/Arun (2).png"));
            player1AgilityRun3 = ImageIO.read(getClass().getResourceAsStream("/player1/Arun (3).png"));
            player1AgilityRun4 = ImageIO.read(getClass().getResourceAsStream("/player1/Arun (4).png"));
            player1AgilityRun5 = ImageIO.read(getClass().getResourceAsStream("/player1/Arun (5).png"));
            player1AgilityRun6 = ImageIO.read(getClass().getResourceAsStream("/player1/Arun (6).png"));
            player1AgilityRun7 = ImageIO.read(getClass().getResourceAsStream("/player1/Arun (7).png"));
            player1AgilityRun8 = ImageIO.read(getClass().getResourceAsStream("/player1/Arun (8).png"));
            
            player1AgilityAttack1 = ImageIO.read(getClass().getResourceAsStream("/player1/Aattack (1).png"));
            player1AgilityAttack2 = ImageIO.read(getClass().getResourceAsStream("/player1/Aattack (2).png"));
            player1AgilityAttack3 = ImageIO.read(getClass().getResourceAsStream("/player1/Aattack (3).png"));
            player1AgilityAttack4 = ImageIO.read(getClass().getResourceAsStream("/player1/Aattack (4).png"));
            player1AgilityAttack5 = ImageIO.read(getClass().getResourceAsStream("/player1/Aattack (5).png"));
            player1AgilityAttack6 = ImageIO.read(getClass().getResourceAsStream("/player1/Aattack (6).png"));
            
            player1AgilitySpellAttack1 = ImageIO.read(getClass().getResourceAsStream("/player1/Aattack2 (1).png"));
            player1AgilitySpellAttack2 = ImageIO.read(getClass().getResourceAsStream("/player1/Aattack2 (2).png"));
            player1AgilitySpellAttack3 = ImageIO.read(getClass().getResourceAsStream("/player1/Aattack2 (3).png"));
            player1AgilitySpellAttack4 = ImageIO.read(getClass().getResourceAsStream("/player1/Aattack2 (4).png"));
            player1AgilitySpellAttack5 = ImageIO.read(getClass().getResourceAsStream("/player1/Aattack2 (5).png"));
            player1AgilitySpellAttack6 = ImageIO.read(getClass().getResourceAsStream("/player1/Aattack2 (6).png"));
            
            player1AgilityDeath1 = ImageIO.read(getClass().getResourceAsStream("/player1/Adeath (1).png"));
            player1AgilityDeath2 = ImageIO.read(getClass().getResourceAsStream("/player1/Adeath (2).png"));
            player1AgilityDeath3 = ImageIO.read(getClass().getResourceAsStream("/player1/Adeath (3).png"));
            player1AgilityDeath4 = ImageIO.read(getClass().getResourceAsStream("/player1/Adeath (4).png"));
            player1AgilityDeath5 = ImageIO.read(getClass().getResourceAsStream("/player1/Adeath (5).png"));
            player1AgilityDeath6 = ImageIO.read(getClass().getResourceAsStream("/player1/Adeath (6).png"));
            
            
            player1Intelligence1 = ImageIO.read(getClass().getResourceAsStream("/player1/I.png"));
            player1IntelligenceRun1 = ImageIO.read(getClass().getResourceAsStream("/player1/Irun (1).png"));
            player1IntelligenceRun2 = ImageIO.read(getClass().getResourceAsStream("/player1/Irun (2).png"));
            player1IntelligenceRun3 = ImageIO.read(getClass().getResourceAsStream("/player1/Irun (3).png"));
            player1IntelligenceRun4 = ImageIO.read(getClass().getResourceAsStream("/player1/Irun (4).png"));
            player1IntelligenceRun5 = ImageIO.read(getClass().getResourceAsStream("/player1/Irun (5).png"));
            player1IntelligenceRun6 = ImageIO.read(getClass().getResourceAsStream("/player1/Irun (6).png"));
            player1IntelligenceRun7 = ImageIO.read(getClass().getResourceAsStream("/player1/Irun (7).png"));
            player1IntelligenceRun8 = ImageIO.read(getClass().getResourceAsStream("/player1/Irun (8).png"));
            
            player1IntelligenceAttack1 = ImageIO.read(getClass().getResourceAsStream("/player1/Iattack (1).png"));
            player1IntelligenceAttack2 = ImageIO.read(getClass().getResourceAsStream("/player1/Iattack (2).png"));
            player1IntelligenceAttack3 = ImageIO.read(getClass().getResourceAsStream("/player1/Iattack (3).png"));
            player1IntelligenceAttack4 = ImageIO.read(getClass().getResourceAsStream("/player1/Iattack (4).png"));
            player1IntelligenceAttack5 = ImageIO.read(getClass().getResourceAsStream("/player1/Iattack (5).png"));
            player1IntelligenceAttack6 = ImageIO.read(getClass().getResourceAsStream("/player1/Iattack (6).png"));
            player1IntelligenceAttack7 = ImageIO.read(getClass().getResourceAsStream("/player1/Iattack (7).png"));
            player1IntelligenceAttack8 = ImageIO.read(getClass().getResourceAsStream("/player1/Iattack (8).png"));
            
            player1IntelligenceSpellAttack1 = ImageIO.read(getClass().getResourceAsStream("/player1/Iattack2 1.png"));
            player1IntelligenceSpellAttack2 = ImageIO.read(getClass().getResourceAsStream("/player1/Iattack2 2.png"));
            player1IntelligenceSpellAttack3 = ImageIO.read(getClass().getResourceAsStream("/player1/Iattack2 3.png"));
            player1IntelligenceSpellAttack4 = ImageIO.read(getClass().getResourceAsStream("/player1/Iattack2 4.png"));
            player1IntelligenceSpellAttack5 = ImageIO.read(getClass().getResourceAsStream("/player1/Iattack2 5.png"));
            player1IntelligenceSpellAttack6 = ImageIO.read(getClass().getResourceAsStream("/player1/Iattack2 6.png"));
            player1IntelligenceSpellAttack7 = ImageIO.read(getClass().getResourceAsStream("/player1/Iattack2 7.png"));
            player1IntelligenceSpellAttack8 = ImageIO.read(getClass().getResourceAsStream("/player1/Iattack2 8.png"));
            
            player1IntelligenceDeath1 = ImageIO.read(getClass().getResourceAsStream("/player1/Ideath 1.png"));
            player1IntelligenceDeath2 = ImageIO.read(getClass().getResourceAsStream("/player1/Ideath 2.png"));
            player1IntelligenceDeath3 = ImageIO.read(getClass().getResourceAsStream("/player1/Ideath 3.png"));
            player1IntelligenceDeath4 = ImageIO.read(getClass().getResourceAsStream("/player1/Ideath 4.png"));
            player1IntelligenceDeath5 = ImageIO.read(getClass().getResourceAsStream("/player1/Ideath 5.png"));
            player1IntelligenceDeath6 = ImageIO.read(getClass().getResourceAsStream("/player1/Ideath 6.png"));
            player1IntelligenceDeath7 = ImageIO.read(getClass().getResourceAsStream("/player1/Ideath 7.png"));
            
           
            player1Strength1 = ImageIO.read(getClass().getResourceAsStream("/player1/S.png"));
            player1StrengthRun1 = ImageIO.read(getClass().getResourceAsStream("/player1/Srun (1).png"));
            player1StrengthRun2 = ImageIO.read(getClass().getResourceAsStream("/player1/Srun (2).png"));
            player1StrengthRun3 = ImageIO.read(getClass().getResourceAsStream("/player1/Srun (3).png"));
            player1StrengthRun4 = ImageIO.read(getClass().getResourceAsStream("/player1/Srun (4).png"));
            player1StrengthRun5 = ImageIO.read(getClass().getResourceAsStream("/player1/Srun (5).png"));
            player1StrengthRun6 = ImageIO.read(getClass().getResourceAsStream("/player1/Srun (6).png"));
            player1StrengthRun7 = ImageIO.read(getClass().getResourceAsStream("/player1/Srun (7).png"));
            player1StrengthRun8 = ImageIO.read(getClass().getResourceAsStream("/player1/Srun (8).png"));
            
            player1StrengthAttack1 = ImageIO.read(getClass().getResourceAsStream("/player1/Sattack (1).png"));
            player1StrengthAttack2 = ImageIO.read(getClass().getResourceAsStream("/player1/Sattack (2).png"));
            player1StrengthAttack3 = ImageIO.read(getClass().getResourceAsStream("/player1/Sattack (3).png"));
            player1StrengthAttack4 = ImageIO.read(getClass().getResourceAsStream("/player1/Sattack (4).png"));
            player1StrengthAttack5 = ImageIO.read(getClass().getResourceAsStream("/player1/Sattack (5).png"));
            player1StrengthAttack6 = ImageIO.read(getClass().getResourceAsStream("/player1/Sattack (6).png"));
            player1StrengthAttack7 = ImageIO.read(getClass().getResourceAsStream("/player1/Sattack (7).png"));
            
            player1StrengthSpellAttack1 = ImageIO.read(getClass().getResourceAsStream("/player1/Sattack2 (1).png"));
            player1StrengthSpellAttack2 = ImageIO.read(getClass().getResourceAsStream("/player1/Sattack2 (2).png"));
            player1StrengthSpellAttack3 = ImageIO.read(getClass().getResourceAsStream("/player1/Sattack2 (3).png"));
            player1StrengthSpellAttack4 = ImageIO.read(getClass().getResourceAsStream("/player1/Sattack2 (4).png"));
            player1StrengthSpellAttack5 = ImageIO.read(getClass().getResourceAsStream("/player1/Sattack2 (5).png"));
            player1StrengthSpellAttack6 = ImageIO.read(getClass().getResourceAsStream("/player1/Sattack2 (6).png"));
            
            player1StrengthDeath1 = ImageIO.read(getClass().getResourceAsStream("/player1/Sdeath (1).png"));
            player1StrengthDeath2 = ImageIO.read(getClass().getResourceAsStream("/player1/Sdeath (2).png"));
            player1StrengthDeath3 = ImageIO.read(getClass().getResourceAsStream("/player1/Sdeath (3).png"));
            player1StrengthDeath4 = ImageIO.read(getClass().getResourceAsStream("/player1/Sdeath (4).png"));
            player1StrengthDeath5 = ImageIO.read(getClass().getResourceAsStream("/player1/Sdeath (5).png"));
            player1StrengthDeath6 = ImageIO.read(getClass().getResourceAsStream("/player1/Sdeath (6).png"));
            player1StrengthDeath7 = ImageIO.read(getClass().getResourceAsStream("/player1/Sdeath (7).png"));
            player1StrengthDeath8 = ImageIO.read(getClass().getResourceAsStream("/player1/Sdeath (8).png"));
            
            player2Agility1 = ImageIO.read(getClass().getResourceAsStream("/player2/A.png"));
            player2AgilityRun1 = ImageIO.read(getClass().getResourceAsStream("/player2/Arun (1).png"));
            player2AgilityRun2 = ImageIO.read(getClass().getResourceAsStream("/player2/Arun (2).png"));
            player2AgilityRun3 = ImageIO.read(getClass().getResourceAsStream("/player2/Arun (3).png"));
            player2AgilityRun4 = ImageIO.read(getClass().getResourceAsStream("/player2/Arun (4).png"));
            player2AgilityRun5 = ImageIO.read(getClass().getResourceAsStream("/player2/Arun (5).png"));
            player2AgilityRun6 = ImageIO.read(getClass().getResourceAsStream("/player2/Arun (6).png"));
            player2AgilityRun7 = ImageIO.read(getClass().getResourceAsStream("/player2/Arun (7).png"));
            player2AgilityRun8 = ImageIO.read(getClass().getResourceAsStream("/player2/Arun (8).png"));
            
            player2AgilityAttack1 = ImageIO.read(getClass().getResourceAsStream("/player2/Aattack (1).png"));
            player2AgilityAttack2 = ImageIO.read(getClass().getResourceAsStream("/player2/Aattack (2).png"));
            player2AgilityAttack3 = ImageIO.read(getClass().getResourceAsStream("/player2/Aattack (3).png"));
            player2AgilityAttack4 = ImageIO.read(getClass().getResourceAsStream("/player2/Aattack (4).png"));
            player2AgilityAttack5 = ImageIO.read(getClass().getResourceAsStream("/player2/Aattack (5).png"));
            player2AgilityAttack6 = ImageIO.read(getClass().getResourceAsStream("/player2/Aattack (6).png"));
            
            player2AgilitySpellAttack1 = ImageIO.read(getClass().getResourceAsStream("/player2/Aattack2 (1).png"));
            player2AgilitySpellAttack2 = ImageIO.read(getClass().getResourceAsStream("/player2/Aattack2 (2).png"));
            player2AgilitySpellAttack3 = ImageIO.read(getClass().getResourceAsStream("/player2/Aattack2 (3).png"));
            player2AgilitySpellAttack4 = ImageIO.read(getClass().getResourceAsStream("/player2/Aattack2 (4).png"));
            player2AgilitySpellAttack5 = ImageIO.read(getClass().getResourceAsStream("/player2/Aattack2 (5).png"));
            player2AgilitySpellAttack6 = ImageIO.read(getClass().getResourceAsStream("/player2/Aattack2 (6).png"));
            
            player2AgilityDeath1 = ImageIO.read(getClass().getResourceAsStream("/player2/Adeath (1).png"));
            player2AgilityDeath2 = ImageIO.read(getClass().getResourceAsStream("/player2/Adeath (2).png"));
            player2AgilityDeath3 = ImageIO.read(getClass().getResourceAsStream("/player2/Adeath (3).png"));
            player2AgilityDeath4 = ImageIO.read(getClass().getResourceAsStream("/player2/Adeath (4).png"));
            player2AgilityDeath5 = ImageIO.read(getClass().getResourceAsStream("/player2/Adeath (5).png"));
            player2AgilityDeath6 = ImageIO.read(getClass().getResourceAsStream("/player2/Adeath (6).png"));
           
            
            player2Intelligence1 = ImageIO.read(getClass().getResourceAsStream("/player2/I.png"));
            player2IntelligenceRun1 = ImageIO.read(getClass().getResourceAsStream("/player2/Irun (1).png"));
            player2IntelligenceRun2 = ImageIO.read(getClass().getResourceAsStream("/player2/Irun (2).png"));
            player2IntelligenceRun3 = ImageIO.read(getClass().getResourceAsStream("/player2/Irun (3).png"));
            player2IntelligenceRun4 = ImageIO.read(getClass().getResourceAsStream("/player2/Irun (4).png"));
            player2IntelligenceRun5 = ImageIO.read(getClass().getResourceAsStream("/player2/Irun (5).png"));
            player2IntelligenceRun6 = ImageIO.read(getClass().getResourceAsStream("/player2/Irun (6).png"));
            player2IntelligenceRun7 = ImageIO.read(getClass().getResourceAsStream("/player2/Irun (7).png"));
            player2IntelligenceRun8 = ImageIO.read(getClass().getResourceAsStream("/player2/Irun (8).png"));
           
            player2IntelligenceAttack1 = ImageIO.read(getClass().getResourceAsStream("/player2/Iattack (1).png"));
            player2IntelligenceAttack2 = ImageIO.read(getClass().getResourceAsStream("/player2/Iattack (2).png"));
            player2IntelligenceAttack3 = ImageIO.read(getClass().getResourceAsStream("/player2/Iattack (3).png"));
            player2IntelligenceAttack4 = ImageIO.read(getClass().getResourceAsStream("/player2/Iattack (4).png"));
            player2IntelligenceAttack5 = ImageIO.read(getClass().getResourceAsStream("/player2/Iattack (5).png"));
            player2IntelligenceAttack6 = ImageIO.read(getClass().getResourceAsStream("/player2/Iattack (6).png"));
            player2IntelligenceAttack7 = ImageIO.read(getClass().getResourceAsStream("/player2/Iattack (7).png"));
            player2IntelligenceAttack8 = ImageIO.read(getClass().getResourceAsStream("/player2/Iattack (8).png"));
            
            player2IntelligenceSpellAttack1 = ImageIO.read(getClass().getResourceAsStream("/player2/Iattack2 1.png"));
            player2IntelligenceSpellAttack2 = ImageIO.read(getClass().getResourceAsStream("/player2/Iattack2 2.png"));
            player2IntelligenceSpellAttack3 = ImageIO.read(getClass().getResourceAsStream("/player2/Iattack2 3.png"));
            player2IntelligenceSpellAttack4 = ImageIO.read(getClass().getResourceAsStream("/player2/Iattack2 4.png"));
            player2IntelligenceSpellAttack5 = ImageIO.read(getClass().getResourceAsStream("/player2/Iattack2 5.png"));
            player2IntelligenceSpellAttack6 = ImageIO.read(getClass().getResourceAsStream("/player2/Iattack2 6.png"));
            player2IntelligenceSpellAttack7 = ImageIO.read(getClass().getResourceAsStream("/player2/Iattack2 7.png"));
            player2IntelligenceSpellAttack8 = ImageIO.read(getClass().getResourceAsStream("/player2/Iattack2 8.png"));
           
            player2IntelligenceDeath1 = ImageIO.read(getClass().getResourceAsStream("/player2/Ideath 1.png"));
            player2IntelligenceDeath2 = ImageIO.read(getClass().getResourceAsStream("/player2/Ideath 2.png"));
            player2IntelligenceDeath3 = ImageIO.read(getClass().getResourceAsStream("/player2/Ideath 3.png"));
            player2IntelligenceDeath4 = ImageIO.read(getClass().getResourceAsStream("/player2/Ideath 4.png"));
            player2IntelligenceDeath5 = ImageIO.read(getClass().getResourceAsStream("/player2/Ideath 5.png"));
            player2IntelligenceDeath6 = ImageIO.read(getClass().getResourceAsStream("/player2/Ideath 6.png"));
            player2IntelligenceDeath7 = ImageIO.read(getClass().getResourceAsStream("/player2/Ideath 7.png"));
          
           
            player2Strength1 = ImageIO.read(getClass().getResourceAsStream("/player2/S.png"));
            player2StrengthRun1 = ImageIO.read(getClass().getResourceAsStream("/player2/Srun (1).png"));
            player2StrengthRun2 = ImageIO.read(getClass().getResourceAsStream("/player2/Srun (2).png"));
            player2StrengthRun3 = ImageIO.read(getClass().getResourceAsStream("/player2/Srun (3).png"));
            player2StrengthRun4 = ImageIO.read(getClass().getResourceAsStream("/player2/Srun (4).png"));
            player2StrengthRun5 = ImageIO.read(getClass().getResourceAsStream("/player2/Srun (5).png"));
            player2StrengthRun6 = ImageIO.read(getClass().getResourceAsStream("/player2/Srun (6).png"));
            player2StrengthRun7 = ImageIO.read(getClass().getResourceAsStream("/player2/Srun (7).png"));
            player2StrengthRun8 = ImageIO.read(getClass().getResourceAsStream("/player2/Srun (8).png"));
           
            player2StrengthAttack1 = ImageIO.read(getClass().getResourceAsStream("/player2/Sattack (1).png"));
            player2StrengthAttack2 = ImageIO.read(getClass().getResourceAsStream("/player2/Sattack (2).png"));
            player2StrengthAttack3 = ImageIO.read(getClass().getResourceAsStream("/player2/Sattack (3).png"));
            player2StrengthAttack4 = ImageIO.read(getClass().getResourceAsStream("/player2/Sattack (4).png"));
            player2StrengthAttack5 = ImageIO.read(getClass().getResourceAsStream("/player2/Sattack (5).png"));
            player2StrengthAttack6 = ImageIO.read(getClass().getResourceAsStream("/player2/Sattack (6).png"));
            player2StrengthAttack7 = ImageIO.read(getClass().getResourceAsStream("/player2/Sattack (7).png"));
           
            player2StrengthSpellAttack1 = ImageIO.read(getClass().getResourceAsStream("/player2/Sattack2 (1).png"));
            player2StrengthSpellAttack2 = ImageIO.read(getClass().getResourceAsStream("/player2/Sattack2 (2).png"));
            player2StrengthSpellAttack3 = ImageIO.read(getClass().getResourceAsStream("/player2/Sattack2 (3).png"));
            player2StrengthSpellAttack4 = ImageIO.read(getClass().getResourceAsStream("/player2/Sattack2 (4).png"));
            player2StrengthSpellAttack5 = ImageIO.read(getClass().getResourceAsStream("/player2/Sattack2 (5).png"));
            player2StrengthSpellAttack6 = ImageIO.read(getClass().getResourceAsStream("/player2/Sattack2 (6).png"));
           
            player2StrengthDeath1 = ImageIO.read(getClass().getResourceAsStream("/player2/Sdeath (1).png"));
            player2StrengthDeath2 = ImageIO.read(getClass().getResourceAsStream("/player2/Sdeath (2).png"));
            player2StrengthDeath3 = ImageIO.read(getClass().getResourceAsStream("/player2/Sdeath (3).png"));
            player2StrengthDeath4 = ImageIO.read(getClass().getResourceAsStream("/player2/Sdeath (4).png"));
            player2StrengthDeath5 = ImageIO.read(getClass().getResourceAsStream("/player2/Sdeath (5).png"));
            player2StrengthDeath6 = ImageIO.read(getClass().getResourceAsStream("/player2/Sdeath (6).png"));
            player2StrengthDeath7 = ImageIO.read(getClass().getResourceAsStream("/player2/Sdeath (7).png"));
            player2StrengthDeath8 = ImageIO.read(getClass().getResourceAsStream("/player2/Sdeath (8).png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     public void gifMaker(long imageTimer,BufferedImage image1,BufferedImage image2,BufferedImage image3,
             BufferedImage image4,BufferedImage image5,BufferedImage image6,BufferedImage image7,
             BufferedImage image8, Graphics g, int x, int y) {

        imageTimer++;
        if (imageTimer % 800 >= 0 && imageTimer % 800 <= 100) {
            g.drawImage(image1, x, y, 110, 110, null);
        } else if (imageTimer % 800 >= 100 && imageTimer % 800 <= 200) {
            g.drawImage(image2, x, y, 110, 110, null);
        } else if (imageTimer % 800 >= 200 && imageTimer % 800 <= 300) {
            g.drawImage(image3, x, y, 110, 110, null);
        } else if (imageTimer % 800 >= 300 && imageTimer % 800 <= 400) {
            g.drawImage(image4, x, y, 110, 110, null);
        } else if (imageTimer % 800 >= 400 && imageTimer % 800 <= 500) {
            g.drawImage(image5, x, y, 110, 110, null);
        } else if (imageTimer % 800 >= 500 && imageTimer % 800 <= 600) {
            g.drawImage(image6, x, y, 110, 110, null);
        } else if (imageTimer % 800 >= 600 && imageTimer % 800 <= 700) {
            g.drawImage(image7, x, y, 110, 110, null);
        } else if (imageTimer % 800 >= 700 && imageTimer % 800 <= 800) {
            g.drawImage(image8, x, y, 110, 110, null);
        }
    }
}
