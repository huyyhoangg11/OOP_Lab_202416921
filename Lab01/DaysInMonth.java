import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year = -1;
        String monthInput;
        int month = -1;

        String[] months = { "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December" };

        while (true) {
            System.out.print("Nhao nam (so duong): ");
            year = sc.nextInt();
            sc.nextLine();

            if (year < 0) {
                System.out.println("Ban nhap khong hop le, vui long nhap lai.");
                continue;
            }

            System.out.print("Nhap thang can tinh, co the nhap so hoac chu: ");
            monthInput = sc.nextLine();

            month = treatMonth(monthInput, months);

            if (month != -1) {
                break;
            } else{
                System.out.println("Ban nhap khong hop le. Vui long nhap lai tu dau!");
            }
        }

        int days = treatDay(month, year);

        System.out.println("So ngay cua thang " + month + ", nam " + year + " la: " + days);

        sc.close();
    }

    private static int treatMonth(String input, String[] months) {
        input = input.toLowerCase();

        for(int i = 0; i < months.length; i++){
            if(months[i].toLowerCase().startsWith(input)) {
                return i + 1;
            }
        }

        try {
            int monthNumber = Integer.parseInt(input);
            if (monthNumber >= 1 && monthNumber <= 12) {
                return monthNumber;
            }
        } catch (NumberFormatException e){

        }
        return -1;
    }

    private static int treatDay(int month, int year) {
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return (treat_2(year)) ? 29 : 28;
            default:
                return -1;
        }
    }

    private static boolean treat_2(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}