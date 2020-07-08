package lifo;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: LifoTest
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/8 20:32
 * @version: 1.0
 */
public class LifoTest {

    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        String str = "[dsfdsf[{ee(r)er}]]";
        String l1 = "(";
        String l2 = "{";
        String l3 = "[";
        String r1 = ")";
        String r2 = "}";
        String r3 = "]";
        char[] chars = str.toCharArray();

        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if ("{[(".contains(String.valueOf(aChar))) {
                list.add(String.valueOf(aChar));
            }
            if ("}])".contains(String.valueOf(aChar))) {
                if (list.size() == 0) {
                    throw new Exception("语法错误" + aChar);
                }
                if (l1.equals(String.valueOf(aChar)) && !list.get(list.size() - 1).equals(r1)) {
                    throw new Exception("语法错误" + aChar);
                }
                if (l2.equals(String.valueOf(aChar)) && !list.get(list.size() - 1).equals(r2)) {
                    throw new Exception("语法错误" + aChar);
                }
                if (l3.equals(String.valueOf(aChar)) && !list.get(list.size() - 1).equals(r3)) {
                    throw new Exception("语法错误" + aChar);
                }
                list.remove(list.size() - 1);
            }
            if (i == chars.length - 1 && list.size() > 0) {
                throw new Exception("语法错误");
            }
        }
    }
}

