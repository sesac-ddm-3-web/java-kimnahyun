package part2;

import java.util.Scanner;

public class Practice12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("생년월일 입력: ");
        String birth = sc.nextLine();

        String[] parts = birth.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        int currentYear = 2023;
        int age = currentYear - year;

        String binary = Integer.toBinaryString(year);
        String octal = Integer.toOctalString(year);
        String hex = Integer.toHexString(year);

        System.out.println("\n=== 생년월일 분석 ===");
        System.out.println("생년: " + year + "년");
        System.out.println("생월: " + month + "월");
        System.out.println("생일: " + day + "일");
        System.out.println("나이: " + age + "세");

        System.out.println("\n=== 생년 진법 변환 ===");
        System.out.println("10진수: " + year);
        System.out.println("2진수: " + binary);
        System.out.println("8진수: " + octal);
        System.out.println("16진수: " + hex);

        int sum = 0;
        System.out.print("\n=== 생년 자릿수 분석 ===\n각 자릿수: ");
        for (int i = 0; i < parts[0].length(); i++) {
            int digit = parts[0].charAt(i) - '0';
            sum += digit;
            System.out.print(digit);
            if (i < parts[0].length() - 1) System.out.print(", ");
        }

        System.out.println("\n자릿수 합: " + sum);

        sc.close();
    }
}

