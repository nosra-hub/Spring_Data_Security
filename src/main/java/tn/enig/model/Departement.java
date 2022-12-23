package tn.enig.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Departement {
	@Id 
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer idd ;
	private String titre ;
	public Departement() {
		super();
	}
	public Departement(int idd, String titre) {
		super();
		this.idd = idd;
		this.titre = titre;
	}
	public Integer getIdd() {
		return idd;
	}
	public void setIdd(Integer idd) {
		this.idd = idd;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
}
