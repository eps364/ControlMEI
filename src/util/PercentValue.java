package util;

import java.text.DecimalFormat;

public class PercentValue {

    private static double compra;
    private static double venda;
    private static double lucro;

    /**
     * @param compra
     * @param venda
     * @return
     */
    public static String percente(String compra, String venda) {
        if (Double.parseDouble(0 + compra.replace(",", ".")) > 0) {
            double c = Double.parseDouble(0 + compra.replace(",", "."));
            PercentValue.venda = Double.parseDouble(0 + venda.replace(",", "."));

            double value = (PercentValue.venda - c) / c;
            return String.valueOf(new DecimalFormat("0.0#").format(0 + value * 100));
        } else {
            return "0.0";
        }
    }

    /**
     * @param compra
     * @param percente
     * @return
     */
    public static String venda(String compra, String percente) {
        PercentValue.lucro = Double.parseDouble(0 + percente.replace(",", ".")) / 100;
        PercentValue.compra = Double.parseDouble(0 + compra.replace(",", "."));

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
