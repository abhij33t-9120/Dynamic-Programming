public class target_sum {
    static int[][] t;
    public static void calculate(int[] arr, int sum, int n){
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
        int[] arr = {1, 1, 2, 3};
        int given_sum = 1;
        int sum = 0;
        for(int i : arr)
            sum += i;
        t = new int[arr.length+1][sum+1];
        t[0][0] = 1;
        for(int i=1; i<=arr.length; i++)
            t[0][i] = 0;
        int sum1 = (given_sum+sum)/2;
        calculate(arr, sum1, arr.length);
        System.out.println(t[arr.length][sum1]);
    }
}
