https://leetcode.com/problems/continuous-subarray-sum/


/* FORMULA or FUNCTION: If prefix sum of a subarray modulas k = prefix sum of another subarray modulas k.
Then there exists an subarray whose sum is multiple of k. 
So, save each index prefix sum % k into a HashMap. If any other index, (prefix sum % k) exists in the HashMap already then we found the asnswer. 
    MATH:
        x % k = r
        x = k * m + r
        prefixSum[i] % k = r
        prefixSum[j] % k = r   when, (j > i)
        
        prefixSum[i] = k * x + r
        prefixSum[j] = k * y + r
        subarraySum = prefixSum[j] - prefixSum[i]
                    = (k * y + r) - (k * x + r)
                    = k * (y - x)
        Hence,
        k * (y - x) is exactly divisible by k.
        So: subarraySum % k == 0


*/


class Solution {
    public boolean checkSubarraySum(int[] a, int k) {
        int n = a.length;
        int sum = 0;
        Map<Integer,Integer> remMap = new HashMap<>();
        remMap.put(0,-1);
        for(int i=0;i<n;i++){
            sum = sum + a[i];
            int rem = k==0?sum:sum%k;
            if(remMap.containsKey(rem)){
                if(i-remMap.get(rem)>=2){
                    return true;
                }
            }else{
                remMap.put(rem,i);
            }
        }
        return false;
    }
}