class Solution {
    public int numDecodings(String s) {
        Map<Integer, Character> map = new HashMap<>();
        Map<Integer, Integer> dp = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            map.put(i, (char) ('A' + i - 1));
        }

        

        return recursion(map,s,0,dp);
    }

    public static int recursion(Map<Integer, Character> map,String s,int i,Map<Integer, Integer> dp){
        if (s.length() == i) {
        return 1;
    }

    if(dp.containsKey(i)){
        return dp.get(i);
    }

    int one = 0;
    int two = 0;

    if (map.containsKey(Integer.parseInt(s.substring(i, i + 1)))) {
        one = recursion(map, s, i + 1,dp);
    }

    if (i + 2 <= s.length() && s.charAt(i) != '0'
            && map.containsKey(Integer.parseInt(s.substring(i, i + 2)))) {
        two = recursion(map, s, i + 2,dp);
    }

    dp.put(i,one + two);

    return dp.get(i);
    }
}
