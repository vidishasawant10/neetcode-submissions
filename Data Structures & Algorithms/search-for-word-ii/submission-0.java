class TrieNode{
    public Map<Character, TrieNode> children;
    public boolean isEnd; // if this word is ending
    public TrieNode() {
        this.children = new HashMap<Character, TrieNode>();
        this.isEnd = false;
    }
}
class Solution {
    private ArrayList<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        //Constructing the Trie
        TrieNode root = new TrieNode();
        for(String word: words){
            TrieNode node = root;

            for(Character letter: word.toCharArray()){
                if(node.children.containsKey(letter)){
                    node = node.children.get(letter);
                }else{
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.isEnd = true; // mark this node as true as the word as ended here
        }

        //Step 2: Do Backtracking from every cell
        for(int row =0; row < board.length; ++row){
            for(int col = 0; col < board[row].length; ++col){
                if(root.children.containsKey(board[row][col])){ // if there is any word starting from that cell letter we will start backtracking
                    String currentWord = Character.toString(board[row][col]);
                    search(board, row, col, root, currentWord);
                }
            }
        }
        return this.result;
        
    }

    private void search(char[][] board, int row, int col, TrieNode parent, String word){
        Character letter = board[row][col]; // current letter
        TrieNode currNode = parent.children.get(letter); // current node from the parent

        //check if there is the word match
        if(currNode.isEnd){
            currNode.isEnd = false; // we found the complete word so we reset it to false and then add the word to the result.
        this.result.add(word);
        }

        //mark the current letter before exploration by exploring more words
        board[row][col] = '#'; // we will mark current cell as visited

        int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        for(int[] dir : directions){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow< 0 ||newRow >= board.length || newCol < 0 || newCol >= board[0].length){
                continue;
            }
            if(currNode.children.containsKey(board[newRow][newCol])) { // check char at the new cell
                search(board, newRow, newCol, currNode, word + board[newRow][newCol]);
            }
        }

        board[row][col] = letter;

    }
}