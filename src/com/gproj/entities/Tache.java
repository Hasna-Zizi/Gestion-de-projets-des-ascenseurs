package com.gproj.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TACHE")
public class Tache {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_TACHE")
	private int id_tache ;
    
	 @Column(name="NOM")
	 private String nom;
	
     // Constructeur 
	
	public Tache() {
		super();
	}
	public Tache(int id_tache, String nom) {
		super();
		this.id_tache = id_tache;
		this.nom = nom;
	}

//Setters && Getters

public int getId_tache() {
	return id_tache;
}
public void setId_tache(int id_tache) {
	this.id_tache = id_tache;
}
 
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
// ToString 
@Override
public String toString() {
	return "Tache [id_tache=" + id_tache + ", nom=" + nom + "]";
}

}
