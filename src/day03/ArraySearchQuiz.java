package day03;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySearchQuiz {

    public static void main(String[] args) {
        // 1. 수정 타겟의 이름을 입력받는다.
        // 2. 해당 이름이 있는지 탐색해본다.
        // 3. 탐색에 성공하면 해당 이름의 인덱스를 알아온다.
        // 4. 탐색에 실패하면 실패한 증거를 확보한다.
        // 5. 성공했을 시 수정을 원하는 새로운 이름을 입력받는다.
        // 6. 찾은 인덱스를 통해 새로운 이름으로 수정한다.
        // 7. 위 내용을 수정이 정확히 완료될때까지 반복한다.

        Scanner sc = new Scanner(System.in);

        String[] tvxq = {"영웅재중", "최강창민", "시아준수", "믹키유천", "유노윤호"};

        System.out.println("* 변경 전 정보: " + Arrays.toString(tvxq));

        int index = -1;

        while (index < 0) {
            System.out.print("바꿀 대상을 입력하세요 : ");
            String originName = sc.nextLine();

            for (int i = 0; i < tvxq.length; i++) {

                if (originName.equals(tvxq[i])) {
                    index = i;
                    System.out.print(tvxq[index] + "의 별명을 변경합니다\n >> ");
                    tvxq[index] = sc.nextLine();
                    break;
                }
            }
            if (index == -1) {
                System.out.println("바꿀 대상이 없습니다 다시 입력해주세요");
            }
        }//end while

        System.out.println("* 변경 후 정보: " + Arrays.toString(tvxq));
    }
}
