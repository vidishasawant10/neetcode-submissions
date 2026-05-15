class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> result = new HashMap<>();

        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedS= new String (charArray);
            result.putIfAbsent(sortedS, new ArrayList<>());
            result.get(sortedS).add(str);
        }
        return new ArrayList<>(result.values());


    }
}
