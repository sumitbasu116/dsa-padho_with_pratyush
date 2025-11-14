https://leetcode.com/problems/3sum/description/

class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        Arrays.sort(a);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<a.length-2;i++){
            if(i>0 && a[i]==a[i-1]){
                continue;
            }
            int target=-a[i];
            int left=i+1;int right=a.length-1;
            int sum= 0;
            while(left<right){
                sum= a[left] + a[right];
                if(sum==target){
                res.add(Arrays.asList(a[i], a[left], a[right]));
                left++;right--;
                while(left<a.length && a[left]==a[left-1]){
                    left++;
                } while(right>=0 && a[right]==a[right+1]){
                    right--;
                }
            } else if(sum > target){
                right--;
            }else if(sum<target){
                left++;
            }
        }
        }
        return res;
    }
}