package leetCode;

/**
 * Description
 *
 * @author Lynn-zd
 * @date Created on 2020/3/16 12:33
 */
public class LinkedListRelatedQuestions {
    /**
     * ListNode定义
     */
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {val =  x;}
    }

    /**
     * 2. 两数相加
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode PlusNode = new ListNode(0);
        ListNode p1 = l1, p2 = l2, curr = PlusNode;
        int carry = 0;
        while(p1!=null || p2!=null){
            int x = (p1!=null)? p1.val:0 ;
            int y = (p2!=null)? p2.val:0 ;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p1!=null) p1=p1.next;    //出现了判断条件错误，应该选择的是节点本身为空，因为整个循环当中都是本位加法；
            if(p2!=null) p2=p2.next;
        }
        if(carry!=0){
            curr.next = new ListNode(carry);
        }
        return PlusNode.next;
    }

    public static void main(String[] args) {

    }
}
