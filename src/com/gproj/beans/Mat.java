package com.gproj.beans;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.MoveEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gproj.entities.Materiels;
import com.gproj.imetier.IMetier;

// Component : est utilisée sur les classes pour indiquer un composant Spring. 

@ManagedBean
@Component
public class Mat {
	// Autowired : permet de faire l’injection de dépendances entre les beans de l’application .
	@Autowired
	IMetier<Materiels> metierMat;
	
 // Attributs  :
	
	   private Materiels materiel = new Materiels();
	   private Materiels materiel1 = new Materiels();
	   private String fournisseur;
	   
 //getter and setters des attributes :
	
	public Materiels getMateriel() {
		return materiel;
	}
	public void setMateriel(Materiels materiel) {
		this.materiel = materiel;
	}
	public String getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}  
	
 //Methodes :
	
	public Materiels getMateriel1() {
		return materiel1;
	}
	public void setMateriel1(Materiels materiel1) {
		this.materiel1 = materiel1;
	}
	// Methode 1 : get All Materiels 
	   public List<Materiels> getAllMat() throws Exception{
		  return metierMat.getAll();
	   }
	   
	 //Methode 2 : Delete Materiele
		  public void deleteMat(int id_materiel) {
			  
	 		materiel=metierMat.FindById(id_materiel);
	 		System.out.println(materiel);
	 		metierMat.delete(materiel);
	 	 }
	 	 
	 //Methode 2 : Update materiel
	 	public String findmat(int id_materiel) {
	 		materiel1=metierMat.FindById(id_materiel);
	 		  return "updatem";
	 	 }
	 	public String updateM() {
	 		metierMat.update(materiel1);
	 		 return "materiels";
	 	 }
	 	// Methode 3 : Save Materiel 
	 	
	 	public List<String> getAllFou() throws Exception{
	 		List<String> fou = new ArrayList<String>();
	 		List<Materiels> all = metierMat.getAll();
	 		for(Materiels M : all) {
	 		  fou.add(M.getFournisseur());
	 		}
	 		Set<String> mySet = new HashSet<String>(fou);
	 		List<String> array = new ArrayList<String>(mySet);
	 		return array;
	 	}
	 	public String saveM() {
	 		metierMat.save(materiel);
	 		return "materiels";
	 	}
		
	 	public String findmat1(int id_materiel) {
	 		materiel=metierMat.FindById(id_materiel);
	 		  return materiel.getNom();
	 	 }
	   
}





