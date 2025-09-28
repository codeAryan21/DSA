package Recursion.Backtrack;

import java.util.*;

public class RatInMaze {
    public static void main(String[] args) {
        int N = 4; // order of the matrix
        int [][] matrix = {
                {1,0,0,0},
                {1,1,0,1},
                {1,1,0,0},
                {0,1,1,1}
        };

        ArrayList<String> ans = findPath(matrix,N);
        if (ans.size() == 0) {
            System.out.println("No path found");
        } else {
            System.out.print("All possible paths: ");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
        }
    }

    static ArrayList<String> findPath(int [][]matrix, int N){
        int [][]visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = 0;
            }
        }
        //Direction  D  L  R   U
        int []di = { 1, 0, 0, -1};
        int []dj = { 0, -1, 1, 0};

        ArrayList<String> ans = new ArrayList<>();
        if(matrix[0][0] == 1){
            solve(0,0,matrix,N,ans,"",visited,di,dj);
        }
        return ans;
    }

    static void solve(int i,int j,int [][]matrix,int N,ArrayList<String> ans,String moves,int [][]visited,int []di,int []dj){
        if(i == N-1 && j == N-1){
            ans.add(moves);
            return;
        }
        String direction = "DLRU";
        visited[i][j] = 1;
        for (int ind = 0; ind < 4; ind++) {
            int nextI = i + di[ind];
            int nextJ = j + dj[ind];

            if(nextI >= 0 && nextJ >= 0 && nextI < N && nextJ < N && visited[nextI][nextJ] == 0 && matrix[nextI][nextJ] == 1){
                solve(nextI,nextJ,matrix,N,ans,moves + direction.charAt(ind),visited,di,dj);
            }
        }
        visited[i][j] = 0;
    }
}