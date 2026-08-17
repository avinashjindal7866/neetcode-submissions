class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int si = 0;
        int il = 0;
        int ei = si + k - 1;
        int minCount = Integer.MAX_VALUE;
        int count = 0;
        
        while(ei < blocks.length()){
            
            char a = blocks.charAt(il);    
            if(a == 'B'){
                il++;
            }else{
                count++;
                il++;
            }

            if( il > ei){
                si++;
                ei = si + k - 1;
                il = si;
                minCount = Math.min(minCount,count);
                count = 0;
            }
        } 

        return minCount;       
    }
}