package interview.OnlineTest;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/3/29 13:06
 */
class Leihuo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        String s1 = in.next();
        String s2 = in.next();
        //System.out.println(s1 + s2);
        fibonacci(a, s1, s2);
    }

    public static void fibonacci(int n, String s1, String s2) {
        String[] s = new String[n];
        s[0] = s1;
        s[1] = s2;
        for (int i = 2; i < n; i++) {
            s[i] = s[i - 2] + s[i - 1];
        }
        //System.out.println(s[n - 1]);

        char[] c = s[n - 1].toCharArray();
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < c.length; i++) {
            if (!(c[i] >= 'a' && c[i] <= 'z')) {
                continue;
            }
            Integer value = map.get(c[i]);
            int count = 1;
            if (value != null) {
                count = value + 1;
            }
            map.put(c[i], count);
        }

        Iterator<Character> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Character key = iterator.next();
            Integer value = map.get(key);
            if(iterator.hasNext()){
                System.out.println(key + ":" + value);
            }else{
                System.out.print(key + ":" + value);
            }
        }
    }
}
