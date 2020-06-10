package impl;

import entity.person.Company;
import factory.Generic;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ImplCompany extends Generic<Company> {

    public List<Company> findAll() {
        EntityManager em = Generic.Factory();
        List<Company> list;
        try {
            Query query = em.createNamedQuery("Company.findAll");
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
