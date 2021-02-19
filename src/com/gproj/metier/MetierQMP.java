package com.gproj.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gproj.entities.*;
import com.gproj.idao.IDao;
import com.gproj.imetier.IMetier;
@Service
public class MetierQMP implements IMetier<Mat_Quant_Proj>{
    
	@Autowired
	IDao<Mat_Quant_Proj> daoQMatP;

	@Override
	public List<Mat_Quant_Proj> getAll() throws Exception {
		return daoQMatP.getAll();
	}

	@Override
	public Mat_Quant_Proj FindById(int id) {
		return daoQMatP.FindById(id);
	}

	@Override
	public Mat_Quant_Proj getOne(String nom) {
		return daoQMatP.getOne(nom);
	}

	@Override
	public boolean save(Mat_Quant_Proj obj) {
		return daoQMatP.save(obj);
	}

	@Override
	public boolean update(Mat_Quant_Proj obj) {
		return daoQMatP.update(obj);
	}

	@Override
	public boolean delete(Mat_Quant_Proj obj) {
		return daoQMatP.delete(obj);
	}
}
