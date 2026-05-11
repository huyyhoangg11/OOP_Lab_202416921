package hust.soict.hedspi.Lab03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.txt"; // Tạo file test.txt cùng cấp với thư mục src
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char)b;
            }
            endTime = System.currentTimeMillis();
            System.out.println("Time with String (+): " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.out.println("Không tìm thấy file. Hãy tạo file test.txt!");
            e.printStackTrace();
        }
    }
}