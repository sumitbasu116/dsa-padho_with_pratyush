https://leetcode.com/problems/maximum-product-subarray/description/


class Solution {
    public int maxProduct(int[] a) {
        int maxBest = a[0];
        int minBest=a[0];
        int ans = a[0];
        int n = a.length;
        for(int i=1;i<n;i++){
            int v1 = maxBest * a[i];
            int v2 = a[i];
            int v3=minBest*a[i];
            maxBest = Math.max(v3,Math.max(v1,v2));
            minBest=Math.min(v1,Math.min(v2,v3));
            ans=Math.max(ans,Math.max(maxBest,minBest));
        }
        return ans;
    }
}