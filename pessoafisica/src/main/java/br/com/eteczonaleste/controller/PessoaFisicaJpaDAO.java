package br.com.eteczonaleste.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.eteczonaleste.model.PessoaFisica;

public class PessoaFisicaJpaDAO {

	private static PessoaFisicaJpaDAO instance;
    protected EntityManager entityManager;
    
    public static PessoaFisicaJpaDAO getInstance(){
              if (instance == null){
                       instance = new PessoaFisicaJpaDAO();
              }
              
              return instance;
    }

    private PessoaFisicaJpaDAO() {
              entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
              EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
              if (entityManager == null) {
                       entityManager = factory.createEntityManager();
              }

              return entityManager;
    }

    public PessoaFisica getById(final int id) {
              return entityManager.find(PessoaFisica.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<PessoaFisica> findAll() {
              return entityManager.createQuery("FROM " + PessoaFisica.class.getName()).getResultList();
    }

    public void persist(PessoaFisica pessoafisica) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.persist(pessoafisica);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void merge(PessoaFisica pessoafisica) {
              try {
                       entityManager.getTransaction().begin();
                       entityManager.merge(pessoafisica);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void remove(PessoaFisica pessoafisica) {
              try {
                       entityManager.getTransaction().begin();
                       pessoafisica = entityManager.find(PessoaFisica.class, pessoafisica.getId());
                       entityManager.remove(pessoafisica);
                       entityManager.getTransaction().commit();
              } catch (Exception ex) {
                       ex.printStackTrace();
                       entityManager.getTransaction().rollback();
              }
    }

    public void removeById(final int id) {
              try {
            	  PessoaFisica pessoafisica = getById(id);
                       remove(pessoafisica);
              } catch (Exception ex) {
                       ex.printStackTrace();
              }
    }
}
