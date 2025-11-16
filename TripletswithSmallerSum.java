https://www.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1

class Solution {
    long countTriplets(int n, int target, long a[]) {
        long ans=0;
        Arrays.sort(a);
        for(int i=0;i<n-2;i++){
            int left = i+1;
            int right = n-1;
            while(left<right){
                long sum = a[i] + a[left] + a[right];
                if(sum >= target){
                    right--;
                }else{
                   ans = ans+(right-left);
                   left++;
                }
            }
        }
        return ans;
    }
}
