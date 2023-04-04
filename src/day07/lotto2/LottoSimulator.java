package day07.lotto2;

import java.util.Arrays;

import static juice.Utility.input;

public class LottoSimulator {


    public static void run() {
        // 입력해서 만든 내 로또 번호
        int[] winLotto = makeUserLotto();

        int paper = 0;
        while (true) {
            int[] getLotto = Lotto.getLotto();
            paper++;

            int count = checkLotto(winLotto, getLotto);

            if (count == 6) {
                System.out.printf("# %d장만에 1등에 당첨되었습니다.\n", paper);
                System.out.println("당첨번호 : " + Arrays.toString(winLotto));
                break;
            } else {
                System.out.printf("# %d장째 구매중... ㅠㅠ\n", paper);
            }


        }
    }

    public static int checkLotto(int[] myNum, int[] targetNum) {
        int count = 0;
        for (int i : myNum) {
            for (int j : targetNum) {
                if (i == j) count++;
            }
        }
        return count;
    }

    public static int[] makeUserLotto(){
        int inputNum;
        int count = 0;
        int[] inputLotto = new int[6];

        System.out.println("구매번호 6개 차례대로 입력하세요");
        // 6개 숫자 입력 받는 기능
        while (count < inputLotto.length) {

            inputNum = Integer.parseInt(input(String.format("%d번째 번호", count+1)));
            if (!Lotto.isDuplicate(inputLotto, inputNum)) {
                inputLotto[count] = inputNum;
                ++count;
            } else {
                System.out.println("# 중복 숫자 입니다.");
            }
        }

        return inputLotto;
    }
}
