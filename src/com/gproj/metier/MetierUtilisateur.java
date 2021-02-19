package com.gproj.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gproj.entities.Utilisateur;
import com.gproj.idao.IdaoUser;
import com.gproj.imetier.IMetierUser;

@Service //marque une classe java qui effectue certains traitements service,tels que l'execution de la logique metier, l'execution de calculs et l'appel d'API externes.
public class MetierUtilisateur implements IMetierUser{
	@Autowired //nous permet de faire l'injection de dependances entre les beans de l'application.
	IdaoUser daoUser;

	@Override
	public List<Utilisateur> getAll() throws Exception {
		return daoUser.getAll();
	}

	@Override
	public Utilisateur FindById(int id) {
		return daoUser.FindById(id);
	}

	@Override
	public Utilisateur getOne(String nom) {
		return daoUser.getOne(nom);
	}

	@Override
	public boolean save(Utilisateur obj) {
		return daoUser.save(obj);
	}

	@Override
	public boolean update(Utilisateur obj) {
		return daoUser.update(obj);
	}

	@Override
	public boolean delete(Utilisateur obj) {
		return daoUser.delete(obj);
	}

	@Override
	public int login(String username, String pwd) throws Exception {
		return daoUser.login(username, pwd);
	}

	@Override
	public Utilisateur getUsername(String username) throws Exception {
		return daoUser.getUsername(username);
	}

}
