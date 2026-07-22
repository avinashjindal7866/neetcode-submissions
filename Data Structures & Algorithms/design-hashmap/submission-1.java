class MyHashMap {
    List<List<Integer>> map;
    public MyHashMap() {
        map = new ArrayList();
    }
    
    public void put(int key, int value) {
        for(int i=0;i<map.size();i++){
            if(map.get(i).get(0) == key){
                remove(key);
            }
        }
        map.add(List.of(key, value));
    }
    
    public int get(int key) {
        if(map.size() > 0){
            for(int i=0;i<map.size();i++){
                if(map.get(i).get(0) == key){
                    System.out.println(map.get(i).get(0) + " " + map.get(i).get(1));
                    return map.get(i).get(1);
                }
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = 0;
        if(map.size() > 0){
            for(int i=0;i<map.size();i++){
                if(map.get(i).get(0) == key){
                    index = i;
                }
            }
            map.remove(index);
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */