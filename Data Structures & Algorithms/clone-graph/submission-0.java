/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private HashMap<Node,Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }

        //if the node was already visited befire
        //return the clone from the visited dict
        if(visited.containsKey(node)){
            return visited.get(node);
        }

        //Created a clone for the given node
        //Note thatwe dont habe cloned neighbors as of now hence[]
        Node cloneNode = new Node(node.val, new ArrayList());

        //The key is original node and value being the colne node
        visited.put(node, cloneNode);

        //Iterate through the neighbors to generate their clones
        //and prepare a list of cloned neighbors to be added to the cloned node.
        for(Node neighbor: node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
        
    }
}