/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Casa
 */
public class Consulta {
    Conexion conector;
    
    public void InsertarConjunto(int conjunto){
       conector=new Conexion();
        try{
        conector.resultado=conector.sentencia.executeQuery("insert into conjuntopuntos values("+conjunto+",nest_puntos())");   
        conector.Cerrar();
        }catch (SQLException asd){
           // System.out.println("Error: " + asd.getMessage());
        }
    }/*
    public int InsertarClusters(ArrayList<Punto> generados, int id){
       conector=new Conexion();
       ArrayList existen= new ArrayList();
        try{
           conector.resultado=conector.sentencia.executeQuery("Select id from cluster2");     
           while (conector.resultado.next()){
               if(conector.resultado.getInt("id")==id){
            JOptionPane.showMessageDialog(null, "ID ya existe","Error",  JOptionPane.ERROR_MESSAGE);
            return 1;
               }
            }
            
            
            
            for (int i=0;i<generados.size();i++ ){
                conector.resultado=conector.sentencia.executeQuery("insert into cluster2 values(cluster_type("+id+",punto_tip("+generados.get(i).x+","+generados.get(i).y+"),nest_puntos() ))");
                if(generados.get(i) instanceof Centroide){
                    Centroide alfa = (Centroide)generados.get(i);
                    for(int l=0;l<alfa.puntosUnidos.size();l++){
                  conector.resultado=conector.sentencia.executeQuery("INSERT INTO TABLE(SELECT c.puntos FROM cluster2 c WHERE c.centroide.x="+generados.get(i).x+"and c.centroide.y="+generados.get(i).y+"and c.id="+id+")values(punto_tip("+alfa.puntosUnidos.get(l).x +","+alfa.puntosUnidos.get(l).y +"))");
                      
                    }
                }
                
            }
      
        conector.Cerrar();
        }catch (SQLException awt){
            System.out.println("Error: " + awt.getMessage());
        }
        return 0;
    }   
    */public int InsertarClusters(ArrayList<Punto> generados, int id){
       conector=new Conexion();
       ArrayList existen= new ArrayList();
        try{
           conector.resultado=conector.sentencia.executeQuery("Select id from cluster2");     
           while (conector.resultado.next()){
               if(conector.resultado.getInt("id")==id){
            JOptionPane.showMessageDialog(null, "ID ya existe","Error",  JOptionPane.ERROR_MESSAGE);
            return 1;
               }
            }
            
            
            String Consulta="";
            for (int i=0;i<generados.size();i++ ){
              Consulta="insert into cluster2 values(cluster_type("+id+",punto_tip("+generados.get(i).x+","+generados.get(i).y+"),nest_puntos(";
               // conector.resultado=conector.sentencia.executeQuery("insert into cluster2 values(cluster_type("+id+",punto_tip("+generados.get(i).x+","+generados.get(i).y+"),nest_puntos() ))");
              if(generados.get(i) instanceof Centroide){
                    Centroide alfa = (Centroide)generados.get(i);
                    for(int l=0;l<alfa.puntosUnidos.size()-1;l++){
                     Consulta+="punto_tip("+alfa.puntosUnidos.get(l).x +","+alfa.puntosUnidos.get(l).y +"),";
                    }
                    Consulta+="punto_tip("+alfa.puntosUnidos.get(alfa.puntosUnidos.size()-1).x +","+alfa.puntosUnidos.get(alfa.puntosUnidos.size()-1).y +") ";
                }
                conector.resultado=conector.sentencia.executeQuery(Consulta+") ))");
            }
      
        conector.Cerrar();
        }catch (SQLException awt){
            System.out.println("Error: " + awt.getMessage());
        }
        return 0;
    }
    
     public ArrayList<Punto> DevolverClusters(int id){
       conector=new Conexion();
        ArrayList<Punto> retornados= new ArrayList();
       try{ 
        
           conector.resultado=conector.sentencia.executeQuery("Select c.centroide.x as x, c.centroide.y as y from cluster2 c where id="+id);     
           while (conector.resultado.next()){
  //             System.out.println("entro!!");
            Centroide viejo= new Centroide(conector.resultado.getInt("x"),conector.resultado.getInt("y"));
           retornados.add(viejo);
           }
           for(int a=0;a<retornados.size();a++){
            conector.resultado=conector.sentencia.executeQuery("Select p.x as x, p.y as y from cluster2 c, table(c.puntos) p where id="+id+ "and c.centroide.x="+retornados.get(a).x+" and c.centroide.y="+retornados.get(a).y);
            while(conector.resultado.next()){
              Centroide alfa=(Centroide)retornados.get(a);
             alfa.AgregarPuntos(new Punto(conector.resultado.getInt("x"),conector.resultado.getInt("y")));
     //          System.out.println("entro mas adentro!!");
            }   
           }
            
           conector.Cerrar();
           return retornados;
        }catch (SQLException awt){
        JOptionPane.showMessageDialog(null, "Data no encontrada","Error",  JOptionPane.ERROR_MESSAGE); 
            
        }
        return retornados;
    }
     
   public void InsertarPuntos(int codconjunto, int x, int y){
          conector=new Conexion(); 
       try {
        conector.resultado=conector.sentencia.executeQuery("INSERT INTO TABLE(SELECT mis_puntos FROM conjuntopuntos WHERE id_conj="+codconjunto+") VALUES("+x+","+y+")");   
        conector.Cerrar();
    } catch(SQLException e ){      
      System.out.println("Error: " + e.getMessage());
      }
   }
   
    public void commit(){
        conector=new Conexion();   
        try {
        conector.resultado=conector.sentencia.executeQuery("commit");   
        conector.Cerrar();
    } catch(SQLException e ){      
      System.out.println("Error: " + e.getMessage());
      }
   }   
    public String imprimirConjunto(){
    conector=new Conexion();
        try {
      //Se recorren las tuplas retornadas
      conector.resultado = conector.sentencia.executeQuery("SELECT id_conj FROM conjuntopuntos");
     String cadena="";
      while (conector.resultado.next())
      {
          cadena=cadena+conector.resultado.getInt("id_conj");

      }
        conector.Cerrar();
      return cadena;
}catch(SQLException e ){
      System.out.println("Error: " + e.getMessage());
      }
        return "nada";
   }   
    
    
     public ArrayList<Punto> AdquirirPuntos(int id){
    conector=new Conexion();
    ArrayList<Punto> ListaPuntos= new ArrayList();    
    try {
      //Se recorren las tuplas retornadas
      conector.resultado = conector.sentencia.executeQuery("SELECT t2.x as x, t2.y as y FROM conjuntopuntos t, TABLE(t.mis_puntos) t2 where id_conj="+id);
      while (conector.resultado.next())
      {
          ListaPuntos.add(new Punto(conector.resultado.getInt("x"), conector.resultado.getInt("y")));

      }
        conector.Cerrar();
      return ListaPuntos;
}catch(SQLException e ){
      System.out.println("Error: " + e.getMessage());
      }
        return null;
   }    
    
}
