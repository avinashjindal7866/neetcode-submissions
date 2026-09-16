class Solution {
    public int change( int amount,int[] coins) {
        HashMap<String,Integer> dp = new HashMap<>();
        int result = recursion(coins,0,0,amount,dp);
        System.out.println(result);
        return result;
    }

    public int recursion(int[] coins,int i, int sum,int amount,HashMap<String,Integer> dp){
        if(sum > amount){
            return 0;
        }

        if(sum == amount){
            return 1;
        }

        if(dp.containsKey(i+","+sum)){
            // count = insideCount;
            return dp.get(i+","+sum);
        }

        int insideCount = 0;

        for(int j=i;j<coins.length;j++){
            if(sum > amount - coins[j]){
                continue;
            }
            insideCount += recursion(coins,j,sum + coins[j],amount,dp); 
        }

        dp.put(i+","+sum,insideCount);

        return insideCount;
    }
}
