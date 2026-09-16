class Solution {
    
    public int uniquePaths(int m, int n) {
        HashMap<String,Integer> dp = new HashMap<>();
        
        return recursion(m,n,0,0,dp);
    }
    
    public int recursion(int m,int n,int i,int j,HashMap<String,Integer> dp){
        if(i >= m || j >= n){
            return 0;
        }

        if(m-1 == i && n-1 == j){
            return 1;
        }

        if(dp.containsKey(i+","+j)){
            return dp.get(i+","+j);
        }
        
        int totalSets = 0;

        totalSets += recursion(m,n,i+1,j,dp);
        totalSets += recursion(m,n,i,j+1,dp);

        dp.put(i+","+j,totalSets);

        return totalSets;
    }
}
