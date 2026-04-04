package Tree.BST;

import java.util.*;

public class QuestionsBST {

    class Node{
        int val;
        Node left;
        Node right;
        Node(int data){
            this.val = data;
            this.left = this.right = null;
        }
    }

    // https://leetcode.com/problems/search-in-a-binary-search-tree/
    public Node searchBST(Node root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        if(val < root.val){
            return searchBST(root.left,val);
        }else{
            return searchBST(root.right,val);
        }
    }

    // https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1
    public int findCeil(Node root, int x) {
        int ceil = -1;
        while(root != null){
            if(root.val == x){
                ceil = root.val;
                return ceil;
            }
            if(x > root.val){
                root = root.right;
            }else{
                ceil = root.val;
                root = root.left;
            }
        }
        return ceil;
    }

    // https://www.geeksforgeeks.org/problems/floor-in-bst/1
    public int findFloor(Node root, int x) {
        int floor = -1;
        while(root != null){
            if(root.val == x){
                floor = root.val;
                return floor;
            }
            if(x > root.val){
                floor = root.val;
                root = root.right;
            }else{
                root = root.left;
            }
        }
        return floor;
    }

    // https://leetcode.com/problems/insert-into-a-binary-search-tree/
    public Node insertIntoBST(Node root, int val) {
        // if root is null we create a node a return that node
        if(root == null) return new Node(val);
        Node node = root;
        while(node != null){
            // we move on the right side
            if(val > node.val){
                if(node.right != null){
                    node = node.right;
                }else{ // we reach to the leaf node and we insert the value
                    node.right = new Node(val);
                    break;
                }
            }else{ // we move on the left side
                if(node.left != null){
                    node = node.left;
                }else{ // we reach to the leaf node and we insert the value
                    node.left = new Node(val);
                    break;
                }
            }
        }
        return root;
    }

    // https://leetcode.com/problems/delete-node-in-a-bst/
    public Node deleteNode(Node root, int key) {
        if(root == null) return null;
        if(root.val == key) return helper(root);

        Node curr = root;
        while(root != null){
            if(root.val > key){
                if(root.left != null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                }else {
                    root = root.left;
                }
            }else{
                if(root.right != null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                }else {
                    root = root.right;
                }
            }
        }
        return curr;
    }

    private Node helper(Node root){
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;

        Node rightOne = root.right;
        Node lastRight = findLastRight(root.left);
        lastRight.right = rightOne;
        return root.left;
    }

    private Node findLastRight(Node root){
        if(root.right == null) return root;
        return findLastRight(root.right);
    }

