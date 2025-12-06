https://leetcode.com/problems/find-pivot-index/


class Solution {
    public int pivotIndex(int[] a) {
        int n = a.length;
        if(n==1){ //When only one element in the array
            return 0;
        }
        int left=0;
        int right=0;
        int sum =0;
        for(int i=0;i<n;i++){
          sum = sum + a[i];
        }
        if(sum - a[0]==0) return 0; //When pivot index is in 0th index
        
        for(int i=1;i<n;i++){
          left = left + a[i-1];
          right = sum - (a[i]+left);
          if(left==right){
            return i;
          }
        }
        return -1;
    }
}