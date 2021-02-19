package com.gproj.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.gproj.entities.Mat_Quant_Proj;
import com.gproj.idao.IDao;

@Repository("daoQMatP")
@Transactional
@EnableTransactionManagement
public class DaoMat_Quant_Proj implements IDao<Mat_Quant_Proj>{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Mat_Quant_Proj> getAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from Mat_Quant_Proj").list();
	}

	@Override
	public Mat_Quant_Proj FindById(int id) {
		return sessionFactory.getCurrentSession().get(Mat_Quant_Proj.class,id);
	}

	@Override
	public Mat_Quant_Proj getOne(String nom) {
		return (Mat_Quant_Proj) sessionFactory.getCurrentSession().createQuery("from Mat_Quant_Proj where nom =:nom").setParameter("nom", nom).list().get(0);
	}

	@Override
	public boolean save(Mat_Quant_Proj obj) {
		try {	
			sessionFactory.getCurrentSession().save(obj);
			return true;
		  } catch (Exception e) {
			return false;}
	}

	@Override
	public boolean update(Mat_Quant_Proj obj) {
		try {	
			sessionFactory.getCurrentSession().update(obj);
			return true;
		  } catch (Exception e) {
			return false; }
	}

	@Override
	public boolean delete(Mat_Quant_Proj obj) {
		try {	
			sessionFactory.getCurrentSession().delete(obj);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	} 
}
