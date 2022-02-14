import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * ZeroOne Knapsack using recursion
 * Applying memoization here
 */


public class ZeroOne1 {

    static int[][] t;

    ZeroOne1(int n, int cap){
        t = new int[n+1][cap+1];
        for(int[] i : t)
            Arrays.fill(i, -1);
    }

    int knapsack(int[] val, int[] wt, int capacity, int n){
        if(val.length != wt.length)
            throw new NoSuchElementException("Invalid weights profit array");
        if(capacity == 0 || n == 0)
            return 0;
        if(t[n][capacity] != -1)
            return t[n][capacity];
        else{
            if(wt[n] <= capacity)
                return t[n][capacity] = Math.max(val[n] + knapsack(val, wt, capacity - wt[n] , n-1), knapsack(val, wt, capacity, n-1));
            else
                return t[n][capacity] = knapsack(val, wt, capacity, n-1);
        }
        
    } 

    public static void main(String[] args) {
        int[] wt = {1, 2, 3, 4, 5, 6, 7};
        int[] val = {21, 13, 94, 32, 12, 54, 131};
        ZeroOne1 z = new ZeroOne1(wt.length, 20);
        System.out.println(z.knapsack(val, wt, 20, wt.length - 1)); 
    }
}


