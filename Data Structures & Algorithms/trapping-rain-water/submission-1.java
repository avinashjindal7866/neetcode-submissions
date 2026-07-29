class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {

                // Bottom of the container
                int bottomIndex = stack.pop();

                // No left boundary
                if (stack.isEmpty()) {
                    break;
                }

                // Left boundary
                int leftIndex = stack.peek();

                // Width between left and right boundaries
                int width = i - leftIndex - 1;

                // Height of trapped water
                int waterHeight = Math.min(height[leftIndex], height[i]) - height[bottomIndex];

                // Add trapped water
                result += width * waterHeight;
            }

            stack.push(i);
        }

        return result;
    }
}
