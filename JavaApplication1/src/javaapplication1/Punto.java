/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author UNALMED
 */
public class Punto {
    float x, y;
  
   public Punto(float x,float y){
        this.x=x;
        this.y=y;
    }

   public String ToString(){
       return x+","+y;
   }
  }
