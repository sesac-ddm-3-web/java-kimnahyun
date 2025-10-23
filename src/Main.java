import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecentPlayList recentPlayList = new RecentPlayList();

        boolean play = true;

        while (play) {
            System.out.println("==== 플레이 리스트 ====");
            System.out.print("1. 노래 듣기\n2. 최근 재생 목록\n선택 : ");

            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    System.out.print("\n노래 제목 : ");
                    String title = scanner.next();
                    System.out.print("가수 : ");
                    String singer = scanner.next();
                    System.out.println();

                    recentPlayList.addPlayList(title, singer);
                    break;
                case 2:
                    System.out.println("\n==== \uD83C\uDFA7 최근 재생 목록 ====");
                    recentPlayList.print();
                    break;
                default:
                    System.out.println("1, 2만 입력하세요");
            }
        }
    }
}