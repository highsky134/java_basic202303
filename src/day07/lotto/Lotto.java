package day07.lotto;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static juice.Utility.*;

class LottoSimulator {

    static int inputNum;
    static Set<Integer> correctLotto;
    static int[] inputLotto = new int[6];

    public static void run() {


        System.out.println("구매번호 6개 차례대로 입력하세요");

        int count = 0;
        // 6개 숫자 입력 받는 기능
        while (count < inputLotto.length) {

            inputNum = Integer.parseInt(input(String.format("%d번째 번호", count+1)));
            if (!isDuplicate(inputLotto, inputNum)) {
                inputLotto[count] = inputNum;
                ++count;
            } else {
                System.out.println("# 중복 숫자 입니다.");
            }
        }

        int howMany = 1;
        // 입력한 값과 맞을때까지 비교
        while (true) {
            System.out.printf("# %d장째 구매중... ㅜㅜ", howMany);
            correctLotto = Lotto.inforamtion();



        }
    }

    public static boolean isDuplicate(int[] targetLotto, int n) {
        for (int x : targetLotto) {
            if (n == x ) return true;
        }
        return false;
    }

}
public class Lotto {

    public static Set<Integer> inforamtion() {
        Set<Integer> lottoSet = new HashSet<Integer>();

        while (lottoSet.size() < 6) {
            lottoSet.add((int)(Math.random() * 45) + 1);
        }

        Iterator<Integer> iter = lottoSet.iterator();

        int[] lotto = new int[6];
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = iter.next();
        }

//        System.out.println("제발... " + Arrays.toString(lotto));
        return lottoSet;
    }


    public static void main(String[] args) {
//        Lotto.inforamtion();
        LottoSimulator.run();
    }

}
