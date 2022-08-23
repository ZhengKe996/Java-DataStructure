package LeetCode;

/**
 * 203. 移除链表元素 使用递归
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * https://leetcode.cn/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElementsThree{
    public ListNode removeElements(ListNode head,int val){
        if(head == null) return null;
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }
}
