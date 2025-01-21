import java.util.Scanner;


public class Task2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the number of rows and columns of the matrices:");
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            
            int[][] matrix1 = new int[rows][cols];
            int[][] matrix2 = new int[rows][cols];
            
            System.out.println("Enter the elements of the first matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix1[i][j] = scanner.nextInt();
                }
            }
            
            System.out.println("Enter the elements of the second matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix2[i][j] = scanner.nextInt();
                }
            }
            
            // System.out.println("Choose the operation: 1. Add 2. Subtract 3. Multiply 4. Divide");
            // int choice = scanner.nextInt();
            
            int[][] result = new int[rows][cols];
            
            // switch (choice) {
            //     case 1:
            //         result = addMatrices(matrix1, matrix2, rows, cols);
            //         break;
            //     case 2:
            //         result = subtractMatrices(matrix1, matrix2, rows, cols);
            //         break;
            //     case 3:
            //         result = multiplyMatrices(matrix1, matrix2, rows, cols);
            //         break;
            //     case 4:
            //         result = divideMatrices(matrix1, matrix2, rows, cols);
            //         break;
            //     default:
            //         System.out.println("Invalid choice");
            //         return;
            // }
            
            // System.out.println("The result is:");
            // for (int i = 0; i < rows; i++) {
            //     for (int j = 0; j < cols; j++) {
            //         System.out.print(result[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            
            result = addMatrices(matrix1, matrix2, rows, cols);
            printMatrix(result);
            result = subtractMatrices(matrix1, matrix2, rows, cols);
            printMatrix(result);
            result = multiplyMatrices(matrix1, matrix2, rows, cols);
            printMatrix(result);
        }
    }
    
    
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2, int rows, int cols) {
        System.out.println("Addition of two matrices is: ");
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }
    
    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2, int rows, int cols) {
        System.out.println("Subtraction of two matrices is: ");
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }
    
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2, int rows, int cols) {
        System.out.println("Multiplication of two matrices is: ");
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] * matrix2[i][j];
            }
        }
        return result;
    }
    
  
    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}