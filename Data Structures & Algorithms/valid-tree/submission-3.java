class Solution {
    public boolean validTree(int n, int[][] edges) {
         if (edges.length == 0) {
            return true;
        }


        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);    
        }
        System.out.println(graph);
        return bfs(graph,n);
    }

    public boolean bfs(Map<Integer, List<Integer>> graph,int n){
        Queue<int[]> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        q.add(new int[]{0, -1});

        while (!q.isEmpty()) {

            int[] current = q.poll();

            int r = current[0];
            int parent = current[1];

            if (visited.contains(r)) {
                return false;
            }

            visited.add(r);

            for (int nbs : graph.get(r)) {

                if (nbs == parent) {
                    continue;
                }

                q.add(new int[]{nbs, r});
            }
        }

        return visited.size() == n;
    }
}