    // https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    public int kthSmallest(Node root, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return ans.get(k-1);
    }

    private void inOrder(Node root, ArrayList<Integer> list){
        if(root == null) return;

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    // https://www.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
    public int kthLargest(Node root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root,list);
        return list.get(list.size() - k);
    }

    // https://leetcode.com/problems/validate-binary-search-tree/
    public boolean isValidBST(Node root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(Node root, long minVal, long maxVal) {
        if (root == null) return true;
        // if the current node val is greater than maxVal OR the current node val is lesser than minVal
        // that means it is out of range so we return false at that point
        if (root.val >= maxVal || root.val <= minVal) return false;
        // we check for left subTree and right right subTree if both return true i.e. it is a valid BST
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null) return null;
        int curr = root.val;
        // if both of them lie on the right side we go to right part of tree
        if(curr < p.val && curr < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        // if both of them lie on the left side we go to left part of tree
        else if(curr > p.val && curr > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        // if one is on the left side other is on the right side so we return the last node where it split
        return root;
    }

    // https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
    public Node bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder,Integer.MAX_VALUE,new int[]{0});
    }

    private Node bstFromPreorder(int []preorder,int bound,int []arr){
        if(arr[0] == preorder.length || preorder[arr[0]] > bound) return null;
        Node root = new Node(preorder[arr[0]++]);
        root.left = bstFromPreorder(preorder,root.val,arr);
        root.right = bstFromPreorder(preorder,bound,arr);
        return root;
    }

    // https://www.geeksforgeeks.org/problems/inorder-successor-in-bst/1
    public int inorderSuccessor(Node root, Node x) {
        Node successor = null;
        while(root != null){
            if(x.val >= root.val){
                root = root.right;
            }else{
                successor = root;
                root = root.left;
            }
        }
        if(successor == null) return -1;
        return successor.val;
    }

    // find the inOrder Predecessor of the given node
    public int inOrderPredecessor(Node root, Node x){
        Node predecessor = null;
        while(root != null){
            if(x.val > root.val){
                predecessor = root;
                root = root.right;
            }else{
                root = root.left;
            }
        }
        if(predecessor == null) return -1;
        return predecessor.val;
    }

    // find Predecessor and Successor of the given val from the BST
    // https://www.geeksforgeeks.org/problems/predecessor-and-successor/1
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> list = new ArrayList<>();
        Node succ = null, pred = null;
        while(root != null){
            if(key > root.val){
                pred = root;
                root = root.right;
            }else if(key < root.val){
                succ = root;
                root = root.left;
            }else{
                // if the key is equal to the root.data then
                // we have to find the pred and succ and add it to the list

                // find predecessor (max in left subtree)
                if(root.left != null){
                    Node temp = root.left;
                    while(temp.right != null){
                        temp = temp.right;
                    }
                    pred = temp;
                }

                // find successor (min in right subtree)
                if(root.right != null){
                    Node temp = root.right;
                    while(temp.left != null){
                        temp = temp.left;
                    }
                    succ = temp;
                }
                break;
            }
        }
        list.add(pred);
        list.add(succ);
        return list;
    }

    // https://leetcode.com/problems/binary-search-tree-iterator/
    // we are using inOrder first we push the element and go to the extreme left
    class BSTIterator {
        private Stack<Node> stack = new Stack<>();
        public BSTIterator(Node root) {
            while(root != null){
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            Node topEle = stack.peek();
            stack.pop();
            Node node = topEle.right;
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            return topEle.val;
        }

        public boolean hasNext() {
            if(!stack.isEmpty()) return true;
            return false;
        }
    }

    // https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
    public boolean findTarget(Node root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, k, set);
    }

    private boolean dfs(Node root, int k, HashSet<Integer> set) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;

        set.add(root.val);
        return dfs(root.left, k, set) || dfs(root.right, k, set);
    }

    // https://leetcode.com/problems/recover-binary-search-tree/
    private Node first;
    private Node prev;
    private Node middle;
    private Node last;

    private void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        if(prev !=null && (root.val < prev.val)){
            // if this is the first violation then mark these two nodes as first & middle;
            if(first == null){
                first = prev;
                middle = root;
            }
            // if this is the second violation mark this node as last
            else {
                last = root;
            }
        }
        // mark this node as previous
        prev = root;
        inOrder(root.right);
    }
     public void recoverTree(Node root) {
        first = middle = last = null;
        prev = new Node(Integer.MIN_VALUE);
        inOrder(root);
        if(first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }else if(first != null && middle != null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    // https://www.geeksforgeeks.org/problems/largest-bst/1
    int maxi;
    public int largestBst(Node root) {
        maxi = 0;
        solve(root);
        return maxi;
    }

    private  void solve(Node root) {
        if (root == null) return;

        if (isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            maxi = Math.max(maxi, getSize(root));
        }
        solve(root.left);
        solve(root.right);
    }

    private static int getSize(Node root){
        if(root == null) return 0;
        int left = getSize(root.left);
        int right = getSize(root.right);
        return 1 + left + right;
    }

    // https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
    int max = 0;
    public int maxSumBST(Node root) {
        if(root == null) return 0;
        if(isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)){
            max = Math.max(max,getSum(root));
        }
        maxSumBST(root.left);
        maxSumBST(root.right);
        return max;
    }

    private int getSum(Node root){
        if(root == null) return 0;
        int left = getSum(root.left);
        int right = getSum(root.right);
        return root.val + left + right;
    }

    // Optimal approach of this question
    class NodeInfo {
        int sum;
        int min;
        int max;
        boolean isBST;

        NodeInfo(int sum, int min, int max, boolean isBST) {
            this.sum = sum;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    class Solution {
        int maxSum = 0;

        private NodeInfo helper(Node root) {
            if (root == null) {
                return new NodeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
            }

            NodeInfo left = helper(root.left);
            NodeInfo right = helper(root.right);

            // check BST condition
            if (left.isBST && right.isBST &&
                    root.val > left.max && root.val < right.min) {

                int currSum = root.val + left.sum + right.sum;
                maxSum = Math.max(maxSum, currSum);

                int min = Math.min(root.val, left.min);
                int max = Math.max(root.val, right.max);
                return new NodeInfo(currSum, min, max, true);
            }

            // not BST
            return new NodeInfo(0, 0, 0, false);
        }

        public int maxSumBST(Node root) {
            helper(root);
            return maxSum;
        }
    }


}