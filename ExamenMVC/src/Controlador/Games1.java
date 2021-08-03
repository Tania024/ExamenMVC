/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author LENOVO
 */
public class Games1 {
    private JTextField jTextField;
    private JLabel jLabe1;
    private JLabel jLabel2;
    private boolean play = false;

    private final String[] palabra_secr ={"Rosa", "Girasol", "Lirio", "Tulipsn","Claveles" ,
                                        "Rana","Pato","Gallina","Perro","Raton"};
    
   //flores
   //animales                                     
    private char[] palabra_secreta;
    private char[] palabra;
   
   

    private int intentos = 0;
    private boolean cambios = false;

    /**
     * Constructor de clase
     * @param jTextField Control donde va la palabra
     * @param jLabel1 Para mostrar la cantidad de fallos
     * @param jLabel2 Para mostrar la imagen del colgado
     */
    public Games1(JTextField jTextField, JLabel jLabel1, JLabel jLabel2) {        
        this.jTextField = jTextField;
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        
        //obtiene palabra secreta
        //palabra_secreta = Random().toCharArray();
        palabra_secreta = palabra_secr[(int) (Math.random() * (palabra_secr.length))].toCharArray();
        System.out.println(Arrays.toString(palabra_secreta)); //no haga trampa
        String s = " ";
        for (int i = 0; i <= palabra_secreta.length - 1; i++) {
            s = s + " x ";            
        }
        //convierte este en un array
        this.palabra = s.toCharArray();
        
        //inicia valores en la interfaz
        jTextField.setText(s);
        jLabel1.setIcon(new ImageIcon(getClass().getResource("C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\ExamenMVC\\src\\Archivos\\1.jpeg")));
        jLabel2.setIcon(new ImageIcon(getClass().getResource("C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\ExamenMVC\\src\\Archivos\\5.jpeg")));
        this.play = true;
    }
    
   
    public void evaluar(char letra) {
        if (play) {
            String p = " ";
            //controla cantidad de intentes restantes
            if (intentos == 4) {
                JOptionPane.showMessageDialog(null, "Ganaste");
            } else {
                //evalua caracter por caracter                
                for (int j = 0; j <= this.palabra_secreta.length - 1; j++) {
                    //si el caracter se encuentra en la palabra secreta            
                    if (this.palabra_secreta[j] == letra) {
                        this.palabra[j] = letra;//se asigna para que se pueda ver en pantalla
                        cambios = true;
                    }
                    p = p + this.palabra[j];
                }//fin for
                
                //si no se produjo ningun cambio, quiere decir que el jugador se equivoco
                if (cambios == false) {
                    intentos += 1; //se incrementa     
                    //actualiza interfaz
                    jLabel1.setIcon(new ImageIcon(getClass().getResource("C:\\Users\\LENOVO\\Downloads\\ExamenFinal\\src\\Archivos\\1.jpeg" + this.intentos + ".jpg")));
                    jLabel2.setIcon(new ImageIcon(getClass().getResource("C:\\Users\\LENOVO\\Downloads\\ExamenFinal\\src\\Archivos\\1.jpeg" + this.intentos + ".jpg")));
                    if (this.intentos < 4) {
                        JOptionPane.showMessageDialog(null, "Faltan " + (4 - intentos) + " intentos ");
                    }
                } else {
                    this.cambios = false;
                }
                this.jTextField.setText(p);
                //comprobamos el estado del juego
                gano();
            }
        }
    }

    private void gano() {
        boolean win = false;
        for (int i = 0; i <= this.palabra_secreta.length - 1; i++) {
            if (this.palabra[i] == this.palabra_secreta[i]) {
                win = true;
            } else {
                win = false;
                break;
            }
        }
        if (win) {
            JOptionPane.showMessageDialog(null, "GANASTE ");
        }
    }

}

