class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        for (int i=heights.length-1; i>=0; i--) {

            if(!stack.isEmpty() && heights[stack.peek()] >= heights[i] ) {
                continue;
            }
            System.out.println(i);
            stack.push(i);
        }

        int[] result = new int[stack.size()];
        int count = 0;
        while(!stack.isEmpty()){
            int popVal = stack.pop();
            result[count] = popVal;
            count++;
        }

        return result;
    }
}