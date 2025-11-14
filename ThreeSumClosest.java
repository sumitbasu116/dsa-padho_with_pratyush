
https://leetcode.com/problems/3sum-closest/
class Solution {
    public int threeSumClosest(int[] a, int target) {
        Arrays.sort(a);
        int n = a.length;
        int diff = 9999;
        int resSum=-1;
        for(int i=0;i<n-2;i++){
            int left=i+1,right=n-1;
            while(left<right){
                int sum = a[i] + a[left] + a[right];
                int d = Math.abs(sum-target);
                if(d < diff){
                    diff = d;
                    resSum=sum;
                }
                if(resSum==target){
                    return resSum;
                } else if(resSum>target){
                    right--;
                }else if(resSum<target){
                    left++;
                }
            }
            
        }
        return resSum;
    }
}
