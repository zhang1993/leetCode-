import java.util.Scanner;

/**
 * Created by Shinelon on 2017/6/3.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rowLength = in.nextInt();
        int columnLength = in.nextInt();
        int[][] matrix = new int[rowLength][columnLength];
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = in.nextInt();
        new Solution().setZeroes(matrix);
    }
    public void setZeroes(int[][] matrix) {
        boolean[] rowFlag = new boolean[matrix.length];
        boolean[] columnFlag = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rowFlag[i] = true;
                    columnFlag[j] = true;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(rowFlag[i] == true || columnFlag[j] == true)
                    matrix[i][j] = 0;
            }
        }
        return;
    }
}
