package day02;

import java.io.IOException;
import java.util.Scanner;

public class StdIO {



    public static void main(String[] args) throws IOException {
        String dog = "멍멍이", cat = "야옹이";
        System.out.print(dog + "\n");
        System.out.print(cat);

        int month = 10;
        int day = 3;
        String anni = "개천절";

        // printf
        System.out.printf("%d월 %d일은 %s입니다.\n", month, day, anni);


        // 표준입력
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int result = 0;

        try {
            result = Integer.parseInt(str);
        } catch (Exception e) {
            System.out.println("정수로 입력 하거라~");
        }

        System.out.println("result = " + result);

    }


}
