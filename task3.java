Given daily profit/loss values, find the maximum possible profit obtainable from a contiguous sequence of days using Kadane’s 


Program:
import java.util.*;
public class kadanes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            currentSum = Math.max(value, currentSum + value);
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println(maxSum);
       sc.close();
    }
}
