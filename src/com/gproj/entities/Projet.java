package com.gproj.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;


@Entity
@Table(name="PROJET")
public class Projet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PROJET")
	private int id_projet;
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="DATE_DEBUT")
	private LocalDate date_debut;
	
	@Column(name="DATE_FIN")
	private LocalDate date_fin;
    
	@Column(name="STATUT")
	private String status;
	
	
   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="id_user")
   private Utilisateur user = new Utilisateur();

    @OneToMany(mappedBy="projet", fetch=FetchType.LAZY)
    private List<Mat_Quant_Proj> quantites=new ArrayList<Mat_Quant_Proj>();
   
    @OneToMany(mappedBy="proj", fetch=FetchType.LAZY)
    private List<Proj_Users_Taches> taches=new ArrayList<Proj_Users_Taches>();
   
   
    // Setters Getters and Constructeurs
     
    public Projet() {
		super();
	}
 
	
	public Projet(int id_projet, String nom, LocalDate date_debut, LocalDate date_fin, Utilisateur user,
			List<Mat_Quant_Proj> quantites, List<Proj_Users_Taches> taches) {
		super();
		this.id_projet = id_projet;
		this.nom = nom;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.user = user;
		this.quantites = quantites;
		this.taches = taches;
	}
	
	public Projet(String nom, LocalDate date_debut, LocalDate date_fin) {
		super();
		this.nom = nom;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}

	public int getId_projet() {
		return id_projet;
	}

	public void setId_projet(int id_projet) {
		this.id_projet = id_projet;
	}

	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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

	public List<Mat_Quant_Proj> getQuantites() {
		return quantites;
	}
    public void setQuantites(List<Mat_Quant_Proj> quantites) {
		this.quantites = quantites;
	}

    public List<Proj_Users_Taches> getTaches() {
		return taches;
	}
    public void setTaches(List<Proj_Users_Taches> taches) {
		this.taches = taches;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Projet(int id_projet, String nom, LocalDate date_debut, LocalDate date_fin, String status,
			Utilisateur user) {
		super();
		this.id_projet = id_projet;
		this.nom = nom;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.status = status;
		this.user = user;
	}


	@Override
	public String toString() {
		return "Projet [id_projet=" + id_projet + ", nom=" + nom + ", date_debut=" + date_debut + ", date_fin="
				+ date_fin + ", status=" + status + "]";
	}

	
}
	  
	
