class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue();
    int kl = 0;
    public KthLargest(int k, int[] nums) {
        kl = k;
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
    }
    
    public int add(int val) {
        
            pq.add(val);
        
        if(pq.size() > kl) {
				pq.poll();
				
			}
        return pq.peek();
    }
}
