package domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ElectronicDevices {
 
	private int id;
	private int Conso;
	private Person owner;
	
	public ElectronicDevices(int conso){
		this.Conso=conso;
		
	}

	

	public int getConso() {
		return Conso;
	}

	public void setConso(int conso) {
		Conso = conso;
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
	public Person getOwner(){
		return owner;
	}
	
	public void setOwner(Person owner){
		this.owner=owner;
	}
}
