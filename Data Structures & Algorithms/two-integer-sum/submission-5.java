class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> track = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int diff = target- nums[i];
            if(track.containsKey(diff)){
                return new int[] {track.get(diff), i};
            }
            track.put(nums[i], i);

        }
        return new int[]{};
    }
}
