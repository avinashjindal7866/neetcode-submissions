class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        if(s.length() == 1){
            return 1;
        }

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            if(set.contains(s.charAt(right))){
            
                maxLength = Math.max(maxLength, right - left);
                while(s.charAt(left) != s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
                
            }

            set.add(s.charAt(right));
            // System.out.println(right + " " + left);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
