class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        recursion(s, 0, new ArrayList<>(), result);

        return result;
    }

    public void recursion(
            String s,
            int start,
            List<String> current,
            List<List<String>> result) {

        // We have partitioned the entire string
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every possible substring starting from start
        for (int end = start; end < s.length(); end++) {

            String part = s.substring(start, end + 1);

            // Only choose it if it is a palindrome
            if (isPalindrome(part)) {

                current.add(part);

                recursion(s, end + 1, current, result);

                // Backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
