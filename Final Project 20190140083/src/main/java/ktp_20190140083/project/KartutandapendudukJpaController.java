/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ktp_20190140083.project;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ktp_20190140083.project.exceptions.NonexistentEntityException;
import ktp_20190140083.project.exceptions.PreexistingEntityException;

/**
 *
 * @author yusuf
 */
public class KartutandapendudukJpaController implements Serializable {

    public KartutandapendudukJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ktp_20190140083_project_jar_0.0.1-SNAPSHOTPU");

    public KartutandapendudukJpaController(){}
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Kartutandapenduduk kartutandapenduduk) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(kartutandapenduduk);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findKartutandapenduduk(kartutandapenduduk.getId()) != null) {
                throw new PreexistingEntityException("Kartutandapenduduk " + kartutandapenduduk + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Kartutandapenduduk kartutandapenduduk) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            kartutandapenduduk = em.merge(kartutandapenduduk);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = kartutandapenduduk.getId();
                if (findKartutandapenduduk(id) == null) {
                    throw new NonexistentEntityException("The kartutandapenduduk with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Kartutandapenduduk kartutandapenduduk;
            try {
                kartutandapenduduk = em.getReference(Kartutandapenduduk.class, id);
                kartutandapenduduk.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The kartutandapenduduk with id " + id + " no longer exists.", enfe);
            }
            em.remove(kartutandapenduduk);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Kartutandapenduduk> findKartutandapendudukEntities() {
        return findKartutandapendudukEntities(true, -1, -1);
    }

    public List<Kartutandapenduduk> findKartutandapendudukEntities(int maxResults, int firstResult) {
        return findKartutandapendudukEntities(false, maxResults, firstResult);
    }

    private List<Kartutandapenduduk> findKartutandapendudukEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Kartutandapenduduk.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Kartutandapenduduk findKartutandapenduduk(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Kartutandapenduduk.class, id);
        } finally {
            em.close();
        }
    }

    public int getKartutandapendudukCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Kartutandapenduduk> rt = cq.from(Kartutandapenduduk.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
