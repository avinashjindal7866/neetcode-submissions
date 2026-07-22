class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Map<Integer, Integer> mapList = new HashMap<>();
        int count = 1;
        for(int i=1;i<=nums.length;i++){
            mapList.put(i, 0);
        }
        for(int s : nums){
            mapList.put(s, mapList.getOrDefault(s, 0) + 1);
            count++;
        }

        List<Integer> result = new ArrayList();
        for(int i=1;i<=nums.length;i++){
            // System.out.println(i + " " + mapList.get(i));
            if (mapList.get(i) == 0) {
                result.add(i);
            }
        }

        return result;
    }
}