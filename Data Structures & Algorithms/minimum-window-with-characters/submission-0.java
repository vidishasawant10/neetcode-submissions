class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";

        Map<Character,Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>(); //map for current window count
        //freqMap to count characters in T
        for( char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c,0) +1);
        }

        //have: how many characters currently meet the req count | need: how many distinct char we need to match
        int have = 0, need = countT.size(); 
        //res: to store the best window
        int[] res = {-1,-1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for(int r = 0; r< s.length(); r++){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0)+ 1);

            if(countT.containsKey(c) && window.get(c).equals(countT.get(c))){
                have++;
            }
            while(have == need){
                if((r-l + 1) < resLen){
                    resLen = r-l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if(countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)){
                    have--;
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "": s.substring(res[0], res[1] + 1);
    }
}
