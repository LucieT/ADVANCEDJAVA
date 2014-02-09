package Vue;

import Modele.Bouton;
import Modele.Contact;
import Modele.Label;
import Modele.Repertoire;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/** La classe panel est un conteneur de la fenetre.
 * tous ses attributs sont les composants de la fenetre.
 * Tout est ajouté/construit dans le constructeur.
 * Les actions sur les boutons sont gérés ensuite.
 * ajout, suppression, modification, selection dans les differentes combobox, 
 * acceder aux urls / liens / mail / affichage et tri **/

public class Panel extends JPanel implements ActionListener {

    //DECLARATION DES COMPOSANTS DE LA FENETRES: ATTRIBUTS
    //ATTRIBUTS CONTROLLER 
    private static int NBCONTACTS = 10;
    private Repertoire rep1 = new Repertoire(NBCONTACTS);
    // CONTACT PANEL
    // Boutons de contrôle de la liste de contact 
    private Bouton orderbyletter = new Bouton("BY LETTERS");
    private Bouton orderbydate = new Bouton("BY ENTRIES");
    // Bouton de contrôle lorsqu'un contact est selectionné 
    private Bouton suppr = new Bouton("DELETE");
    private Bouton modif = new Bouton("MODIFY");
    // Combo box de la liste de contact 
    private Label liste = new Label("Contacts: ");
    private JComboBox list;
    // Text Area de la liste de contact
    private JTextArea displaycontact = new JTextArea("");
    private JScrollPane scroll = new JScrollPane(displaycontact);
    //Combo box de la liste des groupes possibles.
    private Label grouplist = new Label("Groups: ");
    private JComboBox group;
    // FORM PANEL
    // Bouton de contrôle pour un nouveau contact
    private Bouton add = new Bouton("ADD");
    private Bouton newcontact = new Bouton("NEW");
    // Bouton des actions sur un contact
    private Bouton gotowebsite = new Bouton("GO TO HOMEPAGE");
    private Bouton sendproemail = new Bouton("MAIL PRO");
    private Bouton sendpersemail = new Bouton("MAIL PERSO");
    // Formulaire, les différents champs et labels associés
    private Label fname = new Label("First Name: ");
    private JTextField jfname = new JTextField("Enter the name");
    private Label lname = new Label("Last Name: ");
    private JTextField jlname = new JTextField("Enter the last name");
    private Label address = new Label("Address: ");
    private JTextField jaddress = new JTextField("Enter the address");
    private Label cmpaddress = new Label("Company Address: ");
    private JTextField jcaddress = new JTextField("Enter the company address");
    private Label persophone = new Label("Personnal Phone: ");
    private JTextField jpersophone = new JTextField("00");
    private Label profphone = new Label("Professional Phone: ");
    private JTextField jprophone = new JTextField("00");
    private Label homepage = new Label("Home Page: ");
    private JTextField jhome = new JTextField("www.");
    private Label proemail = new Label("Professional Email: ");
    private JTextField jproemail = new JTextField("@ece.fr");
    private Label persoemail = new Label("Personal Email: ");
    private JTextField jpersoemail = new JTextField("@gmail.com");
    private Bouton photo = new Bouton("PICTURE: ");
    private JTextField jpict = new JTextField("inconnu.jpg");
    private Image img;
    private ImageIcon imgicon;
    private JLabel imagecontact;
    private Label groupe = new Label("Groupe: ");
    private JTextField jgroupe = new JTextField("Enter a group");

