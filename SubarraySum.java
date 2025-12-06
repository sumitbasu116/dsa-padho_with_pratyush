https://leetcode.com/problems/subarray-sum-equals-k/description/

/*
    FORMULA or FUNCTION: If substraction two prefix sum = k then there exist a subarray whose sum = k
    So, save each index prefix sum into a HashMap. If any other index, (prefix sum - k) exists in the HashMap already then we found one asnswer.
*/

class Solution {
    public int subarraySum(int[] a, int k) {
        int n = a.length;
        int sum = 0;
        int res = 0;
        Map<Integer,Integer> counter = new HashMap<>();
        counter.put(0,1);
        for(int i=0;i<n;i++){
            sum = sum + a[i];
            if(counter.containsKey(sum-k)){
                res=res + counter.get(sum-k);
            }
            counter.put(sum,counter.containsKey(sum)?counter.get(sum)+1:1);
        }
        return res;
    }
}