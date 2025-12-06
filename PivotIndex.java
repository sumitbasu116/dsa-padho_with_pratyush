https://leetcode.com/problems/find-pivot-index/description/


class Solution {
    public int pivotIndex(int[] a) {
        int n = a.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        if(n==1){
            return 0;
        }
        prefix[0]=0;
        for(int i=1;i<n;i++){
          prefix[i]=  prefix[i-1] + a[i-1];
        }
        suffix[n-1]=0;
        for(int i=n-2;i>=0;i--){
        	suffix[i]=  suffix[i+1] + a[i+1];
        }

        for(int i=0;i<n;i++){
            if(prefix[i]==suffix[i]){
                return i;
            }
        }
        return -1;
    }
}