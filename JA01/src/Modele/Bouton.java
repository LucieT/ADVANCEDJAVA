package Modele;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/** Cette classe est une classe qui sert seulement a modifier
 * l'apparence de mes boutons **/

public class Bouton extends JButton implements MouseListener {
  private String name;
  private Image img;
  private Graphics g;
  
  public Bouton(String str){
    super(str);
    this.name = str;
    this.addMouseListener(this);
  }
        
  public void paintComponent(Graphics g){
      
      this.g=g;
      Color b1 = new Color(180, 180, 180);
      Color b2 = new Color(230, 230, 230);
      Color b3 = new Color(49, 51, 130);
    Graphics2D g2d = (Graphics2D)g;
    GradientPaint gp = new GradientPaint(0, 0, b2, 0, 25, b1, true);
    g2d.setPaint(gp);
    g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
    g2d.setColor(b3);
    g2d.drawString(this.name, (this.getWidth() / 2) - (this.name.length()*4), (this.getHeight() / 2) + 5);
  }    
  
   //Méthode appelée lors du clic de souris
  public void mouseClicked(MouseEvent event) {
  }

  //Méthode appelée lors du survol de la souris
  public void mouseEntered(MouseEvent event) {  
  }

  //Méthode appelée lorsque la souris sort de la zone du bouton
  public void mouseExited(MouseEvent event) { 
  }

  //Méthode appelée lorsque l'on presse le bouton gauche de la souris
  public void mousePressed(MouseEvent event) {
  }

  //Méthode appelée lorsque l'on relâche le clic de souris
  public void mouseReleased(MouseEvent event) {          
  }  
}

