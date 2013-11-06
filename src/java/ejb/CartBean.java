/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import jpa.Merchandise;

/**
 *
 * @author HugoCésar
 */
@Stateful
public class CartBean {

    @PersistenceContext(unitName = "ShoppingCartPU")
    private EntityManager em;

    List<String> contents = new ArrayList<>();

    public void add(String merchandise) {

        Merchandise m = new Merchandise();
        m.setName(merchandise);
        em.persist(m);

    }

    public void delete(Long id) {
        Merchandise m = em.find(Merchandise.class, id);
        em.remove(m);
    }

    public List<Merchandise> getContents() {
        TypedQuery<Merchandise> q = em.createQuery("select m from Merchandise m", Merchandise.class);
        return q.getResultList();
    }

    public void persist(Object object) {
        em.persist(object);
    }

    public void update(Long id, String merchandise) {
//MEthod One to update
//                Merchandise m = em.find(Merchandise.class,id);
//                m.setName(merchandise);
//                
        
        //Method 3 to update
        Merchandise m = new Merchandise();
        m.setId(id);
        m.setName(merchandise);
        em.merge(m);

    }
}
