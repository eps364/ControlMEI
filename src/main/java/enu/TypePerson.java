/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enu;

/**
 *
 * @author colpv
 */
public enum TypePerson {
    EMPLOYEE("Employee"),
    CUSTOMER("Customer"),
    COMPANY("Company");

    private final String value;

    TypePerson(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        System.out.println("enum: ".concat(value));
        return value;

    }

}
