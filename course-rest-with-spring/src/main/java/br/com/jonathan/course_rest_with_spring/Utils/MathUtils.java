package br.com.jonathan.course_rest_with_spring.Utils;

import br.com.jonathan.course_rest_with_spring.exception.UnsupportedMathOperationException;

public class MathUtils {

    public static Double convertToDouble(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public static boolean isZero(String number) {
        return Double.parseDouble(number) == 0;
    }
}
