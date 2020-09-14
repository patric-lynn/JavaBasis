package interview;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description
 * 1.设计LRU缓存结构,大小为k,支持两种操作。[有序链表]
 * 2.反转链表。[原地逆置]
 * 3.判断给定的链表中是否有环。[双指针]
 * 4.将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的。[递归]
 * 5.分别按照二叉树先序，中序和后序打印所有的节点。
 *
 * @author Lynn-zd
 * @date Created on 2020/8/27 21:36
 */
public class TopHighFrequencyProbelms {
    /**
     * 链表问题辅助类
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 二叉树问题辅助类
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }


    /**
     * NC93
     * LRU缓存问题辅助类：基于有序哈希map的LRUCache实现类
     */
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int val) {
            super.put(key, val);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    /**
     * 1.设计LRU缓存结构，该结构在构造时确定大小，假设大小为K，并有如下两个功能:
     * set(key, value)：将记录(key, value)插入该结构
     * get(key)：返回key对应的value值
     * [要求]
     * set和get方法的时间复杂度为O(1)
     * 某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的。
     * 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
     * 若opt=1，接下来两个整数x, y，表示set(x, y)
     * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
     * 对于每个操作2，输出一个答案
     * 示例1
     * 输入
     * [[1,1,1],[1,2,2],[1,3,2],[2,1],[1,4,4],[2,2]],3
     * 输出
     * [1,-1]
     *
     * @param operators
     * @param k
     * @return
     */
    public int[] LRU(int[][] operators, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        LRUCache cache = new LRUCache(k);
        for (int[] operator : operators) {
            if (operator[0] == 1) {
                cache.put(operator[1], operator[2]);
            } else if (operator[0] == 2) {
                int val = cache.get(operator[1]);
                list.add(val);
                ;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }


    /**
     * NC78
     * 2.反转链表
     *
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        ListNode newHead = null;
        ListNode tmp = null;
        while (head != null) {
            tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    /**
     * NC4
     * 3.判断给定的链表中是否有环
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && low != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * NC33
     * 4.将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    /**
     * NC45
     * 5.分别按照二叉树先序，中序和后序打印所有的节点。
     */
    private int preIndex = 0, inIndex = 0, postIndex = 0;

    public int[][] threeOrders(TreeNode root) {
        // write code here
        int n = count(root);
        int[][] res = new int[3][n];
        orders(root, res);
        return res;
    }

    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    public void orders(TreeNode root, int[][] res) {
        if (root == null) {
            return;
        }
        res[0][preIndex++] = root.val;
        orders(root.left, res);
        res[1][inIndex++] = root.val;
        orders(root.right, res);
        res[2][postIndex++] = root.val;
    }

    public static void main(String[] args) {

    }

}


