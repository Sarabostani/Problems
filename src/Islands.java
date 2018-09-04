public class Islands {
	int m = 0;
    int n = 0;
    
    public int numIslands(char[][] mat) {
        int count = 0;
        m = mat.length;
        if (mat.length == 0 || mat[0] == null){
            return 0;
        }
        n = mat[0].length;
        for (int i = 0; i < m ; i++){
            for (int j = 0; j < n; j++){
                if (mat[i][j] == '1'){
                    DFSMat(mat, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void DFSMat(char[][] mat, int i, int j){
        if (i < 0 || j < 0 || i >= m || j >= n || mat[i][j] == '0') return;
        
        mat[i][j] = '0';
        DFSMat(mat, i + 1, j);
        DFSMat(mat, i - 1, j);
        DFSMat(mat, i, j + 1);
        DFSMat(mat, i, j - 1);
    }
}
