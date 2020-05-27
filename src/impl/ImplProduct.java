/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import entities.entity.product.Stock;
import factory.Generic;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author colpv
 */
public class ImplProduct extends Generic<Stock> {

    EntityManager em;

    public List<Stock> findAll() {
        em = Generic.Factory();
        List<Stock> list;
        try {
            Query query = em.createNamedQuery("Stock.findAll");
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

    public Stock getLike(String like) {
        em = Generic.Factory();
        Stock item;
        try {

            Query query = em.createNamedQuery("Stock.findLike");
            query.setParameter("codebar", like + "%");
            item = (Stock) query.getSingleResult();
        } catch (Exception e) {
            item = new Stock();
            System.out.println("error like: " + e.getMessage());
        }
        return item;
    }

}
