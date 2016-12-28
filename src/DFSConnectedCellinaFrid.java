import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFSConnectedCellinaFrid {

    public static int getBiggestRegion(int[][] matrix) {
        if (matrix == null) return 0;

        int columns = matrix[0].length;
        int rows = matrix.length;

        List<Integer> regions = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                regions.add(dfs(matrix, i, j));
            }
        }

        int max = 0;

        for (Integer region : regions) {
            if (max < region) {
                max = region;
            }
        }

        return max;
    }

    private static int dfs(int[][] matrix, int r, int c) {
        if (r < 0 || c < 0) return 0;
        if (r > matrix[0].length-1 || c > matrix.length-1) return 0;
        if (matrix[c][r] == 0) return 0;

        matrix[c][r] = 0;

        return 1
                + dfs(matrix, r-1, c+1)
                + dfs(matrix, r-1, c)
                + dfs(matrix, r-1, c-1)
                + dfs(matrix, r, c-1)
                + dfs(matrix, r, c+1)
                + dfs(matrix, r+1, c-1)
                + dfs(matrix, r+1, c)
                + dfs(matrix, r+1, c+1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }
}
