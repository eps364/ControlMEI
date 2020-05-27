/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.SimpleDateFormat;

/**
 *
 * @author colpv
 */
public class ConvertDate {

    private java.util.Date date;

    public ConvertDate(java.util.Date date) {

        this.date = date;

    }

    public ConvertDate() {
    }

    public static java.sql.Date ConvertDate(java.util.Date date) {

        if (date != null) {
            return new java.sql.Date(date.getTime());
        }

        return null;
    }

    public static java.util.Date ConvertDate(java.sql.Date date) {

        if (date != null) {
            return new java.util.Date(date.getTime());
        }

        return null;
    }

    @Override
    public String toString() {

        return new SimpleDateFormat("dd/MM/yyyy").format(date);

    }

}
