class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<trust.length;i++){
            int[] getVal = trust[i];
            if(!map.containsKey(getVal[0])){
                map.put(getVal[0],0);
            }else{
                map.put(getVal[0],map.get(getVal[0])-1); 
            }
            if(!map.containsKey(getVal[1])){
                map.put(getVal[1],1);
            }else{
                map.put(getVal[1],map.get(getVal[1])+1); 
            }
        }

        
        
            for(int v: map.keySet()){
                if(map.get(v) == (n-1)){
                    return v;
                }
            }
        


        return -1;

    }
}