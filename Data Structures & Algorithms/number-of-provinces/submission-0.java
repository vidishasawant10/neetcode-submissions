class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for(int city = 0; city < n; city++){
            if(!visited[city]){
                dfs(city, isConnected, visited, n);
                count++;
            }
        }
        return count;
        
    }
    private void dfs(int city, int[][] isConnected, boolean[] visited, int n){
        visited[city] = true;
        
        for(int neighbor = 0; neighbor < n; neighbor++){
            if(isConnected[city][neighbor] == 1 && !visited[neighbor]){
                dfs(neighbor, isConnected, visited, n);
            }
        }
    }
}