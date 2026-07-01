class Solution {
    public int countSeniors(String[] details) {
        int ageCount = 0;
        for(String val : details){
            String age = val.substring(11,13);
            int result = Integer.parseInt(age);
            if(result > 60){
                ageCount++;
            }
        }
        return ageCount;
    }
}