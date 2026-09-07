class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {

            int a = edge[0];
            int b = edge[1];

            map.get(a).add(b);
            map.get(b).add(a);
        }

        int minHeight = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>();

        for (int start = 0; start < n; start++) {

            Queue<Integer> pq = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();

            pq.add(start);
            visited.add(start);

            int height = -1;

            while (!pq.isEmpty()) {

                int size = pq.size();
                height++;

                for (int i = 0; i < size; i++) {

                    int r = pq.poll();

                    for (int nbs : map.get(r)) {

                        if (!visited.contains(nbs)) {
                            visited.add(nbs);
                            pq.add(nbs);
                        }
                    }
                }
            }

            if (height < minHeight) {

                minHeight = height;
                result.clear();
                result.add(start);

            } else if (height == minHeight) {

                result.add(start);
            }
        }

        return result;
    }
}