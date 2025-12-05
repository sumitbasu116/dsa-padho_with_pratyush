https://leetcode.com/problems/maximum-subarray/description/


class Solution {
    public int maxSubArray(int[] a) {
        int best = a[0];// 0th index me ek hi subarray possible hai and wahi best hai
        int ans = a[0];// 0th index me ek hi subarray possible hai and wahi ans hai
        int n = a.length;
        for(int i=1;i<n;i++){
            int v1 = best + a[i];
            int v2 = a[i];
            best = Math.max(v1,v2);
            ans = Math.max(ans,best);
        }
        return ans;
    }
}