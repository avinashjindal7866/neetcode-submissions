class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // Build graph
        for (int i = 0; i < prerequisites.length; i++) {

            int f = prerequisites[i][0];
            int s = prerequisites[i][1];

            if (!map.containsKey(f)) {
                List<Integer> result = new ArrayList<>();
                result.add(s);
                map.put(f, result);
            } else {
                List<Integer> result = map.get(f);
                result.add(s);
            }
        }

        System.out.println(map);

        HashSet<Integer> visited = new HashSet<>();

        // Check every component
        for (int i = 0; i < numCourses; i++) {

            if (!visited.contains(i)) {

                if (!find(i, map, visited)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean find(
        int src,
        HashMap<Integer, List<Integer>> map,
        HashSet<Integer> visited
    ) {

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> currentPath = new HashSet<>();

        q.add(src);

        while (!q.isEmpty()) {

            int r = q.poll();
            currentPath.add(r);

            if (map.containsKey(r)) {

                for (int nbs : map.get(r)) {

                    // Cycle detected
                    if (currentPath.contains(nbs) && visited.contains(r)) {
                        return false;
                    }

                    if (!visited.contains(nbs)) {
                        visited.add(nbs);
                        q.add(nbs);
                    }
                }
            }
        }

        return true;
    }
}