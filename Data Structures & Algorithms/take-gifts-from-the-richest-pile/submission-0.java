class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<gifts.length;i++){
            pq.add(gifts[i]);
        }

        for(int i=0;i<k;i++){
            int val = pq.poll();
            int square = (int) Math.sqrt(val);
            pq.add(square);
        }
        System.out.println(pq.size());
        int result = 0;
        while(pq.size() != 0){
            System.out.println(pq.peek());
            result = result + pq.poll();
        }

        return result;
    }
}