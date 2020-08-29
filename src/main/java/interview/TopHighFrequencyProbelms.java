package interview;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description
 * 1.设计LRU缓存结构,大小为k,支持两种操作。[有序链表]
 * @author Lynn-zd
 * @date Created on 2020/8/27 21:36
 */
public class TopHighFrequencyProbelms {
    /**
     * LRU缓存问题辅助类：基于有序哈希map的LRUCache实现类
     */
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        int capacity;
        public LRUCache(int capacity){
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }
        public int get(int key){
            return super.getOrDefault(key, -1);
        }
        public void put(int key, int val){
            super.put(key, val);
        }
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
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
     * @param operators
     * @param k
     * @return
     */
    public int[] LRU (int[][] operators, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        LRUCache cache = new LRUCache(k);
        for(int[] operator : operators){
            if(operator[0] == 1){
                cache.put(operator[1], operator[2]);
            }else if(operator[0] == 2){
                int val = cache.get(operator[1]);
                list.add(val);;
            }
        }

        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }

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
     * 反转链表
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        ListNode newHead = null;
        ListNode tmp = null;
        while(head != null){
            tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    public static void main(String[] args) {

    }

}


