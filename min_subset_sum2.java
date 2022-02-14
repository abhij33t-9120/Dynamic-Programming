
// Using dp --> top down approach

public class min_subset_sum2 {
    static boolean[][] t;
    static void subset_sum(int[] arr, int n, int sum){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1] > j)
                    t[i][j] = t[i-1][j];
                else
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
            }
        }
    }
    public static void main(String[] args) {
        int[] arr ={1, 6, 11, 5, 2};
        int sum = 0;
        for(int i : arr)
            sum += i;
        t = new boolean[arr.length+1][sum+1];
        for(int i=0; i<=arr.length; i++)
            t[i][0] = true;
        for(int i=1; i<=sum; i++)
            t[0][i] = false;
        subset_sum(arr, arr.length, sum);
        int min = Integer.MAX_VALUE;
        for(int i=0; i<=sum/2; i++)
            if(t[arr.length][i])
                min = Math.min(min, sum-2*i);
        System.out.println(min);

    }
}
