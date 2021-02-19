package com.gproj.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="MATERIELS")
public class Materiels {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_MATERIEL")
	private int id_materiel;
	
	@Column(name="NOM")
	private String Nom;
	
	@Column(name="UNITE")
	private String Unite;
	
	@Column(name="PRIX")
	private double Prix;
	
	@Column(name="QUANTITE")
	private int Quant;
	
	@Column(name="FOURNISSEUR")
	private String Fournisseur;
	
	@OneToMany(mappedBy="mat",fetch=FetchType.EAGER)
    private List<Mat_Quant_Proj> quans = new ArrayList<Mat_Quant_Proj>();

	// Setters Getters and Constructeurs 

	public Materiels() {
		super();
	}

	

	public Materiels(int id_materiel, String nom, String unite, double prix, int quant, String fournisseur,
			List<Mat_Quant_Proj> quans) {
		super();
		this.id_materiel = id_materiel;
		Nom = nom;
		Unite = unite;
		Prix = prix;
		Quant = quant;
		Fournisseur = fournisseur;
		this.quans = quans;
	}



	public int getId_materiel() {
		return id_materiel;
	}

	public void setId_materiel(int id_materiel) {
		this.id_materiel = id_materiel;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getUnite() {
		return Unite;
	}

	public void setUnite(String unite) {
		Unite = unite;
	}

	public double getPrix() {
		return Prix;
	}

	public void setPrix(double prix) {
		Prix = prix;
	}

	public String getFournisseur() {
		return Fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		Fournisseur = fournisseur;
	}

	public int getQuant() {
		return Quant;
	}

	public void setQuant(int quant) {
		Quant = quant;
	}

	

	public List<Mat_Quant_Proj> getQuans() {
		return quans;
	}



	public void setQuans(List<Mat_Quant_Proj> quans) {
		this.quans = quans;
	}


	//ToString 
	@Override
	public String toString() {
		return "Materiels [id_materiel=" + id_materiel + ", Nom=" + Nom + ", Unite=" + Unite + ", Prix=" + Prix
				+ ", Fournisseur=" + Fournisseur + "]";
	}

}