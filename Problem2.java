// Time Complexity: O(n) n is the length of the string
// Space Complexity: O(1) considering, we only have a finite set of characters

// Approach: 2 Way HashMap, if theres a conflict in storing in the HashMap, they are not Isomorphic

class Solution {
    public boolean isIsomorphic(String s, String t) {

        // Isomorphic strings need to be of equal length
        if (s.length() != t.length()) return false;

        // 2 Way HashMap Approach, to store char to char mapping
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            if (!sMap.containsKey(sChar)) sMap.put(sChar, tChar);
            else if (sMap.get(sChar) != tChar) return false;

            if (!tMap.containsKey(tChar)) tMap.put(tChar, sChar);
            else if (tMap.get(tChar) != sChar) return false;
        }

        return true;
    }
}
