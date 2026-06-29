class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        String backS = new String(sChar);
        String backT = new String(tChar);
        if(backS.equals(backT)){
            return true;
        }else{
            return false;
        }
    }
}
