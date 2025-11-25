https://leetcode.com/problems/max-consecutive-ones-iii/


class Solution {
    public int longestOnes(int[] a, int k) {
        int count = 0;
        int n = a.length;
        int low =0;
        int high =0;
        int d=0;
        int res = 0;
        while(high<n){
            if(a[high]==0){
                count++;
            }
            if(count<=k){
                int len = high-low+1;
                res = Math.max(len,res);
            }

            while(count>k){
                if(a[low]==0){
                    count--;
                }
                low++;
            }
            high++;
        }
        return res;
    }
}