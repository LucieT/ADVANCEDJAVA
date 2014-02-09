package Modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/** La classe répertoire contient une arraylist de contact utilisée dans la vue.
 * C'est ici qu'est géré la liste de contact (ajout, modification, suppression) 
 * ainsi que l'import / export de ces contacts.
 La classe implements runnable afin de pouvoir utiliser les threads.**/
public class Repertoire implements Runnable {

    private ArrayList<Contact> contactlist;
    private int action = 0;

    public Repertoire(int nbContacts) {
        contactlist = new ArrayList<Contact>();
        for (int i = 0; i < nbContacts; i++) {
            contactlist.add(new Contact(i));
        }

    }

    public String showRepertoire() {
        Iterator<Contact> it = contactlist.iterator();
        String display = "";
        while (it.hasNext()) {
            Contact current = it.next();
            display = display + current.showContact();
        }
        return display;
    }

    public void addContact(String nfname, String nlname, String naddress, String ncompanyaddress, int npersonalphone, int nprofessionalphone, String nhomepage, String nproemail, String nperemail, String nphoto, String groupe) {
        Contact newc = new Contact();
        newc.Contact(nfname, nlname, naddress, ncompanyaddress, npersonalphone, nprofessionalphone, nhomepage, nproemail, nperemail, nphoto, groupe);
        contactlist.add(newc);
    }

    public void supprContact(int id) {
                contactlist.remove(id);
    }

    public void modifContact(int id, String nfname, String nlname, String naddress, String ncompanyaddress, int npersonalphone, int nprofessionalphone, String nhomepage, String nproemail, String nperemail, String nphoto, String groupe) {
        for (int i = 0; i < contactlist.size(); i++) {
            if (id == contactlist.get(i).getID()) {
                contactlist.get(i).Contact(nfname, nlname, naddress, ncompanyaddress, npersonalphone, nprofessionalphone, nhomepage, nproemail, nperemail, nphoto, groupe);
            }
        }
    }

    public void ChargerContacts() {
        try {
            int id = 0;
            File sauvegarde = new File("./res/sauvegarde.csv");
            contactlist = new ArrayList<Contact>();
            Contact tmpco;
            String tmpstr[] = null;
            Scanner lecture = new Scanner(sauvegarde);
            while (lecture.hasNextLine()) {
                tmpco=new Contact();
                System.out.println(tmpstr);
                tmpstr = lecture.nextLine().split(";");
                tmpco.setID(id);
                id++;
                tmpco.setFirstname(tmpstr[1]);
                tmpco.setLastname(tmpstr[2]);
                tmpco.setAddress(tmpstr[3]);
                tmpco.setCompanyaddress(tmpstr[4]);
                tmpco.setPersonalphone(Integer.parseInt(tmpstr[5]));
                tmpco.setProfessionalphone(Integer.parseInt(tmpstr[6]));
                tmpco.setHomepage(tmpstr[7]);
                tmpco.setPeremail(tmpstr[8]);
                tmpco.setProemail(tmpstr[9]);
                tmpco.setPhoto(tmpstr[10]);
                tmpco.setGroupe(tmpstr[11]);
                contactlist.add(tmpco);
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Repertoire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EnregContacts() {
        PrintWriter pwrite = null;
        FileWriter sauvegarde;
        try {
            sauvegarde = new FileWriter("./res/sauve.csv");
            pwrite = new PrintWriter(sauvegarde);
            for (int i = 0; i < contactlist.size(); i++) {
                pwrite.print(contactlist.get(i).getID());
                pwrite.print(";");
                pwrite.print(contactlist.get(i).getFirstname());
                pwrite.print(";");
                pwrite.print(contactlist.get(i).getLastname());
                pwrite.print(";");
                pwrite.print(contactlist.get(i).getAddress());
                pwrite.print(";");
                pwrite.print(contactlist.get(i).getCompanyaddress());
                pwrite.print(";");
                pwrite.print(contactlist.get(i).getPersonalphone());
                pwrite.print(";");
                pwrite.print(contactlist.get(i).getProfessionalphone());
                pwrite.print(";");
                pwrite.print(contactlist.get(i).getHomepage());
                pwrite.print(";");
                pwrite.print(contactlist.get(i).getPeremail());
                pwrite.print(";");
                pwrite.print(contactlist.get(i).getProemail());
                pwrite.print(";");
                pwrite.print(contactlist.get(i).getPhoto());
                pwrite.print(";");
                pwrite.println(contactlist.get(i).getGroupe());

            }
        } catch (IOException ex) {
            Logger.getLogger(Repertoire.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            pwrite.flush();
            pwrite.close();
        }

    }
    
    public ArrayList<Contact> getList(){
    return contactlist;
    }
    
    public void setAction(int a){
    action = a;
    }

    @Override
                public void run(){
        if (action == 0){
    ChargerContacts();
        } else if (action == 1){
        EnregContacts();
        }else{
            System.out.println("Erreur lors du choix de l'action");
        }
    }

}
