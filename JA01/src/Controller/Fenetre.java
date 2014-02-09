package Controller;

import Vue.Panel;
import javax.swing.JFrame;

/** Cette classe est la classe fenetre qui contient ses paramètres de base
 * comme titre, taille, position, comportenement, et visibilité.
 * On y déclare un conteneur, un Panel **/

public class Fenetre extends JFrame {
    
    public Fenetre(){
        
     // PARAMETRES DE LA FENETRE      
        
    //Titre de la fenetre
    this.setTitle("Advanced JAVA LAB 01 - Lucie TEILHAC");
    //Taille
    this.setSize(1006,758);
    //Position
    this.setLocationRelativeTo(null);
    //Exit on close
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Redimensionnement
    this.setResizable(false);
    // Déclaration du panel
    Panel pan = new Panel();
     this.setContentPane(pan);       
    //Visibilité       
    this.setVisible(true);
    
    }
}
