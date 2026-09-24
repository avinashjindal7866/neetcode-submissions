class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxPrice = 0;

        for(int i=1;i<prices.length;i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else{
                int data = prices[i] - minPrice;
                maxPrice = Math.max(maxPrice,data);
            }
        }

        return maxPrice;
    }
}
