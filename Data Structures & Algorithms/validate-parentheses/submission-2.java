class Solution {
    public boolean isValid(String s) {
        HashMap <Character, Character> characters = new HashMap<>();
        characters.put(')','(');
        characters.put(']','[');
        characters.put('}','{');

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(characters.containsKey(c)){
                if(!stack.isEmpty() && stack.peek() == characters.get(c)){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
