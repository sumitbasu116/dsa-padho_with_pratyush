

https://www.geeksforgeeks.org/problems/smallest-sum-contiguous-subarray/1

class Solution {
    static int smallestSumSubarray(int a[], int n) {
        int best = a[0];
        int ans = a[0];
        for(int i=1;i<n;i++){
            int v1 = best + a[i];
            int v2 = a[i];
            best = Math.min(v1,v2);
            ans = Math.min(ans,best);
        }
        return ans;
        
    }
}