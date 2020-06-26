/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import entity.person.Employee;
import factory.Generic;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author colpv
 */
public class ImplEmployee extends Generic<Employee>{
    
        public List<Employee> findAll() {
        EntityManager em = Generic.Factory();
        List<Employee> list;
        try {
            Query query = em.createNamedQuery("Employee.findAll");
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
