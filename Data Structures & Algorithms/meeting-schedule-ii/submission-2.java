/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(i -> i.start));
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)->{
            int cum = Integer.compare(a.end, b.end);
            return cum;
        });

        if(intervals.size()>=1){
            pq.add(intervals.get(0));
        }

        

        for(int i=1;i<intervals.size();i++){
            System.out.println(pq.peek().end + " " + intervals.get(i).start);
            if(intervals.get(i).start >= pq.peek().end){
                pq.remove();
            }
            pq.add(intervals.get(i));
        }

        


        return pq.size();
    }
}
