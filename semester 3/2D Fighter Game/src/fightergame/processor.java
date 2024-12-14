/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fightergame;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author Saber
 */
public class processor {
    static LinkedList<object> object=new LinkedList<object>();
    public void tick(){
        for(int i=0;i<object.size();i++){
            object temp=object.get(i);
            
            temp.tick();
        }
        
    }
    public void render(Graphics g){
        for(int i=0;i<object.size();i++){
            object temp=object.get(i);
            temp.render(g);
        }
    }
    public void addObject(object object){
        this.object.add(object);
    }
    public void removeObject(){
        this.object.clear();
    }
}
