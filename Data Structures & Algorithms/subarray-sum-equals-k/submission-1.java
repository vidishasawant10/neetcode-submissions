//Time and space O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        //map from prefix sum value to how many times we've see it
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);//empty prefix (sum= 0) seen once

        for(int num : nums){
            prefixSum += num;
            if(prefixCount.containsKey(prefixSum - k)){
                count += prefixCount.get(prefixSum - k); 
            }
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) +1);
        }
        return count;
    }
}