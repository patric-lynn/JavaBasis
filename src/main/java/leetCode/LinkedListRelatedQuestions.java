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
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 2. 两数相加
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
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
        while (p1 != null || p2 != null) {
            int x = (p1 != null) ? p1.val : 0;
            int y = (p2 != null) ? p2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p1 != null) p1 = p1.next;    //出现了判断条件错误，应该选择的是节点本身为空，因为整个循环当中都是本位加法；
            if (p2 != null) p2 = p2.next;
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return PlusNode.next;
    }


    /**
     * 19. 删除链表的倒数第N个节点
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * <p>
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * <p>
     * 解法一：整体思路是让前面的指针先移动n步，之后前后指针共同移动直到前面的指针到尾部为止
     * 首先设立预先指针 pre，预先指针是一个小技巧，在第2题中进行了讲解
     * 设预先指针 pre 的下一个节点指向 head，设前指针为 start，后指针为 end，二者都等于 pre
     * start 先向前移动n步，之后 start 和 end 共同向前移动，此时二者的距离为 n，
     * 当 start 到尾部时，end 的位置恰好为倒数第 n 个节点，因为要删除该节点，
     * 所以要移动到该节点的前一个才能删除，所以循环结束条件为 start.next != null
     * 删除后返回 pre.next，为什么不直接返回 head 呢，因为 head 有可能是被删掉的点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode start = result, post = result;
        int count = 0;
        while (count < n) {
            count++;
            start = start.next;
        }
        while (start.next != null) {
            start = start.next;
            post = post.next;
        }
        post.next = post.next.next;
        return result.next;
    }


    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     * <p>
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * <p>
     * 解法一：递归算法 O(n+m)的时间和空间复杂度
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
     * 解法二：迭代法
     * 首先，我们设定一个哨兵节点 "prehead" ，这可以在最后让我们比较容易地返回合并后的链表。
     * 我们维护一个 prev 指针，我们需要做的是调整它的 next 指针。
     * 然后，我们重复以下过程，直到 l1 或者 l2 指向了 null ：如果 l1 当前位置的值小于等于 l2 ，我们就把 l1 的值接在 prev 节点的后面同时将 l1 指针往后移一个。否则，我们对 l2 做同样的操作。
     * 不管我们将哪一个元素接在了后面，我们都把 prev 向后移一个元素。
     * 在循环终止的时候， l1 和 l2 至多有一个是非空的。由于输入的两个链表都是有序的，所以不管哪个链表是非空的，它包含的所有元素都比前面已经合并链表中的所有元素都要大。
     * 这意味着我们只需要简单地将非空链表接在合并链表的后面，并返回合并链表。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static void main(String[] args) {

    }
}
