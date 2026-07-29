class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temp.length];

        for (int i = 0; i < temp.length; i++) {

            while (!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
                int leftSide = stack.pop();
                int findDistance  = i - leftSide;
                result[leftSide] = findDistance;
            }

            stack.push(i);
        }
        return result;
    }
}
