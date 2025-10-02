package part2;

import java.util.Scanner;

public class Practice10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("키(cm) 입력: ");
        double heightCm = sc.nextDouble();

        System.out.print("몸무게(kg) 입력: ");
        double weight = sc.nextDouble();

        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);

        String category;
        if (bmi < 18.5) {
            category = "저체중";
        } else if (bmi < 25) {
            category = "정상체중";
        } else if (bmi < 30) {
            category = "과체중";
        } else {
            category = "비만";
        }

        System.out.println("\n키: " + (int) heightCm + "cm");
        System.out.println("몸무게: " + (int) weight + "kg");
        System.out.println("BMI: " + bmi);
        System.out.println("판정: " + category);

        sc.close();
    }

}
