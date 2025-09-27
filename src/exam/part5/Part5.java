package exam.part5;

import java.util.Random;
import java.util.Scanner;

public class Part5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int randomNum = random.nextInt(1000) + 1;

        int num = 1;
        System.out.println("두꺼운 책의 아무 페이지나 펼쳤습니다. 몇 페이지일까요? (1~1000, 기회 : 10번");

        while (num < 11) {
            System.out.print(num + "번째 시도: ");
            int page = sc.nextInt();

            if (randomNum == page) {
                System.out.println("정답입니다! 책을 찾았네요.\n축하합니다! " + num + "번 만에 페이지를 찾았습니다.");
                num = 12;

            } else if (randomNum < page) {
                System.out.println("더 앞장이에요! (Down!)\n");
                num++;
            } else {
                System.out.println("더 뒷장이에요! (Up!)\n");
                num++;
            }

        }
    }
}
