package impl;

import entity.person.Person;
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

}
