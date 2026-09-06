class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }

        System.out.println(map);

        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            map.get(a).add(b);
            map.get(b).add(a);
        }

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> pq = new LinkedList<>();
        int count = 0;
        for(int i : map.keySet()){
            if(visited.contains(i)){
                continue;
            }
            pq.add(i);
            count++;
            while(!pq.isEmpty()){
                int r = pq.poll();
                if(visited.contains(r)){
                   continue; 
                }
                visited.add(r);
                for(int nbs : map.get(r)){
                    if(!visited.contains(nbs)){
                        pq.add(nbs); 
                    }
                }
            }
        }

        return count;
    }
}
