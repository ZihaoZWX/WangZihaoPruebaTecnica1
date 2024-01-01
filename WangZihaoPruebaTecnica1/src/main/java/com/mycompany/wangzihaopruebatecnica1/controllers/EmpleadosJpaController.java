
package com.mycompany.wangzihaopruebatecnica1.controllers;

import com.mycompany.wangzihaopruebatecnica1.exceptions.NonexistentEntityException;
import com.mycompany.wangzihaopruebatecnica1.models.Empleados;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * 
 * Clase generada por Netbeans para realizar el CRUD
 * @author Zihao Wang
 */
public class EmpleadosJpaController implements Serializable {

    /**
     * 
     * Constructor con parametro 
     * @param emf 
     */
    public EmpleadosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    /**
     * 
     * Constructor de EmpleadosJpaController
     * Creamos una instancia de entityManagerFactory
     */
    public EmpleadosJpaController(){
        emf=Persistence.createEntityManagerFactory("empleadosPersistence");
    }
    
    private EntityManagerFactory emf = null;

    /**
     *  
     * @return Retorna una instancia de EntityManager
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    /**
     * 
     * @param empleados de la clase Empleados
     * Metodo autogenerado por Netbeans para crear empleados
     */
    public void create(Empleados empleados) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(empleados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * 
     * @param empleados de la clase Empleados
     * @throws NonexistentEntityException excepcion si no existe el empleado
     * @throws Exception tira la excepcion si no existe el empleado en la base de datos
     */
    public void edit(Empleados empleados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            empleados = em.merge(empleados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = empleados.getId();
                if (findEmpleados(id) == null) {
                    throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * 
     * @param id Se usa para filtrar el empleado que quieres eliminar
     * @throws NonexistentEntityException excepcion de empleado no existente en la base de datos
     */
    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados empleados;
            try {
                empleados = em.getReference(Empleados.class, id);
                empleados.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.", enfe);
            }
            em.remove(empleados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * 
     * @return Retorna una lista de todos los empleados
     */
    public List<Empleados> findEmpleadosEntities() {
        return findEmpleadosEntities(true, -1, -1);
    }

    /**
     * 
     * @param maxResults El número máximo de resultados que se deben devolver.
     * @param firstResult El índice del primer resultado a recuperar.
     * @return Una lista de entidades Empleados que cumplen con los criterios de paginación.
     */
    public List<Empleados> findEmpleadosEntities(int maxResults, int firstResult) {
        return findEmpleadosEntities(false, maxResults, firstResult);
    }

    /**
     * 
     * @param all Si es falso se aplica los criterios de paginacion si es verdadero no
     * @param maxResults Indica el maximo de resultados que se devuelve si all es false
     * @param firstResult Indica el indice del primer resultado si all es false
     * @return Retornamos una lista de empleados que cumplan con el criterio
     */
    private List<Empleados> findEmpleadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleados.class));
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

    /**
     * 
     * @param id Parametro que se usa para filtrar
     * @return Retorna el empleado con esa id
     */
    public Empleados findEmpleados(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleados.class, id);
        } finally {
            em.close();
        }
    }
    
    /**
     * 
     * @param cargo parametro que usaremos como condicion de busqueda
     * @return retornamos una lista con los empleados con el cargo deseado
     */
    public List<Empleados> findEmpleadosPosition(String cargo) {
        EntityManager em = getEntityManager();
        try {
            String jpql="select e from Empleados e where e.cargo =:cargo";
            TypedQuery<Empleados> query= em.createQuery(jpql,Empleados.class);
            query.setParameter("cargo", cargo);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    /**
     * 
     * @param dni parametro que usaremos para filtrar por dni
     * @return retornamos una variable booleana verdadera si existe el dni y falsa si no existe
     */
    public boolean findEmpleadoDni(String dni){
        EntityManager em = getEntityManager();
         String jpql = "select case when count(e) > 0 then true else false end from Empleados e where e.dni = :dni";
        boolean existe = em.createQuery(jpql, Boolean.class)
                .setParameter("dni", dni)
                .getSingleResult();
        return existe;
    }

    /**
     * 
     * @return Retorna la cantidad de empleados que tenemos en la base de datos
     */
    public int getEmpleadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleados> rt = cq.from(Empleados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
