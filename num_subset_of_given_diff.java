
// Using dp --> top down approach

public class num_subset_of_given_diff {
    static int[][] t;
    static void no_subset_sum(int[] arr, int n, int sum) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] > j)
                    t[i][j] = t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
            }
        }
    }
    public static void main(String[] args) {
        int[] arr ={1, 1, 2, 3};
        int sum = 0;
        int diff = 1;
        for(int i : arr)
            sum += i;
        t = new int[arr.length+1][sum+1];
        t[0][0] = 1;
        for(int i=1; i<=arr.length; i++)
            t[0][i] = 0;
        int sum1 = (diff+sum)/2;
        no_subset_sum(arr, arr.length, sum1);
        System.out.println(t[arr.length][sum1]);

    }
}


//s1 - s2 = diff
//s1 + s2 = sum
//
//hence,
//
//2s1 = diff + sum
