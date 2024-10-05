package remove_duplicates_from_sorted_list;

// 83 https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
public class Solution {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(-1, new ListNode(-1, new ListNode(1, new ListNode(1))));
        ListNode result = deleteDuplicates(listNode);
        System.out.println("result = " + result);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        // Пока следующая нода не null, сравниваем с прошлым значением
        // если равны, меняем ссылки
        ListNode current = head;
        while (current != null && current.next != null) {
            //System.out.println("current = " + current);
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

}
