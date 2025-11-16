https://leetcode.com/problems/remove-duplicates-from-sorted-array/

class Solution {
    public int removeDuplicates(int[] a) {
        int low=0;
        int high = low+1;
        int n = a.length;
        int res=1;
        while(high<n){
            if(a[high]==a[high-1]){
                high++;
            }else{
                low++;
                a[low]=a[high];
                high++;
                res++;
            }
        }
        return res;
    }
}

