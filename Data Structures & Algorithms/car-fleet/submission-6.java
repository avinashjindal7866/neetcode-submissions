class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // cars[i][0] = position
        // cars[i][1] = speed
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort by position (closest to target will be processed first)
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];

            // If current car catches the fleet ahead,
            // it becomes part of that fleet.
            if (!stack.isEmpty() && time <= stack.peek()) {
                continue;
            }

            // Otherwise, it forms a new fleet.
            stack.push(time);
        }

        return stack.size();
    }
}