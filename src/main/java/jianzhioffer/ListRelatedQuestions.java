package jianzhioffer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Description
 * 面试题06. 从尾到头打印链表: 从尾到头反过来返回每个节点的值。[堆栈法]
 * 面试题24. 反转链表: 输入一个链表的头节点，反转该链表并输出反转后链表的头节点。[头插法]
 * 面试题18. 删除链表的节点: 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。[双指针法]
 * 面试题22. 链表中倒数第k个节点: 输出该链表中倒数第k个节点。[双指针法]
 *
 * @author Lynn-zd
 * @date Created on 2020/4/14 01:13
 */
public class ListRelatedQuestions {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 面试题06. 从尾到头打印链表   面试题24. 反转链表
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * 示例 1：
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     */
    public static int[] reversePrint(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int num = stack.size();
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = stack.pop().val;
        }
        return result;
    }

    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     * 头插法
     */
    public static LinkedList<Integer> printListFromTailToHead(ListNode listNode) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ListNode node = listNode;
        while (node != null) {
            linkedList.add(0, node.val);
            node = node.next;
        }
        return linkedList;
    }

    /**
     * 面试题24. 反转链表
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        // 虚拟头，用于存放反转结果
        ListNode result = new ListNode(-1);
        ListNode item = head;
        ListNode next = null;
        while (item != null) {
            // 为了保证循环正常后移，先把下一个元素临时取出来
            next = item.next;
            // 因为需要移动到result链表中最前一个，所以我们需要把result的next节点，赋值给最新元素的item
            item.next = result.next;
            // 然后再把item插入到result当中
            result.next = item;
            // 元素后移继续循环
            item = next;
        }
        // 由于我们使用的虚拟头，第一个元素是无效的，直接取下一个节点就行了
        return result.next;
    }

    /**
     * 面试题18. 删除链表的值为val的节点
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     * 注意：此题对比原题有改动
     * 示例 1:
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) pre.next = cur.next;
        return head;
    }

    /**
     * 面试题22. 链表中倒数第k个节点
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     * 返回链表 4->5.
     *
     * @param head
     * @param k
     * @return
     */
    public static int getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++)
            former = former.next;
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter.val;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(4);

        System.out.println("倒数第K个节点的值为 " + getKthFromEnd(root, 3));
        System.out.println(reverseList(root));
        System.out.println(reversePrint(root));
        System.out.println(printListFromTailToHead(root));
        System.out.println(deleteNode(root, 2));
    }
}
