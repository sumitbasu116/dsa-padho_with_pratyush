https://leetcode.com/problems/subarray-sums-divisible-by-k/




class Solution {
    public int subarraysDivByK(int[] a, int k) {
        int n = a.length;
        Map<Integer,Integer> map = new HashMap<>();
        int sum =0;
        int res =0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum = sum + a[i];
            int rem = k==0?sum:sum%k;
            if(rem<0){
                rem = rem + k;
            }
            if(map.containsKey(rem)){
                res = res+map.get(rem);
            }
            map.put(rem,map.containsKey(rem)?map.get(rem)+1:1);
        }
        return res;
    }
}