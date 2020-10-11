package interview.ByteDance;

import java.util.*;

/**
 * @author Lynn
 */
public class Main {
    /**
     * 依次输入员工id及其题目分；根据分值降序取前n个员工
     * 5 3
     * 1 1
     * 2 2
     * 3 3
     * 4 4
     * 4 4
     * 4
     * 3
     * 2
     */
    public static void jizhiExec() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (map.get(a) != null) {
                map.put(a, b + map.get(a));
            } else {
                map.put(a, b);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int i = 0;
        for (Map.Entry<Integer, Integer> mapping : list) {
            if (i >= m) {
                break;
            }
            i++;
            System.out.println(mapping.getKey() + " ");
        }
    }

    public static void main(String[] args) {
        jizhiExec();
    }
}








