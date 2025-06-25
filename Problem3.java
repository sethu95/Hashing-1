// Time Complexity: O(n * k) n is the length of the string, k is the length of each word
// Space Complexity: O(n), n is the number of words

// Approach: 2 Way HashMap, if theres a conflict in storing in the HashMap, then it not a word pattern

class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] sArray = s.split(" ");

        // words need to be of equal length with pattern's characters
        if (pattern.length() != sArray.length) return false;

        // 2 Way HashMap Approach, to store char to string mapping
        HashMap<Character, String> charMap = new HashMap<>();
        HashMap<String, Character> wordMap = new HashMap<>();

        for (int i=0; i<pattern.length(); i++) {
            char patternChar = pattern.charAt(i);
            String word = sArray[i];
            
            if (!charMap.containsKey(patternChar)) charMap.put(patternChar, word);
            else if (!charMap.get(patternChar).equals(word)) return false;

            if (!wordMap.containsKey(word)) wordMap.put(word, patternChar);
            else if (!wordMap.get(word).equals(patternChar)) return false;
        }

        return true;
    }
}
