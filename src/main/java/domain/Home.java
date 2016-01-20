package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Home {
	
	private int id;

	private int taille;
	
	private int nbPieces;
	
	private Person owner;
	
	private List<Heater> chauffages=new ArrayList<Heater>();
	
	public Home(int taille, int nbPieces){
		this.taille=taille;
		this.nbPieces=nbPieces;
	}

	
	
	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getNbPieces() {
		return nbPieces;
	}

	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}
	
	
	@Id
    @GeneratedValue
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name="OWNER_ID")
	public Person getOwner(){
		return owner;
	}
	
	public void setOwner(Person owner){
		this.owner=owner;
	}
	
	@OneToMany(mappedBy="owner")
    public List<Heater> getChauffages(){
    	return chauffages;
    }
    
    public void setChauffages(List<Heater> chauffages){
    	this.chauffages=chauffages;
    }
    
    public void addChauffages(Heater heater){
    	chauffages.add(heater);
    }
	
}
