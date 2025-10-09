import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Log log = new Log();

        Scanner sc = new Scanner(System.in);
        boolean play = true;

        while (play) {
            System.out.print("1. 조회\n2. 계산\n3. 종료\n선택 : ");

            int choice = sc.nextInt();
            System.out.println();

            if (choice == 1) {
                log.viewLog();
                System.out.println();

            } else if (choice == 2) {
                System.out.print("식을 입력하세요 : ");
                String question = sc.next();

                try {
                    String result = question + " = " + calculator.calculateAll(question);
                    System.out.println(result);
                    log.saveLog(result);
                } catch (ArithmeticException e) {
                    System.out.println("0으로 나눌 수 없습니다!!!!");
                    System.out.println();

                    continue;
                }

                System.out.println();

            } else if (choice == 3) {
                System.out.println("종료합니다.");
                play = false;
            } else {
                System.out.println("1,2,3만 입력하세요.");
            }
        }
    }
}