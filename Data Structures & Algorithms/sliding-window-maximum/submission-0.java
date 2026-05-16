class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k +1];

        for(int l = 0; l < nums.length-k+1; l++){
            int r = l + k - 1;
            int maxVal = nums[l];
            for(int i = l; i <= r; i++){
                if(nums[i] > maxVal){
                    maxVal = nums[i];
                }
            }
            result[l] = maxVal;
        }
        return result;
    }
}