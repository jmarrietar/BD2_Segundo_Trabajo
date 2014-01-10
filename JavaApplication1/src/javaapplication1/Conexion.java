/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.sql.*;
/**
 *
 * @author Casa
 */
public class Conexion {
        Connection conn;
    ResultSet resultado;
    Statement sentencia;
    
    public Conexion(){
     try{ // Se carga el driver JDBC-ODBC
     Class.forName ("oracle.jdbc.driver.OracleDriver");
    } catch( Exception e ) {
      System.out.println("No se pudo cargar el driver JDBC");
      return;           
      }

    try{ // Se establece la conexión con la base de datos Oracle Express
     conn = DriverManager.getConnection  
     ("jdbc:oracle:thin:@EQUIPOJOSE-PC:1521:xe","jose2","gato");
      sentencia = conn.createStatement();
    } catch( SQLException el ) {
      System.out.println("No hay conexión con la base de datos.");
      return;
      }
}
    public void Cerrar(){
   
        try{ // Se establece la conexión con la base de datos Oracle Express
    conn.close();
    } catch( SQLException el ) {
      System.out.println("No se pudo cerra la conexion.");
      return;
      }
    }
}
