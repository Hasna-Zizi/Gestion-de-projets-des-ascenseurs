package com.gproj.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gproj.entities.*;
import com.gproj.idao.IDao;
import com.gproj.imetier.IMetier;
@Service
public class MetierRole implements IMetier<Role>{
	@Autowired
	IDao<Role> daoRole;

	@Override
	public List<Role> getAll() throws Exception {
		return daoRole.getAll();
	}

	@Override
	public Role FindById(int id) {
		return daoRole.FindById(id);
	}

	@Override
	public Role getOne(String nom) {
		return daoRole.getOne(nom);
	}

	@Override
	public boolean save(Role obj) {
		return daoRole.save(obj);
	}

	@Override
	public boolean update(Role obj) {
		return daoRole.update(obj);
	}

	@Override
	public boolean delete(Role obj) {
		return daoRole.delete(obj);
	}
}
