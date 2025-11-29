https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/description/


class Solution {
    public int maximumSum(int[] a) {
        int n = a.length;
        int noDelete=a[0];
        int oneDelete=0;
        int res = a[0];
        for(int i=1;i<n;i++){
            int v3 = noDelete;
            int v4 = oneDelete+a[i];
            oneDelete=Math.max(v3,v4);
            int v1 = noDelete + a[i];
            int v2 = a[i];
            noDelete = Math.max(v1,v2);
            res = Math.max(res,Math.max(oneDelete,noDelete));
        }
        return res;
    }
}