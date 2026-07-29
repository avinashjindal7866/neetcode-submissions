class StockSpanner {
    Stack<Integer> stack;
    Map<Integer,Integer> mapSpan = new HashMap<>();
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        if(stack.isEmpty()){
            stack.push(price);
            mapSpan.put(price, 1);
            return 1;
        }else{
            int result = 1;
            while(!stack.isEmpty() && price >= stack.peek()){
                int popVal = stack.pop();
                int getVal = mapSpan.get(popVal);
                result = result + getVal;
            }
            stack.push(price);
            mapSpan.put(price,result);
            return result;
        } 
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */