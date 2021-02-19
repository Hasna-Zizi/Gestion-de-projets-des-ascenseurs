package com.gproj.beans;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;



import javax.faces.bean.ManagedBean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gproj.entities.Mat_Quant_Proj;
import com.gproj.entities.Materiels;
import com.gproj.entities.Proj_Users_Taches;
import com.gproj.entities.Projet;
import com.gproj.entities.Tache;
import com.gproj.entities.Utilisateur;
import com.gproj.imetier.IMetier;
import com.gproj.imetier.IMetierUser;




@ManagedBean
@Component
public class Project {
	@Autowired
	IMetier<Proj_Users_Taches> MetierUTProj;
	
	@Autowired
	IMetier<Projet> metierProj;
	
	@Autowired
	IMetierUser metierUser;
	
	@Autowired
	IMetier<Mat_Quant_Proj> metierdetailM;
	
	@Autowired
	IMetier<Tache> metierTache;
	
	@Autowired
	IMetier<Proj_Users_Taches> metierdetailT;
	
	@Autowired
	IMetier<Materiels> metierMat;
// Les attributs :
	private Proj_Users_Taches pp = new Proj_Users_Taches();
	private Projet projet = new Projet();
	private Utilisateur u = new Utilisateur();
	private Materiels materiel = new Materiels();
    private Mat_Quant_Proj btnMateriel =  new Mat_Quant_Proj();
    private Proj_Users_Taches detail = new Proj_Users_Taches();
	private String dd;
	private LocalDate dod = LocalDate.now();
    private String df ;
    private int quanti ;
    private String ddt;
    private String dft;
	private int a =1;
	
public String getDdt() {
		return ddt;
	}
	public void setDdt(String ddt) {
		this.ddt = ddt;
	}
	public String getDft() {
		return dft;
	}
	public void setDft(String dft) {
		this.dft = dft;
	}
public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
public LocalDate getDod() {
		return dod;
	}
	public void setDod(LocalDate dod) {
		this.dod = dod;
	}
	// Setter && Getter :
	public Projet getProjet() {
			return projet;
		}
    public void setProjet(Projet projet) {
			this.projet = projet;
		}
    public Utilisateur getU() {
			return u;
		}
	public void setU(Utilisateur u) {
			this.u = u;
		}
	public Proj_Users_Taches getDetail() {
		return detail;
	}
	public void setDetail(Proj_Users_Taches detail) {
		this.detail = detail;
	}
	public Mat_Quant_Proj getBtnMateriel() {
  		return btnMateriel;
  	}
    public void setBtnMateriel(Mat_Quant_Proj btnMateriel) {
  		this.btnMateriel = btnMateriel;
  	}
    public Materiels getMateriel() {
    		return materiel;
    	}
    public void setMateriel(Materiels materiel) {
    		this.materiel = materiel;
    	}
    public String getDd() {
		return dd;
	}
	public void setDd(String dd) {
		this.dd = dd;
	}
	public String getDf() {
		return df;
	}
	public void setDf(String df) {
		this.df = df;
	}
	public int getQuanti() {
		return quanti;
	}
	public void setQuanti(int quanti) {
		this.quanti = quanti;
	}
	
	
	
// Constructeurs :

	public Proj_Users_Taches getPp() {
		return pp;
	}
	public void setPp(Proj_Users_Taches pp) {
		this.pp = pp;
	}
	public Project() {
		
     	btnMateriel.setProjet(new Projet());
     	btnMateriel.setMat(new Materiels());
     	detail.setProj(new Projet());
     	detail.setUser(new Utilisateur());
     }
//Methodes :
	
	
	//Methode 1 : get all projets
	 
	   public List<Projet> getAllProj() throws Exception{
	    	 return metierProj.getAll();
	     }
	   
	  public List<Projet> getProjs(String username) throws Exception{
		  
	    	  Utilisateur us = metierUser.getUsername(username);
	    	  
	    	  List<Projet> l = new ArrayList<Projet>();
	    	  
	    	  List<Projet> a = us.getProjets();
	    	  
	    	 for(int i=a.size();i>0;i--)
	    		  {     
	    		    l.add(a.get(i-1));  }
	    	  return l;
	      }
	
//Methode 2 : ajouter projet 
   public List<Utilisateur> dispo() throws Exception {
    	
	   List<Utilisateur> ingn = new ArrayList<Utilisateur>();
		List<Utilisateur> all = metierUser.getAll();
		  for(Utilisateur U : all )
	       { 
		    if(U.getRole().getId_role()==2)
		      ingn.add(U);  
		   }
		  
		  for(int i=0;i<ingn.size();i++) {
			  for(Projet p : ingn.get(i).getProjets())
			  {  
				  if(p.getDate_fin().isAfter(LocalDate.parse(dd)))
					  ingn.remove(i);
			  }
		  }
		  return ingn;
    }
	  
	  
	  public String sv() {
		  projet.setDate_debut(LocalDate.parse(dd));
	    	projet.setDate_fin(LocalDate.parse(df));
	    	projet.setStatus("Nouveau");
		  return "chef_dispo";
	  }
	  
