class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int r = nums2.length -1;
        int greater = 0;
        for(int i=0;i<nums1.length;i++){
            // for(int j=0;j<nums2.length;j++){
            //     if(nums1[i] == nums2[j]){
                    // if(j == (nums2.length -1)){
                    //     nums1[i] = -1;
                    // }else{
                    //     if(nums2[j+1]>nums1[i]){
                    //         System.out.println(nums2[j+1]);
                    //         nums1[i] = nums2[j+1];
                    //     }else{
                    //         nums1[i] = -1;
                    //     }
                    //     break;
                    // }
            //     }
            // }
            while(nums1[i] != nums2[r]){
                if(nums2[r] > nums1[i]){
                    greater = nums2[r];
                }
                r--;
                // System.out.println(greater+" "+r+ " "+ nums1[i]);
            }
            if(greater == 0){
                nums1[i] = -1;
                r = nums2.length -1;
            }else{
                nums1[i] = greater;
                greater = 0;
                r = nums2.length -1;
            }
        }
        return nums1;
    }
}