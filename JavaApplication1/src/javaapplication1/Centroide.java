/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;

/**
 *
 * @author UNALMED
 */
public class Centroide extends Punto {
        double Radio;
        double diametro;
    public ArrayList<Punto> puntosUnidos = new ArrayList();

    public String ToString(){
    return super.ToString() + " Radio: " + Radio; 
    }
    
    public void CalcularRadio(){
        Radio=-1;  
        double d=0;
        for (int j = 0; j < puntosUnidos.size(); j++) {
                    d = Calculo.Distancia(new Punto(x,y), puntosUnidos.get(j));
                    if (d >Radio) {
                        Radio = d;
                    }
        }
    }
        public void CalcularDiametro(){
        diametro=-1;  
        double d=0;
        for (int j = 0; j < puntosUnidos.size(); j++) {
            for (int y = 0; y < puntosUnidos.size(); y++) {
                if(y!=j){
             d = Calculo.Distancia( puntosUnidos.get(y), puntosUnidos.get(j));
                    if (d >diametro) {
                        diametro = d;
                    }
                }

        }
        }
    }
    
    
    public Centroide(float x, float y, ArrayList<Punto> nuevos) {
        super(x, y);
        puntosUnidos = nuevos;
        Radio=-1;  
        double d=0;
        for (int j = 0; j < nuevos.size(); j++) {
                    d = Calculo.Distancia(new Punto(x,y), nuevos.get(j));
                    if (d >Radio) {
                        Radio = d;
                    }
        }
    }

    public Centroide(float x, float y) {
        super(x, y);
        puntosUnidos = new ArrayList();
        Radio=0;    
    }

    public void AgregarPuntos(Punto a) {
        puntosUnidos.add(a);
  
    }

    public void MezclarLista(ArrayList<Punto> listavieja) {

        puntosUnidos.addAll(listavieja);
 

    }

    public Centroide(Punto a, Punto b) {


        super((float) ((a.x + b.x) / 2), (float) ((a.y + b.y) / 2));


        // Esto lo puse yo 

        if (!(a instanceof Centroide)) {

            this.AgregarPuntos(a);
        }

        if (!(b instanceof Centroide)) {

            this.AgregarPuntos(b);
        }

        /*
         System.out.println("Se crea nuevo centroide");
         System.out.println("A es el punto " + a.ToString() );
         System.out.println("b es el punto " + b.ToString() );
         System.out.println((a.x+b.x)/2 + " "+(a.y+b.y)/2 );
         */

        if (a instanceof Centroide) {
            Centroide nuevoA = (Centroide) a;
            ArrayList<Punto> aLista = nuevoA.puntosUnidos;
            //System.out.println("A es instancia de Centroide" + a.ToString() );
            this.MezclarLista(aLista);
        }

        if (b instanceof Centroide) {
            Centroide nuevoB = (Centroide) b;
            ArrayList<Punto> bLista = nuevoB.puntosUnidos;
            /*
             System.out.println("b es instancia de Centroide " + b.ToString() );
             System.out.println();
             System.out.println("El tamaño de la lista de B es "+ bLista.size());
             * */

            this.MezclarLista(bLista);
            //   System.out.println("El tamaño de mi propia lista es  "+ puntosUnidos.size());
        }




    }

    public void mostrar_hijos() {

        if (puntosUnidos.size() == 0) {
            System.out.println("Sin hijos");
        }
         System.out.println("hijos");
        for (int j = 0; j < puntosUnidos.size(); j++) {
           
            System.out.println(puntosUnidos.get(j).ToString());
        }



    }
}
