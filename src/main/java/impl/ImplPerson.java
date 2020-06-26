package impl;

import entity.person.Person;
import enu.TypePerson;
import factory.Generic;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ImplPerson extends Generic<Person> {

    public List<Person> findAll() {
        EntityManager em = Generic.Factory();
        List<Person> list;
        try {
            Query query = em.createNamedQuery("Person.findAll");
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
    
    
        public List<Person> findAll(TypePerson dtype) {
        EntityManager em = Generic.Factory();
        List<Person> list;
        try {
            Query query = em.createNamedQuery("GenericPerson.findDType");
            query.setParameter("dtype", dtype.toString());
            list = query.getResultList();
        } catch (Exception e) {
            list = new ArrayList<>();
            System.out.println("error list: ".concat(e.getMessage()));
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }

        return list;

    }

}