    //CONSTRUCTEUR
    public Panel() {

        // PARAMETRES GENERAUX

        Color font = new Color(220, 220, 220);
        this.setBackground(font);
        this.setLayout(null);
        // On charge les contacts:
        rep1.setAction(0);
        Thread t1 = new Thread(rep1);
        t1.start();

        // FORM PANEL 

        // Champs du formulaire

        fname.setBounds(26, 96, 250, 20);
        this.add(fname);
        jfname.setBounds(276, 96, 200, 20);
        this.add(jfname);
        lname.setBounds(26, 126, 250, 20);
        this.add(lname);
        jlname.setBounds(276, 126, 200, 20);
        this.add(jlname);
        address.setBounds(26, 156, 250, 20);
        this.add(address);
        jaddress.setBounds(276, 156, 200, 20);
        this.add(jaddress);
        cmpaddress.setBounds(26, 186, 250, 20);
        this.add(cmpaddress);
        jcaddress.setBounds(276, 186, 200, 20);
        this.add(jcaddress);
        persophone.setBounds(26, 216, 250, 20);
        this.add(persophone);
        jpersophone.setBounds(276, 216, 200, 20);
        this.add(jpersophone);
        profphone.setBounds(26, 246, 250, 20);
        this.add(profphone);
        jprophone.setBounds(276, 246, 200, 20);
        this.add(jprophone);
        homepage.setBounds(26, 276, 250, 20);
        this.add(homepage);
        jhome.setBounds(276, 276, 200, 20);
        this.add(jhome);
        proemail.setBounds(26, 306, 250, 20);
        this.add(proemail);
        jproemail.setBounds(276, 306, 200, 20);
        this.add(jproemail);
        persoemail.setBounds(26, 336, 250, 20);
        this.add(persoemail);
        jpersoemail.setBounds(276, 336, 200, 20);
        this.add(jpersoemail);
        groupe.setBounds(26, 366, 250, 20);
        this.add(groupe);
        jgroupe.setBounds(276, 366, 200, 20);
        this.add(jgroupe);
        //picture
        photo.setBounds(26, 396, 80, 40);



        this.add(photo);
        jpict.setBounds(276, 396, 200, 20);
        this.add(jpict);
        try {
            img = ImageIO.read(new File("inconnu.jpg"));
            imgicon = new ImageIcon(img);
            imagecontact = new JLabel(imgicon);
            imagecontact.setBounds(56, 450, 200, 200);
            this.add(imagecontact);
        } catch (IOException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
                photo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                File selection = null;
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    selection = chooser.getSelectedFile();
                    jpict.setText(selection.getAbsolutePath());
                }

                try {
                    imagecontact.setIcon(new ImageIcon(ImageIO.read(new File(selection.getAbsolutePath()))));
                } catch (IOException ex) {
                    Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //Boutons

        add.setBounds(300, 480, 150, 40);
        add.addActionListener(this);
        add.setEnabled(false);
        this.add(add);

        gotowebsite.addActionListener(new URLOpenAdapter());
        gotowebsite.setBounds(300, 530, 150, 40);
        gotowebsite.setEnabled(false);
        this.add(gotowebsite);

        sendproemail.addActionListener(new MailOpenAdapter());
        sendproemail.setBounds(300, 580, 150, 40);
        sendproemail.setEnabled(false);
        this.add(sendproemail);

        sendpersemail.addActionListener(new MailOpenAdapter());
        sendpersemail.setBounds(300, 630, 150, 40);
        sendpersemail.setEnabled(false);
        this.add(sendpersemail);

        newcontact.addActionListener(this);
        newcontact.setBounds(300, 430, 150, 40);
        this.add(newcontact);

        // CONTACT PANEL

        //Boutons

        modif.setBounds(538, 550, 80, 40);
        modif.addActionListener(this);
        modif.setEnabled(false);
        this.add(modif);

        suppr.setBounds(638, 550, 80, 40);
        suppr.addActionListener(this);
        suppr.setEnabled(false);
        this.add(suppr);

        orderbyletter.setBounds(738, 550, 80, 40);
        orderbyletter.addActionListener(this);
        this.add(orderbyletter);

        orderbydate.setBounds(838, 550, 80, 40);
        orderbydate.addActionListener(this);
        this.add(orderbydate);

        liste.setBounds(528, 86, 100, 30);
        this.add(liste);

        list = new JComboBox(updateBox());
        list.setBounds(628, 86, 300, 30);
        list.addActionListener(new ItemAction());
        this.add(list);

        displaycontact.setBounds(528, 126, 400, 400);
        scroll.setBounds(528, 126, 400, 400);
        displaycontact.setEditable(false);
        displaycontact.setText(rep1.showRepertoire());
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scroll);

        grouplist.setBounds(538, 605, 80, 40);
        this.add(grouplist);

        String[] tab = {"Famille", "Amis", "Collegue", "Autre"};
        group = new JComboBox(tab);
        group.setBounds(628, 610, 300, 30);
        group.addActionListener(new ItemAction());
        this.add(group);

        displaycontact.setText(rep1.showRepertoire());

    }

    public void paintComponent(Graphics g) {

// paramètres de base
        Font font = new Font("Verdana", Font.PLAIN, 20);
        g.setFont(font);
        Color writting_color = new Color(49, 51, 130);
        g.setColor(writting_color);


        // form panel            
        g.drawRect(16, 16, 476, 698);
        g.drawRoundRect(332, 26, 150, 50, 20, 20);
        g.drawString("Form Panel", 357, 56);

        // Contact panel
        g.drawRect(508, 16, 476, 698);
        g.drawRoundRect(518, 26, 150, 50, 20, 20);
        g.drawString("Contact Panel", 523, 56);

    }

