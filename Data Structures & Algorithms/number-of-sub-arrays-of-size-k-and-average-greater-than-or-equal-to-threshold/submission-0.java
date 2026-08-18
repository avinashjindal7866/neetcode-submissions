class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int si = 0;
        int ei = si+k-1;
        int ith = si;
        int product = 0;
        int count = 0;
        while(ei < arr.length){
            
            product = product + arr[ith];
            ith++;
            
            if(ith > ei){
                si++;
                ith = si;
                ei = si+k-1;
                System.out.print(product + " ");
                product = product / k;
                System.out.println(product);
                if(product >= threshold){
                    count++;
                }
                product = 0;
            }
        }
        return count;
    }
}