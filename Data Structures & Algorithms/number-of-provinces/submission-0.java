class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int i = 1;i<=isConnected.length; i++){
            map.put(i,new ArrayList<>());
        }

        for(int i = 0;i<isConnected.length; i++){
            for(int j = 0;j<isConnected.length; j++){
                if(i != j && isConnected[i][j] == 1){
                    map.get(i+1).add(j+1);
                }
            }
        }

        System.out.println(map);

        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> pq = new LinkedList<>();
        int count = 0 ;

        for(int i = 1;i<=isConnected.length; i++){
            
            if(visited.contains(i)){
                continue;
            }

            pq.add(i);
            count++;
            while(!pq.isEmpty()){
                int r = pq.poll();

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