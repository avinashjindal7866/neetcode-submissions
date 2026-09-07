class Solution {

    public int[] findRedundantConnection(int[][] edges) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 1; i <= edges.length; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {

            int a = edge[0];
            int b = edge[1];

            // Already connected?
            if (isConnected(a, b, map)) {
                return edge;
            }

            // No cycle yet, so add the edge
            map.get(a).add(b);
            map.get(b).add(a);
        }

        return new int[0];
    }

    private boolean isConnected(
            int start,
            int target,
            HashMap<Integer, List<Integer>> map) {

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {

            int node = q.poll();

            if (node == target) {
                return true;
            }

            for (int nbs : map.get(node)) {

                if (!visited.contains(nbs)) {
                    visited.add(nbs);
                    q.add(nbs);
                }
            }
        }

        return false;
    }
}