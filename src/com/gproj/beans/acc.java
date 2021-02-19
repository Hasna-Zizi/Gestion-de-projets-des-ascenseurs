package com.gproj.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gproj.imetier.IMetier;
import com.gproj.imetier.IMetierUser;
import com.gproj.entities.*;
@ManagedBean
@Component
public class acc {
    
	@Autowired
	IMetierUser metierUser;
	
	@Autowired
	IMetier<Projet> metierProj;
	
	@Autowired
	IMetier<Materiels> metierMat;
	
	@Autowired
	IMetier<Proj_Users_Taches> MetierUTProj;
	public int getTotalTech() throws Exception{
		
		List<Utilisateur> tech = new ArrayList<Utilisateur>();
	  	for(Utilisateur a : metierUser.getAll())
	  		{if(a.getRole().getId_role()==3)
	  			tech.add(a);}
	  	return tech.size();
		
	}
public int getTotalIng() throws Exception{
		
		List<Utilisateur> tech = new ArrayList<Utilisateur>();
	  	for(Utilisateur a : metierUser.getAll())
	  		{if(a.getRole().getId_role()==2)
	  			tech.add(a);}
	  	return tech.size();
		
	}
	
	public int getTotalDisp1() throws Exception {
		int r=0;
		List<Utilisateur> tech = new ArrayList<Utilisateur>();
		for(Utilisateur a : metierUser.getAll())
  		{if(a.getRole().getId_role()==3)
  			tech.add(a);}
		
		
		for(Utilisateur i : tech) {
		  for(Proj_Users_Taches p : i.getTaches()) {
			  
			  if(p.getAvancement().equals("encours")||p.getAvancement().equals("Nouveau")) 
				  
				  r=r+1;
			  }   }
		
		return tech.size()-r;
		}
	
	
	public int getTotalMat() throws Exception {
		
		List<Materiels> mts = metierMat.getAll();
		return mts.size();
	}
	public int getTotalQuant() throws Exception {
		int a=0;
		List<Materiels> mts = metierMat.getAll();
		for(Materiels n : mts) {
			a=a+n.getQuant();
			}
		
		return a;}
	
	public int getTotalPT(String username) throws Exception {
		Utilisateur u = metierUser.getUsername(username);
		 int a = 0;
		for(Projet p : u.getProjets()) {
			
			if(p.getStatus().equals("Terminer"))
				a=a+1;
				
		}
		return a;
		}
	
	public int getTotalP(String username) throws Exception {
		Utilisateur u = metierUser.getUsername(username);
		
		List<Projet> m = u.getProjets(); 
		return m.size();
			
		}
	public int getTotalPE(String username) throws Exception {
		Utilisateur u = metierUser.getUsername(username);
		 int a = 0;
		for(Projet p : u.getProjets()) {
			
			if(p.getStatus().equals("encours"))
				a=a+1;
				
		}
		return a;
		}
	public int getTotalPN(String username) throws Exception {
		Utilisateur u = metierUser.getUsername(username);
		 int a = 0;
		for(Projet p : u.getProjets()) {
			
			if(p.getStatus().equals("Nouveau"))
				a=a+1;
				
		}
		return a;
		}
	
	
	
	public int getTotalDisp2() throws Exception {
		int r=0;
		List<Utilisateur> tech = new ArrayList<Utilisateur>();
		for(Utilisateur a : metierUser.getAll())
  		{if(a.getRole().getId_role()==2)
  			tech.add(a);}
		
		
		for(Utilisateur i : tech) {
		  for(Projet p : i.getProjets()) {
			  
			  if(p.getStatus().equals("encours")||p.getStatus().equals("Nouveau")) 
				  
				  r=r+1;
			  }   }
		
		return tech.size()-r;
		}
	}
	

