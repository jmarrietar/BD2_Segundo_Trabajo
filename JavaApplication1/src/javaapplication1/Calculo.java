/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.math.*;
import java.util.ArrayList;

/**
 *
 * @author UNALMED
 */
public class Calculo {

    static public ArrayList<Punto> lista;

    public Calculo(ArrayList<Punto> l) {
        this.lista = l;
    }

    public static double Distancia(Punto a, Punto b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public void Metodo1(double r) {

        Punto Punto1 = null, Punto2 = null;
        double distanciaM = 20000;
        double d;

        //System.out.println("El tamaño Para la busqueda " + lista.size());
        for (int j = 0; j < lista.size(); j++) {
            for (int i = 0; i < lista.size(); i++) {
                if (i != j) {
                    d = Calculo.Distancia((Punto) lista.get(i), (Punto) lista.get(j));
                    if (d <= distanciaM) {
                        distanciaM = d;
                        Punto1 = (Punto) lista.get(i);   // Cuando un centoride se mete aqui queda como punto? . 
                        Punto2 = (Punto) lista.get(j);

                    }

                }

            }
        }

        Centroide nuevo = null;

        try {
            nuevo = new Centroide(Punto1, Punto2);
        } catch (NullPointerException e) {
            System.out.println("No se pudo crear centroide " + e);

        }

        lista.remove(Punto1);
        lista.remove(Punto2);
        lista.add(nuevo);

        for (int k = 0; k < lista.size(); k++) {
            if (lista.size() < 1) {
                break;
            }
            //    if ((!(lista.get(k) instanceof Centroide))) {
            //    System.out.println("Entro recursivo");
            // System.out.println("Este punto no es centroide "+lista.get(k).ToString());

            for (int m = 0; m < lista.size(); m++) {
                if (m != k) {

                    if (Calculo.Distancia((Punto) lista.get(k), (Punto) lista.get(m)) < r) {
                        Metodo1(r);
                    }
                }

            }
            //  }
        }

    }

    public void Metodo1(int n) {

        Punto Punto1 = null, Punto2 = null;
        double distanciaM = 20000;
        double d;

        //System.out.println("El tamaño Para la busqueda " + lista.size());
        for (int j = 0; j < lista.size(); j++) {
            for (int i = 0; i < lista.size(); i++) {
                if (i != j) {
                    d = Calculo.Distancia((Punto) lista.get(i), (Punto) lista.get(j));
                    if (d <= distanciaM) {
                        distanciaM = d;
                        Punto1 = (Punto) lista.get(i);   // Cuando un centoride se mete aqui queda como punto? . 
                        Punto2 = (Punto) lista.get(j);

                    }

                }

            }
        }
        //   System.out.println("Distancia minima es "+  distanciaM);

        /*
         try {
         System.out.println("Fusionar Puntos "+ Punto1.ToString());
         } catch (NullPointerException e){
         System.out.println("Error con Punto1 " + e);
         }
         * 
         * */
        Centroide nuevo = null;

        try {
            //System.out.println("Fusionar Puntos "+ Punto1.ToString()+" "+Punto2.ToString());
            nuevo = new Centroide(Punto1, Punto2);  // Aqui se crea Nuevo centroide . 
            // Si uno de los dos puntos ya es un centroide entonces sus puntos se le pasan al nuevo centroide. 
        } catch (NullPointerException e) {
            System.out.println("No se pudo crear centroide " + e);

        }

        lista.remove(Punto1);
        lista.remove(Punto2);
        //System.out.println("Tamaño de Lista sin dos puntos " + lista.size());
        lista.add(nuevo);
        //System.out.println("Tamaño de Lista con nuevo centroide " + lista.size());

        /*  for (int k = 0; k < lista.size(); k++) {
         if (!(lista.get(k) instanceof Centroide)) {

         // System.out.println("Este punto no es centroide "+lista.get(k).ToString());
         Metodo1(n);
         }
         }*/
        if (lista.size() > n) {
            Metodo1(n);
        }

    }

    public void mostrar_centroides() {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).ToString());
        }

        System.out.println();
    }

    public ArrayList<Punto> retornar_puntos() {
        return lista;

    }

    public void Metodo2(int n) {
        Punto Punto1 = null, Punto2 = null;
        double distanciaM = 20000;
        double d;

        //System.out.println("El tamaño Para la busqueda " + lista.size());
        for (int j = 0; j < lista.size(); j++) {
            for (int i = 0; i < lista.size(); i++) {
                if (i != j) {
                    d = Calculo.Distancia((Punto) lista.get(i), (Punto) lista.get(j));
                    if (d <= distanciaM) {
                        distanciaM = d;
                        Punto1 = (Punto) lista.get(i);
                        Punto2 = (Punto) lista.get(j);

                    }

                }

            }
        }

        Centroide nuevo = null;

        try {
            //System.out.println("Fusionar Puntos "+ Punto1.ToString()+" "+Punto2.ToString());
            nuevo = new Centroide(Punto1, Punto2);  // Aqui se crea Nuevo centroide . 
            // Si uno de los dos puntos ya es un centroide entonces sus puntos se le pasan al nuevo centroide. 
        } catch (NullPointerException e) {
            System.out.println("No se pudo crear centroide " + e);

        }
        nuevo.x = Punto1.x;
        nuevo.y = Punto1.y;

        lista.remove(Punto1);
        lista.remove(Punto2);
        //System.out.println("Tamaño de Lista sin dos puntos " + lista.size());
        lista.add(nuevo);

        /*              for (int k = 0; k < lista.size(); k++) {
         if (!(lista.get(k) instanceof Centroide)) {

         // System.out.println("Este punto no es centroide "+lista.get(k).ToString());
         Metodo2(n);
         }
         }
         */
        if (lista.size() > n) {
            Metodo2(n);
        }

    }

    public void Metodo2(double r) {
        Punto Punto1 = null, Punto2 = null;
        double distanciaM = 20000;
        double d;

        //System.out.println("El tamaño Para la busqueda " + lista.size());
        for (int j = 0; j < lista.size(); j++) {
            for (int i = 0; i < lista.size(); i++) {
                if (i != j) {
                    d = Calculo.Distancia((Punto) lista.get(i), (Punto) lista.get(j));
                    if (d <= distanciaM) {
                        distanciaM = d;
                        Punto1 = (Punto) lista.get(i);
                        Punto2 = (Punto) lista.get(j);

                    }

                }

            }
        }

        Centroide nuevo = null;

        try {
            //System.out.println("Fusionar Puntos "+ Punto1.ToString()+" "+Punto2.ToString());
            nuevo = new Centroide(Punto1, Punto2);  // Aqui se crea Nuevo centroide . 
            // Si uno de los dos puntos ya es un centroide entonces sus puntos se le pasan al nuevo centroide. 
        } catch (NullPointerException e) {
            System.out.println("No se pudo crear centroide " + e);

        }
        nuevo.x = Punto1.x;
        nuevo.y = Punto1.y;

        lista.remove(Punto1);
        lista.remove(Punto2);
        //System.out.println("Tamaño de Lista sin dos puntos " + lista.size());
        lista.add(nuevo);

        /*              for (int k = 0; k < lista.size(); k++) {
         if (!(lista.get(k) instanceof Centroide)) {

         // System.out.println("Este punto no es centroide "+lista.get(k).ToString());
         Metodo2(n);
         }
         }
         */
        for (int k = 0; k < lista.size(); k++) {
            if (lista.size() < 1) {
                break;
            }

            //    if ((!(lista.get(k) instanceof Centroide))) {
            //    System.out.println("Entro recursivo");
            // System.out.println("Este punto no es centroide "+lista.get(k).ToString());
            for (int m = 0; m < lista.size(); m++) {
                if (m != k) {

                    if (Calculo.Distancia((Punto) lista.get(k), (Punto) lista.get(m)) < r) {
                        Metodo2(r);
                    }
                }

            }
            //  }
        }

    }

    public void Metodo3(double r) {
        
    //    System.out.println("COMIENZA METODO 3");
        Punto Punto1 = null, Punto2 = null;
        double distanciaM = 20000;
        double d;

//        System.out.println("El tamaño Para la busqueda " + lista.size());
        for (int j = 0; j < lista.size(); j++) {
            for (int i = 0; i < lista.size(); i++) {
                if (i != j) {
                    d = Calculo.Distancia((Punto) lista.get(i), (Punto) lista.get(j));
                    if (d <= distanciaM) {
                        distanciaM = d;
                        Punto1 = (Punto) lista.get(i);
                        Punto2 = (Punto) lista.get(j);

                    }

                }

            }
        }

//           System.out.println("Los puntos seleccionados de menor distancia son ");
       //   System.out.println("A " + Punto1.ToString() + " B "+ Punto2.ToString());
        Centroide nuevo = null;

        try {
             //   System.out.println("Fusionar Puntos "+ Punto1.ToString()+" "+Punto2.ToString());
            nuevo = new Centroide(Punto1, Punto2);
            nuevo.CalcularRadio();// Aqui se crea Nuevo centroide . 
           //  System.out.println("Centoride es"+ nuevo.ToString());

            // Si uno de los dos puntos ya es un centroide entonces sus puntos se le pasan al nuevo centroide. 
            //   System.out.println("El radio del centoride es " + nuevo.Radio);
        } catch (NullPointerException e) {
            System.out.println("No se pudo crear centroide " + e);

        }
        if (nuevo.Radio <= r) {  //MIRAR  DETENIDAMENTE ESTO
       //        System.out.println("Se eliminan los dos puntos seleccionados de la lista");
            lista.remove(Punto1); //Si el radio que se forma es menor a r(threshold ) entonces se quitan de la lista los puntos con los que s ehizo el centoride.
            lista.remove(Punto2);
        }

        // en este momento la lista tienen dos puntos menos
        // AUn no se agrega el centroide a al lista.
        nuevo.CalcularRadio();
        double radioaux = nuevo.Radio; // RadioAux tiene el valor del radio del nuevo cluster (centoride)

        while (radioaux < r) {      // Mientras que el valor del radio sea menor que el theshold.
            double radmin = 99999;   // radio minimo 
            Punto nuevok = null;  // Es el punto que se saca de la lista 
            Centroide u = null;
            for (int j = 0; j < lista.size(); j++) {

                if (!(lista.get(j) instanceof Centroide)) {
                    // System.out.println("Se prueba con punto "+lista.get(j).ToString());
                    u = new Centroide(nuevo, lista.get(j)); // u es el nuevo centroid
                   // System.out.println("Operacion: "+ "("+nuevo.x +"+"+lista.get(j).x+")"+"/2"+ " , " + "("+nuevo.y +"+"+lista.get(j).y+")"+"/2" );
                   // System.out.println("U :"+ u.ToString());
                    u.CalcularRadio();
                    //  System.out.println("El radio del cluster con ESTE punto es "+u.Radio);
                    if (u.Radio < radmin) { // si el radio del nuevo cluster es menor que el radio minimo

                         //  System.out.println("Se selecciona punto "+lista.get(j).ToString()+"con radio de cluster " +u.Radio);
                        
                        radmin = u.Radio;  //mio
                        
                        // mio
                        nuevok = lista.get(j);   // Nuevok es el punto que se saca de la lista. 
                        // Aqui habia un nuevo erroneo
                    }
                }
            }
            
//            System.out.println("el punto nuevok seleccionado es " + nuevok.ToString());
            int a = 0;
            for (int j = 0; j < lista.size(); j++) {
                if ((lista.get(j) instanceof Centroide)) {
                    a++;
                }
            }
            if (a == lista.size()) {
                return;
            }

            Centroide U1 = null;
           
            U1 = new Centroide(nuevo, nuevok);
            U1.CalcularRadio();
 //System.out.println("Se crea el  U1, este es el  centroide fromado con el nuevok(3) "+ U1.ToString());
            if (U1.Radio > r) { // ESTO ESTA BIEN , si el proximo punto 
               lista.add(nuevo);   //ESTO LO PUSE YO AHORA
                break;
            }

            lista.remove(nuevo);
            
          //  System.out.println("Se REMUEVE el punto nuevok de la lista (3 punto) " + nuevok.ToString());
            lista.remove(nuevok);

            radioaux = U1.Radio; 
            
            
          //  System.out.println("Se AGREGA el punto U1 a la lista ");
            lista.add(U1);

            // System.out.print("RADIO MINIMO DE SALIDA "+ radioaux);
            nuevo = U1;
            // nuevo=new Centroide(nuevo,nuevok);
            // lista.remove(nuevok); // Se remueve el punto 
            // Se agrega centroide ultimo a la lista! . 
        }

        for (int k = 0; k < lista.size(); k++) {
            if (lista.size() < 1) {
                break;
            }
            if ((!(lista.get(k) instanceof Centroide))) {
            //       System.out.println("Entro recursivo");
           //      System.out.println("Este punto no es centroide "+lista.get(k).ToString());

                for (int m = 0; m < lista.size(); m++) {
                    if (m != k) {
                        Centroide exit = new Centroide(lista.get(m), lista.get(k));
                        exit.CalcularRadio();
                        if (exit.Radio < r) {
                            Metodo3(r);
                        }
                    }

                }
            }
        }
        
        
       // System.out.print("Tamaño de la lista de puntos cuando termina metodos"+lista.size());
        
        for(int k = 0; k < lista.size(); k++){
            
            if ((!(lista.get(k) instanceof Centroide))) {
            System.out.println("");    
            }
            
        }

    }

    public void Metodo3(int n) {

     //   System.out.println("METODO 3 COMIENZA ");
        Punto Punto1 = null, Punto2 = null;
        double distanciaM = 20000;
        double d;

        // Cada vez que se mete Buca los dos primeros puntos (o punto + cluster(centroide) ) mas cercanos. 
        for (int j = 0; j < lista.size(); j++) {
            for (int i = 0; i < lista.size(); i++) {
                if (i != j) {
                    d = Calculo.Distancia((Punto) lista.get(i), (Punto) lista.get(j));
                    if (d <= distanciaM) {
                        distanciaM = d;
                        Punto1 = (Punto) lista.get(i);
                        Punto2 = (Punto) lista.get(j);

                    }

                }

            }
        }
        //////////////////////////////////////////////////////

   //  System.out.println("Los puntos seleccionados de menor distancia son ");
        //  System.out.println("A " + Punto1.ToString() + " B "+ Punto2.ToString());
        //  Se Trata de crear un punto nuevo (CENTROIDE) con los dos puntos seleccionados anteriormente 
        Centroide nuevo = null;

        try {
            //      System.out.println("Fusionar Puntos "+ Punto1.ToString()+" "+Punto2.ToString());
            nuevo = new Centroide(Punto1, Punto2);
            nuevo.CalcularRadio();// Aqui se crea Nuevo centroide . 
            //      System.out.println("Centoride es nuevo "+ nuevo.ToString());

            // Si uno de los dos puntos ya es un centroide entonces sus puntos se le pasan al nuevo centroide. 
       //  System.out.println("El radio del centoride es " + nuevo.Radio);
        } catch (NullPointerException e) {
            //   System.out.println("No se pudo crear centroide " + e);

        }

        /////////////////////////////////////////////////////////////////
        // Como NO tenemos Threshold entonces se quitan enseguida los dos puntos con los que se hizo el centroide. 
        //   System.out.println("Se eliminan los dos puntos seleccionados de la lista");
        lista.remove(Punto1);
        lista.remove(Punto2);

        // en este momento la lista tienen dos puntos menos
        // AUn no se agrega el centroide a al lista.
        nuevo.CalcularRadio();

        // Mientras que el valor del radio sea menor que el theshold.
        double radmin = 99999;   // radio minimo 
        Punto nuevok = null;  // Es el punto que se saca de la lista 
        Centroide u = null;
        Centroide U1 = null;  // Nuevo centroide con ultimo punto pegado. 
        // En este For se selecciona el punto al cual el cluster se le va a pegar 
        // Teniendo en cuenta que se le pega el que tenga el radio menor. 

           // System.out.println("Ahora escogeremos el 3 punto de la iteracion para Unir");
        if (lista.size() > 0) {

            for (int j = 0; j < lista.size(); j++) {

                //    System.out.println("Se prueba con punto "+lista.get(j).ToString());
                u = new Centroide(nuevo, lista.get(j)); // u es el nuevo centroid
                //      System.out.println("Operacion: "+ "("+nuevo.x +"+"+lista.get(j).x+")"+"/2"+ " , " + "("+nuevo.y +"+"+lista.get(j).y+")"+"/2" );
                //       System.out.println("U :"+ u.ToString());
                u.CalcularRadio();
                //     System.out.println("El radio del cluster con ESTE punto es "+u.Radio);
                if (u.Radio < radmin) { // si el radio del nuevo cluster es menor que el radio minimo

          //           System.out.println("Se selecciona punto "+lista.get(j).ToString()+"con radio de cluster " +u.Radio);
                    radmin = u.Radio;  //mio

                    // mio
                    nuevok = lista.get(j);   // Nuevok es el punto que se saca de la lista. 
                    // Aqui habia un nuevo erroneo
                }

            }

            int a = 0;
            for (int j = 0; j < lista.size(); j++) {
                if ((lista.get(j) instanceof Centroide)) {
                    a++;                                      // # de Centroides en la Lista
                }
            }

          //     System.out.println("Numero de centroides al momento "+ a);
            //  if (a == lista.size()) {
            //     return;
            // }
            try {
                U1 = new Centroide(nuevo, nuevok);
                U1.CalcularRadio();   // Se calcula su radio
            } catch (NullPointerException e) {
                // System.out.println("NO SE PUDO CREAR CENTROIDE U1" + e);

            }

           // System.out.println("3 punto para agregar es " + nuevok.ToString());
        } else if (lista.size() == 0) {
            U1 = nuevo;
            U1.CalcularRadio();
        }

//System.out.println("Ultimo centroide U'  es " + U1.ToString());
        lista.remove(nuevo);  // Se elimina el centroide anterior. 
        lista.remove(nuevok);  // se elimina el ultimo punto que se Unio. 

        lista.add(U1);

  //          System.out.println("Se agrega a la lista " + U1.ToString());
            // System.out.print("RADIO MINIMO DE SALIDA "+ radioaux);
        // nuevo = U1;
        // nuevo=new Centroide(nuevo,nuevok);
        // lista.remove(nuevok); // Se remueve el punto 
        // Se agrega centroide ultimo a la lista! . 
        //////////////////////// FIN DEL SUPUESTO WHILE . 
            // Ahora necesito entrar denuevo a la iteracion . 
            // Junto conun criterio de parada. 
        // Opcion 1 criterio de parada.
    //        System.out.println("La lista antes de meterme al metodo es de tamaño " + lista.size());
        if (n % 2 != 0) {

        }

        if (lista.size() > n) {           // N o N+1 es un aspecto Importante que debatir

            Metodo3(n);
        }

        // Opcion 2 criterio de parada TODOS deben ser instancias de centroide. 

        /*
         for (int k = 0; k < lista.size(); k++) {
         //   if (lista.size() < 1) {
         //      break;
         //  }
       
          
          
         if ((!(lista.get(k) instanceof Centroide) || lista.size() > n )  ) {   // Si hay un elemento que es instancia de centroide 
         Metodo3(n);
         }
            

         }
     
         */
    }

    public void Metodo4(double di) {
        Punto Punto1 = null, Punto2 = null;
        double distanciaM = 20000;
        double d;

        //System.out.println("El tamaño Para la busqueda " + lista.size());
        for (int j = 0; j < lista.size(); j++) {
            for (int i = 0; i < lista.size(); i++) {
                if (i != j) {
                    d = Calculo.Distancia((Punto) lista.get(i), (Punto) lista.get(j));
                    if (d <= distanciaM) {
                        distanciaM = d;
                        Punto1 = (Punto) lista.get(i);
                        Punto2 = (Punto) lista.get(j);

                    }

                }

            }
        }

        //   System.out.println("Los puntos seleccionados de menor distancia son ");
        //  System.out.println("A " + Punto1.ToString() + " B "+ Punto2.ToString());
        Centroide nuevo = null;

        try {
            //    System.out.println("Fusionar Puntos "+ Punto1.ToString()+" "+Punto2.ToString());
            nuevo = new Centroide(Punto1, Punto2);
            nuevo.CalcularDiametro();// Aqui se crea Nuevo centroide . 
            // System.out.println("Centoride es"+ nuevo.ToString());

            // Si uno de los dos puntos ya es un centroide entonces sus puntos se le pasan al nuevo centroide. 
            //   System.out.println("El radio del centoride es " + nuevo.Radio);
        } catch (NullPointerException e) {
            System.out.println("No se pudo crear centroide " + e);

        }
        if (nuevo.diametro <= di) {
            //   System.out.println("Se eliminan los dos puntos seleccionados de la lista");
            lista.remove(Punto1); //Si el radio que se forma es menor a r(threshold ) entonces se quitan de la lista los puntos con los que s ehizo el centoride.
            lista.remove(Punto2);
        }

        // en este momento la lista tienen dos puntos menos
        // AUn no se agrega el centroide a al lista.
        nuevo.CalcularDiametro();
        double diametroaux = nuevo.diametro; // RadioAux tiene el valor del radio del nuevo cluster (centoride)

        while (diametroaux < di) {      // Mientras que el valor del radio sea menor que el theshold.
            double dmin = 99999;   // radio minimo 
            Punto nuevok = null;  // Es el punto que se saca de la lista 
            Centroide u = null;
            for (int j = 0; j < lista.size(); j++) {

                if (!(lista.get(j) instanceof Centroide)) {
                    //  System.out.println("Se prueba con punto "+lista.get(j).ToString());
                    u = new Centroide(nuevo, lista.get(j)); // u es el nuevo centroid
                    // System.out.println("Operacion: "+ "("+nuevo.x +"+"+lista.get(j).x+")"+"/2"+ " , " + "("+nuevo.y +"+"+lista.get(j).y+")"+"/2" );
                    // System.out.println("U :"+ u.ToString());
                    u.CalcularDiametro();
                    //   System.out.println("El radio del cluster con ESTE punto es "+u.Radio);
                    if (u.diametro < dmin) { // si el radio del nuevo cluster es menor que el radio minimo

                        //     System.out.println("Se selecciona punto "+lista.get(j).ToString()+"con radio de cluster " +u.Radio);
                        //   radmin=nuevo.Radio; // radio minimo es ahora el  
                        dmin = u.diametro;  //mio
                        //     radioaux=nuevo.Radio; // PREGUNTAR ESTA PARTE YA que yo la pienso diferente
                        // mio
                        nuevok = lista.get(j);   // Nuevok es el punto que se saca de la lista. 
                        // Aqui habia un nuevo erroneo
                    }
                }
            }
            int a = 0;
            for (int j = 0; j < lista.size(); j++) {
                if ((lista.get(j) instanceof Centroide)) {
                    a++;
                }
            }
            if (a == lista.size()) {
                return;
            }

            Centroide U1 = null;
            U1 = new Centroide(nuevo, nuevok);
            U1.CalcularDiametro();

            if (U1.diametro > di) {
                lista.add(nuevo);   //ESTO LO PUSE YO AHORA
                break;
            }

            lista.remove(nuevo);
            lista.remove(nuevok);

            diametroaux = U1.diametro;
            lista.add(U1);

            // System.out.print("RADIO MINIMO DE SALIDA "+ radioaux);
            nuevo = U1;
            // nuevo=new Centroide(nuevo,nuevok);
            // lista.remove(nuevok); // Se remueve el punto 
            // Se agrega centroide ultimo a la lista! . 
        }
        for (int k = 0; k < lista.size(); k++) {
            if (lista.size() < 1) {
                break;
            }
            if ((!(lista.get(k) instanceof Centroide))) {
                //    System.out.println("Entro recursivo");
                // System.out.println("Este punto no es centroide "+lista.get(k).ToString());

                for (int m = 0; m < lista.size(); m++) {
                    if (m != k) {
                        Centroide exit = new Centroide(lista.get(m), lista.get(k));
                        exit.CalcularDiametro();
                        if (exit.diametro < di) {
                            Metodo4(di);
                        }
                    }

                }
            }
        }

    }

    public void Metodo4(int n) {
        Punto Punto1 = null, Punto2 = null;
        double distanciaM = 20000;
        double d;

        //System.out.println("El tamaño Para la busqueda " + lista.size());
        for (int j = 0; j < lista.size(); j++) {
            for (int i = 0; i < lista.size(); i++) {
                if (i != j) {
                    d = Calculo.Distancia((Punto) lista.get(i), (Punto) lista.get(j));
                    if (d <= distanciaM) {
                        distanciaM = d;
                        Punto1 = (Punto) lista.get(i);
                        Punto2 = (Punto) lista.get(j);

                    }

                }

            }
        }

        //   System.out.println("Los puntos seleccionados de menor distancia son ");
        //  System.out.println("A " + Punto1.ToString() + " B "+ Punto2.ToString());
        Centroide nuevo = null;

        try {
            //    System.out.println("Fusionar Puntos "+ Punto1.ToString()+" "+Punto2.ToString());
            nuevo = new Centroide(Punto1, Punto2);
            nuevo.CalcularDiametro();// Aqui se crea Nuevo centroide . 
            // System.out.println("Centoride es"+ nuevo.ToString());

            // Si uno de los dos puntos ya es un centroide entonces sus puntos se le pasan al nuevo centroide. 
            //   System.out.println("El radio del centoride es " + nuevo.Radio);
        } catch (NullPointerException e) {
            System.out.println("No se pudo crear centroide " + e);

        }

        //   System.out.println("Se eliminan los dos puntos seleccionados de la lista");
        lista.remove(Punto1); //Si el radio que se forma es menor a r(threshold ) entonces se quitan de la lista los puntos con los que s ehizo el centoride.
        lista.remove(Punto2);

        // en este momento la lista tienen dos puntos menos
        // AUn no se agrega el centroide a al lista.
        nuevo.CalcularDiametro();
        double diametroaux = nuevo.diametro; // RadioAux tiene el valor del radio del nuevo cluster (centoride)

        // Mientras que el valor del radio sea menor que el theshold.
        double dmin = 99999;   // radio minimo 
        Punto nuevok = null;  // Es el punto que se saca de la lista 
        Centroide u = null;
        Centroide U1 = null;
        if (lista.size() > 0) {
            for (int j = 0; j < lista.size(); j++) {

                //  System.out.println("Se prueba con punto "+lista.get(j).ToString());
                u = new Centroide(nuevo, lista.get(j)); // u es el nuevo centroid
                // System.out.println("Operacion: "+ "("+nuevo.x +"+"+lista.get(j).x+")"+"/2"+ " , " + "("+nuevo.y +"+"+lista.get(j).y+")"+"/2" );
                // System.out.println("U :"+ u.ToString());
                u.CalcularDiametro();
                //   System.out.println("El radio del cluster con ESTE punto es "+u.Radio);
                if (u.diametro < dmin) { // si el radio del nuevo cluster es menor que el radio minimo

                        //     System.out.println("Se selecciona punto "+lista.get(j).ToString()+"con radio de cluster " +u.Radio);
                    //   radmin=nuevo.Radio; // radio minimo es ahora el  
                    dmin = u.diametro;  //mio
                    //     radioaux=nuevo.Radio; // PREGUNTAR ESTA PARTE YA que yo la pienso diferente
                    // mio
                    nuevok = lista.get(j);   // Nuevok es el punto que se saca de la lista. 
                    // Aqui habia un nuevo erroneo
                }

            }
            int a = 0;
            for (int j = 0; j < lista.size(); j++) {
                if ((lista.get(j) instanceof Centroide)) {
                    a++;
                }
            }

            try {
                U1 = new Centroide(nuevo, nuevok);
                U1.CalcularDiametro();
            } catch (NullPointerException e) {
                System.out.println("NO SE PUDO CREAR CENTROIDE U1" + e);

            }
        } else if (lista.size() == 0) {
            U1 = nuevo;
            U1.CalcularDiametro();
        }

        lista.remove(nuevo);
        lista.remove(nuevok);

        lista.add(U1);

            // System.out.print("RADIO MINIMO DE SALIDA "+ radioaux);
        //  nuevo = U1;  // MIRAR AQUI
        // nuevo=new Centroide(nuevo,nuevok);
        // lista.remove(nuevok); // Se remueve el punto 
        // Se agrega centroide ultimo a la lista! . 
        if (lista.size() > n) {           // N o N+1 es un aspecto Importante que debatir

            Metodo4(n);
        }

    }

    static public double DistanciaProm(Punto a, Punto b){
        if(a instanceof Centroide && !(b instanceof Centroide) ){
            Centroide aprima = (Centroide)a;
            ArrayList <Punto> la = aprima.puntosUnidos; 
            double sum=0;
            for (int i=0;i< la.size();i++){
                sum+=Distancia(la.get(i),b);
                   
            }
            return sum/(la.size());
        
        }
        
        if(a instanceof Centroide && (b instanceof Centroide) ){
            Centroide aprima = (Centroide)a;
            Centroide bprima = (Centroide)b;
            
            ArrayList <Punto> la = aprima.puntosUnidos; 
            ArrayList <Punto> lb = bprima.puntosUnidos; 
            double sum=0;
            for (int i=0;i< la.size();i++){
                for (int j=0;j< lb.size();j++){
                sum+=Distancia(la.get(i),lb.get(j));
                }   
            }
            return sum/(la.size()*lb.size());
        
        }
        if(!(a instanceof Centroide) && !(b instanceof Centroide) ){
            return Distancia(a,b);
        }
        
        if(!(a instanceof Centroide) && (b instanceof Centroide) ){
           Centroide bprima = (Centroide)b;
            ArrayList <Punto> lb = bprima.puntosUnidos; 
            double sum=0;
            for (int i=0;i< lb.size();i++){
                sum+=Distancia(lb.get(i),a);
                   
            }
            return sum/(lb.size());
            
        }
        return 0;
    }
    
    public void Metodo5(double dis){
    Punto Punto1 = null, Punto2 = null;
        double distanciaM = 20000;
        double d;

        //System.out.println("El tamaño Para la busqueda " + lista.size());
        for (int j = 0; j < lista.size(); j++) {
            for (int i = 0; i < lista.size(); i++) {
                if (i != j) {
                    d = DistanciaProm(lista.get(i),lista.get(j));
                    if (d <= distanciaM) {
                        distanciaM = d;
                        Punto1 = (Punto) lista.get(i);   // Cuando un centoride se mete aqui queda como punto? . 
                        Punto2 = (Punto) lista.get(j);

                    }

                }

            }
        }
        

        Centroide nuevo = null;

        try {
            nuevo = new Centroide(Punto1, Punto2);
        } catch (NullPointerException e) {
            System.out.println("No se pudo crear centroide " + e);

        }

        lista.remove(Punto1);
        lista.remove(Punto2);
        lista.add(nuevo);

        for (int k = 0; k < lista.size(); k++) {
            if (lista.size() < 1) {
                break;
            }
            for (int m = 0; m < lista.size(); m++) {
                if (m != k) {

                    if (Calculo.DistanciaProm( lista.get(k),  lista.get(m)) < dis) {
                        Metodo5(dis);
                    }
                }

            }
           
        }

        
        
    }
    
    
    
    
    public void Metodo5(int n){
    Punto Punto1 = null, Punto2 = null;
        double distanciaM = 20000;
        double d;

        //System.out.println("El tamaño Para la busqueda " + lista.size());
        for (int j = 0; j < lista.size(); j++) {
            for (int i = 0; i < lista.size(); i++) {
                if (i != j) {
                    d = DistanciaProm(lista.get(i),lista.get(j));
                    if (d <= distanciaM) {
                        distanciaM = d;
                        Punto1 = (Punto) lista.get(i);   // Cuando un centoride se mete aqui queda como punto? . 
                        Punto2 = (Punto) lista.get(j);

                    }

                }

            }
        }
        

        Centroide nuevo = null;

        try {
            nuevo = new Centroide(Punto1, Punto2);
        } catch (NullPointerException e) {
            System.out.println("No se pudo crear centroide " + e);

        }

        lista.remove(Punto1);
        lista.remove(Punto2);
        lista.add(nuevo);

               if (lista.size() > n) {
            Metodo5(n);
        }
        

        
        
    }
    
    
    
}
