class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        HashMap<Character, Integer> s1Count = new HashMap<>();
        
        for(int i = 0; i < s1.length(); i++){
            char c=s1.charAt(i);
            s1Count.put(c, s1Count.getOrDefault(c,0)+1);
        }
        int l =0;
        int count = s1.length();
        
        for (int r = 0; r < s2.length(); r++){
            char c2 = s2.charAt(r);
            
            if(s1Count.containsKey(c2)){
                if(s1Count.get(c2) > 0){
                    count--;
                }
                s1Count.put(c2, s1Count.get(c2)-1);
            }
            if(r - l +1 > s1.length()){
                char lc3 = s2.charAt(l);
                if(s1Count.containsKey(lc3)){
                   if(s1Count.get(lc3) >=0){
                       count++;
                   }
                   s1Count.put(lc3, s1Count.get(lc3)+1);
                }
                l++;
            }
            if(count==0) return true;
        }
        
        return false;
    }
}
