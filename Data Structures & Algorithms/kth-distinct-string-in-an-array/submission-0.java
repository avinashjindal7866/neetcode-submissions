class Solution {
    public String kthDistinct(String[] arr, int k) {
        int a = 0;
        String holdVal = "";
        for(int i=0;i<arr.length;i++){
            int count = 0;
            for(int j=0;j<arr.length;j++){
                if(arr[i].equals(arr[j])){
                    count++;
                }
            }
            // System.out.println(count + " " + arr[i]);
            if(count <= 1){
                a++;
                holdVal = arr[i];
                if(a == k){
                    return holdVal;
                }
            }
        }

        return "";
    }
}