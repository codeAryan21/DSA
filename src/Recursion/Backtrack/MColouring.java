package Recursion.Backtrack;

import java.util.*;

public class MColouring {
    public static void main(String[] args) {
        int N = 4, M = 3; // N = no. of node, M = no. of color;
        List<Integer> []G = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList<>();
        }
        G[0].add(1);
        G[1].add(0);
        G[1].add(2);
        G[2].add(1);
        G[2].add(3);
        G[3].add(2);
        G[3].add(0);
        G[0].add(3);
        G[0].add(2);
        G[2].add(0);
        int []color = new int[N];
        boolean ans = graphColoring(G, color, 0, M); // i = starting node
        if (ans == true)
            System.out.println("1");
        else
            System.out.println("0");
    }

    static boolean graphColoring(List<Integer> []G,int []color,int i,int M){
        int n = G.length; // no. of nodes
        if(solve(i,G,color,n,M) == true) return true;
        return false;
    }

    static boolean solve(int node,List<Integer> []G,int []color,int N,int M){
        if(node == N) return true;

        for(int i = 1;i <= M;i++){
            if(isSafe(node,G,color,N,i)){
                color[node] = i;
                if(solve(node+1,G,color,N,M) == true) return true;
                color[node] = 0; // backtrack
            }
        }
        return false;
    }

    static boolean isSafe(int node,List<Integer> []G, int []color,int n, int col){
        for (int i : G[node]) { // for traversing the adjacent node
            if (color[i] == col) return false;
        }
        return true;
    }
}
