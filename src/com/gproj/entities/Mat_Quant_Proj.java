package com.gproj.entities;


import javax.persistence.*;

import org.hibernate.annotations.Proxy;


@Entity
@Table(name="Mat_Quant_Proj")
@Proxy(lazy = false)
public class Mat_Quant_Proj {
	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="ID")
	    private int id;
		
		@Column(name="QUANTITE")
		private int quantite;
		
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="id_projet")
	    private Projet projet;
        
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="id_materiel")
		private Materiels mat;

		// Setters Getters and Constructeurs 
		
		public Mat_Quant_Proj() {
			super();
		}

		
		public Mat_Quant_Proj(int id, int quantite, Projet projet, Materiels mat) {
			super();
			this.id = id;
			this.quantite = quantite;
			this.projet = projet;
			this.mat = mat;
		}


		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getQuantite() {
			return quantite;
		}

		public void setQuantite(int quantite) {
			this.quantite = quantite;
		}

		public Projet getProjet() {
			return projet;
		}

		public void setProjet(Projet projet) {
			this.projet = projet;
		}

		
		public Materiels getMat() {
			return mat;
		}


		public void setMat(Materiels mat) {
			this.mat = mat;
		}

		//ToString
		@Override
		public String toString() {
			return "Mat_Quant_Proj [id=" + id + ", quantite=" + quantite + ", projet=" + projet + ", mat=" + mat + "]";
		}

}
