package com.gproj.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gproj.entities.*;
import com.gproj.idao.IDao;
import com.gproj.imetier.IMetier;
@Service
public class MetierUTProj implements IMetier<Proj_Users_Taches>{
   
	@Autowired
	IDao<Proj_Users_Taches> daoUTprojet;

	@Override
	public List<Proj_Users_Taches> getAll() throws Exception {
		return daoUTprojet.getAll();
	}

	@Override
	public Proj_Users_Taches FindById(int id) {
		return daoUTprojet.FindById(id);
	}

	@Override
	public Proj_Users_Taches getOne(String nom) {
		return daoUTprojet.getOne(nom);
	}

	@Override
	public boolean save(Proj_Users_Taches obj) {
		return daoUTprojet.save(obj);
	}

	@Override
	public boolean update(Proj_Users_Taches obj) {
		return daoUTprojet.update(obj);
	}

	@Override
	public boolean delete(Proj_Users_Taches obj) {
		return daoUTprojet.delete(obj);
	}
}
