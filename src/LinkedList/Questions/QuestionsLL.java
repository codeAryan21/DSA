package LinkedList.Questions;

import java.util.*;

public class QuestionsLL {
    public class ListNode {
        int val;
        ListNode next;

        ListNode bottom;

        ListNode(int val) {
            this.val = val;
        }
    }

    // https://leetcode.com/problems/add-two-numbers/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0;
        while (h1 != null || h2 != null) {
            int sum = carry;
            if (h1 != null) sum = sum + h1.val;
            if (h2 != null) sum = sum + h2.val;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;

            curr.next = newNode;
            curr = newNode;

            if (h1 != null) h1 = h1.next;
            if (h2 != null) h2 = h2.next;
        }
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
        }
        return dummy.next;
    }

    // https://leetcode.com/problems/odd-even-linked-list/?envType=problem-list-v2&envId=linked-list
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    // https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
    // sort 0's, 1's and 2's.
    public ListNode sortList0(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);
        ListNode zero = zeroHead;
        ListNode one = oneHead;
        ListNode two = twoHead;

        ListNode temp = head;
        while (temp != null) {
            if (temp.val == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.val == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }

        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;
    }

    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/?envType=problem-list-v2&envId=linked-list
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode deleteNode = slow.next;
        slow.next = slow.next.next;
        return head;
    }

    // https://leetcode.com/problems/reverse-linked-list/description/
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    // reverse a linked list via recursion
    /*
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
     */

    // https://leetcode.com/problems/palindrome-linked-list/
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // Step 1: find middle
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // Step 2: reverse second half
        ListNode newHead = reverse(slow.next);

        // Step 3: compare first half & reversed second half
        ListNode first = head;
        ListNode second = newHead;
        while(second != null){
            if(first.val != second.val){
                reverse(newHead);  // reverse before returning
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
    }

    static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    // add 1 to LL
    public ListNode addOne(ListNode head) {
        head = reverse(head);
        ListNode temp = head;
        int carry = 1;
        while(temp != null){
            temp.val = temp.val + carry;
            if(temp.val < 10){
                carry = 0;
                break;
            }else{
                temp.val = 0;
                carry = 1;
            }
            temp = temp.next;
        }
        if(carry == 1){
            ListNode newHead = new ListNode(carry);
            head = reverse(head);
            newHead.next = head;
            head = newHead;
            return head;
        }
        head = reverse(head);
        return head;
    }

    /*
    public ListNode addOneRecursive(ListNode head) {
        int carry = helper(head);
        if(carry == 1){
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }
    public int helper(ListNode temp){
        if(temp == null) return 1; // if temp == null return 1 add to the prev temp.val
        int carry = helper(temp.next); // go to the last node
        temp.val = temp.val + carry;
        if(temp.val < 10){
            return 0;
        }
        temp.val = 0;
        return 1;
    }
     */

    // https://leetcode.com/problems/intersection-of-two-linked-lists/description/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
            if(temp1 == temp2) return temp1;
            if(temp1 == null) temp1 = headB;
            if(temp2 == null) temp2 = headA;
        }
        return temp2;
    }

    // https://leetcode.com/problems/middle-of-the-linked-list/submissions/
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    // https://leetcode.com/problems/linked-list-cycle/description/
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    // https://www.geeksforgeeks.org/problems/find-length-of-loop/1
    // find the length of loop in LL
    public int findLengthOfLoop(ListNode head) {
        if(head == null) return 0;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return length(slow,fast);
            }
        }
        return 0;
    }

    public int length(ListNode slow,ListNode fast){
        int cnt = 1;
        fast = fast.next;
        while(fast != slow){
            cnt++;
            fast = fast.next;
        }
        return cnt;
    }

    // https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow; // we need to keep track of prev of the middle node
            slow = slow.next;
        }
        prev.next = slow.next;
        return head;
    }

    // https://leetcode.com/problems/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                slow = head;
                // Find the first node of the loop
                while(fast != slow){
                    // Move slow and fast one step at a time
                    fast = fast.next;
                    slow = slow.next;
                    // When slow and fast meet again, it's the first node of the loop
                }
                // Return the first node of the loop
                return slow; // or return fast both point at the same node
            }
        }
        return null;
    }

    /*
    public ListNode detectCycle(ListNode head) {
        ListNode temp = head;
        HashMap<ListNode, Integer> map = new HashMap<>();
        while(temp != null){
            if(map.containsKey(temp)){
                return temp;
            }
            map.put(temp,1);
            temp = temp.next;
        }
        return null;
    }
     */


    // https://leetcode.com/problems/reverse-nodes-in-k-group/description/
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp != null){
            ListNode kThNode = getKthNode(temp,k);
            if(kThNode == null){
                if(prevNode != null) prevNode.next = temp;
                break;
            }
            ListNode nextNode = kThNode.next;
            kThNode.next = null;
            // reverse current k block of node
            ListNode reversedHead = reverse(temp);

            if(temp == head){
                head = kThNode;
            }else{
                prevNode.next = kThNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }

    public ListNode getKthNode(ListNode temp,int k){
        k = k - 1;
        while(temp != null && k > 0){
            k--;
            temp = temp.next;
        }
        return temp;
    }

    // https://leetcode.com/problems/rotate-list/
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode tail = head;
        int length = 1;
        while(tail.next != null){
            length++;
            tail = tail.next;
        }
        if(k % length == 0) return head;
        k = k % length;
        tail.next = head;
        ListNode temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            if(cnt == length-k){
                head = temp.next;
                temp.next = null;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // https://leetcode.com/problems/merge-two-sorted-lists/description/
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if(list1 != null){
            curr.next = list1;
        }
        if(list2 != null){
            curr.next = list2;
        }
        return dummy.next;
    }

    // https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1
    public ListNode flatten(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mergedHead = flatten(head.next);
        head =  mergeLists(head,mergedHead);
        return head;
    }

    public ListNode mergeLists(ListNode list1,ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.bottom = list1;
                list1 = list1.bottom;
            }else{
                temp.bottom = list2;
                list2 = list2.bottom;
            }
            temp = temp.bottom;
        }
        if(list1 != null){
            temp.bottom = list1;
        }else{
            temp.bottom = list2;
        }
        return dummy.bottom;
    }

    // https://leetcode.com/problems/merge-k-sorted-lists/description/
    // Pair is a helper class and each pair stores a val(the data of the node) and a node(this is the actual node)
    public class Pair{
        int val;
        ListNode node;
        Pair(int val,ListNode node){
            this.val = val;
            this.node = node;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        // Comparator ensures that the heap is sorted by val(the node data).So, the smallest node is always at the top
        // compare Pair objects by their 'val' field and store them in ascending order
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        // Push all list heads into the heap
        for(int i=0;i<lists.length;i++){
            if(lists[i] != null){
                pq.add(new Pair(lists[i].val,lists[i]));
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!pq.isEmpty()){
            // pq.poll() → remove the smallest node (based on val).
            Pair p = pq.poll();
            temp.next = p.node;
            temp = temp.next;
            if(p.node.next != null){
                pq.add(new Pair(p.node.next.val,p.node.next));
            }
        }
        return dummy.next;
    }

    // https://leetcode.com/problems/sort-list/description/
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode middle = findMiddle(head);
        ListNode leftList = head;
        ListNode rightList = middle.next;
        middle.next = null;

        leftList = sortList(leftList);
        rightList = sortList(rightList);
        return mergeList2(leftList,rightList);
    }

    public ListNode findMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode mergeList2(ListNode list1,ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list1 != null){
            temp.next = list1;
        }else{
            temp.next = list2;
        }
        return dummy.next;
    }

    // https://leetcode.com/problems/copy-list-with-random-pointer/description/
    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }
    }
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        insertCopyInBetween(head);
        connectRandomPointers(head);
        return connectNextPointers(head);
    }

    // step 1: insert the copy of node in between
    public void insertCopyInBetween(Node head){
        Node temp = head;
        while(temp != null){
            // Create a new node with the same data
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
    }

    // step 2: connect random pointers  of the copied nodes
    public void connectRandomPointers(Node head){
        Node temp = head;
        while(temp != null){
            // Access the copied node
            Node copyNode = temp.next;
            if(temp.random != null){
                // Point the copied node's random to the corresponding copied random node
                copyNode.random = temp.random.next;
            }else{
                // Set the copied node's random to null if the original random is null
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
    }

    // step 2: connect next pointers
    public Node connectNextPointers(Node head){
        Node temp = head;
        Node dummy = new Node(-1);
        Node curr = dummy;
        while(temp != null){
            curr.next = temp.next;
            temp.next = temp.next.next;
            curr = curr.next;
            temp = temp.next;
        }
        return dummy.next;
    }


}
