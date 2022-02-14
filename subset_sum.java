//Using Recursion


public class subset_sum {

    boolean present(int sum, int[] arr, int n){

            if(sum == 0)
            return true;
            if(n == 0)
                return false;
            if(arr[n] > sum){
                return present(sum, arr, n-1);
            }
            return present(sum - arr[n], arr, n-1) || present(sum, arr, n-1);
        }
        
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int sum = 11;
        subset_sum s = new subset_sum();
        if(s.present(sum, arr, arr.length - 1))
            System.out.println("Subset present");
        else
            System.out.println("Not present");
    }
}
