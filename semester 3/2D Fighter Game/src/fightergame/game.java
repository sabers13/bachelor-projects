/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fightergame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Saber
 */
public class game extends Canvas implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static final int width = 720, hight = width / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private processor Processor;
    private bar bar;
    private menu Menu;
    private res resources;
    boolean saved = false;

    public enum state {
        Menu, Game, End
    }
    public state gameState = state.Menu;

    public game() {

        Processor = new processor();
        resources = new res();
        Menu = new menu(this, Processor);
        this.addKeyListener(new input(Processor));
        this.addMouseListener(Menu);
        new window(width, hight, "Fight!", this);
        bar = new bar();

    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new game();

    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;

            }
            if (running) {
                render();
            }
            frames++;

            if (System.currentTimeMillis() - timer > 50) {
                timer += 50;
                //System.out.println("fps: " + frames);

                frames = 0;
            }
        }
        stop();

    }

    public void tick() {
        Processor.tick();
        if (gameState == state.Game) {

            bar.tick();

        } else if (gameState == state.Menu) {
            Menu.tick();
        } else if (gameState == state.End) {

        }
    }
    int imageTimer = 0;

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        BufferStrategy bs1 = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        if (bs1 == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        Graphics g1 = bs1.getDrawGraphics();

        g.setColor(Color.red);
        g.fillRect(0, 0, width, hight);
        g.drawImage(resources.gameBackground, 0, 0, width, hight, null);

        if (bar.health <= 0) {

            Font font = new Font("arial", 1, 40);
            g.setFont(font);
            gameState = state.End;
            g.setColor(Color.white);
            g.drawString("Player 2 wins!", 220, 200);
            //Processor.removeObject();
            if (!saved) {
                try {
                    String type = null;
                    if (menu.player2ID == ID.strength) {
                        type = "strength";
                    } else if (menu.player2ID == ID.agility) {
                        type = "agility";
                    } else if (menu.player2ID == ID.intelligence) {
                        type = "intelligence";
                    }
                    Files.write(Paths.get("records.txt"), ("\n winner:Player two/type: " + type + "/Hit Count: "
                            + player.hit2Count + "/ManaX1 Count: " + player.manaX1hit2Count + "/ManaX2 Count: "
                            + player.manaX2hit2Count + "/ManaX3 Count: " + player.manaX3hit2Count + "/Super Power Hit:"
                            + player.SPhit2Count).getBytes(), StandardOpenOption.APPEND);
                    saved = true;
                } catch (IOException e) {

                }
            }
        } else if (bar.health2 <= 0) {

            Font font = new Font("arial", 1, 40);
            g.setFont(font);
            gameState = state.End;
            g.setColor(Color.white);
            g.drawString("Player 1 wins!", 220, 200);

            //Processor.removeObject();
            if (!saved) {
                try {
                    String type = null;
                    if (menu.player1ID == ID.strength) {
                        type = "strength";
                    } else if (menu.player1ID == ID.agility) {
                        type = "agility";
                    } else if (menu.player1ID == ID.intelligence) {
                        type = "intelligence";
                    }
                    Files.write(Paths.get("records.txt"), ("\n winner:Player one/type: " + type + "/Hit Count: "
                            + player.hit1Count + "/ManaX1 Count: " + player.manaX1hit1Count + "/ManaX2 Count: "
                            + player.manaX2hit1Count + "/ManaX3 Count: " + player.manaX3hit1Count + "/Super Power Hit:"
                            + player.SPhit1Count).getBytes(), StandardOpenOption.APPEND);
                    saved = true;
                } catch (IOException e) {
                    
                }
            }

        }

        Processor.render(g);
        if (gameState == state.Game) {

            bar.render(g);
        } else if (gameState == state.Menu) {
            Menu.render(g, g1);
        } else if (gameState == state.End) {

        }
        g.dispose();
        bs.show();
    }

}
