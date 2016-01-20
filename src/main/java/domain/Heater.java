package domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Heater {

	private int id;
	private int conso;
	
	private Home owner;
	
	public Heater(int conso){
		this.conso=conso;
	}

	

	public int getConso() {
		return conso;
	}

	public void setConso(int conso) {
		this.conso = conso;
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OWNER_ID")
	public Home getOwner(){
		return owner;
	}
	
	public void setOwner(Home owner){
		this.owner=owner;
	}
	
}
