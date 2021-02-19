package com.gproj.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gproj.entities.*;
import com.gproj.idao.IDao;
import com.gproj.imetier.IMetier;
@Service
public class MetierMateriels implements IMetier<Materiels>{
  
	@Autowired
	IDao<Materiels> daoMateriels;

	@Override
	public List<Materiels> getAll() throws Exception {
		return daoMateriels.getAll();
	}

	@Override
	public Materiels FindById(int id) {
		return daoMateriels.FindById(id);
	}

	@Override
	public Materiels getOne(String nom) {
		return daoMateriels.getOne(nom);
	}

	@Override
	public boolean save(Materiels obj) {
		return daoMateriels.save(obj);
	}

	@Override
	public boolean update(Materiels obj) {
		return daoMateriels.update(obj);
	}

	@Override
	public boolean delete(Materiels obj) {
		return daoMateriels.delete(obj);
	}
}
