package StacksAndQueues.Questions;

import java.util.*;

// https://leetcode.com/problems/asteroid-collision/description/
public class AestroidCollision {
    public static void main(String[] args) {
        int []arr = {4,7,1,1,2,-3,-7,17,15,-16};
//        int []arr = {4,7,1,1,2,-3,-7,17,15,-18,-19};

        int []ans = asteroidCollision(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    // Function to determine the state of asteroids after all collisions
    static int[] asteroidCollision(int [] asteroids){
        List<Integer> stack = new ArrayList<>();
        for (int i = 0; i < asteroids.length; i++) {
            // If asteroid is moving right, push it to the stack
            if(asteroids[i] > 0){
                stack.add(asteroids[i]);
            }
            // If asteroid is moving left, handle possible collisions
            else {
                // Destroy all smaller right-moving asteroids
                while (!stack.isEmpty() && stack.get(stack.size()-1) > 0 && stack.get(stack.size()-1) < Math.abs(asteroids[i])){
                    stack.removeLast();
                }
                // Destroy both if sizes are equal
                if(!stack.isEmpty() && stack.get(stack.size()-1) == Math.abs(asteroids[i])){
                    stack.removeLast();
                }
                // If top of stack is a left-moving or no asteroid, add this one
                else if(stack.isEmpty() || stack.get(stack.size()-1) < 0){
                    stack.add(asteroids[i]);
                }
            }
        }
        // Convert the list to an array
        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }
        // Return the final state of asteroids
        return result;
    }
}
