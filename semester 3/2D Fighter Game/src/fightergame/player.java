/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fightergame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Saber
 */
public class player extends object {

    private processor Processor;
    public static boolean collided = false;
    public static int timer = 300;
    public static int timer2 = 300;
    private res resources;
    long imageTimer;
    static int hit1Count = 0;
    static int manaX1hit1Count = 0;
    static int manaX2hit1Count = 0;
    static int manaX3hit1Count = 0;
    static int SPhit1Count = 0;
    static int hit2Count = 0;
    static int manaX1hit2Count = 0;
    static int manaX2hit2Count = 0;
    static int manaX3hit2Count = 0;
    static int SPhit2Count = 0;

    public player(int x, int y, ID id, processor Processor) {

        super(x, y, id);
        resources = new res();
        this.Processor = Processor;
    }

    public Rectangle getBounds() {

        return new Rectangle(x, 300, 115, 115);

    }

    @Override
    public void tick() {

        if (x >= 0 && Vx < 0) {
            x += Vx;
        } else if (x <= game.width - 135 && Vx > 0 && !collided) {
            x += Vx;
        }
        collision();
        System.out.println(menu.aList);

    }

    @Override
    public void render(Graphics g) {

        imageTimer++;
        if (Vx != 0) {
            if (menu.player1ID == ID.agility) {
                System.out.println(input.hit1GIF);
                System.out.println(timer);
                if (input.hit1GIF && timer <= 80) {
                    resources.gifMaker(timer * 10, resources.player1AgilityAttack1, resources.player1AgilityAttack2,
                            resources.player1AgilityAttack3, resources.player1AgilityAttack3, resources.player1AgilityAttack4,
                            resources.player1AgilityAttack4, resources.player1AgilityAttack5, resources.player1AgilityAttack6,
                            g, x, 300);

                } else if ((input.manaX1Hit1GIF || input.spHit1GIF) && timer <= 80) {
                    resources.gifMaker(timer * 10, resources.player1AgilitySpellAttack1, resources.player1AgilitySpellAttack2,
                            resources.player1AgilitySpellAttack3, resources.player1AgilitySpellAttack3, resources.player1AgilitySpellAttack4,
                            resources.player1AgilitySpellAttack4, resources.player1AgilitySpellAttack5, resources.player1AgilitySpellAttack6,
                            g, x, 300);

                } else {
                    resources.gifMaker(imageTimer, resources.player1AgilityRun1, resources.player1AgilityRun2,
                            resources.player1AgilityRun3, resources.player1AgilityRun4, resources.player1AgilityRun5,
                            resources.player1AgilityRun6, resources.player1AgilityRun7, resources.player1AgilityRun8,
                            g, x, 300);
                    input.hit1GIF = input.manaX1Hit1GIF = input.spHit1GIF = false;
                }
            } else if (menu.player1ID == ID.strength) {
                if (input.hit1GIF && timer <= 80) {
                    resources.gifMaker(timer * 10, resources.player1StrengthAttack1, resources.player1StrengthAttack2,
                            resources.player1StrengthAttack3, resources.player1StrengthAttack3, resources.player1StrengthAttack4,
                            resources.player1StrengthAttack5, resources.player1StrengthAttack6, resources.player1StrengthAttack7,
                            g, x, 300);

                } else if ((input.manaX1Hit1GIF || input.spHit1GIF) && timer <= 80) {
                    resources.gifMaker(timer * 10, resources.player1StrengthSpellAttack1, resources.player1StrengthSpellAttack2,
                            resources.player1StrengthSpellAttack3, resources.player1StrengthSpellAttack3, resources.player1StrengthSpellAttack4,
                            resources.player1StrengthSpellAttack5, resources.player1StrengthSpellAttack6, resources.player1StrengthSpellAttack6,
                            g, x, 300);

                } else {
                    resources.gifMaker(imageTimer, resources.player1StrengthRun1, resources.player1StrengthRun2,
                            resources.player1StrengthRun3, resources.player1StrengthRun4,
                            resources.player1StrengthRun5, resources.player1StrengthRun6,
                            resources.player1StrengthRun7, resources.player1StrengthRun8, g, x, 300);
                    input.hit1GIF = input.manaX1Hit1GIF = input.spHit1GIF = false;
                }
            } else if (menu.player1ID == ID.intelligence) {
                if (input.hit1GIF && timer <= 80) {
                    resources.gifMaker(timer * 10, resources.player1IntelligenceAttack1, resources.player1IntelligenceAttack2,
                            resources.player1IntelligenceAttack3, resources.player1IntelligenceAttack4, resources.player1IntelligenceAttack5,
                            resources.player1IntelligenceAttack6, resources.player1IntelligenceAttack7, resources.player1IntelligenceAttack8,
                            g, x, 300);

                } else if ((input.manaX1Hit1GIF || input.spHit1GIF) && timer <= 80) {
                    resources.gifMaker(timer * 10, resources.player1IntelligenceSpellAttack1, resources.player1IntelligenceSpellAttack2,
                            resources.player1IntelligenceSpellAttack3, resources.player1IntelligenceSpellAttack4, resources.player1IntelligenceSpellAttack5,
                            resources.player1IntelligenceSpellAttack6, resources.player1IntelligenceSpellAttack7, resources.player1IntelligenceSpellAttack8,
                            g, x, 300);

                } else {
                    resources.gifMaker(imageTimer, resources.player1IntelligenceRun1, resources.player1IntelligenceRun2,
                            resources.player1IntelligenceRun3, resources.player1IntelligenceRun4,
                            resources.player1IntelligenceRun5, resources.player1IntelligenceRun6,
                            resources.player1IntelligenceRun7, resources.player1IntelligenceRun8, g, x, 300);
                    input.hit1GIF = input.manaX1Hit1GIF = input.spHit1GIF = false;
                }
            }
        } else {
            if (menu.player1ID == ID.agility) {
                if (input.hit1GIF && timer <= 80) {
                    resources.gifMaker(timer * 10, resources.player1AgilityAttack1, resources.player1AgilityAttack2,
                            resources.player1AgilityAttack3, resources.player1AgilityAttack3, resources.player1AgilityAttack4,
                            resources.player1AgilityAttack4, resources.player1AgilityAttack5, resources.player1AgilityAttack6,
                            g, x, 300);

                } else if ((input.manaX1Hit1GIF || input.spHit1GIF) && timer <= 80) {
                    resources.gifMaker(timer * 10, resources.player1AgilitySpellAttack1, resources.player1AgilitySpellAttack2,
                            resources.player1AgilitySpellAttack3, resources.player1AgilitySpellAttack3, resources.player1AgilitySpellAttack4,
                            resources.player1AgilitySpellAttack4, resources.player1AgilitySpellAttack5, resources.player1AgilitySpellAttack6,
                            g, x, 300);

                } else {
                    g.drawImage(resources.player1Agility1, x, 300, 110, 110, null);
                    input.hit1GIF = input.spHit1GIF = input.manaX1Hit1GIF = false;

                }
            } else if (menu.player1ID == ID.strength) {
                if (input.hit1GIF && timer <= 80) {
                    resources.gifMaker(timer * 10, resources.player1StrengthAttack1, resources.player1StrengthAttack2,
                            resources.player1StrengthAttack3, resources.player1StrengthAttack3, resources.player1StrengthAttack4,
                            resources.player1StrengthAttack5, resources.player1StrengthAttack6, resources.player1StrengthAttack7,
                            g, x, 300);

                } else if ((input.manaX1Hit1GIF || input.spHit1GIF) && timer <= 80) {
                    resources.gifMaker(timer * 10, resources.player1StrengthSpellAttack1, resources.player1StrengthSpellAttack2,
                            resources.player1StrengthSpellAttack3, resources.player1StrengthSpellAttack3, resources.player1StrengthSpellAttack4,
                            resources.player1StrengthSpellAttack5, resources.player1StrengthSpellAttack6, resources.player1StrengthSpellAttack6,
                            g, x, 300);

                } else {
                    g.drawImage(resources.player1Strength1, x, 300, 110, 110, null);
                    input.hit1GIF = input.spHit1GIF = input.manaX1Hit1GIF = false;
                }
            } else if (menu.player1ID == ID.intelligence) {
                if (input.hit1GIF && timer <= 80) {
                    resources.gifMaker(timer * 10, resources.player1IntelligenceAttack1, resources.player1IntelligenceAttack2,
                            resources.player1IntelligenceAttack3, resources.player1IntelligenceAttack4, resources.player1IntelligenceAttack5,
                            resources.player1IntelligenceAttack6, resources.player1IntelligenceAttack7, resources.player1IntelligenceAttack8,
                            g, x, 300);

                } else if ((input.manaX1Hit1GIF || input.spHit1GIF) && timer <= 80) {
                    resources.gifMaker(timer * 10, resources.player1IntelligenceSpellAttack1, resources.player1IntelligenceSpellAttack2,
                            resources.player1IntelligenceSpellAttack3, resources.player1IntelligenceSpellAttack4, resources.player1IntelligenceSpellAttack5,
                            resources.player1IntelligenceSpellAttack6, resources.player1IntelligenceSpellAttack7, resources.player1IntelligenceSpellAttack8,
                            g, x, 300);

                } else {
                    g.drawImage(resources.player1Intelligence1, x, 300, 110, 110, null);
                    input.hit1GIF = input.spHit1GIF = input.manaX1Hit1GIF = false;
                }
            }
        }

    }

