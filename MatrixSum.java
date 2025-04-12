public class MatrixSum{
    public static void main(String args[]){
         int [][] matrix = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
         int row = matrix.length;
         System.out.println(row);
         int column = matrix[0].length;
         System.out.println(column);

         // Sum of each row
        for (int i = 0; i < row; i++) {
            int rowSum = 0;
            for (int j = 0; j < column; j++) {
                rowSum += matrix[i][j];
            }
            System.out.println("Row " + i + " sum = " + rowSum);
        }
    }
}

