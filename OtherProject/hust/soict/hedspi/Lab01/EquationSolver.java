package hust.soict.hedspi.Lab01;

import javax.swing.JOptionPane;

public class EquationSolver {

    public static void main(String[] str) {
        String[] options = {"Giai phuong trinh bac nhat", "Giai he phuong trinh", "Giai phuong trinh bac 2"};
        int choice = JOptionPane.showOptionDialog(null, "Ban muon giai phuong trinh nao ?", "Lua chon",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        switch (choice) {
            case 0:
                PhuongTrinhBacNhat();
                break;
            case 1:
                HePhuongTrinh();
                break;
            case 2:
                PhuongTrinhBacHai();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Khong lua chon.");
        }
    }

    private static void PhuongTrinhBacNhat() {
        try {
            double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap he so a (a khac 0): "));
            double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap he so b: "));

            if (a == 0) {
                JOptionPane.showMessageDialog(null, "Nhap a phai khac 0");
            } else {
                double x = -b / a;
                JOptionPane.showMessageDialog(null, "Nghiem cua phuong trinh la x = " + x);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROL", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Xac nhan huy.");
        }
    }

    private static void HePhuongTrinh() {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap a11: "));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap a12: "));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap b1: "));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap a21: "));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap a22: "));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap b2: "));

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = b2 * a11 - b1 * a21;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                JOptionPane.showMessageDialog(null, "He phuong trinh tren vo so nghiem.");
            } else {
                JOptionPane.showMessageDialog(null, "He phuong trinh tren vo nghiem.");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            JOptionPane.showMessageDialog(null, "Nghiem cua he la: x1 = " + x1 + ", x2 = " + x2);
        }
    }

    private static void PhuongTrinhBacHai() {
        double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap he so a (a khac 0): "));
        double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap he so b: "));
        double c = Double.parseDouble(JOptionPane.showInputDialog(null, "Nhap he so c: "));

        if (a == 0) {
            if (b == 0) {
                if (c == 0) JOptionPane.showMessageDialog(null, "Phuong trinh co vo so nghiem.");
                else JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem.");
            } else {
                double x = -c / b;
                JOptionPane.showMessageDialog(null, "Nghiem cua phuon trinh la: x = " + x);
            }
        } else {
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta) / (2 * a));
                double x2 = (-b - Math.sqrt(delta) / (2 * a));
                JOptionPane.showMessageDialog(null, "Phuong trinh co nghiem la: x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "Phuong trinh co nghiem kep: x = " + x);
            } else {
                JOptionPane.showMessageDialog(null, "Phuong trinh vo nghiem");
            }
        }
    }

}