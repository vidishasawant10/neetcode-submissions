class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> [] bucket = new List[nums.length+1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // create a frequency map by traversing through each element and 
        //then adding it to the map with increment its frequency where needed
        for(int n : nums){
            frequencyMap.put (n, frequencyMap.getOrDefault(n, 0)+1);
        }
        // traverse through the frequency only and 
        //use bucket sort algorithm to store the elements with the same frequency n the same bucket
        for(int key: frequencyMap.keySet()){
            int frequency = frequencyMap.get(key);
            if(bucket[frequency] == null){
                //create a new arraylist if the bucket frequency is empty
                bucket[frequency] = new ArrayList<>();
            }
            //if already a bucket(arraylist) is present at the particular frequency just add the new element with the same frequency
            bucket[frequency].add(key);
        }

        //now we will traverse through the bucket from last and then add the most frequent k elements into the res array
        int[] res = new int[k];
        int counter = 0;

        for(int pos = bucket.length - 1; pos >= 0 && counter < k; pos--){
            if(bucket[pos] != null){
                for(Integer integer : bucket[pos]){
                    res[counter++] = integer;
                }
            }
        }
        return res;
        
    }
}
