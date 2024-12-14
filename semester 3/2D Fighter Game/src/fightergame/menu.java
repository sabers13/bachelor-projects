/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fightergame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Saber
 */
public class menu extends MouseAdapter {

    private game Game;
    private processor Processor;
    private res resources;

    static ArrayList<ArrayList<Double>> aList
            = new ArrayList<ArrayList<Double>>(2);
    ArrayList<Double> a1 = new ArrayList<Double>();
    ArrayList<Double> a2 = new ArrayList<Double>();
    boolean strength1 = false;
    boolean agility1 = false;
    boolean intelligence1 = false;
    boolean strength2 = false;
    boolean agility2 = false;
    boolean intelligence2 = false;
    long imageTimer = 0;
    private BufferedImage image1;
    private BufferedImage image2;
    private BufferedImage image3;
    private BufferedImage image4;
    private BufferedImage image5;
    private BufferedImage image6;
    private BufferedImage image7;
    private BufferedImage image8;
    private BufferedImage background;
    static ID player1ID = null;
    static ID player2ID = null;

    public menu(game Game, processor Processor) {
        this.Game = Game;
        this.Processor = Processor;
        resources = new res();

    }

    public void mousePressed(MouseEvent e) {
        int mX = e.getX();
        int mY = e.getY();

        if (mouseOver(mX, mY, 175, 100, 125, 125)) {
            strength1 = true;
            agility1 = false;
            intelligence1 = false;
        }
        if (mouseOver(mX, mY, 350, 100, 125, 125)) {
            strength1 = false;
            agility1 = true;
            intelligence1 = false;
        }
        if (mouseOver(mX, mY, 525, 100, 125, 125)) {
            strength1 = false;
            agility1 = false;
            intelligence1 = true;
        }

        if (mouseOver(mX, mY, 175, 250, 125, 125)) {
            strength2 = true;
            agility2 = false;
            intelligence2 = false;
        }
        if (mouseOver(mX, mY, 350, 250, 125, 125)) {
            strength2 = false;
            agility2 = true;
            intelligence2 = false;
        }
        if (mouseOver(mX, mY, 525, 250, 125, 125)) {
            strength2 = false;
            agility2 = false;
            intelligence2 = true;
        }

        if (mouseOver(mX, mY, 260, 400, 200, 75) && (strength1 || agility1 || intelligence1)
                && (strength2 || agility2 || intelligence2)) {

            if (strength1) {
                player1ID = ID.strength;
            }

            if (agility1) {
                player1ID = ID.agility;
            }

            if (intelligence1) {
                player1ID = ID.intelligence;
            }

            if (strength2) {
                player2ID = ID.strength;

            }

            if (agility2) {
                player2ID = ID.agility;

            }
            if (intelligence2) {
                player2ID = ID.intelligence;

            }

            Processor.addObject(new player(100, 100, player1ID, Processor));

            object Player11 = processor.object.get(0);

            a1.add(Player11.HP);
            a1.add(Player11.damage);
            a1.add(Player11.mana);

            Processor.addObject(new player2(400, 100, player2ID, Processor, resources));

            object Player22 = processor.object.get(1);

            a2.add(Player22.HP);
            a2.add(Player22.damage);
            a2.add(Player22.mana);

            aList.add(a1);
            aList.add(a2);
            System.out.println(processor.object);
            Game.gameState = game.state.Game;

        }
        
    }

    public void mouseReleased(MouseEvent e) {

    }

