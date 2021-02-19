package com.gproj.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.gproj.idao.IDao;
import com.gproj.entities.*;
@Repository("daoUTprojet")
@Transactional
@EnableTransactionManagement
public class DaoProj_Users_Taches implements IDao<Proj_Users_Taches>{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Proj_Users_Taches> getAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from Proj_Users_Taches").list();
	}

	@Override
	public Proj_Users_Taches FindById(int id) {
		return sessionFactory.getCurrentSession().get(Proj_Users_Taches.class,id);
	}

	@Override
	public Proj_Users_Taches getOne(String nom) {
		return (Proj_Users_Taches) sessionFactory.getCurrentSession().createQuery("from Proj_Users_Taches where nom =:nom").setParameter("nom", nom).list().get(0);
	}

	@Override
	public boolean save(Proj_Users_Taches obj) {
		System.out.println(obj);
		try {	
			sessionFactory.getCurrentSession().merge(obj);
			return true;
		  } catch (Exception e) {
			return false;}
	}

	@Override
	public boolean update(Proj_Users_Taches obj) {
		try {	
			sessionFactory.getCurrentSession().update(obj);
			return true;
		  } catch (Exception e) {
			return false; }
	}

	@Override
	public boolean delete(Proj_Users_Taches obj) {
		try {	
			sessionFactory.getCurrentSession().delete(obj);
			return true;
			
		} catch (Exception e) {
			return false;
	}

	}}
