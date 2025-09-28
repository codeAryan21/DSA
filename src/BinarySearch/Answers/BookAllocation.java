package BinarySearch.Answers;

public class BookAllocation {
    public static void main(String[] args) {
        int []arr = {25, 46, 28, 49, 24};
        System.out.println("The answer is: " + findPage(arr,4));
    }

    static int findPage(int []arr,int students){
        // book allocation impossible
        if(students > arr.length){
            return -1;
        }
//        int ans = 0;
        int low = findMax(arr);
        int high = totalSum(arr);
        while (low <= high){
            int mid = low + (high - low) / 2;
            int countSudent = countStudents(arr,mid);
//            if(countSudent == students){
//                ans = mid;
//                high = mid - 1;
//            } else if (countSudent > students) {
//                low = mid + 1;
//            }else {
//                high = mid - 1;
//            }

            if(countSudent <= students){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
//        return ans;
        return low;
    }

    static int findMax(int []arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    static int totalSum(int []arr){
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total;
    }

    static int countStudents(int []arr,int pages){
        int student = 1;
        int pagesStudent = 0;

        for (int i = 0; i < arr.length; i++) {
            if(pagesStudent + arr[i] <= pages){
                // add pages to current student
                pagesStudent += arr[i];
            }else{
                // add pages to next student
                student++;
                pagesStudent = arr[i];
            }
        }
        return student;
    }

    /*
    static int findPages(int []arr,int student){
        // book allocation impossible
        if(student > arr.length){
            return -1;
        }

        int low = findMax(arr);
        int high = totalSum(arr);
        for (int pages = low; pages <= high; pages++) {
            int countStudent = countStudents(arr,pages);
            if(countStudent == student){
                return pages;
            }
        }
        return low;
    }
     */
}
