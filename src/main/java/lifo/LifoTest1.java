package lifo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: LifoTest1
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/8 21:20
 * @version: 1.0
 */
public class LifoTest1 {
    List<String> list = new ArrayList<>();
    List<BigDecimal> bigDecimalList = new ArrayList<>();
    final String s1 = "+";
    final String s2 = "-";
    final String s3 = "*";
    final String s4 = "/";
    final String s5 = "(";
    final String s6 = ")";
    public BigDecimal scale(String str) {
        char[] chars = str.toCharArray();

        return null;
    }

    public String gen(String str) {
        char[] chars = str.toCharArray();
        int j = 0;
        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            switch (String.valueOf(aChar)) {
                case s1 :
                    j = i;
                    break;
                case s2 :
                    break;
                case s3 :
                    break;
                case s4 :
                    break;
                default:
            }
        }
        return null;
    }

    public boolean isNumber(String str) {
        try {
            Double.valueOf(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {


    }
}
