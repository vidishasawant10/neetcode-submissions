class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //assume nums  is not null
        int n = nums.length;
        if(n == 0 || k == 0) return new int[0];

        int[] result = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>(); // stores indices
        int l = 0, r= 0;

        while(r < n){
            while(!q.isEmpty() && nums[q.getLast()] < nums[r]){
                q.removeLast();
            }
            q.addLast(r);

            if(l >q.getFirst()){
                q.removeFirst();
            }

            if((r+1) >= k){
                result[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return result;
    }
}