import java.util.NoSuchElementException;

/**
 * ZeroOne Knapsack using recursion
 */


public class ZeroOne {

    int knapsack(int[] val, int[] wt, int capacity, int n){
        if(val.length != wt.length)
            throw new NoSuchElementException("Invalid weights profit array");
        if(capacity == 0 || n == 0)
            return 0;
        if(wt[n] <= capacity)
            return Math.max(val[n] + knapsack(val, wt, capacity - wt[n] , n-1), knapsack(val, wt, capacity, n-1));
        else
            return knapsack(val, wt, capacity, n-1);
    } 

    public static void main(String[] args) {
        ZeroOne z = new ZeroOne();
        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 120};
        System.out.println(z.knapsack(val, wt, 50, wt.length - 1)); 
    }
}


