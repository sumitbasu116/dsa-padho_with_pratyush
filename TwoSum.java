https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

class Solution {
    public int[] twoSum(int[] a, int target) {
        int n = a.length;
        int low =0,high=n-1;
        
        while(high<n){
            int sum = a[low]+a[high];
            if(sum == target){
                return new int[]{low+1,high+1};
            } else if(sum>target){
                high--;
            }else{
                low++;
            }
        }
        return new int[]{-1,-1};
    }
}