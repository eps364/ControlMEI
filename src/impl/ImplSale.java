package impl;

import entities.entity.Sale;
import factory.Generic;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ImplSale extends Generic<Sale> {

    public List<Sale> findAll() {
        EntityManager em = Generic.Factory();
        List<Sale> list;
        try {
            Query query = em.createNamedQuery("Sale.findAll");
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
