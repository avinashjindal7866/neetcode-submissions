class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      
        // Step 1: frequency map
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap based on frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]   // compare frequency
        );

        // Step 3: push into heap
        for (int key : freq.keySet()) {
            pq.add(new int[]{key, freq.get(key)});

            // keep size = k
            if (pq.size() > k) {
                pq.poll(); // remove smallest frequency
            }
        }

        // Step 4: build answer
        int[] res = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll()[0];
        }

        return res;  
    }
}
