https://leetcode.com/problems/contiguous-array/description/



class Solution {
    public int findMaxLength(int[] a) {
        int n = a.length;
        Map<Integer,Integer> map = new HashMap<>();
        int countZero = 0;
        int countOne = 0;
        int res = 0;
        for(int i=0;i<n;i++){
            if(a[i]==0){
                countZero++;
            }else{
                countOne++;
            }
            int diff = countZero-countOne;
            if(diff==0){
                res = Math.max(res,i+1);
            }
            else if(!map.containsKey(diff)){
                map.put(diff,i);
            }
            else{
                int v1 = i - map.get(diff);
                res = Math.max(res,v1);
            }
        }
        return res;
    }
}