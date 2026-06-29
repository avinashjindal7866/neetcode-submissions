class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        for(int i=0;i<arr.length;i++){
            int maxNumber = findMaxFromIndex(arr,i+1);
            ans[i] = maxNumber;
        }
        return ans;
    }

    public int findMaxFromIndex(int[] arr, int start) {

        if(start >= arr.length){
            return -1;
        }

        int max = arr[start];  // start from given index

        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }
}