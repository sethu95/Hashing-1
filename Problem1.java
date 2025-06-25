// Time Complexity: O(n * k), n is the number of words, k is the length of each word
// Space Complexity: O(n * k), n is the number of words, k is the length of each word

// Approach: compute freqArr for each string in a charArr (we have finite characters ie 26)
// Store the charArray as key in HashMap, value is a list of string. Return all the values as a list in the end

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> tracker = new HashMap<>();

        for (String str : strs) {

            String freqStr = getFreqStr(str);

            if (tracker.containsKey(freqStr)) {

                tracker.get(freqStr).add(str);

            } else {

                List<String> list = new ArrayList<>();
                list.add(str);
                tracker.put(freqStr, list);

            }
        }

        return new ArrayList<>(tracker.values());
    }

    public String getFreqStr(String str) {
        char[] freqArr = new char[26]; // to store 26 lower case alphabets
        Arrays.fill(freqArr, '0');

        for (int i=0 ; i<str.length(); i++) {
            freqArr[str.charAt(i) - 'a']++;
        }

        return String.valueOf(freqArr);
    }
}
