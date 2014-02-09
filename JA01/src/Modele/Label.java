
package Modele;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/** Cette classe est une classe qui sert seulement a modifier
 * l'apparence / ecriture... de mes labels **/

public class Label extends JLabel {
    
    private String name;
    
    public Label(String str){
    super(str);
    this.name = str;
    Font police = new Font("Verdana", Font.PLAIN, 16);
    this.setFont(police);
    this.setForeground(Color.black);
  }  
       
}
