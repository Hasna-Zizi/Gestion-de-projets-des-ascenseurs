package com.gproj.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gproj.entities.Utilisateur;
import com.gproj.imetier.IMetier;
import com.gproj.imetier.IMetierUser;
import com.gproj.entities.Projet;
import com.gproj.entities.Role;

@ManagedBean
@Component
public class User {
	@Autowired
	IMetierUser metierUser;
	
	@Autowired
	IMetier<Role> metierRole;
 // Les Attributs : 
	
	private String username;
	private String pwd;
	private Utilisateur users = new Utilisateur();
	Utilisateur u = new Utilisateur();
	private int a ;
// Setters && Getters :
	
	public String getUsername() {
		return username;
	}
	public Utilisateur getU() {
		return u;
	}
	public void setU(Utilisateur u) {
		this.u = u;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Utilisateur getUsers() {
			return users;
		}
	public void setUsers(Utilisateur users) {
		  this.users = users;
		}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
 // Constructeurs:
	
	
	public User() {  users.setRole(new Role()); }
	
// Les Methodes :
	
  //Methode 1 : VerifAuth
	public String VerifAuth() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		if(metierUser.login(username, pwd)==1)
		  return "acc1.xhtml";
			else
				 if(metierUser.login(username , pwd)==2)
			  
		    	   return "acc2.xhtml";
				 else
		            if(metierUser.login(username , pwd)==3)
		        
			         return "espace_tech.xhtml";
		            else
		     {context.addMessage(null, new FacesMessage("l'authentification a échoué. Vérifiez le nom d'utilisateur ou le mot de passe."));      	
			 return "login.xhtml";}
		}

 //Methode 2 : get All with role = 2
	
	public List<Utilisateur> getAllUsers() throws Exception{
		List<Utilisateur> ingn = new ArrayList<Utilisateur>();
		 List<Utilisateur> all = metierUser.getAll();
		
	  for(Utilisateur U : all )
	    { 
		 if(U.getRole().getId_role()==2)
		      ingn.add(U);  
		 }
		return ingn; }
	
  // Methode 3 : get All techniciens
	 public List<Utilisateur> getAllTech() throws Exception{
			List<Utilisateur> tech = new ArrayList<Utilisateur>();
			List<Utilisateur> all=metierUser.getAll();
			
		for(Utilisateur U : all )
		  { 
			 if(U.getRole().getId_role()==3)
				 tech.add(U);
	      }
			return tech;  }
	 
  //Methode 4 : Save User
	
	public String saveA(){
		   
		if(users.getUsername()==null) 
		  {
			users.setUsername(u.getNom()+"_"+users.getPrenom());
		    users.setPwd("1234");   }
		
		metierUser.save(users);
	  return "users"; }
	
  //Methode 5 : get all roles 
	
	public List<Role> getAllRoles() throws Exception{
		List<Role> TechInge = new ArrayList<Role>();
		List<Role> all = metierRole.getAll();
		
		for(Role r : all) {
		   if(r.getId_role()!=1)
			   
			  TechInge.add(r); }
		
		return TechInge;
	}
	
	// Methode 6 : get One user par nom
	
		public Utilisateur getOne(String nom) {
			metierUser.getOne(nom);
			return users;
		}
		
   //Methode 7 : Update user
		public String FindUser(int id_user) {
			
		     u=metierUser.FindById(id_user);
			 
			 return "updateu";
		 }
		
		public String updateU() {
			
			metierUser.update(u);
			
			 return "users";
		 }
		
 //Methode 8 : Delete user
		  
		public void deleteUser(String nom) {
			 users=metierUser.getOne(nom);
			 metierUser.delete(users);
		 }
		
 //Methode 9: disponibilite :
	 
	public String dissp(Utilisateur A) {
		
		String m="disponible";
		
		 for(Projet p : A.getProjets()) {
			 if(p.getStatus().equals("encours")||p.getStatus().equals("Nouveau")) {
				 m="indisponible";
				 }
		    }
	  return m;
	}		
}	



		
	




	