https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1

class Solution {
    public int longestKSubstr(String s, int k) {
        
        char[] a = s.toCharArray();
        int n = a.length;
        int res=-1;
        Map<Character,Integer> helpMap=new HashMap<>();
        int low =0;
        int high=0;
        while(high<n){
            helpMap.put(a[high],helpMap.containsKey(a[high])?
            helpMap.get(a[high])+1:1);
            while(helpMap.size()>k){
                helpMap.put(a[low],helpMap.get(a[low])-1);
                if(helpMap.get(a[low])==0){
                    helpMap.remove(a[low]);
                }
                low++;
            }
            if(k==helpMap.size()){
                res=Math.max(res, high - low + 1);
            }
            high++;
        }
        return res;
        
    }
}