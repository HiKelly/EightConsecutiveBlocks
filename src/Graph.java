import java.util.Random;

public class Graph {
    private boolean[][] block;
    private boolean[][] vis;
    private int n;

    Graph(int n){
        this.n = n;
        block = new boolean[n][n];
    }

    public boolean[][] getBlock() {
        return block;
    }

    public int getN() {
        return n;
    }

    public void generateGraph(){
        Random r = new Random();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                block[i][j] = r.nextBoolean();
            }
        }
        for(int i = 0; i < n; i++){
            for(int j =0; j < n; j++){
                if(block[i][j])
                    System.out.print("1");
                else
                    System.out.print("0");
            }
            System.out.println();
        }
    }

    public int countEightConsecutiveBlocks(){
        vis = new boolean[n][n];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(block[i][j] && !vis[i][j]){
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void dfs(int i, int j){
        if(i >= 0 && i < n && j >= 0 && j < n && block[i][j] && !vis[i][j]){
            vis[i][j] = true;
            dfs(i - 1, j);
            dfs(i + 1, j);
            dfs(i, j - 1);
            dfs(i, j + 1);
            dfs(i + 1, j - 1);
            dfs(i + 1, j + 1);
            dfs(i - 1, j - 1);
            dfs(i - 1, j + 1);
        }
    }
}
