class Solution {
    public boolean isValid(String s) {
        Stack<Character> open = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                open.push(ch);
            }else if(ch == ')'|| ch ==']' || ch=='}'){
                if(open.isEmpty()) return false;
                char top = open.peek();
                if((ch == ')' && top == '(') || 
                (ch == ']' && top == '[') ||
                (ch == '}' && top == '{')){
                    open.pop();
                }else{
                    return false;
                }
            }
        }
        return open.isEmpty();
        
    }
}
