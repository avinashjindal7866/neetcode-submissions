class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }

        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            System.out.println(a + " " + b);
            if(a == b){

            }
            else{
                int c = a - b ;
                pq.add(c);
                System.out.println(pq);
            }
        }
        
        if(pq.size() == 1){
            return pq.peek();
        }else{
            return 0;
        }
    }
}
