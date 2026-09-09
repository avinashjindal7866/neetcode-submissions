class Solution {
    HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
    List<String> result = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        

        for(List<String> t : tickets){
            String from = t.get(0);
            String to = t.get(1);

            graph.computeIfAbsent(from,k -> new PriorityQueue<>()).add(to);
        }

        dsf("JFK");

        Collections.reverse(result);

        return result;
    }

    public void dsf(String start){
        PriorityQueue<String> val = graph.get(start);

        while(val != null && !val.isEmpty()){
            String d = val.poll();

            dsf(d);
        }

        result.add(start);
    }
}
