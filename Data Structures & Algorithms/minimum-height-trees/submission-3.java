class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if(n == 1){
            return Arrays.asList(0);
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {

            int a = edge[0];
            int b = edge[1];

            map.get(a).add(b);
            map.get(b).add(a);
            indegree[a]++;
            indegree[b]++;
        }
        
        Queue<Integer> pq = new LinkedList<>();
        int remaning = n;

        for (int i = 0; i < n; i++) {
            if(indegree[i] == 1){
                pq.add(i);
            }
        }

        while(remaning > 2){
            int size = pq.size();
            remaning -= size;

            for (int i = 0; i < size; i++) {
                int r = pq.poll();
                for(int nbs : map.get(r)){
                    indegree[nbs]--;
                    if(indegree[nbs] == 1){
                        pq.add(nbs);
                    }
                }
            }
        }
        
        return new ArrayList<>(pq);
    }
}