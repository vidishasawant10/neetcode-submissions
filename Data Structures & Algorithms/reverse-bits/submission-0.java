class Solution {
    public int reverseBits(int n) {
        int res = 0; // to store rev number
        for(int i = 0; i < 32; i++){ //for each bit position i from 0 to 31
            int bit = (n >> i) & 1; // extract the ith bit from n
            res+= (bit<< (31-i)); // shift this bit to 31-i position & add to res
        }
        return res;
    }
}
