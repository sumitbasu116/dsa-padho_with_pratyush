https://leetcode.com/problems/merge-intervals/description/

class Solution {
    public int[][] mergeInterval(int[][] a) {
        List<List<Integer>> res = new ArrayList<>();
		int n = a.length;
        if(n<=1) return a;
        
		Arrays.sort(a,(e1,e2)->Integer.compare(e1[0], e2[0]));
		
        int start1 = a[0][0];
        int end1 = a[0][1];
        for(int i=1;i<n;i++){
            int start2=a[i][0];
            int end2 = a[i][1];
            if(end1>=start2){
                end1=Math.max(end1,end2);
            	continue;
            }
            addPairIntoRes(res,start1,end1);
            start1=start2;
            end1=end2;
        }
        addPairIntoRes(res,start1,end1);
        if(res.size()==0) {
        	return a;
        }
        int arr[][] = new int[res.size()][2];
        int i=0;
        for(List<Integer> ele:res) {
        	arr[i][0]=ele.get(0);
        	arr[i][1]=ele.get(1);
        	i++;
        }
		return arr;
    }
    private void addPairIntoRes(List<List<Integer>> res,int a,int b){
        List<Integer> mergePair = new ArrayList<>();
        mergePair.add(a);
        mergePair.add(b);
        res.add(mergePair);
    }
}

