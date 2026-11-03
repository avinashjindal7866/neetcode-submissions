class Solution {
    
    public String longestPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        String result = "";
        for(int i=0;i<s.length();i++){
            for(int j=right;j>=i;j--){
                boolean val = palidrom(i,j,s);
                if(val){
                    String temp = s.substring(i,j+1);
                    if( temp.length() > result.length()){
                        result = temp;
                    }
                }
            }
        }

        return result;
    }

    public boolean palidrom(int left,int right,String s){

        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

}
