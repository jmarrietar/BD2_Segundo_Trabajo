/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class AgregarPunto extends JFrame {
       JLabel label1, label2, label3;
   JTextField textfield1,textfield2,textfield3;
     JButton boton1, boton2;
     public AgregarPunto(){
         super("Agregar Punto");
         setSize(350,150);
    setLayout(new FlowLayout());
    label1= new JLabel("ID"); 
    label2= new JLabel("X");
    label3= new JLabel("Y");
    textfield1=new JTextField(8);
    textfield2=new JTextField(8);
    textfield3=new JTextField(8);
    boton1=new JButton("Insertar");
    boton2=new JButton("Devolver");
    boton1.addActionListener(new accionesAgregarPunto());
    boton2.addActionListener(new accionesAgregarPunto());
    Container contenedor= this.getContentPane();
    contenedor.add(label1);
    contenedor.add(textfield1);
    contenedor.add(label2);
    contenedor.add(textfield2);
    contenedor.add(label3);
    contenedor.add(textfield3);
    contenedor.add(boton1);
    contenedor.add(boton2);
    setLocation(200,100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setVisible(true); 
    setBackground(Color.white);
     }
        class accionesAgregarPunto implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton1){
            int ID;
            int X;
            int Y;
            try{
            ID=Integer.parseInt(textfield1.getText());
            X=Integer.parseInt(textfield2.getText());
            Y=Integer.parseInt(textfield3.getText());
            if(X>0 && X<1000 && Y>0 && Y<1000){
            Consulta consulta=new Consulta();
            consulta.InsertarConjunto(ID);
            consulta.InsertarPuntos(ID, X, Y);
               JOptionPane.showMessageDialog(null, "Datos ingresados con exito","Exito",  JOptionPane.PLAIN_MESSAGE); 
            }else{
                JOptionPane.showMessageDialog(null, "Números entre 0 y 999","Error",  JOptionPane.ERROR_MESSAGE); 
            }
            }catch(Exception al){
               JOptionPane.showMessageDialog(null, "Números por favor","Error",  JOptionPane.ERROR_MESSAGE); 
            textfield1.setText("");
            }
            textfield2.setText("");
            textfield3.setText("");
            
        }if(e.getSource()==boton2){
            new Interface();
            setVisible(false);
        }
    } 
   }    

}
