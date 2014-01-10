/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Usuario
 */




public class Interface extends JFrame{
   JLabel label1, label2, label3;
   JTextField textfield1,textfield2;
   JComboBox combo1, combo2;
   JButton boton1, boton2, boton3; 
    public Interface(){
    super("Bienvenido");
    setSize(350,150);
    setLayout(new FlowLayout());
    label1= new JLabel("ID"); 
    label2= new JLabel("Método");
    label3= new JLabel("Parada");
    textfield1=new JTextField(8);
    textfield2=new JTextField(8);
    combo1= new JComboBox();
    combo1.addItem("Selecione una opción");
    combo1.addItem("Distancia Centroide");
    combo1.addItem("Distancia Punto");
    combo1.addItem("Radio");
    combo1.addItem("Diámetro");
    combo1.addItem("Promedio");
    combo2= new JComboBox();
    combo2.addItem("-------------");
    combo2.addItem("Número Clusters");
    combo2.addItem("Umbral");
    boton1=new JButton("Insertar");
    boton1.addActionListener(new accionesInterface());
    boton2=new JButton("Generar");
    boton2.addActionListener(new accionesInterface());
    boton3=new JButton("Guardados");
    boton3.addActionListener(new accionesInterface());
    Container contenedor= this.getContentPane();
    contenedor.add(label1);
    contenedor.add(textfield1);
    contenedor.add(label2);
    contenedor.add(combo1);
    contenedor.add(label3);
    contenedor.add(combo2);
    contenedor.add(textfield2);
    contenedor.add(boton1);
    contenedor.add(boton2);
    contenedor.add(boton3);
    setLocation(200,100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setVisible(true);
    setBackground(Color.white);
    }
   class accionesInterface implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton3){
            try{
             Consulta consultas= new Consulta();
             int ID=Integer.parseInt(JOptionPane.showInputDialog ( "Digite ID del cluster guardado" ));
              new Generador(new JavaApplication1(consultas.DevolverClusters(ID)));
             setVisible(false);    
            }catch (NumberFormatException ek) {
                JOptionPane.showMessageDialog(null, "Digite un número","Error",  JOptionPane.ERROR_MESSAGE);
            }
            
            
   
        } 
        
        
        if(e.getSource()==boton1){
            new AgregarPunto();
            setVisible(false);
        }
        if(e.getSource()==boton2){
            Consulta consultas= new Consulta();
            try{
              if(textfield1.getText().equals("")||textfield2.getText().equals("")){
                  JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",  JOptionPane.ERROR_MESSAGE);
              return;
              }
            int ID=Integer.parseInt(textfield1.getText());
            Calculo calcular = new Calculo(consultas.AdquirirPuntos(ID));
            if(combo1.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null, "Elija un método de generación de cluster","Error",  JOptionPane.ERROR_MESSAGE); 
            return;
            }
            if(combo2.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null, "Elija un método de parada","Error",  JOptionPane.ERROR_MESSAGE); 
            return;
            }
            if(combo1.getSelectedIndex()==1){
                if(combo2.getSelectedIndex()==1){
                  calcular.Metodo1(Integer.parseInt(textfield2.getText()));
          new Generador(new JavaApplication1(calcular.retornar_puntos()));
            setVisible(false);
                }else{
                calcular.Metodo1(Double.parseDouble(textfield2.getText()));    
              
            new Generador(new JavaApplication1(calcular.retornar_puntos()));
            setVisible(false);
                }
            }
            
            if(combo1.getSelectedIndex()==2){
                if(combo2.getSelectedIndex()==1){
                calcular.Metodo2(Integer.parseInt(textfield2.getText()));
                
            new Generador(new JavaApplication1(calcular.retornar_puntos()));
            setVisible(false);
                }else{
                calcular.Metodo2(Double.parseDouble(textfield2.getText()));    
                
            new Generador(new JavaApplication1(calcular.retornar_puntos()));
            setVisible(false);
                }
            }
            
            if(combo1.getSelectedIndex()==3){
                if(combo2.getSelectedIndex()==1){
                calcular.Metodo3(Integer.parseInt(textfield2.getText()));
                
            new Generador(new JavaApplication1(calcular.retornar_puntos()));
            setVisible(false);
                }else{
                calcular.Metodo3(Double.parseDouble(textfield2.getText()));    
                
            new Generador(new JavaApplication1(calcular.retornar_puntos()));
            setVisible(false);
                }
            }
            
            if(combo1.getSelectedIndex()==4){
                if(combo2.getSelectedIndex()==1){
                calcular.Metodo4(Integer.parseInt(textfield2.getText()));
                
            new Generador(new JavaApplication1(calcular.retornar_puntos()));
            setVisible(false);
                }else{
                calcular.Metodo4(Double.parseDouble(textfield2.getText()));    
                
            new Generador(new JavaApplication1(calcular.retornar_puntos()));
            setVisible(false);
                }
            }
            
            if(combo1.getSelectedIndex()==5){
                if(combo2.getSelectedIndex()==1){
                calcular.Metodo5(Integer.parseInt(textfield2.getText()));
                }else{
                calcular.Metodo5(Double.parseDouble(textfield2.getText()));    
                }
                new Generador(new JavaApplication1(calcular.retornar_puntos()));
            setVisible(false);
                
                
            }
            }catch(NumberFormatException error){
                 JOptionPane.showMessageDialog(null, "Números por favor","Error",  JOptionPane.ERROR_MESSAGE);
            }
            
        }
    } 
   }    
  
}
