package com.gproj.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="ROLE")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_ROLE")
	private int id_role;
	
	@Column(name="ROLE")
	private String role;
	
	@Column(name="DISCRIPTION")
	private String discription;
	
	@OneToMany(mappedBy="role", fetch=FetchType.EAGER)
    private List<Utilisateur>utilisateurs = new ArrayList<Utilisateur>();
    
	// Getters and Setters Constructeurs 
	  
	public Role() {
		 super();
	}
   
	public Role(int id_role, String role, String discription, List<Utilisateur> utilisateurs) {
		super();
		this.id_role = id_role;
		this.role = role;
		this.discription = discription;
		this.utilisateurs = utilisateurs;
	}


	public int getId_role() {
		return id_role;
	}
	public void setId_role(int id_role) {
		this.id_role = id_role;
	}


	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}


	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}


	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

// ToString 
	@Override
	public String toString() {
		return "Role [id_role=" + id_role + ", role=" + role + ", discription=" + discription +
			 "]";
	}	
	
}
