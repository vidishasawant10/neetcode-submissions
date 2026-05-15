class Solution {
    public boolean isPalindrome(String s) {
                int start = 0, end = s.length() - 1;

        while(start < end){
            char l = s.charAt(start);
            char r = s.charAt(end);

            //If uppercase convert to lowercase
            if(l >= 'A' && l <= 'Z') l = (char)(l + 32);
            if(r >= 'A' && r <= 'Z') r = (char)(r + 32);

            //Skip non-Alphanumeric

            if(!((l>='a' && l <= 'z') || (l>='0' && l <= '9'))){
                start++;
                continue;
            }

            if(!((r >= 'a' && r <= 'z') || (r>='0' && r <= '9'))){
                end--;
                continue;
            }

            //compare both ends
            if(l != r) return false;

            start++;
            end--;

        }
        return true;
    }
}
