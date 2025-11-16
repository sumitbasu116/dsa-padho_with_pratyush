https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

class Solution {
    public int maxSubarraySum(int[] a, int k) {
        
        int low=0;
        int high = k-1;
        int n = a.length;
        int sum = 0;
        int res=Integer.MIN_VALUE;
        for(int i=low;i<=high;i++){
            sum = sum + a[i];
        }
        while(high<n){
            if(sum>res){
                res=sum;
            }
            low++;
            high++;
            sum = sum - a[low-1];
            if(high==n){
                break;
            }
            sum = sum + a[high];
        }
        return res;
    }
}