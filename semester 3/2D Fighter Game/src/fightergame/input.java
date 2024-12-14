/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fightergame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Saber
 */
public class input extends KeyAdapter {

    
    private processor processor;

    public static boolean hit1 = false;
    public static boolean hit1GIF = false;
    public static boolean spHit1 = false;
    public static boolean spHit1GIF = false;
    public static boolean spHeal1 = false;
    public static boolean spUse1 = false;
    public static boolean manaX1Hit1GIF = false;
    public static boolean manaX1Hit1 = false;
    public static boolean manaX2Hit1 = false;
    public static boolean manaX3Hit1 = false;

    public static boolean hit2GIF = false;
    public static boolean spHit2GIF = false;
    public static boolean manaX1Hit2GIF = false;
    public static boolean hit2 = false;
    public static boolean spHit2 = false;
    public static boolean spHeal2 = false;
    public static boolean spUse2 = false;
    public static boolean manaX1Hit2 = false;
    public static boolean manaX2Hit2 = false;
    public static boolean manaX3Hit2 = false;

    public input(processor processor) {
        this.processor = processor;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println(key);
        object player1 = processor.object.get(0);
        object player2 = processor.object.get(1);
        if (key == KeyEvent.VK_W && player.timer > 80) {
            player.timer = 0;
            hit1 = true;
            hit1GIF=true;
        }
        if (key == KeyEvent.VK_Q && player.timer > 80) {
            player.timer = 0;
            spHeal1 = true;

        }
        if (key == KeyEvent.VK_E && player.timer > 80) {
            player.timer = 0;
            spHit1 =spHit1GIF = true;
        }
        if (key == KeyEvent.VK_Z && player.timer > 80) {
            player.timer = 0;
            manaX1Hit1 =manaX1Hit1GIF =  true;
        }
        if (key == KeyEvent.VK_X && player.timer > 80) {
            player.timer = 0;
            manaX2Hit1 =manaX1Hit1GIF =  true;
        }
        if (key == KeyEvent.VK_C && player.timer > 80) {
            player.timer = 0;
            manaX3Hit1 =manaX1Hit1GIF =  true;
        }
        if (key == KeyEvent.VK_A) {
            player1.setVx(-3);
        }
        if (key == KeyEvent.VK_D) {
            player1.setVx(3);
        }

        if (key == KeyEvent.VK_UP && player.timer2 > 80) {

            player.timer2 = 0;
            hit2GIF =hit2 = true;
        }
        if (key == KeyEvent.VK_ALT && player.timer2 > 80) {
            player.timer2 = 0;
            spHeal2 = true;
        }
        if (key == KeyEvent.VK_CONTROL && player.timer2 > 80) {
            player.timer2 = 0;

            spHit2GIF =spHit2 = true;
        }
        if (key == 44 && player.timer2 > 80) {
            player.timer2 = 0;
            manaX1Hit2GIF =manaX1Hit2 = true;
        }
        if (key == 46 && player.timer2 > 80) {
            player.timer2 = 0;
            manaX1Hit2GIF =manaX2Hit2 = true;
        }
        if (key == 47 && player.timer2 > 80) {
            player.timer2 = 0;
            manaX1Hit2GIF =manaX3Hit2 = true;
        }
        if (key == KeyEvent.VK_LEFT) {

            player2.setVx(-3);
        }
        if (key == KeyEvent.VK_RIGHT) {
            player2.setVx(3);
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        object player1 = processor.object.get(0);
        object player2 = processor.object.get(1);
        if (key == KeyEvent.VK_W) {
            hit1 = false;
        }
        if (key == KeyEvent.VK_Q) {
            spHeal1 = false;

        }
        if (key == KeyEvent.VK_E) {
            spHit1 = false;
        }
        if (key == KeyEvent.VK_Z) {
            manaX1Hit1 = false;
        }
        if (key == KeyEvent.VK_X) {
            manaX2Hit1 = false;
        }
        if (key == KeyEvent.VK_C) {
            manaX3Hit1 = false;
        }
        if (key == KeyEvent.VK_A) {
            player1.setVx(0);
        }
        if (key == KeyEvent.VK_D) {
            player1.setVx(0);
        }

        if (key == KeyEvent.VK_UP) {
            hit2 = false;

        }
        if (key == KeyEvent.VK_ALT) {

            spHeal2 = false;

        }
        if (key == KeyEvent.VK_CONTROL) {
            spHit2 = false;
        }
        if (key == 44) {
            manaX1Hit2 = false;
        }
        if (key == 46) {
            manaX2Hit2 = false;
        }
        if (key == 47) {
            manaX3Hit2 = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            player2.setVx(0);
        }
        if (key == KeyEvent.VK_RIGHT) {
            player2.setVx(0);
        }
    }
}
