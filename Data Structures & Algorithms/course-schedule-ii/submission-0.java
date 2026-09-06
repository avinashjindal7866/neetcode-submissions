class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        Queue<Integer> pq = new LinkedList<>();
        int[] in = new int[numCourses];
        int finish = 0;
        int[] output = new int[numCourses];
        // Check every component
        for (int v : map.keySet()) {
            for(int nbs : map.get(v)){
                in[nbs]++;
                // System.out.println(in[v]);
            }
        } 

        for(int i=0;i<in.length;i++){
            if(in[i] == 0){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            int r = pq.poll();
            System.out.println(r);
            output[numCourses - finish - 1] = r;
            finish++;
            if(map.containsKey(r)){
                for(int nbs : map.get(r)){
                    in[nbs]--;
                    if(in[nbs] == 0){
                        pq.add(nbs);
                    }
                }
            }

        }
        System.out.println(finish);
        if (finish != numCourses || finish == 0) {
            return new int[0];
        }

        return output;
    }
}
