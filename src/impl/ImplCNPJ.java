package impl;

import entities.entity.person.Cnpj;
import factory.Generic;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ImplCNPJ extends Generic<Cnpj> {

    public List<Cnpj> findAll() {
        EntityManager em = Generic.Factory();
        List<Cnpj> list;
        try {
            Query query = em.createNamedQuery("Cnpj.findAll");
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
