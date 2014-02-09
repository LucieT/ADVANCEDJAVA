package Modele;


import java.util.Random;
/** La classe contact contient les attributs de chaque contact ainsi que
 * plusieurs methodes constructeurs dont une qui permet de générer des contacts
 * avec des noms aléatoires (avec les fonctions appropriées).
 * Showcontact permet d'afficher tous les attributs d'un contact, 
 * et l'attribut count permet de gérer les ID des contacts. **/
public final class Contact {
	int ID;
	private String fname;
	private String lname;
	private String address;
	private String companyaddress;
	private int personalphone;
	private int professionalphone;
	private String homepage;
	private String proemail; 
	private String persoemail;
	private String photo;
        private String groupe;
        private static int count =0;
	
	public Contact(){
		ID=count;
		fname=null;
		lname=null;
		address=null;
		companyaddress=null;
		personalphone=000000000;
		professionalphone=000000000;
		homepage=null;
		proemail=null; 
		persoemail=null;
		photo=null;
                groupe=null;
                count++;              
	}
        
	public Contact(int nID){
		ID=nID;
		fname=randomString();
		lname=randomString();
		address=randomString();
		companyaddress=randomString();
		personalphone=Integer.parseInt(randomInt());
		professionalphone=Integer.parseInt(randomInt());
		homepage="www."+randomString()+".com";
		proemail=fname+"."+lname+"@ece.fr"; 
		persoemail=fname+"."+lname+"@gmail.com";
		photo=randomString();
                groupe=randomGroupe();
	}
        
	String randomGroupe(){
        String[] tab={"Famille","Amis","Collegue","Autre"};
        Random random=new Random();
        int choix = random.nextInt(4);
        return tab[choix];     
        }
        
	String randomString(){
		Random random=new Random();
		String fullword;
		char[] word = new char[random.nextInt(8)+3];
		for(int j = 0; j < word.length; j++)
		{
			word[j] = (char)('a' + random.nextInt(26));
		}
		fullword = new String(word);
		return fullword;
	}
	
	String randomInt(){
		Random random=new Random();
		String fullint="06";
		int currentint;
		for(int j = 0; j <=3; j++)
		{
			currentint= (int) (10+(Math.random()*(99-10+1)));
			fullint+=String.valueOf(currentint);
		}
		return fullint;
	}
	
	public void Contact(String nfname,String nlname,String naddress,String ncompanyaddress,int npersonalphone,int nprofessionalphone,String nhomepage,String nproemail,String nperemail,String nphoto, String groupe){
		
                this.fname=nfname;
		this.lname=nlname;
		this.address=naddress;
		this.companyaddress=ncompanyaddress;
		this.personalphone=npersonalphone;
		this.professionalphone=nprofessionalphone;
		this.homepage=nhomepage;
		this.proemail=nproemail; 
		this.persoemail=nperemail;
		this.photo=nphoto;
                this.groupe=groupe;
	}
	
	public String showContact(){
            String description =("Contact n° "+ID+"\n"
				+ fname+
				" "+ lname+
				"\n Address: "+ address+
				"\n Company address: "+ companyaddress+
				"\n Personal phone: "+personalphone+
				"\n Professional phone: "+professionalphone+
				"\n Homepage:"+ homepage+
				"\n Professional email: "+ proemail+ 
				"\n Personal email: "+ persoemail+
                                "\n Groupe: "+ groupe+
				"\n\n");
                return description;
	}

	public String getFirstname() {
		return fname;
	}

	public void setFirstname(String firstname) {
		this.fname = firstname;
	}

	public String getLastname() {
		return lname;
	}

	public void setLastname(String lastname) {
		this.lname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyaddress() {
		return companyaddress;
	}

	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}

	public int getPersonalphone() {
		return personalphone;
	}

	public void setPersonalphone(int personalphone) {
		this.personalphone = personalphone;
	}

	public int getProfessionalphone() {
		return professionalphone;
	}

	public void setProfessionalphone(int professionalphone) {
		this.professionalphone = professionalphone;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getProemail() {
		return proemail;
	}

	public void setProemail(String proemail) {
		this.proemail = proemail;
	}

	public String getPeremail() {
		return persoemail;
	}

	public void setPeremail(String persoemail) {
		this.persoemail = persoemail;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
        
        public int getID(){
        return ID;
        }
        
        public void setID(int id){
        ID= id;
        }
                
        int getCount(){
        return count;
        }
        
        public void setCount(){
        count++;
        }
        
        public String getGroupe(){
        return groupe;
        }
        
        public void setGroupe(String groupe){
        this.groupe=groupe;
        }
}

