class Solution {

    public String encode(List<String> strs) {
        String alpha = "";
        for(String s : strs){
            alpha = alpha + s.length() + "#" + s;
        }
        return alpha;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<String>();

        int i = 0;

        while(i<str.length()){
            int j = i;

            while(str.charAt(j) != '#'){
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            j++;

            String word = str.substring(j, j + length);
            result.add(word);

            i = j + length;
        }


        return result;
    }   
}
