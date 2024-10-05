package solution.merge_two_sorted_lists;

//https://leetcode.com/problems/merge-two-sorted-lists/description/
public class Solution {
    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(Integer.MIN_VALUE);
        ListNode tmp = res; //
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tmp.next = list1;
                list1 = list1.next;
            } else {
                tmp.next = list2;
                list2 = list2.next;
            }
            //722 = 720
            tmp = tmp.next;
            System.out.println("tmp = " + tmp + " --- res = " + res);
        }
        if (list1 != null) {
            tmp.next = list1;
        } else if (list2 != null) {
            tmp.next = list2;
        }
        return res.next;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                System.out.println("list1 = " + list1);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                System.out.println("list2 = " + list2);
                return list2;
            }
        }
        if (list1 == null)
            return list2;
        return list1;
    }


    public static void main(String[] args) {
//        ListNode listNode = mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))), new ListNode(2, new ListNode(3, new ListNode(4))));
//        ListNode listNode = mergeTwoLists(new ListNode(1), new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode listNode = mergeTwoLists(new ListNode(1, new ListNode(3, new ListNode(5))), new ListNode(2, new ListNode(4)));
        System.out.println("listNode = " + listNode);
        /*
        * Input: list1 = [1,2,4], list2 = [1,3,4]
            Output: [1,1,2,3,4,4]
        * */
    }
}


