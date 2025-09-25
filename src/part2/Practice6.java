package part2;

import java.util.Scanner;

public class Practice6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("10진수 입력: ");
        int num = sc.nextInt();

        System.out.println("10진수: " + num);
        System.out.println("2진수: " + Integer.toBinaryString(num));
        System.out.println("8진수: " + Integer.toOctalString(num));
        System.out.println("16진수: " + Integer.toHexString(num));

        sc.close();
    }
}
