/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;





public class JavaApplication1 extends JPanel{

    // de aqui 
       ArrayList<Punto> dibujados;
   public JavaApplication1(ArrayList<Punto> dibujados){
       this.dibujados=dibujados;
   }   
   
   @Override
   public void paint(Graphics g) {
   Dimension d = getSize();
   int x = d.width*2;
   int y = d.height*2;
 
   g.setColor(Color.white);
   g.fillRect(0,0,x/2,y/2);
   

    
 /*
   g.setColor(Color.blue);
   for (int i = 0; i < y; i+=25) g.drawLine(0,i,x,i);
   for (int i = 0; i < x; i+=25) g.drawLine(i,0,i,y);
 */
    

    
   g.setColor(Color.red);
   g.drawLine(25/2,0,25/2,y/2);
   g.drawLine(0,(y-25)/2,x/2,(y-25)/2);
   g.setColor(Color.black);
   g.drawString("0,0",13,(y-8)/2);
   
  
   for(int a=0;a<dibujados.size();a++){
        float r=(float)Math.random();
       float j=(float)Math.random();
       float b=(float)(Math.random());
       g.setColor(new Color(r,j,b));
        if (dibujados.get(a) instanceof Centroide ){
   g.fillOval((int)(dibujados.get(a).x-10+25)/2, (int)(y-dibujados.get(a).y-10-25)/2, 5, 5);
    
   
       Centroide ayuda=(Centroide)dibujados.get(a);
           int maxx=-1;
           int maxy=-1;
           int minx=1000;
           int miny=1000;
       for(int l=0;l<ayuda.puntosUnidos.size();l++){

           if(ayuda.puntosUnidos.get(l).x>maxx)
               maxx=Math.round(ayuda.puntosUnidos.get(l).x);
           if(ayuda.puntosUnidos.get(l).x<minx)
               minx=Math.round(ayuda.puntosUnidos.get(l).x);
           if(ayuda.puntosUnidos.get(l).y>maxy)
               maxy=Math.round(ayuda.puntosUnidos.get(l).y);
           if(ayuda.puntosUnidos.get(l).y<miny)
               miny=Math.round(ayuda.puntosUnidos.get(l).y);
           g.fillOval((int)(ayuda.puntosUnidos.get(l).x-10+25)/2, (int)(y-ayuda.puntosUnidos.get(l).y-10-25)/2, 5, 5);
       }
        
       g.drawRect((minx+15)/2,(y-maxy-35)/2,(maxx-minx+10)/2,(maxy-miny+10)/2);
        }else if (dibujados.get(a) instanceof Punto){
          g.fillOval((int)(dibujados.get(a).x-10+25)/2, (int)(y-dibujados.get(a).y-10-25)/2, 5, 5);
         
        }
   }
}
public static void main(String args[]){
   Interface caca= new Interface();
}    
}
   
   
   
   

    //Hasta aqui es nuevo 

   
   

   
