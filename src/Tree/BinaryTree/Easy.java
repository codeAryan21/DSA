package Tree.BinaryTree;

import java.util.*;

class Node{
    int val;
    Node left;
    Node right;
    Node(int data){
        this.val = data;
        this.left = this.right = null;
    }
}

public class Easy {
    // https://leetcode.com/problems/binary-tree-preorder-traversal/
    public List<Integer> preorderTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root,ans);
        return ans;
    }

    public void preOrder(Node node,List<Integer> list){
        if(node == null) return;
        list.add(node.val);
        preOrder(node.left,list);
        preOrder(node.right,list);
    }

    // Iterative solution
    public List<Integer> pre(Node root){
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return list;
    }

    // https://leetcode.com/problems/binary-tree-inorder-traversal/
    public List<Integer> inorderTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(root,ans);
        return ans;
    }

    public void inOrder(Node node,List<Integer> list){
        if(node == null) return;
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);
    }

    // Iterative solution
    public List<Integer> in(Node root){
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        Node node = root;

        while (true){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else {
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }

    // https://leetcode.com/problems/binary-tree-postorder-traversal/
    public List<Integer> postorderTraversal(Node root) {
        List<Integer> ans = new ArrayList<>();
        postOrder(root,ans);
        return ans;
    }

    public void postOrder(Node node,List<Integer> list){
        if(node == null) return;
        postOrder(node.left,list);
        postOrder(node.right,list);
        list.add(node.val);
    }

    // Iterative solution using 2 stack
    public List<Integer> post(Node root){
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()){
            Node node = stack1.pop();
            stack2.push(node);
            if(node.left != null){
                stack1.push(node.left);
            }
            if(node.right != null){
                stack1.push(node.right);
            }
        }
        while(!stack2.isEmpty()){
            list.add(stack2.pop().val);
        }
        return list;
    }

    // https://leetcode.com/problems/binary-tree-level-order-traversal/description/
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i=0;i<size;i++){
                Node node = queue.poll();
                level.add(node.val);

                // check if left exist, then add
                if(node.left != null){
                    queue.add(node.left);
                }

                // check if right exist, then add
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            list.add(level);
        }
        return list;
    }


}
