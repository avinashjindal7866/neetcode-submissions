class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int p1 = 0;
        int p2 = 1;
        for(int i=0;i<numRows;i++){
            List<Integer> a = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j==0 || j==i){
                    a.add(1);
                }else{
                    List<Integer> getVal= result.get(i-1);
                    if(p2 <= getVal.size()){
                        int sum = getVal.get(p1) + getVal.get(p2);
                        a.add(sum);
                        p1++;
                        p2++;
                    }else{
                       a.add(0); 
                    }
                }
            }
            result.add(a);
            p1 = 0;
            p2 = 1;
        }
        return result;
    }
}