    public String saveP(int id_user) throws Exception{
    	System.out.println(id_user);
    	Utilisateur u =metierUser.FindById(id_user);
    	projet.setUser(u);
        metierProj.save(projet);
       
       return "projets";
     }
    
	 //Methode 3 : Update Projet
	    
	    public String findProj1(int id_projet) throws Exception {
	    	u=projet.getUser();
	    	projet=metierProj.FindById(id_projet);
	    	metierUser.delete(projet.getUser());
	        dd=String.valueOf(projet.getDate_debut());
	        df=String.valueOf(projet.getDate_fin());
	        metierProj.save(projet);
	    	return "updatep.xhtml";
	    }
	    
	    public String updateP() throws Exception{
	    	
	    	List<Utilisateur> listU = new ArrayList<Utilisateur>();
	    	u=projet.getUser();
	    	listU.add(u);
	    	projet.setDate_debut(LocalDate.parse(dd));
	    	projet.setDate_fin(LocalDate.parse(df));
	    	u.getProjets().add(projet);
	    	metierUser.update(u);
	    	metierProj.update(projet);
	         return "projets";
	  }
	    
	  //Methode 4 : Delete Projet 
	    
	    public void deleteProj(int id_projet) {
			  
			 projet=metierProj.FindById(id_projet);
			 System.out.println(projet);
		 	 metierProj.delete(projet);
		 	 }
	    
	  //Methode 5 : pour les details
	    
	      // liste des Techniciens :
	      public String findProj2(int id_projet) {
	      	projet=metierProj.FindById(id_projet);
	      	return "detailsP";}
	      
	      public List<Utilisateur> getAllTech() throws Exception{
	     	List<Utilisateur> tech = new ArrayList<Utilisateur>();
	     	for(Utilisateur a : metierUser.getAll())
	     		{if(a.getRole().getId_role()==3)
	     			tech.add(a);}
	     	return tech;
	      }
	      
	     // liste de details
	     public List<Mat_Quant_Proj> getAlldet() throws Exception {
	     	List<Mat_Quant_Proj> dets =	metierdetailM.getAll();
	     	return dets;
	     }
	     
	     //liste des users d'un projet
	   
	     
	   //Methode 8 : affectation : materiels && taches && users
	      public String findProj4(int id_projet) {
	    	  
	     	projet=metierProj.FindById(id_projet);
	     	
	     	System.out.println(projet);
	     	return "new_tache";}
	     
	     //liste des taches
	     
	     public List<Tache> getAllTaches() throws Exception{
	     	 return metierTache.getAll();
	     }
	     
	    public String affProjet() {
	 	 Utilisateur user = metierUser.FindById(detail.getUser().getId_user());
	 	 Projet p = metierProj.FindById(projet.getId_projet());
	 	   detail.setDate_debut(LocalDate.parse(dd));
	 	   detail.setDate_fin(LocalDate.parse(df));
	 	  detail.setProj(p);
	 	  detail.setUser(user);
	 	 metierdetailT.save(detail);
	 	   return "projets_chef";
	    }
	    
	    //quantite les materiels
	    
	    public List<Mat_Quant_Proj> getdet() throws Exception {
	 	  
	 	return projet.getQuantites();
	    }
	   
	    // taches tech 
	    
	    public List<Proj_Users_Taches> getTU() throws Exception{
	 	  return projet.getTaches();
	    }
	 	 // find tach
	    
	    public String findTache(int id_tache) {
	 	   
	 	   Tache t= metierTache.FindById(id_tache);
	 	   return t.getNom();
	    }
	   
	    
	    // ajouter la quantite des materiels
	 	
	 	public String findProj3(int id_projet) {
	    	projet=metierProj.FindById(id_projet);
	    	 
	    	return "materiels_chef"; }
	 	
	 	
	 	public String findmat1(int id_materiel) {
	 	Projet p = metierProj.FindById(projet.getId_projet());	
	 	materiel=metierMat.FindById(id_materiel);
	 	 p.setStatus("encours");
	     metierProj.update(p);
	 	btnMateriel.setProjet(p);
	  	btnMateriel.setMat(materiel);
	  	
	 	
	 	metierdetailM.save(btnMateriel);
	 		return "projets_chef";
	 		
	 	}
	 	
	 	 public String findProj(int id) {
	 	   projet=metierProj.FindById(id);
	 	  
	 	   return "detailP";}
	 	 
	 	 public String compare(int id_tache) {
	 		 String Etat ="";
	 		 for(Proj_Users_Taches a : projet.getTaches()) {
	 			 if(a.getId_tache()==id_tache) {
	 		       if(a.getDate_fin().isAfter(LocalDate.now()) || a.getDate_fin().isEqual(LocalDate.now()) )	 
	 			      Etat = "Terminer";
	 		       if(a.getDate_debut().isBefore(LocalDate.now()) && a.getDate_fin().isBefore(LocalDate.now()))
	 			      Etat ="En cours";
	 		       if(a.getDate_debut().isEqual(LocalDate.now()))
	 			      Etat = "A faire" ;
	 		 }}
	 		
	 		return Etat; 
	 		}
	 	 
	 	 
	     
	 	 public List<Proj_Users_Taches> getTaches(String username) throws Exception {
	 		 Utilisateur t =metierUser.getUsername(username);
	 		 List<Proj_Users_Taches> put=t.getTaches();
	 		List<Proj_Users_Taches> n = new ArrayList();
	 		   for(int i=put.size();i>0;i--)
  		       {     
  		         n.add(put.get(i-1));  }
  	           return n;
	 		  }
	 	public String etatT(int id) {
			 
	 		Proj_Users_Taches t =  MetierUTProj.FindById(id);
			 
			 t.setAvancement("Terminer");
			 
			 MetierUTProj.update(t);
			 
			 System.out.println(t);
			 return "espace_tech";
			 
		 }
	 	 
	 	 public String findNomta(int id_tache) {
	 		Tache tt =metierTache.FindById(id_tache);
	 		 return tt.getNom();
	 	 }
	 	 public String findNomPr(int id_projet) {
	 		 
	 		 Projet pp = metierProj.FindById(id_projet);
	 		 return pp.getNom();
	 	 }
	 	
	 	 
	 public String etat(int id_projet) {
		 
		 Projet p1 =  metierProj.FindById(id_projet);
		 
		 p1.setStatus("Terminer");
		 
		metierProj.update(p1);
		 
		 System.out.println(p1);
		 return "projet_chef";
		 
	 }
	 
	 public List<Utilisateur> getAllUsers() throws Exception{
			List<Utilisateur> ingn = new ArrayList<Utilisateur>();
			 List<Utilisateur> all = metierUser.getAll();
			
		  for(Utilisateur U : all )
		    { 
			 if(U.getRole().getId_role()==2)
			      ingn.add(U);  
			 }
			return ingn; }
	 
	public List<Utilisateur> getAllTechs() throws Exception{
	 
	 
	 List<Utilisateur> tech = new ArrayList<Utilisateur>();
  	for(Utilisateur a : metierUser.getAll())
  		{if(a.getRole().getId_role()==3)
  			tech.add(a);}
  	return tech;
	 
	 
	 }
public String disspo(Utilisateur A) {
		
		String m="disponible";
		
		 for(Proj_Users_Taches p : A.getTaches()) {
			 if(p.getAvancement().equals("encours")||p.getAvancement().equals("Nouveau")) {
				 m="indisponible";
				 }
		    }
	  return m;
	}	
	 
public String sv1() {
	
	detail.setProj(projet);
	detail.setDate_debut(LocalDate.parse(ddt));
	detail.setDate_fin(LocalDate.parse(dft));
	detail.setAvancement("Nouveau");
	System.out.println(detail.getProj());
	System.out.println(detail.getDate_debut());
	System.out.println(detail.getDate_fin());
	  return "tech_dispo";
}

public String saveT(int id_user) throws Exception{
	
	Utilisateur u =metierUser.FindById(id_user);
	detail.setUser(u);    ;
	MetierUTProj.save(detail);
	System.out.println(id_user);
   return "projets_chef";
}
public List<Utilisateur> dispo1() throws Exception {
	
	   List<Utilisateur> tech = new ArrayList<Utilisateur>();
		List<Utilisateur> all = metierUser.getAll();
		  for(Utilisateur U : all )
	       { 
		    if(U.getRole().getId_role()==3)
		      tech.add(U);  
		   }
		  
		  for(int i=0;i<tech.size();i++) {
			  for(Proj_Users_Taches p : tech.get(i).getTaches())
			  {  
				  if(p.getDate_fin().isAfter(LocalDate.parse(ddt)))
					  tech.remove(u);
			  }
		  }
		  return tech;
 }
	
}