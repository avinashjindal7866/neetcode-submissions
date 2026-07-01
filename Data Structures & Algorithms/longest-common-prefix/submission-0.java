class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

    int index = 0;

        while (true) {
            // If the first string ends, return the prefix.
            if (index == strs[0].length()) {
                return strs[0].substring(0, index);
            }

            char currentChar = strs[0].charAt(index);

            // Compare this character with all other strings.
            for (int i = 1; i < strs.length; i++) {
                if (index == strs[i].length() || strs[i].charAt(index) != currentChar) {
                    return strs[0].substring(0, index);
                }
            }

            index++;
        }

    }
}