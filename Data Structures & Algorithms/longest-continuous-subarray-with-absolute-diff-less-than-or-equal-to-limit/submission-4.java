public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> b[0] - a[0]
        );
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );
        int j = 0, res = 0;
        for (int i = 0; i < nums.length; ++i) {
            int v = nums[i];
            maxHeap.offer(new int[]{v, i});
            minHeap.offer(new int[]{v, i});

            while (maxHeap.peek()[0] - minHeap.peek()[0] > limit) {
                ++j;
                while (!maxHeap.isEmpty() && maxHeap.peek()[1] < j) {
                    maxHeap.poll();
                }
                while (!minHeap.isEmpty() && minHeap.peek()[1] < j) {
                    minHeap.poll();
                }
            }

            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}