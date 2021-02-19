package com.gproj.imetier;

import com.gproj.entities.Utilisateur;

public interface IMetierUser extends IMetier<Utilisateur>{
	
	public int login(String username,String pwd) throws Exception;

	public Utilisateur getUsername(String username) throws Exception;
    
	
}

