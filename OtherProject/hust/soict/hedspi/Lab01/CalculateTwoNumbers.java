package hust.soict.hedspi.Lab01;

import javax.swing.JOptionPane;

public class CalculateTwoNumbers {
    public static void main(String[] args) {

        String strNum1 = JOptionPane.showInputDialog(null,
                "Vui lòng nhập số đầu tiên:",
                "Nhập số thứ nhất",
                JOptionPane.INFORMATION_MESSAGE);

        String strNum2 = JOptionPane.showInputDialog(null,
                "Vui lòng nhập số thứ 2:",
                "Nhập số thứ 2",
                JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;

        String quotient;
        if (num2 != 0) {
            quotient = String.valueOf(num1 / num2);
        } else {
            quotient = "Không xác định (không thể chia cho 0)";
        }

        String result = "Tổng: " + sum + "\n" +
                "Hiệu: " + difference + "\n" +
                "Tích: " + product + "\n" +
                "Thương: " + quotient;

        JOptionPane.showMessageDialog(null,
                result,
                "Kết quả tính toán",
                JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}