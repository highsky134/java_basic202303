package day10.exception;

public class ThrowsMain {
    // 누군가는 .. 예외 처리를 해야한다
    public static void main(String[] args) {
        ThrowsExample te = new ThrowsExample();

        int n = te.inputNumber();
        int m = te.convert("100");
    }
}
