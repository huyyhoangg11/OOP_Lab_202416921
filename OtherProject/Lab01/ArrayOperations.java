import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Nhập mảng từ bàn phím hay sử dụng mảng hằng số có sẵn? (nhap/hangso): ");
        String choice = scanner.nextLine().trim().toLowerCase();

        double[] array;

        if (choice.equals("nhap")) {

            System.out.print("\nNhập số phần tử của mảng: ");
            int size = scanner.nextInt();
            array = new double[size];

            System.out.printf("Nhập " + size + " phần tử: ");
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextDouble();
            }
        } else {
            array = new double[]{12.5, 8.2, 3.7, 15.8, 6.4};
            System.out.println("Sử dụng mảng hằng số: " + Arrays.toString(array));
        }

        Arrays.sort(array);
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(array));

        scanner.close();
    }
}