package interview.alibaba;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 笔试题目：
 * 1)实现一个KV型的LRU（最近最少使用）Cache，支持get和put方法；要求实现时间复杂度，O(1);
 * 2)如果要求get,put方法线程安全且性能较好，该如何支持？请用代码实现，并说明如此实现的性能优缺点，注意根据读写频度不同的场景实现方式可以有多种，答案不唯一，语言不限；
 *
 * 继承LinkedHashMap实现的LRUCache，在类中我自定义了一个类LRULinedHashMap继承自LinkedHashMap，
 * 并重写了其removeEldestEntry方法。get()和put()的时间复杂度均是O(1)。空间复杂度是O(n)，其中n为待缓存的键数。
 */
public class LRUCache {
    /**
     * 定义cache容量；
     */

    private int maxLoad;

    /**
     * 此处重写了removeEldestEntry方法，主要是考虑在超出cache容量时进行淘汰
     * @param <K>
     * @param <V>
     */
    private class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            if (size() > maxLoad) {
                return true;
            } else {
                return false;
            }
        }

    }

    private LRULinkedHashMap<Integer, Integer> lruLinkedHashMap = new LRULinkedHashMap<>();

    /**
     * 构造函数提供了容量初始化
     * @param maxload
     */
    public LRUCache(int maxload) {
        this.maxLoad = maxload;
    }

    /**
     * get方法，考虑访问后更新插入位置
     * @param key
     * @return
     */
    public int get(int key) {
        Integer value = lruLinkedHashMap.get(key);
        if (null == value) {
            return -1;
        }
        lruLinkedHashMap.remove(key);
        lruLinkedHashMap.put(key, value);
        return value;
    }

    /**
     * put方法1，返回put是否成功。该方法在多线程下非线程安全，但性能教好
     * @param key
     * @param value
     * @return
     */
    public boolean put1(int key, int value) {
        if (lruLinkedHashMap.containsKey(key)) {
            lruLinkedHashMap.remove(key);
            return false;
        }
        lruLinkedHashMap.put(key, value);
        return true;
    }

    /**
     * put方法2，线程安全，但性能受限
     * @param key
     * @param value
     * @return
     */
    public synchronized boolean put2(int key, int value) {
        if (lruLinkedHashMap.containsKey(key)) {
            lruLinkedHashMap.remove(key);
            return false;
        }
        lruLinkedHashMap.put(key, value);
        return true;
    }

    /**
     * 要实现线程安全的，其实更优的考虑是，类似于Redis，应该由另一个线程负责淘汰缓存，
     * 业务线程get时，当前node存在，可以更新node的时间戳，由负责淘汰缓存的线程根据node时间戳，
     * 加上访问频次等其他因素进行淘汰会更好些。
     */
}




