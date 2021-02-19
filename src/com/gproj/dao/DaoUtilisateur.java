package com.gproj.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.gproj.entities.Utilisateur;
import com.gproj.idao.IdaoUser;

//cette annotation est utilisee sur les classes Java qui accedent directement a la BD
@Repository("daoUser")
@Transactional
@EnableTransactionManagement
public class DaoUtilisateur implements IdaoUser{
    
	//nous permet de faire l'injection de dependances entre les beans de l'application.
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Utilisateur> getAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from Utilisateur").getResultList();
	}

	
	
	
	
	
	
	
	
	
	
	@Override
	public Utilisateur FindById(int id) {
		return sessionFactory.getCurrentSession().get(Utilisateur.class,id);
	}

	@Override
	public Utilisateur getOne(String nom) {
		return (Utilisateur)sessionFactory.getCurrentSession().createQuery("from Utilisateur where nom =:nom").setParameter("nom", nom).list().get(0);
	}

	@Override
	public boolean save(Utilisateur obj) {
		try {	
			sessionFactory.getCurrentSession().save(obj);
			return true;
		  } catch (Exception e) {
			return false;}
	}

	@Override
	public boolean update(Utilisateur obj) {
		try {	
			sessionFactory.getCurrentSession().update(obj);
			return true;
		  } catch (Exception e) {
			return false; }
	}

	@Override
	public boolean delete(Utilisateur obj) {
		try {	
			sessionFactory.getCurrentSession().delete(obj);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public int login(String username, String pwd) throws Exception {
		List<Utilisateur> utilisateur = getAll();
      System.out.println(username);
		for(Utilisateur u : utilisateur)
			if(u.getUsername().equals(username) && u.getPwd().equals(pwd))
				return u.getRole().getId_role();
		
		        return -1; 
	}

	@Override
	public Utilisateur getUsername(String username) throws Exception {
		return (Utilisateur)sessionFactory.getCurrentSession().createQuery("from Utilisateur where username =:username").setParameter("username", username).list().get(0);
	}

}
