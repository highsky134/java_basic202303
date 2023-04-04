package juice;

import java.util.Scanner;

public class Utility {
    private static Scanner sc = new Scanner(System.in);

    private Utility() {}

    // 구분선 출력
    public static void makeLine() {
        System.out.println("==============================");
    }

    public static String input(String message) {
        System.out.println(message);
        return sc.nextLine();
    }

    public static void push() {

    }
}
