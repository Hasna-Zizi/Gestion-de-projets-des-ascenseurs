package com.gproj.idao;

import com.gproj.entities.Utilisateur;

public interface IdaoUser extends IDao<Utilisateur>{
	
	public int login(String username,String pwd) throws Exception;

	public Utilisateur getUsername(String username) throws Exception;
	
}
