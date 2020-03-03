package jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

/*
*输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
*/

public class ListRelatedQuestions {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public int[] reversePrint(ListNode head) {


        //if(head == null) return null;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while(temp!=null){
            stack.push(temp);
            temp = temp.next;
        }
        int num = stack.size();
        int[] result = new int[num];
        for(int i=0;i<num; i++){
            result[i] = stack.pop().val;
        }
        return result;
    }


    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        ListNode li=listNode;
        while(li!=null){
            list.add(0,li.val);
            li=li.next;
        }
        return list;
    }
}
