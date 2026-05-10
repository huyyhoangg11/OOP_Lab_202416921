import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap \"Enter\" neu ban muon nhap ma tran, " +
                "khong thi nhap \"constant\": ");
        String choice = sc.nextLine().trim().toLowerCase();

        int row, col;
        int[][] matrix1;
        int[][] matrix2;
        int[][] sumMatrix;

        if(choice.equals("enter")) {
            System.out.print("Nhap so hang: ");
            row = sc.nextInt();
            System.out.print("Nhap so cot: ");
            col = sc.nextInt();

            matrix1 = new int[row][col];
            matrix2 = new int[row][col];
            sumMatrix = new int[row][col];

            System.out.println("Nhap chi so ma tran thu 1:");
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    matrix1[i][j] = sc.nextInt();
                }
            }

            System.out.println("Nhap chi so ma tran thu 2:");
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    matrix2[i][j] = sc.nextInt();
                }
            }
        } else{
            row = 3;
            col = 3;
            matrix1 = new int[][]{
                    {1, 1, 1},
                    {2, 2, 2},
                    {3, 3, 3}
            };
            matrix2 = new int[][]{
                    {4, 4, 4},
                    {5, 5, 5},
                    {6, 6, 6}
            };
            sumMatrix = new int[row][col];
            System.out.println("Su dung ma tran co san:");
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("Ma tran thu 1:");
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Ma tran thu 2:");
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Tong 2 ma tran:");
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
