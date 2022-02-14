import java.util.Arrays;

// Multiple occurence of same item

public class unbounded_ks {
    
    static int[][] t;

    static int knapsack(int[] val, int[] wt, int W, int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=W; j++){
                if(wt[i-1] > j)
                    t[i][j] = t[i-1][j];
                else{
                    t[i][j] = Math.max(val[i-1] + t[i][j-wt[i-1]], t[i-1][j]);
                }
            }
        }
        return t[n][W];
    }
    public static void main(String[] args) {
        int[] weights = {2, 5, 3, 8};
        int[] value = {4, 5, 7, 9};
        int W = 25;
        t = new int[weights.length+1][W+1];
        for(int i=0; i<=weights.length; i++){
            if(i == 0)
                Arrays.fill(t[0], 0);
            t[i][0] = 0;
        }
        System.out.println(knapsack(value, weights, W, value.length));     
    }
}
