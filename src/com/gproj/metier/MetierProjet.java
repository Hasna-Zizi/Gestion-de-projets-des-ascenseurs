package com.gproj.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gproj.imetier.IMetier;
import com.gproj.entities.*;
import com.gproj.idao.IDao;
@Service
public class MetierProjet implements IMetier<Projet>{
	@Autowired
	IDao<Projet> daoProjet;

	@Override
	public List<Projet> getAll() throws Exception {
		return daoProjet.getAll();
	}

	@Override
	public Projet FindById(int id) {
		return daoProjet.FindById(id);	
		}

	@Override
	public Projet getOne(String nom) {
		return daoProjet.getOne(nom);
	}

	@Override
	public boolean save(Projet obj) {
		return daoProjet.save(obj);
	}

	@Override
	public boolean update(Projet obj) {
		return daoProjet.update(obj);
	}

	@Override
	public boolean delete(Projet obj) {
		return daoProjet.delete(obj);
	}
}
