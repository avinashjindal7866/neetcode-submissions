class Solution {
    public boolean isSubsequence(String s, String t) {
        int[][] dp =  new int[s.length()][t.length()];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
       int val =  LCS(s,t,0,0,dp);
       if(val == s.length()){
        return true;
       }else{
        return false;
       }
    }

    public static int LCS(String s, String t, int i, int j, int[][] dp){
        if( i >= s.length() || j >= t.length() ){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = 0;
        if(s.charAt(i) == t.charAt(j)){
            ans = 1 + LCS(s,t,i+1,j+1,dp);
        }else{
            int f1 = LCS(s,t,i+1,j,dp);
            int f2 = LCS(s,t,i,j+1,dp);
            ans = Math.max(f1,f2);
        }

        return dp[i][j] = ans;
    }
}