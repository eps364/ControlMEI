package util;

import java.text.SimpleDateFormat;

// Convert to date values types
public class ConvertDate {

    private final java.util.Date date;

    public ConvertDate(java.util.Date date) {

        this.date = date;

    }

    public long convertTime() {
        return date.getTime();
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