    private void collision() {
        object Player = processor.object.get(0);
        object Player2 = processor.object.get(1);
        double player1DamageInPercentage = (menu.aList.get(0).get(1) * 100) / menu.aList.get(1).get(0);
        double player2DamageInPercentage = (menu.aList.get(1).get(1) * 100) / menu.aList.get(0).get(0);
        double mana1 = menu.aList.get(0).get(2);
        double mana2 = menu.aList.get(1).get(2);
        if (input.manaX1Hit1 && bar.mana >= ((400 * 100) / mana1)) {
            bar.health2 -= player1DamageInPercentage;
            bar.mana -= ((400 * 100) / mana1);
            manaX1hit1Count++;
            input.manaX1Hit1 = false;
        }
        if (input.manaX2Hit1 && bar.mana >= ((800 * 100) / mana1)) {
            bar.health2 -= (player1DamageInPercentage * 2);
            bar.mana -= ((800 * 100) / mana1);
            manaX2hit1Count++;
            input.manaX2Hit1 = false;
        }
        if (input.manaX3Hit1 && bar.mana >= ((1200 * 100) / mana1)) {
            bar.health2 -= (player1DamageInPercentage * 3);
            bar.mana -= ((1200 * 100) / mana1);
            manaX3hit1Count++;
            input.manaX3Hit1 = false;
        }

        if (input.manaX1Hit2 && bar.mana2 >= ((400 * 100) / mana2)) {
            bar.health -= player2DamageInPercentage;
            bar.mana2 -= ((400 * 100) / mana2);
            manaX1hit2Count++;
            input.manaX1Hit2 = false;
        }
        if (input.manaX2Hit2 && bar.mana2 >= ((800 * 100) / mana2)) {
            bar.health -= (player2DamageInPercentage * 2);
            bar.mana2 -= ((800 * 100) / mana2);
            manaX2hit2Count++;
            input.manaX2Hit2 = false;
        }
        if (input.manaX3Hit2 && bar.mana2 >= ((1200 * 100) / mana2)) {
            bar.health -= (player2DamageInPercentage * 3);
            bar.mana2 -= ((1200 * 100) / mana2);
            manaX3hit2Count++;
            input.manaX3Hit2 = false;
        }

        if (input.spHit1 && !input.spUse1) {
            bar.health2 -= (1000 * 100 / menu.aList.get(1).get(0));
            input.spHit1 = false;
            SPhit1Count++;
            input.spUse1 = true;
        }
        if (input.spHeal1 && !input.spUse1) {
            bar.health += (1000 * 100 / menu.aList.get(0).get(0));
            if (bar.health > 100) {
                bar.health = 100;
            }
            input.spHeal1 = false;
            input.spUse1 = true;
        }
        if (input.spHit2 && !input.spUse2) {
            bar.health -= (1000 * 100 / menu.aList.get(0).get(0));
            SPhit2Count++;
            input.spHit2 = false;
            input.spUse2 = true;
        }
        if (input.spHeal2 && !input.spUse2) {
            bar.health2 += (1000 * 100 / menu.aList.get(1).get(0));
            if (bar.health2 > 100) {
                bar.health2 = 100;
            }
            input.spHeal2 = false;
            input.spUse2 = true;
        }
        if (getBounds().intersects(Player2.getBounds())) {
            if (input.hit1) {
                bar.health2 -= player1DamageInPercentage;
                hit1Count++;
                input.hit1 = false;
            }
            if (input.hit2) {
                bar.health -= player2DamageInPercentage;
                hit2Count++;
                input.hit2 = false;
            }
            collided = true;
        } else {
            collided = false;
        }
        timer++;
        timer2++;

    }
}
