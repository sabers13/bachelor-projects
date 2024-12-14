/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fightergame;

import java.awt.*;
import java.util.Random;

/**
 *
 * @author Saber
 */
public abstract class object {

    
    protected int x, y;
    private static ID id;
    protected int Vx;
    public static double HP;
    public static double mana;
    double damage;
    Random rand = new Random();

    int rand_int1 = rand.nextInt(1000);
    int rand_int2 = rand.nextInt(1000);

    public object(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
        if (id == ID.agility) {

            HP = 1200 + rand.nextInt(700);
            damage = 300 + rand.nextInt(100);;
            mana = 800 + rand.nextInt(800);;

        } else if (id == ID.strength) {

            HP = 2000 + rand.nextInt(500);;
            damage = 200 + rand.nextInt(100);;
            mana = 600 + rand.nextInt(800);;
        } else if (id == ID.intelligence) {

            HP = 1200 + rand.nextInt(700);;
            damage = 100 + rand.nextInt(100);;
            mana = 1600 + rand.nextInt(500);;
        }

    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

    public void setX(int x) {
        this.x = x;
    }

    public void setVx(int Vx) {
        this.Vx = Vx;
    }

    public void setID(ID id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getVx() {
        return Vx;
    }

    public ID getID() {
        return id;
    }

}
