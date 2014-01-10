/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.awt.Container;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class Generador extends JFrame{
    JPanel dibujo;
    JavaApplication1 panela;
    JButton boton1,boton2;
    public Generador(JavaApplication1 p){
    super("Dibujo");
    setSize(500,530);
    panela=p;
    dibujo=new JPanel();
    dibujo.setLayout(new FlowLayout());
    setLayout(new BorderLayout());
    boton1=new JButton("Guardar");
    boton1.addActionListener(new accionesGenerador());
    boton2=new JButton("Volver");
    boton2.addActionListener(new accionesGenerador());
    Container contenedor= this.getContentPane();
    dibujo.add(boton1);
    dibujo.add(boton2);
    dibujo.setBackground(Color.white);
    setBackground(Color.white);
    contenedor.add(panela, BorderLayout.CENTER);
    contenedor.add(dibujo, BorderLayout.SOUTH);
    setLocation(200,100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setVisible(true);
    }
     class accionesGenerador implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton1){
              try{
             Consulta consultas= new Consulta();
             int ID=Integer.parseInt(JOptionPane.showInputDialog ( "Digite ID del cluster a guardar" ));
             if(consultas.InsertarClusters(panela.dibujados, ID)==1){
                    return;  
             }
            
             
             JOptionPane.showMessageDialog(null, "Guardado con exito","Exito",  JOptionPane.PLAIN_MESSAGE);
  
            }catch (NumberFormatException ek) {
                JOptionPane.showMessageDialog(null, "Digite un número","Error",  JOptionPane.ERROR_MESSAGE);
            }
            
        }if(e.getSource()==boton2){
            new Interface();
            setVisible(false);
        }
    } 
   } 
    
}
