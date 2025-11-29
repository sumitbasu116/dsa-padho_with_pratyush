https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/


class Solution {
    public int maxAbsoluteSum(int[] a) {
        int n = a.length;
        int maxBest = a[0];
        int minBest = a[0];
        int res = a[0];
        if(n==1){
            return Math.abs(res);
        }
        for(int i=1;i<n;i++){
            int v1 = maxBest + a[i];
            int v2 = a[i];
            int v3 = minBest + a[i];
            minBest = Math.min(v1,Math.min(v2,v3));
            maxBest = Math.max(v3,Math.max(v1,v2));
            res = Math.max(res,Math.max(Math.abs(minBest),maxBest));
        }
        return res;
    }
}