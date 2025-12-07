https://www.geeksforgeeks.org/problems/overlapping-intervals--174556/1


class Solution {
    static boolean isIntersect(int[][] a) {
        
        int n = a.length;
        if(n<=1) return false;// handle the edge case
        
        Arrays.sort(a,(e1,e2)->Integer.compare(e1[0],e2[0]));// Sort intervals based on start value
        
        int start1 = a[0][0];
        int end1 = a[0][1];
        for(int i=1;i<n;i++){
            int start2=a[i][0];
            int end2 = a[i][1];
            if(end1>=start2){
                return true;
            }
            start1=start2;
            end1=end2;
        }
        return false;
    }
}

