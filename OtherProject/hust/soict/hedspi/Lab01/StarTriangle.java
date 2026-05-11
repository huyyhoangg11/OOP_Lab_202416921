package hust.soict.hedspi.Lab01;

import java.util.Scanner;
public class StarTriangle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap chieu cao: ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < (n * 2); j++){
                if(j < n - i || j > n + i) System.out.print(" ");
                else System.out.print("*");
            }
            if(i != n - 1) System.out.println();
        }

        sc.close();
    }
}
