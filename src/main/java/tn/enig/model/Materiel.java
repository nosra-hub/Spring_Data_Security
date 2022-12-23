package tn.enig.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Materiel {
	@Id 
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer id ;
	private String titre ;
	private String type;
	private int numser;
	private int qte;
	private String etat;

	@ManyToOne
	@JoinColumn(name ="dept_idd")
	private Departement dept ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNumser() {
		return numser;
	}
	public void setNumser(int numser) {
		this.numser = numser;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Departement getDept() {
		return dept;
	}
	public void setDept(Departement dept) {
		this.dept = dept;
	}
	public Materiel() {
		super();
	}
	public Materiel(int id, String titre, String type, int numser, int qte, String etat, Departement dept) {
		super();
		this.id = id;
		this.titre = titre;
		this.type = type;
		this.numser = numser;
		this.qte = qte;
		this.etat = etat;
		this.dept = dept;
	}
}
