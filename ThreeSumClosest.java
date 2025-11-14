
https://leetcode.com/problems/3sum-closest/
class Solution {
    public int threeSumClosest(int[] a, int target) {
        Arrays.sort(a);
        int n = a.length;
        int diff = Integer.MAX_VALUE;;
        int resSum=0;
        for(int i=0;i<n-2;i++){
            int left=i+1,right=n-1;
            while(left<right){
                int sum = a[i] + a[left] + a[right];
                int d = Math.abs(target-sum);
                if(d < diff){
                    diff = d;
                    resSum=sum;
                }
                if(sum==target){
                    return sum;
                } else if(sum>target){
                    right--;
                }else if(sum<target){
                    left++;
                }
            }
            
        }
        return resSum;
    }
}
