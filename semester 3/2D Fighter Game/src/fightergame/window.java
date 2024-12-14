package fightergame;

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 *
 * @author Saber
 */
public class window extends Canvas{
    
     public window(int width,int height,String title,game game){
         JFrame frame=new JFrame(title);
         
          frame.setPreferredSize(new Dimension(width,height));
          frame.setMaximumSize(new Dimension(width,height));
          frame.setMinimumSize(new Dimension(width,height));
          frame.setResizable(false);
          frame.setLocationRelativeTo(null);
          
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
          frame.add(game);
          frame.setVisible(true);
          game.start();
     }
    
}
