class Solution {
    public String foreignDictionary(String[] words) {
      
        HashMap<Character,List<Character>> map = new HashMap<>();
        boolean[] present = new boolean[26];
        for(String word : words){
            for(char c : word.toCharArray()){
                present[c - 'a'] = true;
            }
        }

        int[] arr = new int[26];
        Arrays.fill(arr,0);

        int left = 0;
        int right = 1;

        while(right < words.length){
            int a = 0;
            while(a < words[left].length() && a < words[right].length()){
                char parentChar = words[left].charAt(a);
                char childChar = words[right].charAt(a);
                if(parentChar == childChar){
                    a++;
                    continue;
                }else{
                    map.computeIfAbsent(parentChar,k -> new ArrayList<>()).add(childChar);
                    arr[childChar - 'a']++;
                    break;
                }
            }

            if(a == Math.min(words[left].length(),words[right].length()) && words[left].length() > words[right].length()){
                return "";
            }
            left++;
            right++;
        }

        int total = 0;

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            if(present[i]){
                total++;
                if(arr[i] == 0){
                    queue.offer(i);
                }
            }
        }
        Stream.Builder<Character> builder = Stream.builder();
        int count = 0;
        while(!queue.isEmpty()){
            int val = queue.poll();
            char ch = (char)(val+'a');
            count++;
            builder.add(ch);
            if(map.containsKey(ch)){
                for(char c : map.get(ch)){
                    arr[c - 'a']--;
                    if(arr[c - 'a'] == 0){
                        queue.offer(c - 'a');
                    }
                }
            }
        }

        if(count != total){
            return "";
        }
        
        return builder.build().map(String::valueOf).collect(Collectors.joining());
    }
}
