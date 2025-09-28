package LinkedList.Questions;

import java.util.*;

public class QuestionsDLL {
    public class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Delete all occurrences of a key in DLL
    public ListNode deleteAllOccurrences(ListNode head, int target) {
        if(head == null ) return null;
        ListNode temp = head;
        while(temp != null){
            if(temp.val == target){
                if(temp == head){
                    head = temp.next;
                    // If the new head is not null, set its prev to null because the head should not have a prev pointer.
                    if (head != null) {
                        head.prev = null;
                    }
                }
                ListNode prev = temp.prev;
                ListNode next = temp.next;
                if(next != null) next.prev = prev;
                if(prev != null) prev.next = next;
                temp = next;
            }else{
                temp = temp.next;
            }
        }
        return head;
    }


    // Find all the Pairs with Given Sum in DLL
    public List<List<Integer>> findPairsWithGivenSum(ListNode head, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(head == null) return ans;
        ListNode temp = head;
        ListNode temp1 = head;
        // Find tail of the DLL
        while (temp1.next != null) {
            temp1 = temp1.next;
        }

        // while(temp.val < temp1.val) because it is sorted and does not contain any duplicates
        while(temp != null && temp1 != null && temp != temp1 && temp1.next != temp){
            int sum = temp.val + temp1.val;
            if(sum == target){
                List<Integer> list = new ArrayList<>();
                list.add(temp.val);
                list.add(temp1.val);
                ans.add(list);

                temp = temp.next;
                temp1 = temp1.prev;
            }else if(sum < target){
                temp = temp.next;
            }else{
                temp1 = temp1.prev;
            }
        }
        return ans;
    }


    // Remove duplicated from sorted DLL
    public ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                ListNode next = temp.next.next;
                temp.next = next;
                if (next != null) {
                    next.prev = temp;
                }
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    // https://leetcode.com/problems/design-browser-history/
    public class Node {
        String val;;
        Node next;
        Node prev;

        Node(String val) {
            this.val = val;
        }
    }
    class BrowserHistory {
        Node currPage;
        public BrowserHistory(String homepage) {
            currPage = new Node(homepage);
        }

        public void visit(String url) {
            Node newPage = new Node(url);
            currPage.next = newPage;
            newPage.prev = currPage;
            currPage = newPage;
        }

        public String back(int steps) {
            while(steps > 0){
                if(currPage.prev != null){
                    currPage = currPage.prev;
                }else{
                    break;
                }
                steps--;
            }
            return currPage.val;
        }

        public String forward(int steps) {
            while(steps > 0){
                if(currPage.next != null){
                    currPage = currPage.next;
                }else{
                    break;
                }
                steps--;
            }
            return currPage.val;
        }
    }
}
