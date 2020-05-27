/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import entities.entity.product.Category;
import factory.Generic;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author colpv
 */
public class ImplCategory extends Generic<Category> {
            public List<Category> findAll() {
        EntityManager em = Generic.Factory();
        List<Category> list;
        try {
            Query query = em.createNamedQuery("Category.findAll");
            list = query.getResultList();
        } catch (Exception e) {
            list = new ArrayList<>();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }

        return list;

    }
    
}
