class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        // Max Heap
        // [value, distance]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {

            // Larger distance comes first
            if (a[1] != b[1]) {
                return Integer.compare(b[1], a[1]);
            }

            // If distance is same, larger number comes first
            return Integer.compare(b[0], a[0]);
        });

        for (int i = 0; i < nums.length; i++) {

            int distance = Math.abs(nums[i] - x);

            // Add value and its distance
            pq.add(new int[]{nums[i], distance});

            // Keep only k elements
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll()[0]);
        }

        Collections.sort(result);

        return result;
    }
}