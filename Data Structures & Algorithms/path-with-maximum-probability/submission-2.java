class Solution {

    class Pairs{
        int src;
        String path ;
        double cost;

        Pairs(int i,String j, double c){
            this.src = i;
            this.path = j;
            this.cost = c;
        }
        @Override
		public String toString() {
			return this.src+" "+this.path+" @ "+this.cost;
		}
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        if(edges.length <= 1)
        {
            return (double)0;
        }

        HashMap<Integer,HashMap<Integer,Double>> graph = new HashMap<>();
        for (int i = 0; i< n; i++) {
			graph.put(i, new HashMap<>());
		}
        for(int i = 0;i<edges.length;i++){
            int src = edges[i][0];
            int des = edges[i][1];
            double cost = succProb[i];
            graph.get(src).put(des,cost);
            graph.get(des).put(src,cost);
        }

        PriorityQueue<Pairs> pq = new PriorityQueue<>((a, b) -> Double.compare(b.cost, a.cost));
		HashSet<Integer> visited = new HashSet<>();
		pq.add(new Pairs(start_node, "" + start_node,1.0));
        while(!pq.isEmpty()){
            Pairs rp = pq.poll();
			if(visited.contains(rp.src)) {
				continue;
			}
			visited.add(rp.src);
            if(end_node == rp.src){
                return rp.cost;
            }
            for(int nbrs : graph.get(rp.src).keySet()){
                if(!visited.contains(nbrs)) {
                    double cost=graph.get(rp.src).get(nbrs);
					pq.add(new Pairs(nbrs, rp.path+nbrs, rp.cost*cost));
				}
            }
            // System.out.println(pq);
        }
        return (double)0;
    }
}