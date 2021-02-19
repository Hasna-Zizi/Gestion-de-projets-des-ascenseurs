package com.gproj.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.gproj.idao.IDao;
import com.gproj.entities.*;

@Repository("daoMateriels")
@Transactional
@EnableTransactionManagement
public class DaoMateriels implements IDao<Materiels>{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Materiels> getAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from Materiels").list();
	}

	@Override
	public Materiels FindById(int id) {
		return sessionFactory.getCurrentSession().get(Materiels.class,id);
	}

	@Override
	public Materiels getOne(String nom) {
		return (Materiels) sessionFactory.getCurrentSession().createQuery("from Materiels where nom =:nom").setParameter("nom", nom).list().get(0);
	}

	@Override
	public boolean save(Materiels obj) {
		try {	
			sessionFactory.getCurrentSession().save(obj);
			return true;
		  } catch (Exception e) {
			return false;}
	}

	@Override
	public boolean update(Materiels obj) {
		try {	
			sessionFactory.getCurrentSession().update(obj);
			return true;
		  } catch (Exception e) {
			return false; }
	}

	@Override
	public boolean delete(Materiels obj) {
		try {	
			sessionFactory.getCurrentSession().delete(obj);
			return true;
			
		} catch (Exception e) {
			return false;
	}

	
}}
