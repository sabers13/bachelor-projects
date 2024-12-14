/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fightergame;

import static fightergame.player.timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Saber
 */
public class player2 extends object {
private processor Processor;
private res resources;
    long imageTimer;

    public player2(int x, int y, ID id,processor Processor,res res) {
        super(x, y, id);
        
        this.Processor= Processor;
        resources =res;
    }
public Rectangle getBounds(){
    
    return new Rectangle(x, 300, 115, 115);
    
}
    @Override
    public void tick() {
        
        
        if(x>=0&&Vx<0&&!player.collided )
            x += Vx;
        else if(x<= game.width-125&&Vx>0)
            x += Vx;
        
    }

    @Override
    public void render(Graphics g) {
        
        imageTimer++;
        if (Vx != 0) {
            if (menu.player2ID == ID.agility) {
                
                if (input.hit2GIF && player.timer2 <= 80) {
                    resources.gifMaker(player.timer2 * 10, resources.player2AgilityAttack1, resources.player2AgilityAttack2,
                            resources.player2AgilityAttack3, resources.player2AgilityAttack3, resources.player2AgilityAttack4,
                            resources.player2AgilityAttack4, resources.player2AgilityAttack5, resources.player2AgilityAttack6,
                            g, x-30, 300);

                } else if ((input.manaX1Hit2GIF ||input.spHit2GIF) && player.timer2 <= 80) {
                    resources.gifMaker(player.timer2 * 10, resources.player2AgilitySpellAttack1, resources.player2AgilitySpellAttack2,
                            resources.player2AgilitySpellAttack3, resources.player2AgilitySpellAttack3, resources.player2AgilitySpellAttack4,
                            resources.player2AgilitySpellAttack4, resources.player2AgilitySpellAttack5, resources.player2AgilitySpellAttack6,
                            g, x-30, 300);

                } else {
                    resources.gifMaker(imageTimer, resources.player2AgilityRun1, resources.player2AgilityRun2,
                            resources.player2AgilityRun3, resources.player1AgilityRun4, resources.player2AgilityRun5,
                            resources.player2AgilityRun6, resources.player1AgilityRun7, resources.player2AgilityRun8,
                            g, x-30, 300);
                    input.hit2GIF = input.manaX1Hit2GIF =input.spHit2GIF =false;
                }
            } else if (menu.player2ID == ID.strength) {
                if (input.hit2GIF && player.timer2 <= 80) {
                    resources.gifMaker(player.timer2 * 10, resources.player2StrengthAttack1, resources.player2StrengthAttack2,
                            resources.player2StrengthAttack3, resources.player2StrengthAttack3, resources.player2StrengthAttack4,
                            resources.player2StrengthAttack5, resources.player2StrengthAttack6, resources.player2StrengthAttack7,
                            g, x-30, 300);

                } else if ((input.manaX1Hit2GIF ||input.spHit2GIF) && player.timer2 <= 80) {
                    resources.gifMaker(player.timer2 * 10, resources.player2StrengthSpellAttack1, resources.player2StrengthSpellAttack2,
                            resources.player2StrengthSpellAttack3, resources.player2StrengthSpellAttack3, resources.player2StrengthSpellAttack4,
                            resources.player2StrengthSpellAttack5, resources.player2StrengthSpellAttack6, resources.player2StrengthSpellAttack6,
                            g, x-30, 300);

                } else {
                resources.gifMaker(imageTimer, resources.player2StrengthRun1, resources.player2StrengthRun2,
                        resources.player2StrengthRun3, resources.player2StrengthRun4,
                        resources.player2StrengthRun5, resources.player2StrengthRun6,
                        resources.player2StrengthRun7, resources.player2StrengthRun8, g, x-30, 300);
                input.hit2GIF = input.manaX1Hit2GIF =input.spHit2GIF =false;
                }
            } else if (menu.player2ID == ID.intelligence) {
                 if (input.hit2GIF && player.timer2 <= 80) {
                    resources.gifMaker(player.timer2 * 10, resources.player2IntelligenceAttack1, resources.player2IntelligenceAttack2,
                            resources.player2IntelligenceAttack3, resources.player2IntelligenceAttack4, resources.player2IntelligenceAttack5,
                            resources.player2IntelligenceAttack6, resources.player2IntelligenceAttack7, resources.player2IntelligenceAttack8,
                            g, x-30, 300);

                } else if ((input.manaX1Hit2GIF ||input.spHit2GIF) && player.timer2 <= 80) {
                    resources.gifMaker(player.timer2 * 10, resources.player2IntelligenceSpellAttack1, resources.player2IntelligenceSpellAttack2,
                            resources.player2IntelligenceSpellAttack3, resources.player2IntelligenceSpellAttack4, resources.player2IntelligenceSpellAttack5,
                            resources.player2IntelligenceSpellAttack6, resources.player2IntelligenceSpellAttack7, resources.player2IntelligenceSpellAttack8,
                            g, x-30, 300);

                } else {
                resources.gifMaker(imageTimer, resources.player2IntelligenceRun1, resources.player2IntelligenceRun2,
                        resources.player2IntelligenceRun3, resources.player2IntelligenceRun4,
                        resources.player2IntelligenceRun5, resources.player2IntelligenceRun6,
                        resources.player2IntelligenceRun7, resources.player2IntelligenceRun8, g, x-30, 300);
                input.hit2GIF = input.manaX1Hit2GIF =input.spHit2GIF =false;
                }
            }
        } else {
            if (menu.player2ID == ID.agility) {
                if (input.hit2GIF && player.timer2 <= 80) {
                    resources.gifMaker(player.timer2 * 10, resources.player2AgilityAttack1, resources.player2AgilityAttack2,
                            resources.player2AgilityAttack3, resources.player2AgilityAttack3, resources.player2AgilityAttack4,
                            resources.player2AgilityAttack4, resources.player2AgilityAttack5, resources.player2AgilityAttack6,
                            g, x-30, 300);

                } else if ((input.manaX1Hit2GIF ||input.spHit2GIF)&& player.timer2 <= 80) {
                    resources.gifMaker(player.timer2 * 10, resources.player2AgilitySpellAttack1, resources.player2AgilitySpellAttack2,
                            resources.player2AgilitySpellAttack3, resources.player2AgilitySpellAttack3, resources.player2AgilitySpellAttack4,
                            resources.player2AgilitySpellAttack4, resources.player2AgilitySpellAttack5, resources.player2AgilitySpellAttack6,
                            g, x-30, 300);

                } else {
                    g.drawImage(resources.player2Agility1, x-30, 300, 110, 110, null);
                    input.hit2GIF =input.spHit2GIF= input.manaX1Hit2GIF = false;
                    
                }
            } else if (menu.player2ID == ID.strength) {
                if (input.hit2GIF && player.timer2 <= 80) {
                    resources.gifMaker(player.timer2 * 10, resources.player2StrengthAttack1, resources.player2StrengthAttack2,
                            resources.player2StrengthAttack3, resources.player2StrengthAttack3, resources.player2StrengthAttack4,
                            resources.player2StrengthAttack5, resources.player2StrengthAttack6, resources.player2StrengthAttack7,
                            g, x-30, 300);

                } else if ((input.manaX1Hit2GIF ||input.spHit2GIF) && player.timer2 <= 80) {
                    resources.gifMaker(player.timer2 * 10, resources.player2StrengthSpellAttack1, resources.player2StrengthSpellAttack2,
                            resources.player2StrengthSpellAttack3, resources.player2StrengthSpellAttack3, resources.player2StrengthSpellAttack4,
                            resources.player2StrengthSpellAttack5, resources.player2StrengthSpellAttack6, resources.player2StrengthSpellAttack6,
                            g, x-30, 300);

                } else {
                g.drawImage(resources.player2Strength1, x-30, 300, 110, 110, null);
                input.hit2GIF =input.spHit2GIF= input.manaX1Hit2GIF = false;
            }
            } else if (menu.player2ID == ID.intelligence) {
                if (input.hit2GIF && player.timer2 <= 80) {
                    resources.gifMaker(player.timer2 * 10, resources.player2IntelligenceAttack1, resources.player2IntelligenceAttack2,
                            resources.player2IntelligenceAttack3, resources.player2IntelligenceAttack4, resources.player2IntelligenceAttack5,
                            resources.player2IntelligenceAttack6, resources.player2IntelligenceAttack7, resources.player2IntelligenceAttack8,
                            g, x-30, 300);

                } else if ((input.manaX1Hit2GIF ||input.spHit2GIF) && player.timer2 <= 80) {
                    resources.gifMaker(player.timer2 * 10, resources.player2IntelligenceSpellAttack1, resources.player2IntelligenceSpellAttack2,
                            resources.player2IntelligenceSpellAttack3, resources.player2IntelligenceSpellAttack4, resources.player2IntelligenceSpellAttack5,
                            resources.player2IntelligenceSpellAttack6, resources.player2IntelligenceSpellAttack7, resources.player2IntelligenceSpellAttack8,
                            g, x-30, 300);

                } else {
                g.drawImage(resources.player2Intelligence1, x-30, 300, 110, 110, null);
                input.hit2GIF =input.spHit2GIF= input.manaX1Hit2GIF = false;
                }
            }
        }
        
          
    }
}
