package dbelousov.petprojects.challenges.arraysandstrings;

public class RotateMatrix {

    private int[][] matrix = null;
    private int n = 0;

    public RotateMatrix(int[][] matrix, int n) {
        this.matrix = matrix;
        this.n = n;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void rotate() {
        transpose(0, 0);
        reverseEachRow(0);
    }

    private void transpose(int x, int y) {
        if (x == n - 1 || y == n - 1) {
            return;
        }

        for (var i = x; i < n; i++) {
            var tmp = matrix[x][i];
            matrix[x][i] = matrix[i][y];
            matrix[i][y] = tmp;
        }
        transpose(x + 1, y + 1);
    }

    private void reverseEachRow(int rowInd) {
        if (rowInd == n) {
            return;
        }

        int i = 0;
        int j = n - 1;
        while (i < j) {
            var tmp = matrix[rowInd][i];
            matrix[rowInd][i] = matrix[rowInd][j];
            matrix[rowInd][j] = tmp;
            i++;
            j--;
        }
        reverseEachRow(rowInd + 1);
    }
}
