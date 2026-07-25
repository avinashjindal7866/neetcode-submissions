class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stackList = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            int val = -1;
            while(!stackList.isEmpty() && nums2[i] > stackList.peek()){
                val = stackList.pop();
                System.out.println("pop " + val);
                map.put(val,nums2[i]);
            }
            
                stackList.push(nums2[i]);
                System.out.println("peek " + stackList.peek());
            
            
        }

        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                nums1[i] = map.get(nums1[i]);
            }else{
               nums1[i] = -1; 
            }

        }
        return nums1;
    }
}