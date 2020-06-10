package util;

import java.text.DecimalFormat;

public class PercentValue {

    private static double compra;
    private static double venda;
    private static double lucro;

    /**
     * @param purchase - you give type string value
     * @param sale - you give type string value
     * @return - return string value
     */
    public static String percente(String purchase, String sale) {
        if (Double.parseDouble("0".concat(purchase.replace(",", "."))) > 0) {
            double c = Double.parseDouble("0".concat(purchase.replace(",", ".")));
            PercentValue.venda = Double.parseDouble("0".concat(sale.replace(",", ".")));

            double value = (PercentValue.venda - c) / c;
            return String.valueOf(new DecimalFormat("0.0#").format(0 + value * 100));
        } else {
            return "0.0";
        }
    }

    /**
     * @param purchase - you give type string value
     * @param percente - you give type string value
     * @return - return string value
     */
    public static String venda(String purchase, String percente) {
        PercentValue.lucro = Double.parseDouble("0".concat(percente.replace(",", "."))) / 100;
        PercentValue.compra = Double.parseDouble("0".concat(purchase.replace(",", ".")));

        PercentValue.compra += PercentValue.compra * PercentValue.lucro;
        return String.valueOf(new DecimalFormat("0.0#").format(PercentValue.compra));
    }

    public static double mult(double value) {
        return value * 100;
    }

    public static double mult(String value) {
        double val = 0;
        if (value != null) {
            val = Double.parseDouble(value) * 100;
        }

        return val;
    }

}
