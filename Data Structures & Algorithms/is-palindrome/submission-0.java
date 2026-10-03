class Solution {
    public boolean isPalindrome(String s) {
        char[] charArray = s.toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray();

        int left = 0;
        int right = charArray.length -1 ;

        while(left < right){
            if(charArray[left] != charArray[right]){
                System.out.println(charArray[left] + " " + charArray[right]);
                return false;
            }
            left++;
            right--;
        }
 
        return true;
    }
}