    public void actionPerformed(ActionEvent arg0) {

        if (arg0.getSource() == add) {
            for (int i = 0; i < rep1.getList().size(); i++) {
                if (!jlname.getText().equals(rep1.getList().get(i).getLastname())) {
                    int phone1 = Integer.parseInt(jpersophone.getText());
                    int phone2 = Integer.parseInt(jprophone.getText());
                    rep1.addContact(jfname.getText(), jlname.getText(), jaddress.getText(), jcaddress.getText(), phone1, phone2, jhome.getText(), jproemail.getText(), jpersoemail.getText(), jpict.getText(), jgroupe.getText());
                    int last = (rep1.getList().size() - 1);
                    String affi = rep1.getList().get(last).showContact();
                    displaycontact.setText(affi);
                    list.addItem(jlname.getText());
                            rep1.setAction(1);
                    Thread t2 = new Thread(rep1);
                     t2.start();
                    break;
                }
            }

        } else if (arg0.getSource() == suppr) {
            for (int i = 0; i < rep1.getList().size(); i++) {
                if (rep1.getList().get(i).getLastname().equals(list.getSelectedItem())) {
                    list.removeItem(list.getSelectedItem());
                    rep1.supprContact(i);
                    rep1.setAction(1);
                    Thread t3 = new Thread(rep1);
                     t3.start();
                    String affi = rep1.showRepertoire();
                    displaycontact.setText(affi);
                    break;
                }
            }
            gotowebsite.setEnabled(false);
            sendproemail.setEnabled(false);
            sendpersemail.setEnabled(false);
            modif.setEnabled(false);
            suppr.setEnabled(false);
            newcontact.setEnabled(true);

        } else if (arg0.getSource() == modif) {
            for (int i = 0; i < rep1.getList().size(); i++) {
                if (list.getSelectedItem().equals(rep1.getList().get(i).getLastname())) {
                    String removed = rep1.getList().get(i).getLastname();
                    int phone1 = Integer.parseInt(jpersophone.getText());
                    int phone2 = Integer.parseInt(jprophone.getText());
                    rep1.modifContact(i, jfname.getText(), jlname.getText(), jaddress.getText(), jcaddress.getText(), phone1, phone2, jhome.getText(), jproemail.getText(), jpersoemail.getText(), jpict.getText(), jgroupe.getText());
                    list.addItem(jlname.getText());
                    list.removeItem(removed);
                    rep1.setAction(1);
                    Thread t4 = new Thread(rep1);
                     t4.start();
                    String affi = rep1.showRepertoire();
                    displaycontact.setText(affi);
                    break;
                }
            }
            gotowebsite.setEnabled(false);
            sendproemail.setEnabled(false);
            sendpersemail.setEnabled(false);
            modif.setEnabled(false);
            suppr.setEnabled(false);
            newcontact.setEnabled(true);

        } else if (arg0.getSource() == orderbyletter) {
            int lengh = rep1.getList().size();
            Contact temp;
            String current;
            String next;
            for (int i = 0; i < lengh; i++) {
                current = rep1.getList().get(i).getLastname();
                for (int j = i + 1; j < lengh; j++) {
                    next = rep1.getList().get(j).getLastname();
                    if (current.compareTo(next) > 0) {
                        temp = rep1.getList().get(i);
                        rep1.getList().set(i, rep1.getList().get(j));
                        rep1.getList().set(j, temp);
                        current = next;
                    }
                }
            }
            displaycontact.setText("");
            char letter = 'z';
            for (int k = 0; k < lengh; k++) {

                if (rep1.getList().get(k).getLastname().charAt(0) != letter) {
                    letter = rep1.getList().get(k).getLastname().charAt(0);
                    displaycontact.append(" _ _ _ _ _ _ _ _ " + letter + " _ _ _ _ _ _ _ _\n\n");
                }
                displaycontact.append(rep1.getList().get(k).showContact());
                displaycontact.append("\n");
            }
                        gotowebsite.setEnabled(false);
            sendproemail.setEnabled(false);
            sendpersemail.setEnabled(false);
            modif.setEnabled(false);
            suppr.setEnabled(false);
            newcontact.setEnabled(true);

        } else if (arg0.getSource() == orderbydate) {
            int lengh = rep1.getList().size();
            Contact temp;
            int current;
            int next;
            for (int i = 0; i < lengh; i++) {
                current = rep1.getList().get(i).getID();
                for (int j = i + 1; j < lengh; j++) {
                    next = rep1.getList().get(j).getID();
                    if (current > next) {
                        temp = rep1.getList().get(i);
                        rep1.getList().set(i, rep1.getList().get(j));
                        rep1.getList().set(j, temp);
                        current = next;
                    }
                }
            }
            displaycontact.setText("");
            for (int k = 0; k < lengh; k++) {
                displaycontact.append(rep1.getList().get(k).showContact());
                displaycontact.append("\n\n");
                
                            gotowebsite.setEnabled(false);
            sendproemail.setEnabled(false);
            sendpersemail.setEnabled(false);
            modif.setEnabled(false);
            suppr.setEnabled(false);
            newcontact.setEnabled(true);
            }

        } else if (arg0.getSource() == newcontact) {
            jfname.setText("Enter the name");
            jlname.setText("Enter the last name");
            jaddress.setText("Enter the address");
            jcaddress.setText("Enter the company address");
            jhome.setText("www.");
            jproemail.setText("@ece.fr");
            jpersoemail.setText("@gmail.com");
            jpict.setText("");
            jpersophone.setText("00");
            jprophone.setText("00");
            jgroupe.setText("Enter a group");
            add.setEnabled(true);

        }
    }

