package com.gproj.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gproj.entities.Tache;
import com.gproj.idao.IDao;
import com.gproj.imetier.IMetier;

@Service
public class MetierTache implements IMetier<Tache>{
   
	@Autowired
	IDao<Tache> daoTache;

	@Override
	public List<Tache> getAll() throws Exception {
		return daoTache.getAll();
	}

	@Override
	public Tache FindById(int id) {
		return daoTache.FindById(id);
	}

	@Override
	public Tache getOne(String nom) {
		return daoTache.getOne(nom);
	}

	@Override
	public boolean save(Tache obj) {
		return daoTache.save(obj);
	}

	@Override
	public boolean update(Tache obj) {
		return daoTache.update(obj);
	}

	@Override
	public boolean delete(Tache obj) {
		return daoTache.delete(obj);
	}
}
