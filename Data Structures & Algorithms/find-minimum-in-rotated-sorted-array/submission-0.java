class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];

        int left = 0, right = nums.length - 1;
        //if the last element is greater than the first element then there is no rotation.

        if(nums[right] > nums[0]){
            return nums[0];
        }

        while(right >= left){
            int mid = left +(right-left) / 2;
            //if mid ele is greater than the next element then the mid+1 is the smallest number

            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }

            //if the mid ele is lesser than the previous ele then the mid ele is the smallest

            if(nums[mid-1] > nums[mid]){
                return nums[mid];
            }

            //if the mid ele val is greater than the 0th ele means the small val is still somehwere to the right and we are still dealing with the ele greater than nums[0]

            if(nums[mid] > nums[0]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return Integer.MAX_VALUE;
    }
}
