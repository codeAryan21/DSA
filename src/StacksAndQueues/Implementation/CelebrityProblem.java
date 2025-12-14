package StacksAndQueues.Implementation;

public class CelebrityProblem {
    public static void main(String[] args) {
        int [][]matrix = {
                {0,1,1,0},
                {0,0,0,0},
                {1,1,0,0},
                {0,1,1,0}
        };

        /*
        int [][]matrix = {
                {0,0,1,0},
                {0,0,1,1},
                {0,0,0,0},
                {0,1,1,0}
        };

          This is for index 2
          0 | 1 | 3 | 1
          1 | 2 | 0 | 2
         */
        System.out.println("The index of the celebrity is: " + celebrity(matrix));
    }

    static int celebrity(int [][]matrix){
        int top = 0;
        int bottom = matrix.length-1;

        while(top < bottom){
            if(matrix[top][bottom] == 1){
                top = top + 1;
            } else if(matrix[bottom][top] == 1){
                bottom = bottom - 1;
            }else {
                // if no one knows anyone, means both are not celebrity
                top++;
                bottom--;
            }
        }

        if(top > bottom) return -1;

        // here top == bottom, so we check we both either top or bottom
        for(int i=0;i<matrix.length;i++){
            // check the diagonal
            if(i == top) continue;
            // we check for the entire row && col
            if(matrix[top][i] == 0 && matrix[i][top] == 1){

            }else{
                return -1;
            }
        }

        return top; // return top || bottom both are same
    }

    /*
    static int celebrity(int [][]matrix){
        int []knowMe = new int[matrix.length];
        int []IKnow = new int [matrix.length];

        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(matrix[i][j] == 1){
                    knowMe[j]++;
                    IKnow[i]++;
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            if(knowMe[i] == matrix.length-1 && IKnow[i] == 0){
                return i;
            }
        }
        return -1;
    }
     */
}
