import java.util.Arrays;

/**
 * ZeroOne2
 * Using Top Down Approach --> Ommiting the recursion completely
 */
public class ZeroOne2 {

    int[][] t;
    
    ZeroOne2(int n, int cap){
        t = new int[n+1][cap+1];
        for(int i = 0;i < n+1;i++){
            if(i == 0)
                Arrays.fill(t[i], 0);
            t[i][0] = 0;
        }
    }

    int topdown(int[] val, int[] wt, int capacity, int n){
        for(int i = 1;i <= n;i++)
            for(int j = 1;j <= capacity; j++)
            {
                if(wt[i-1] <= j)
                    t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
                else
                    t[i][j] = t[i-1][j];
            }
        return t[n][capacity];
    }


    public static void main(String[] args) {
        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 120};
        ZeroOne2 z = new ZeroOne2(wt.length, 50);
        System.out.println(z.topdown(val, wt, 50, wt.length));
    }
}