// Using Recursion 

public class min_subset_sum {

    static int subset_sum(int[] arr,int calculated,int range,int n){
        if(n == 0)
            return Math.abs(range - 2*calculated);
        return Math.min(subset_sum(arr, calculated+arr[n], range, n-1), subset_sum(arr, calculated, range, n-1));
    }
    public static void main(String[] args) {
        int[] arr ={1, 6, 11, 5, 2};
        int sum = 0;
        for(int i: arr)
            sum += i;
        System.out.println(subset_sum(arr,0, sum, arr.length-1)); 
    }
}


