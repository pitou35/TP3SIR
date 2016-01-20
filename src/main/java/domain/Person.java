package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
	
	private int Id;

	private String nom;
	
	private String prenom;
	
	private String email;
	
	private List<ElectronicDevices> Elect=new ArrayList<ElectronicDevices>();
	
	private List<Home> maisons=new ArrayList<Home>();
	
	
	
	
	public Person(String nom, String prenom, String email){
		this.nom=nom;
		this.prenom=prenom;
		this.email=email;
		
	}

    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Id
    @GeneratedValue
    public int getId() {
		return Id;
	}
	
    public void setId(int id) {
		Id = id;
	}
	
    @OneToMany(mappedBy="owner", cascade=CascadeType.PERSIST)
    public List<Home> getMaisons(){
    	return maisons;
    }
    
    public void setMaisons(List<Home> maisons){
    	this.maisons=maisons;
    }
    
    public void addMaisons(Home maison){
    	maisons.add(maison);
    	maison.setOwner(this);
    }
    
    public void removeMaisons(Home maison){
    	maisons.remove(maison);
    }
    
    @OneToMany(mappedBy="owner")
    public List<ElectronicDevices> getElect() {
		return Elect;
	}

	public void setElect(List<ElectronicDevices> elect) {
		Elect = elect;
	}

	public void addElec(ElectronicDevices elec){
    	Elect.add(elec);
    }
    
    public void removeElec(ElectronicDevices elec){
    	Elect.remove(elec);
    }
	
	@Override
	public String toString() {
		return "personne [id=" + Id + ", name=" + nom + ", prenom="+ prenom + ", email="+email+"]";
	}
	
	
    
}
