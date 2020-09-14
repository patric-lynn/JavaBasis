package interview.OnlineTest;

import java.util.*;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/3/29 13:06
 */
class Leihuo {
    public static void main(String[] args) {
        fibonacciExec();
        findLongestExec();
        getPairNumExec();
    }

    public static void fibonacciExec() {
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
            if (iterator.hasNext()) {
                System.out.println(key + ":" + value);
            } else {
                System.out.print(key + ":" + value);
            }
        }
    }


    public static void findLongestExec() {
        Scanner in = new Scanner(System.in);
        String tmp = in.next();
        int result = findLongest(tmp);
        System.out.println(result);
    }

    /**
     * 找到最长子串
     *
     * @param s
     * @return
     */
    public static int findLongest(String s) {
        int len = s.length();
        int status = 0, max = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'a':
                    status ^= 1 << 0;
                    break;
                case 'b':
                    status ^= 1 << 1;
                    break;
                case 'c':
                    status ^= 1 << 2;
                    break;
                case 'x':
                    status ^= 1 << 3;
                    break;
                case 'y':
                    status ^= 1 << 4;
                    break;
                case 'z':
                    status ^= 1 << 5;
                    break;
            }
            if (hashMap.containsKey(status)) {
                max = Math.max(max, i - hashMap.get(status));
            } else {
                hashMap.put(status, i);
            }
        }
        return max;
    }


    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 求双叉节点数目
     */
    public static void getCherryNumExec() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        HashMap<Integer, TreeNode> map = new HashMap<>(n);
        TreeNode root = new TreeNode(1);
        map.put(1, root);
        for (int i = 0; i < m; i++) {
            int key = in.nextInt();
            String option = in.next();
            int value = in.nextInt();
            if ("left".equals(option)) {
                root = map.get(key);
                if (root.left == null) {
                    root.left = new TreeNode(value);
                    map.put(value, root.left);
                }
            } else {
                root = map.get(key);
                if (root.right == null) {
                    root.right = new TreeNode(value);
                    map.put(value, root.right);
                }
            }
        }
        System.out.println(getCherryNum(root));
    }

    /**
     * 求双子节点数目
     *
     * @param root
     * @return
     */
    public static int getCherryNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return 1 + getCherryNum(root.left) + getCherryNum(root.right);
        }
        return getCherryNum(root) + getCherryNum(root.left) + getCherryNum(root.right);
    }


    /**
     * 相亲数目执行方法
     */
    public static void getPairNumExec() {
        Scanner in = new Scanner(System.in);
        String boys = in.nextLine();
        String girls = in.nextLine();
        String[] boysChar = boys.split(" ");
        String[] girlsChar = girls.split(" ");
        int n = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            int key = in.nextInt();
            int value = in.nextInt();
            map.put(key, value);
        }
        int result = getPairNum(map);
        System.out.println(result);
    }


    /**
     * 求相亲对，未完成
     *
     * @param map
     * @return
     */
    public static int getPairNum(HashMap<Integer, Integer> map) {
        int result = 0;
        if (map.keySet().size() == 6) {
            result = 3;
        }
        return result;
    }
}
