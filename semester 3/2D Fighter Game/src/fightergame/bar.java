/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fightergame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Saber
 */
public class bar {
    public static double health=100;
    public static double health2=100;
    public static double mana=100;
    public static double mana2=100;
    public BufferedImage spOn;
    public BufferedImage spOff;
    public bar(){
        try {
            spOn = ImageIO.read(getClass().getResourceAsStream("/background/spOn.png"));
            spOff = ImageIO.read(getClass().getResourceAsStream("/background/spOff.png"));
        } catch (IOException ex) {
            Logger.getLogger(bar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void tick() {
        
    }
    public void render(Graphics g){
        if(health<0){
            health=0;
        }
        if(health2<0){
            health2=0;
        }
        if(mana<0){
            mana=0;
        }
        if(mana2<0){
            mana2=0;
        }
        healthBar(g,50, (int) health);
        healthBar(g,500, (int) health2);
        manaBar(g,50, (int) mana);
        manaBar(g,500, (int) mana2);
        Font font = new Font("arial", 1, 12);
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString("HP", 15, 35);
        g.drawString((int)health+"%/"+(int)(menu.aList.get(0).get(0)*(health/100)), 255, 35);
        g.drawString((int)health2+"%/"+(int)(menu.aList.get(1).get(0)*(health2/100)), 420, 35);
        g.drawString("Mana", 15, 70);
        g.drawString((int)mana+"%/"+(int)(menu.aList.get(0).get(2)*(mana/100)), 255, 70);
        g.drawString((int)mana2+"%/"+(int)(menu.aList.get(1).get(2)*(mana2/100)), 420, 70);
        if(input.spUse1){
            g.drawImage(spOff, 50, 90, 35, 35, null);
        }else{
            g.drawImage(spOn, 50, 90, 35, 35, null);
        }
        if(input.spUse2){
            g.drawImage(spOff, 500, 90, 35, 35, null);
        }else{
            g.drawImage(spOn, 500, 90, 35, 35, null);
        }
    }
    public void healthBar(Graphics g,int width,int health){
        g.setColor(Color.black);
        g.fillRect(width, 15, 200, 32);
        
        g.setColor(Color.green);
        g.fillRect(width, 15, (health)*2, 32);
        g.setColor(Color.white);
        g.drawRect(width, 15, 200, 32);
    }
    public void manaBar(Graphics g,int width,int mana){
        g.setColor(Color.black);
        g.fillRect(width, 50, 200, 32);
        
        g.setColor(Color.cyan);
        g.fillRect(width, 50, mana*2, 32);
        g.setColor(Color.white);
        g.drawRect(width, 50, 200, 32);
        
    }
}
