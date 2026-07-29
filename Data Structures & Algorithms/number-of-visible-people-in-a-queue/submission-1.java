class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[heights.length];

        for (int i = heights.length-1; i >= 0; i--) {
            int putVal = 0;

            if(!stack.isEmpty()){
                while(!stack.isEmpty() && heights[i] > heights[stack.peek()]){
                    int popVal = stack.pop();
                    if (!stack.isEmpty()) {
    putVal++;
}
                }
                putVal++;
                result[i] = putVal;
            }
            stack.push(i);
        
        }

        return result;

    }
}