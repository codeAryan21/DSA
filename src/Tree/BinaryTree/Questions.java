package Tree.BinaryTree;

import java.util.*;

public class Questions {

    class Node{
        int val;
        Node left;
        Node right;
        Node(int data){
            this.val = data;
            this.left = this.right = null;
        }
    }

    // https://leetcode.com/problems/maximum-depth-of-binary-tree/
    public int maxDepth(Node root){
        if(root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        int height = 1 + Math.max(l,r);
        return height;
    }

    // https://leetcode.com/problems/minimum-depth-of-binary-tree/
    public int minDepth(Node root){
        if(root == null) return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);

        if(root.left == null) return 1 + r;
        if(root.right == null) return 1 + l;

        int height = 1 + Math.min(l,r);
        return height;
    }

    // https://leetcode.com/problems/balanced-binary-tree/
    public boolean isBalanced(Node root) {
        if(height(root) == -1){
            return false;
        }
        return true;
    }

    public int height(Node root){
        if(root == null) return 0;

        int l = height(root.left);
        if(l == -1) return -1;
        int r = height(root.right);
        if(r == -1) return -1;

        if(Math.abs(l - r) > 1) return -1;
        return 1 + Math.max(l,r);
    }

    // https://leetcode.com/problems/diameter-of-binary-tree/
    int maxi = 0;
    public int diameterOfBinaryTree(Node root){
        heightOfTree(root);
        return maxi;
    }

    public int heightOfTree(Node root){
        if(root == null) return 0;
        int l = heightOfTree(root.left);
        int r = heightOfTree(root.right);
        maxi = Math.max(maxi, l + r);

        return 1 + Math.max(l, r);
    }

    // https://leetcode.com/problems/binary-tree-maximum-path-sum/
    int maximum = Integer.MIN_VALUE;
    public int maxPathSum(Node root) {
        findMaxPath(root);
        return maximum;
    }

    public int findMaxPath(Node node){
        if(node == null) return 0;
        int lSum = Math.max(0, findMaxPath(node.left));
        int rSum = Math.max(0, findMaxPath(node.right));
        maximum = Math.max(maximum, node.val + lSum + rSum);

        return node.val + Math.max(lSum, rSum);
    }

    // https://leetcode.com/problems/same-tree/
    public boolean isSameTree(Node p, Node q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        // Queue to store nodes for BFS (level order traversal)
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean LtoR = true; // Boolean flag to control traversal direction. For LtoR it is true and RtoL it is false;

        while(!queue.isEmpty()){
            // Get the number of nodes at the current level
            int size = queue.size();
            // Temporary array to store current level's values in zigzag order
            Integer[] level = new Integer[size];

            // Process each node in the current level
            for(int i=0;i<size;i++){
                Node node = queue.poll(); // Get the front node from the queue
                // Determine index where this value should be stored
                int index = LtoR ? i : size - i - 1;
                level[index] = node.val;

                // Add left child to queue if it exists
                if (node.left != null) queue.add(node.left);
                // Add right child to queue if it exists
                if (node.right != null) queue.add(node.right);
            }
            // Flip traversal direction for the next level
            LtoR = !LtoR;
            // Add current level to the final ansl
            ans.add(Arrays.asList(level));
        }
        return ans;
    }

    // https://leetcode.com/problems/boundary-of-binary-tree/description/
    public List<Integer> printBoundary(Node root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        // If the root is not a leaf, add its value to the result
        if(!isLeaf(root)) ans.add(root.val);

        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);
        return ans;
    }

    // Function to check if a node is a leaf
    boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    public void addLeftBoundary(Node root, List<Integer> list){
        Node curr = root.left;
        while(curr != null){
            // If the current node is not a leaf, add its value to the list
            if(!isLeaf(curr)) list.add(curr.val);
            if(curr.left != null){
                curr = curr.left;
            }else {
                curr = curr.right;
            }
        }
    }

    public void addLeaves(Node root, List<Integer> list){
        // If the current node is a leaf, add its value to the result
        if(isLeaf(root)){
            list.add(root.val);
            return;
        }
        // Recursively add leaves of the left and right subtrees
        if(root.left != null) addLeaves(root.left, list);
        if(root.right != null) addLeaves(root.right, list);
    }

    public void addRightBoundary(Node root, List<Integer> list){
        Node curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while(curr != null){
            // If the current node is not a leaf, add its value to a temporary list
            if(!isLeaf(curr)) temp.add(curr.val);
            if(curr.right != null){
                curr = curr.right;
            }else {
                curr = curr.left;
            }
        }
        for(int i=temp.size()-1;i>=0;i--){
            list.add(temp.get(i));
        }
    }

    // https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
    // Vertical --> straight(sidha) this is done via levelOrder traversal

    private static class Pair{
        Node node;
        int vertical;
        int level;
        Pair(Node n, int v, int l){
            this.node = n;
            this.vertical = v;
            this.level = l;
        }
    }
    public List<List<Integer>> verticalTraversal(Node root) {
        // Map to store vertical and level mapping
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        // Queue for BFS storing node with vertical and level
        Queue<Pair> queue = new LinkedList<Pair>();

        queue.add(new Pair(root,0,0)); // Push root node with coordinates (0,0)
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            Node temp = p.node;
            int x = p.vertical;
            int y = p.level;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).add(temp.val);

            // If left child exists, push to queue
            if(temp.left != null){
                queue.add(new Pair(temp.left, x - 1, y + 1));
            }
            // If right child exists, push to queue
            if(temp.right != null){
                queue.add(new Pair(temp.right, x + 1, y + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        // Iterate through map to build result
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> pq : ys.values()) {
                while(!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }
            ans.add(list);
        }
        return ans;
    }

    // Same done via inOrder traversal
    /*
    TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        inOrder(root,0,0);
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> t : map.values()){
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> pq : t.values()){
                while(!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public void inOrder(TreeNode node, int x, int y){
        if(node == null) return;
        inOrder(node.left, x - 1, y + 1);
        if(!map.containsKey(x)){
            map.put(x, new TreeMap<>());
        }
        if(!map.get(x).containsKey(y)){
            map.get(x).put(y, new PriorityQueue<>());
        }
        map.get(x).get(y).add(node.val);
        inOrder(node.right, x + 1, y + 1);
    }
     */

    // https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
    private static class PairTop{
        Node node;
        int level;
        PairTop(Node n, int l){
            this.node = n;
            this.level = l;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        // Map to store vertical level -> node value (only first encountered)
        Map<Integer,Integer> map = new TreeMap<>();
        // Queue for BFS storing {node, vertical_level}
        Queue<PairTop> queue = new LinkedList<PairTop>();
        // Push the root node with vertical level 0
        queue.add(new PairTop(root, 0));

        while(!queue.isEmpty()){
            // Get the front element of the queue
            PairTop pt = queue.poll();
            Node temp = pt.node;
            int line = pt.level;

            // If vertical position is visited for the first time, store the value
            if(!map.containsKey(line)){
                map.put(line, temp.val);
            }
            // If left child exists, push it with vertical level - 1
            if (temp.left != null) {
                queue.add(new PairTop(temp.left, line - 1));
            }
            // If right child exists, push it with vertical level + 1
            if (temp.right != null) {
                queue.add(new PairTop(temp.right, line + 1));
            }
        }
        // Transfer values from the map to the answer list
        for(int value : map.values()){
            ans.add(value);
        }
        return ans;
    }

    // https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<PairTop> queue = new LinkedList<PairTop>();
        queue.add(new PairTop(root,0));

        while(!queue.isEmpty()){
            PairTop p = queue.poll();
            Node temp = p.node;
            int line = p.level;

            map.put(line, temp.val);
            if(temp.left != null){
                queue.add(new PairTop(temp.left, line - 1));
            }
            if(temp.right != null){
                queue.add(new PairTop(temp.right, line + 1));
            }
        }
        for(int val : map.values()){
            ans.add(val);
        }
        return ans;
    }

    // https://leetcode.com/problems/binary-tree-right-side-view/
    public List<Integer> rightSideView(Node root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        rightView(root,0,ans);
        return ans;
    }

    private void rightView(Node node,int level,List<Integer> list){
        if(node == null) return;
        if(level == list.size()){
            list.add(node.val);
        }
        rightView(node.right,level + 1,list);
        rightView(node.left,level + 1,list);
    }

    // https://leetcode.com/problems/symmetric-tree/
    public boolean isSymmetric(Node root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(Node left, Node right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val){
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right,right.left);
    }

    // Print Root to Node Path in Binary Tree
    public List<Integer> path(Node root, int x){
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        getPath(root,x,list);
        return list;
    }

    // Function to get path from root to node with value x
    private boolean getPath(Node node,int x,List<Integer> list){
        if(node == null) return false;
        list.add(node.val);
        // If current node is the target
        if(node.val == x){
            return true;
        }
        // Recurse into left and right children
        if(getPath(node.left,x,list) || getPath(node.right,x,list)){
            return true;
        }
        // Backtrack if not found
        list.remove(list.size() - 1);
        return false;
    }

    // https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
    public List<List<Integer>> Paths(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        getPath(root,ans,new ArrayList<>());
        return ans;
    }

    private void getPath(Node node,List<List<Integer>> ans, List<Integer> list){
        if(node == null) return;
        list.add(node.val);
        if(isLeaf(node)){
            ans.add(new ArrayList<>(list));
        }
        getPath(node.left,ans,list);
        getPath(node.right,ans,list);
        list.remove(list.size() - 1);
    }

    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null || root == p || root == q){
            return root;
        }
        Node left = lowestCommonAncestor(root.left,p,q);
        Node right = lowestCommonAncestor(root.right,p,q);

        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }else{ // Both sides returned something, so we returned that node itself
            return root;
        }
    }

    // https://leetcode.com/problems/maximum-width-of-binary-tree/
    private class P{
        Node node;
        int num;
        P(Node node,int num){
            this.node = node;
            this.num = num;
        }
    }
    public int widthOfBinaryTree(Node root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<P> queue = new LinkedList<>();
        queue.add(new  P(root,0));

        while(!queue.isEmpty()){
            int size = queue.size();
            int minNum = queue.peek().num;     // to make the index starting from zero || index of first node in this level.
            int first = 0, last = 0;
            for(int i=0;i<size;i++){
                int currIdx = queue.peek().num - minNum;
                Node node = queue.peek().node;
                queue.poll();
                if(i == 0) first = currIdx;
                if(i == size - 1) last = currIdx;

                if(node.left != null){
                    queue.add(new P(node.left, currIdx * 2 + 1));
                }
                if(node.right != null) {
                    queue.add(new P(node.right, currIdx * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }

    // https://www.geeksforgeeks.org/problems/children-sum-parent/1
    public boolean isSumProperty(Node root){
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;

        int left = 0, right = 0;
        if(root.left != null) left = root.left.val;
        if(root.right != null) right = root.right.val;

        if(root.val == left + right && isSumProperty(root.left) && isSumProperty(root.right)){
            return true;
        }
        return false;
    }

    // Children sum property. Changing the node value so that it matches the property
    public void changeTree(Node root){
        if(root == null) return;
        int child = 0;
        if(root.left != null){
            child = child + root.left.val;
        }
        if(root.right != null){
            child = child + root.right.val;
        }

        if(child >= root.val){
            root.val = child;
        }else {
            if(root.left != null) root.left.val = root.val;
            else if(root.right != null) root.right.val = root.val;
        }
        changeTree(root.left);
        changeTree(root.right);

        int total = 0;
        if(root.left != null) total = total + root.left.val;
        if(root.right != null) total = total + root.right.val;
        if(root.left != null || root.right != null) root.val = total;
    }

    // https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
    public List<Integer> distanceK(Node root, Node target, int k) {
        // Build parent references using BFS
        Map<Node,Node> trackParent = new HashMap<>();
        markParents(root,trackParent);

        Map<Node, Boolean> visited = new HashMap<>(); // to mark the visited node in the map
        Queue<Node> queue = new LinkedList<>();
        queue.add(target);
        visited.put(target,true);
        int dist = 0;

        // BFS starting from the target node to collect nodes at distance K
        while(!queue.isEmpty()){
            int size = queue.size();
            if(dist == k) break;
            dist++;

            for(int i=0;i<size;i++){
                Node curr = queue.poll();
                if(curr.left != null && visited.get(curr.left) == null){
                    queue.add(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right != null && visited.get(curr.right) == null){
                    queue.add(curr.right);
                    visited.put(curr.right,true);
                }
                if(trackParent.get(curr) != null && visited.get(trackParent.get(curr)) == null){
                    queue.add(trackParent.get(curr));
                    visited.put(trackParent.get(curr),true);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            Node current = queue.poll();
            ans.add(current.val);
        }
        return ans;
    }

    // function to mark the parent of each nodes for traversal and finding the node at k distance
    private void markParents(Node root,Map<Node,Node> trackParent){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current.left != null){
                trackParent.put(current.left,current);
                queue.add(current.left);
            }
            if(current.right != null){
                trackParent.put(current.right,current);
                queue.add(current.right);
            }
        }
    }

    // https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
    public int amountOfTime(Node root, int start) {
        Map<Node,Node> trackParent = new HashMap<>();
        markParents(root,trackParent);

        Queue<Node> queue = new LinkedList<>();
        Map<Node,Boolean> visited = new HashMap<>();
        Node startNode = returnNode(root,start);
        queue.add(startNode);
        visited.put(startNode,true);
        int dist = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            int burn = 0;
            for(int i=0;i<size;i++){
                Node curr = queue.poll();
                if(curr.left != null && visited.get(curr.left) == null){
                    burn = 1;
                    queue.add(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right != null && visited.get(curr.right) == null){
                    burn = 1;
                    queue.add(curr.right);
                    visited.put(curr.right,true);
                }
                if(trackParent.get(curr) != null && visited.get(trackParent.get(curr)) == null){
                    burn = 1;
                    queue.add(trackParent.get(curr));
                    visited.put(trackParent.get(curr),true);
                }
            }
            if(burn == 1){
                dist++;
            }
        }
        return dist;
    }

    // function to return the startNode from the given value. we have the value of the given node not the exact node
    private Node returnNode(Node root,int start){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node startNode = new Node(-1);
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.val == start){
                startNode = node;
            }
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        return startNode;
    }

    // https://leetcode.com/problems/count-complete-tree-nodes/
    public int countNodes(Node root) {
        int count = 0;
        if(root == null) return count;
        count++;
        count = count + countNodes(root.left);
        count = count + countNodes(root.right);
        return count;
    }

    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    public Node buildTree1(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        Node root = build1(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1,map);
        return root;
    }

    private Node build1(int []preOrder,int preStart,int preEnd, int []inOrder,int inStart,int inEnd, Map<Integer,Integer> map){
        if(preStart > preEnd || inStart > inEnd) return null;
        Node root = new Node(preOrder[preStart]);

        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = build1(preOrder,preStart + 1,preStart + numsLeft,inOrder,inStart,inRoot - 1,map);
        root.right = build1(preOrder,preStart + numsLeft + 1,preEnd,inOrder,inRoot + 1,inEnd,map);
        return root;
    }

    // https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
    public Node buildTree2(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        Node root = build2(inorder,0,inorder.length-1, postorder,0,postorder.length-1, map);
        return root;
    }

    private Node build2(int []inOrder,int inStart,int inEnd, int []postOrder,int postStart,int postEnd, Map<Integer,Integer> map){
        if(inStart > inEnd || postStart > postEnd) return null;

        Node root = new Node(postOrder[postEnd]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = build2(inOrder,inStart,inRoot - 1, postOrder,postStart,postStart + numsLeft - 1, map);
        root.right = build2(inOrder,inRoot + 1,inEnd, postOrder,postStart + numsLeft,postEnd - 1, map);
        return root;
    }

    // https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null) return "";
        Queue<Node> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node == null){
                sb.append("null ");
                continue;
            }
            sb.append(node.val + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.length() == 0) return null;
        Queue<Node> queue = new LinkedList<>();
        String []values = data.split(" ");
        Node root = new Node(Integer.parseInt(values[0]));
        queue.add(root);
        int i = 1;

        while(!queue.isEmpty()){
            Node parent = queue.poll();
            if(!values[i].equals("null")){
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            i++;
            if(!values[i].equals("null")){
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
            i++;
        }
        return root;
    }

    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    Node prev = null;
    public void flatten(Node root) {
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
