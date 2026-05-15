class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for(String s: strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedS = new String(charArray);
            if (res.containsKey(sortedS)) {
                res.get(sortedS).add(s);
            } else {
                res.put(sortedS, new ArrayList<>(List.of(s)));
            }
        }
        return new ArrayList<>(res.values());
    }
}
