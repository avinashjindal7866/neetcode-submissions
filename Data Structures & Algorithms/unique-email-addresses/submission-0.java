class Solution {
    public int numUniqueEmails(String[] emails) {
        List<String> finalString = new ArrayList();
        for(String s:emails){
            String[] parts = s.split("@");
            if(parts[0].contains("+")){
                String[] words = parts[0].split("\\+");
                if(words[0].contains(".")){
                    // System.out.println(words[0] + "---");
                    String[] wordss = words[0].split("\\.");
                    String combinedString = String.join("", wordss);
                    finalString.add(combinedString+"@"+parts[1]);
                }else{
                    finalString.add(words[0]+"@"+parts[1]);
                }
            }else{
                if(parts[0].contains(".")){
                    // System.out.println(words[0] + "---");
                    String[] wordss = parts[0].split("\\.");
                    String combinedString = String.join("", wordss);
                    finalString.add(combinedString+"@"+parts[1]);
                }else{
                    finalString.add(parts[0]+"@"+parts[1]);
                }
            }
            
        }
        Set<String> set = new HashSet<>(finalString);
        // for(String s:finalString){
        //     System.out.println(s);
        // }
        return set.size();
    }
}