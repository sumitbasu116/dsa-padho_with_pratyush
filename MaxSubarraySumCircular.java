https://leetcode.com/problems/maximum-sum-circular-subarray/description



class Solution {
    public int maxSubarraySumCircular(int[] a) {
        int v1 = maxSum(a);
        int min = minSum(a);
        int n = a.length;
        int totalArraySum=a[0];
        for(int i=1;i<n;i++){
            totalArraySum = totalArraySum + a[i];
        }
        int v2 = totalArraySum - min; // circular sum
        // If all numbers are negative, v2 becomes 0 which is invalid.
        /* 
			For example, {-2,-3,-4} , min = (-2)+(-3)+(-4) = -9
        */
        if(v2==0) return v1;
        return Math.max(v1,v2);
    }
    private int maxSum(int[] a){
        int best = a[0];
        int res = a[0];
        int n = a.length;
        for(int i = 1;i<n;i++){
            int v1 = best + a[i];
            int v2 = a[i];
            best = Math.max(v1,v2);
            res = Math.max(res,best);
        }
        return res;
    }
    private int minSum(int[] a){
        int best = a[0];
        int res = a[0];
        int n = a.length;
        for(int i = 1;i<n;i++){
            int v1 = best + a[i];
            int v2 = a[i];
            best = Math.min(v1,v2);
            res = Math.min(res,best);
        }
        return res;
    }
}

