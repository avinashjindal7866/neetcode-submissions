class Solution {
    public List<String> stringMatching(String[] words) {
       

        LinkedHashSet<String> result = new LinkedHashSet<>();

        for( String i : words){
            for (String j : words){
                if(i != j){
                    if(i.contains(j)){
                    if(i.length() >= j.length()){
                        result.add(j);
                    }else{
                        result.add(i);
                    }
                    }
                }
            }
        }

       return new ArrayList<>(result);
    }
}