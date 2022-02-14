// Using Recursion

public class equal_sum_partition{

    boolean sub_sum(int[] arr, int n, int sum){
        if(sum == 0)
            return true;
        if(n == 0 && sum != 0)
            return false;
        if(arr[n-1] > sum)
            return sub_sum(arr, n-1, sum);
        return sub_sum(arr, n-1, sum-arr[n]) || sub_sum(arr, n-1, sum);
    }
   public static void main(String[] args) {
       int[] arr = {1, 5, 11, 5, 1, 1};
       int sum = 0;
       for(int i : arr)
        sum += i;
       if(sum % 2 != 0)
        System.out.println("No such partition can be created");
       else{
           equal_sum_partition e =new equal_sum_partition();
           if(e.sub_sum(arr, arr.length-1, sum/2))
            System.out.println("Partition can be created");
           else
            System.out.println("Partition cant be created"); 
       }     

   } 
}
