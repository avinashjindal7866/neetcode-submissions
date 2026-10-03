class Solution {
    public int maxArea(int[] h) {
        int p1 = 0;
        int p2 = h.length - 1;
        int max = Integer.MIN_VALUE; 
        while(p1 < p2){

            int min = Math.min(h[p1],h[p2]);
            int count = p2 - p1;    
            max = Math.max(max,min*count);
            
            if(h[p1] < h[p2] ){
                p1++;
            }else{
                p2--;
            }
        }
        return max;
    }
}
