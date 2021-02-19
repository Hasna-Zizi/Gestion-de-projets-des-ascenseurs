package com.gproj.entities;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="UTILISATEUR")
public class Utilisateur {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_USER")
    private int id_user;
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="PRENOM")
	private String prenom;
	
	@Column(name="CIN")
	private String cin;
	
	@Column(name="TELEPHONE")
	private String telephone;
	
	@Column(name="USERNAME")
	private String Username;
	
	@Column
	private String pwd;
	
	  
	@OneToMany(mappedBy="user")
	@LazyCollection(LazyCollectionOption.FALSE)
    private List<Projet> projets = new ArrayList<Projet>();

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_role")
	private Role role;
     
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
    private List<Proj_Users_Taches> taches=new ArrayList<Proj_Users_Taches>();
    
    
	// Getter and Setters and Constructeur 
	
	 public Utilisateur() {
		super();
	  }
    
	 public Utilisateur(int id_user, String nom, String prenom, String cin, String telephone, String username,
		String pwd, List<Projet> projets, Role role, List<Proj_Users_Taches> taches) {
		super();
		this.id_user = id_user;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.telephone = telephone;
		Username = username;
		this.pwd = pwd;
		this.projets = projets;
		this.role = role;
		this.taches = taches;
	}

   public Utilisateur(String nom, String prenom, String cin, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.telephone = telephone;
	}
   

	public Utilisateur(int id_user, String nom, String prenom, String cin, String telephone, String username, String pwd,
		Role role) {
	super();
	this.id_user = id_user;
	this.nom = nom;
	this.prenom = prenom;
	this.cin = cin;
	this.telephone = telephone;
	Username = username;
	this.pwd = pwd;
	this.role = role;
}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
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

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	
	public List<Projet> getProjets() {
		return projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
   
	public List<Proj_Users_Taches> getTaches() {
		return taches;
	}

	public void setTaches(List<Proj_Users_Taches> taches) {
		this.taches = taches;
	}

  // ToString 

	@Override
	public String toString() {
		return "Utilisateur [id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin
				+ ", telephone=" + telephone + ", Username=" + Username + ", pwd=" + pwd + "]";
	}
}