    private boolean mouseOver(int mX, int mY, int x, int y, int width, int height) {
        if (mX > x && mX < x + width) {
            if (mY > y && mY < y + height) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void tick() {

    }

    public void render(Graphics g, Graphics g1) {
        imageTimer++;

        g.drawImage(resources.menuBackground, 0, 0, game.width, game.hight, null);
        Font font = new Font("arial", 1, 40);
        g.setFont(font);

        Font font1 = new Font("arial", 1, 25);
        g1.setFont(font1);

        g1.setColor(Color.white);
        g1.drawString("chose your fighter:", 35, 50);

        g1.setColor(Color.white);
        g1.drawString("Player 1:", 35, 125);

        g1.setColor(Color.white);
        g1.drawString("Player 2:", 35, 275);

        g1.setColor(Color.white);
        g1.drawString("strength", 185, 90);

        g1.setColor(Color.white);
        g1.drawString("agility", 375, 90);

        g1.setColor(Color.white);
        g1.drawString("intelligence", 525, 90);

        if (strength1) {
            g.setColor(Color.green);
            resources.gifMaker(imageTimer, resources.player1StrengthRun1, resources.player1StrengthRun2,
                    resources.player1StrengthRun3, resources.player1StrengthRun4,
                    resources.player1StrengthRun5, resources.player1StrengthRun6,
                    resources.player1StrengthRun7, resources.player1StrengthRun8, g, 185, 105);
        } else {
            g.setColor(Color.white);
            g.drawImage(resources.player1StrengthRun1, 185, 105, 110, 110, null);
        }
        g.drawRect(175, 100, 125, 125);
        if (agility1) {
            g.setColor(Color.green);

            resources.gifMaker(imageTimer, resources.player1AgilityRun1, resources.player1AgilityRun2,
                    resources.player1AgilityRun3, resources.player1AgilityRun4, resources.player1AgilityRun5,
                    resources.player1AgilityRun6, resources.player1AgilityRun7, resources.player1AgilityRun8,
                    g, 360, 105);

        } else {
            g.setColor(Color.white);
            g.drawImage(resources.player1AgilityRun1, 360, 105, 110, 110, null);
        }

        g.drawRect(350, 100, 125, 125);
        if (intelligence1) {
            g.setColor(Color.green);
            resources.gifMaker(imageTimer, resources.player1IntelligenceRun1, resources.player1IntelligenceRun2,
                    resources.player1IntelligenceRun3, resources.player1IntelligenceRun4,
                    resources.player1IntelligenceRun5, resources.player1IntelligenceRun6,
                    resources.player1IntelligenceRun7, resources.player1IntelligenceRun8, g, 535, 105);

        } else {
            g.setColor(Color.white);
            g.drawImage(resources.player1IntelligenceRun1, 535, 105, 110, 110, null);
        }
        g.drawRect(525, 100, 125, 125);

        if (strength2) {
            g.setColor(Color.green);
            g.setColor(Color.green);
            resources.gifMaker(imageTimer, resources.player1StrengthRun1, resources.player1StrengthRun2,
                    resources.player1StrengthRun3, resources.player1StrengthRun4,
                    resources.player1StrengthRun5, resources.player1StrengthRun6,
                    resources.player1StrengthRun7, resources.player1StrengthRun8, g, 185, 250);
        } else {
            g.setColor(Color.white);
            g.drawImage(resources.player1StrengthRun1, 185, 250, 110, 110, null);
        }
        g.drawRect(175, 250, 125, 125);
        if (agility2) {
            g.setColor(Color.green);
            resources.gifMaker(imageTimer, resources.player1AgilityRun1, resources.player1AgilityRun2,
                    resources.player1AgilityRun3, resources.player1AgilityRun4, resources.player1AgilityRun5,
                    resources.player1AgilityRun6, resources.player1AgilityRun7, resources.player1AgilityRun8,
                    g, 360, 260);

        } else {
            g.setColor(Color.white);
            g.drawImage(resources.player1AgilityRun1, 360, 260, 110, 110, null);
        }

        g.drawRect(350, 250, 125, 125);
        if (intelligence2) {
            g.setColor(Color.green);
            resources.gifMaker(imageTimer, resources.player1IntelligenceRun1, resources.player1IntelligenceRun2,
                    resources.player1IntelligenceRun3, resources.player1IntelligenceRun4,
                    resources.player1IntelligenceRun5, resources.player1IntelligenceRun6,
                    resources.player1IntelligenceRun7, resources.player1IntelligenceRun8, g, 535, 260);
        } else {
            g.setColor(Color.white);
            g.drawImage(resources.player1IntelligenceRun1, 535, 260, 110, 110, null);
        }
        g.drawRect(525, 250, 125, 125);

        g.setColor(Color.white);
        g.drawString("FIGHT!", 290, 450);
        g.setColor(Color.white);
        g.drawRect(260, 400, 200, 75);
        

    }

}
