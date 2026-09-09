class Solution {

    class Pairs{
        int from;
        int to;
        int cost;

        Pairs(int i,int j, int c){
            this.from = i;
            this.to = j;
            this.cost = c;
        }
        
    }


    public int minCostConnectPoints(int[][] points) {

        if(points.length == 1){
            return 0;
        }

        HashMap<Integer,List<Pairs>> graph = new HashMap<>();

        for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++){
                if(i != j){
                    int v = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);                    
                    if (!graph.containsKey(i)) {
    graph.put(i, new ArrayList<>());
}
graph.get(i).add( new Pairs(i, j, v));
                }
            }
        }
        int totalCost = 0;
        PriorityQueue<Pairs> pq = new PriorityQueue<>((a,b)->a.cost - b.cost);
        HashSet<Integer> visited = new HashSet<>();
        pq.add(new Pairs(0, 0, 0));
        while(!pq.isEmpty()){
            Pairs r = pq.poll();
            if(visited.contains(r.to)){
                continue;
            }
            visited.add(r.to);
            
            totalCost += r.cost; 
            for(Pairs nbs : graph.get(r.to)){
                if(!visited.contains(nbs.to)){
                    pq.add(nbs);
                }
            }
        }
        return totalCost;
    }
}
