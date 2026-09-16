class Solution {
    public int coinChange(int[] coins, int amount) {
        HashMap<Integer,Integer> dp = new HashMap<>();
        int result = recursion(coins,0,amount,dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int recursion(int[] coins, int sum,int amount,HashMap<Integer,Integer> dp){
        if(sum > amount){
            return Integer.MAX_VALUE;
        }

        if(sum == amount){
            return 0;
        }

        if(dp.containsKey(sum)){
            return dp.get(sum);
        }

        int minCoin = Integer.MAX_VALUE;

        for(int coin : coins){
            if(sum > amount - coin){
                continue;
            }
            int result = recursion(coins,sum + coin,amount,dp);
            if(result != Integer.MAX_VALUE){
               minCoin = Math.min(result+1,minCoin); 
            }
        }

        dp.put(sum,minCoin);

        return minCoin;
    }
}
