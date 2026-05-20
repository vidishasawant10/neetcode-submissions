class Solution {
    public int lengthOfLastWord(String s) {
        String Strim = s.trim();
        String[] words = Strim.split(" ");
        int lastWord = words[words.length - 1].length();
        return lastWord;
        
    }
}