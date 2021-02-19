package com.gproj.entities;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PROJ_USERS_TACHES")
public class Proj_Users_Taches {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="ID_TACHE")
	private int id_tache ;
	
    @Column(name="DATE_DEBUT")
	
	private LocalDate date_debut;
	
	@Column(name="DATE_FIN")
	
	private LocalDate date_fin;
	
    @Column(name="AVANCEMENT")
	
	private String avancement;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user")
	private Utilisateur user;
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_projet")
	private Projet proj;

	//constructeur 
	
	public Proj_Users_Taches() {
		super();
	}

	
	

	public Proj_Users_Taches(int id, int id_tache, LocalDate date_debut, LocalDate date_fin, String avancement,
			Utilisateur user, Projet proj) {
		super();
		this.id = id;
		this.id_tache = id_tache;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.avancement = avancement;
		this.user = user;
		this.proj = proj;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getId_tache() {
		return id_tache;
	}

	public void setId_tache(int id_tache) {
		this.id_tache = id_tache;
	}

	public LocalDate getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(LocalDate date_debut) {
		this.date_debut = date_debut;
	}

	public LocalDate getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(LocalDate date_fin) {
		this.date_fin = date_fin;
	}

	public Utilisateur getUser() {
		return user;
	}


	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Projet getProj() {
		return proj;
	}


	public void setProj(Projet proj) {
		this.proj = proj;
	}


	public String getAvancement() {
		return avancement;
	}


	public void setAvancement(String avancement) {
		this.avancement = avancement;
	}


	@Override
	public String toString() {
		return "Proj_Users_Taches [id=" + id + ", id_tache=" + id_tache + ", date_debut=" + date_debut + ", date_fin="
				+ date_fin + ", user=" + user + ", proj=" + proj + "]";
	}

	
}
