class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            int cum = Integer.compare(a[0], b[0]);
            if(cum == 0){
                cum = Integer.compare(a[1], b[1]);
            }
            return cum;
        });

        PriorityQueue<Integer> meetingRoom = new PriorityQueue<>();
        int[] roomCount = new int[n];
        for(int i=0;i<n;i++){
            meetingRoom.add(i);
        }
        
        for(int i=0;i<meetings.length;i++){
            int start = meetings[i][0];
            int end = meetings[i][1];

            // Release all rooms that have become free
            while (!pq.isEmpty() && pq.peek()[0] <= start) {
                int[] room = pq.poll();

                meetingRoom.add(room[1]);
                roomCount[room[1]]++;
            }

            if(!meetingRoom.isEmpty()){
                int roomNumber = meetingRoom.poll();
                int[] adding = {end,roomNumber};
                roomCount[roomNumber]++;
                pq.add(adding);
            }else{
                int[] getMeeting = pq.poll();
                int exitingEnd = getMeeting[0];
                int roomId = getMeeting[1];

                int distance = end - start;
                int[] adding = {exitingEnd+distance,roomId};
                pq.add(adding);
                roomCount[roomId]++;
            }
        }


        int answer = 0;

        for(int i=1;i<n;i++){
            if(roomCount[i] > roomCount[answer]){
               answer = i;
            }
        }

        return answer;
    }
}