    public String[] updateBox() {
        ArrayList<String> listetemp = new ArrayList<>();
        for (int i = 0; i < rep1.getList().size(); i++) {
            listetemp.add(rep1.getList().get(i).getLastname());
        }
        String[] tab = listetemp.toArray(new String[0]);
        return tab;
    }

    class ItemAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == list) {

                System.out.println("Action sur " + list.getSelectedItem());
                for (int i = 0; i < rep1.getList().size(); i++) {
                    if (rep1.getList().get(i).getLastname().equals(list.getSelectedItem())) {

                        String phone1 = Integer.toString(rep1.getList().get(i).getPersonalphone());
                        String phone2 = Integer.toString(rep1.getList().get(i).getProfessionalphone());
                        jfname.setText(rep1.getList().get(i).getFirstname());
                        jlname.setText(rep1.getList().get(i).getLastname());
                        jaddress.setText(rep1.getList().get(i).getAddress());
                        jcaddress.setText(rep1.getList().get(i).getCompanyaddress());
                        jhome.setText(rep1.getList().get(i).getHomepage());
                        jproemail.setText(rep1.getList().get(i).getProemail());
                        jpersoemail.setText(rep1.getList().get(i).getPeremail());
                        jpict.setText(rep1.getList().get(i).getPhoto());
                        jpersophone.setText(phone1);
                        jprophone.setText(phone2);
                        jgroupe.setText(rep1.getList().get(i).getGroupe());
                        displaycontact.setText(rep1.getList().get(i).showContact());
                        gotowebsite.setEnabled(true);
                        sendproemail.setEnabled(true);
                        sendpersemail.setEnabled(true);
                        modif.setEnabled(true);
                        suppr.setEnabled(true);
                        newcontact.setEnabled(false);
                        add.setEnabled(false);
                                        try {
                    imagecontact.setIcon(new ImageIcon(ImageIO.read(new File(rep1.getList().get(i).getPhoto()))));
                } catch (IOException ex) {
                    Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                }

                        break;
                    }
                }
            } else if (e.getSource() == group) {
                displaycontact.setText("");
                System.out.println("group selected:" + group.getSelectedItem());
                for (int i = 0; i < rep1.getList().size(); i++) {
                    if (rep1.getList().get(i).getGroupe().equals(group.getSelectedItem())) {
                        displaycontact.append(rep1.getList().get(i).showContact());
                    }
                }
                gotowebsite.setEnabled(false);
                sendproemail.setEnabled(false);
                sendpersemail.setEnabled(false);
                modif.setEnabled(false);
                suppr.setEnabled(false);
                add.setEnabled(false);
                newcontact.setEnabled(true);
            }
        }
    }

    class URLOpenAdapter implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (Desktop.isDesktopSupported()) {
                try {
                    System.out.println(jhome.getText());
                    Desktop.getDesktop().browse(new URI(jhome.getText()));
                } catch (Throwable t) {
                    System.out.println("Erreur pour acceder a la home page");
                    //
                }
            }
        }
    }

    class MailOpenAdapter implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == sendpersemail) {

                if (Desktop.isDesktopSupported()) {
                    try {
                        System.out.println(jpersoemail.getText());
                        Desktop.getDesktop().browse(new URI("mailto:" + jpersoemail.getText()));
                    } catch (Throwable t) {
                        System.out.println("Erreur lien email");

                    }
                }
            } else if (e.getSource() == sendproemail) {

                if (Desktop.isDesktopSupported()) {
                    try {

                        System.out.println(jproemail.getText());
                        Desktop.getDesktop().browse(new URI("mailto:" + jproemail.getText()));
                    } catch (Throwable t) {
                        System.out.println("Erreur lien email");

                    }
                }

            }
        }
    }
}
